package mx.santander.fiduciario.instruccionregistro.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Setter;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrFileDto;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrReqDto;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res.SendInstrDataDto;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res.SendInstrResDto;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res.SendIntrsFolioDto;
import mx.santander.fiduciario.instruccionregistro.enumerations.FileInstruction;
import mx.santander.fiduciario.instruccionregistro.enumerations.StatusInstruction;
import mx.santander.fiduciario.instruccionregistro.exception.InvalidDataException;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.BusinessCatalog;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.InvalidDataCatalog;
import mx.santander.fiduciario.instruccionregistro.model.InstruccionEnviadaModel;
import mx.santander.fiduciario.instruccionregistro.repository.IInstructionSendRepository;
import mx.santander.fiduciario.instruccionregistro.exception.BusinessException;

@Setter
@Service
public class InstructionSendService implements IInstructionSendService {

	// La Constante LOGGER. Obtiene el Logger de la clase
	private static final Logger LOGGER = LoggerFactory.getLogger(InstructionSendService.class);

	//Variable de tamaño de archivos 15MB
	private final Long MAX_SIZE_FILE_BYTES = 15728640L;
	
	// Variable de repositorio de Instrucciones enviadas
	@Autowired
	private IInstructionSendRepository instructionSendRepository;

	@Override
	public InstruccionEnviadaModel saveInstruction(SendInstrReqDto instrReqDto) {
		InstruccionEnviadaModel instrSendModelReq = null;
		Long folio = new Long(String.valueOf((int)(Math.random() * 1000000)+1));
		instrSendModelReq = InstruccionEnviadaModel.builder()
								.idList(instrReqDto.getTypeInstruction().getId())
								.buc(instrReqDto.getBuc().getId())
								.idNoContr(instrReqDto.getBusiness().getId())
								.idNoSubContr(instrReqDto.getBusiness().getSubBusiness().getId())
								.IdFolio(folio)
								.idEstat(StatusInstruction.ENTREGADA.getValue())	//Estatus, para este sprint cambiara despues
								.fchRegisInsct(new Date())
								.build();
								
		InstruccionEnviadaModel instrSendModelRes = this.instructionSendRepository.save(instrSendModelReq);
		LOGGER.info("Operacion: saveInstruction, se ha guardado instruccion enviada con exito: {}",instrSendModelRes.toString());
		return instrSendModelRes;
	}

	@Override
	public SendInstrResDto saveInstructions(String jsonRequest, List<MultipartFile> files) {
		//DTO respuesta final
		SendInstrResDto instrResDto = SendInstrResDto.builder()
										.data(SendInstrDataDto.builder()
												.build())
										.build();
		//Lista de folios para respuesta final
		List<SendIntrsFolioDto> foliosObtenidos = new ArrayList<>();
		// Objeto entrada Request DTO
		SendInstrReqDto instrReqDto = null;
		// Objeto mapeer String to DTO
		ObjectMapper mapper = new ObjectMapper();
		try {
			instrReqDto = mapper.readValue(jsonRequest, SendInstrReqDto.class);
		} catch (IOException | IllegalArgumentException e) { // Error al Mapear JSON a DTO
			LOGGER.error("Operacion: saveInstructions, error en la estructura del JSON de entrada.");
			throw new InvalidDataException(InvalidDataCatalog.INVD001, "Error en la estructura del JSON de entrada.");
		}
		
		//Validar cantidad de archivos, con arreglo de arhivos sean iguales
		if(files.size() != instrReqDto.getFiles().size()) {
			LOGGER.error("Operacion: saveInstructions, error en la estructura del JSON de entrada, los archivos enviados no corresponden con la estructura JSON.");
			throw new InvalidDataException(InvalidDataCatalog.INVD001, "Error en la estructura del JSON de entrada, los archivos enviados no corresponden con la estructura JSON.");
		}

		/**Validacion de negocio, de archivos*/
		for(int i=0; i<files.size();i++) {
			//Archivo JSON a validar
			SendInstrFileDto fileDto = instrReqDto.getFiles().get(i);
			//Archivo a validar
			MultipartFile file = files.get(i);
			//InstruccionEnviadaModel instruccion enviada
			InstruccionEnviadaModel instrSendModel = null;
			
			//Validaciones de tamanio de archivo
			this.validateSizeFiles(file,fileDto);
			
			//Validacion de formato de archivo
			this.validateFormatFiles(file, fileDto);
			
			boolean sinComite = false;
			if(sinComite == false) {
				
				//Registrar instruccion 
				instrSendModel = this.saveInstruction(instrReqDto);
				
			}
			//Guardamos folio y solicitud de folio
			foliosObtenidos.add(SendIntrsFolioDto.builder()
									.folio(instrSendModel.getIdFolio())	//Folio
									.folioRequest(instrSendModel.getIdIntrsNvas())	//Solicitud de Folio
									.type(fileDto.getType())	//Tipo de archivo
									.dateOperation(instrSendModel.getFchRegisInsct())	//Fecha de transsaccion
									.build());	
		}
		//Agregamos lista de folios a respuesta final
		instrResDto.getData().setFolios(foliosObtenidos);

		return instrResDto;
	}

	
	private void validateSizeFiles(MultipartFile file, SendInstrFileDto fileDto) {
		Long fileSize = file.getSize();
		if(fileSize > MAX_SIZE_FILE_BYTES) {	//Valida tamanio de archivo, tiene que se menor a 15MB
			LOGGER.warn("Operacion: saveInstructions, subOperacion: validateSizeFiles, se supero peso de archivo: {}, archivo: {}"+file.getSize(),file.getName());
			throw new BusinessException(BusinessCatalog.BUSI001, "El archivo ha superado el limite de MB, archivo: "+file.getName());
		}
		if(fileSize == 0) {	//Valida que el archivo no este vacio
			LOGGER.warn("Operacion: saveInstructions, subOperacion: validateSizeFiles, el archivo esta vacio: {}, archivo: "+file.getSize(),file.getName());
			throw new BusinessException(BusinessCatalog.BUSI001, "El archivo no puede estar vacio, archivo: "+file.getName());
		}
		//Validacion de tamaño arreglo de JSON con archivo actual
		if(file.getSize() != fileDto.getSize()) {
			LOGGER.warn("Operacion: saveInstructions, subOperacion: validateSizeFiles, error archivo enviado no concuerda con el tamanio de bytes enviado en JSON: {}",file.getName());
			throw new BusinessException(BusinessCatalog.BUSI001, "Error archivo enviado no con cuerda con el tamanio de bytes enviado en JSON: "+file.getName());
		}
	}
	
	private void validateFormatFiles(MultipartFile file, SendInstrFileDto fileDto) {
		//Validacion de formato
		switch (fileDto.getType()) {
		case "INSTRUCCION":
			if(!file.getContentType().equalsIgnoreCase(FileInstruction.INSTRUCCION.getFileExtension().getContentType())) {
				throw new BusinessException(BusinessCatalog.BUSI002, "El envio de un archivo de tipo: INSTRUCCION, solo se permite en formato: pdf");
			}
			break;
		case "LAYOUT":
			if(!file.getContentType().equalsIgnoreCase(FileInstruction.LAYOUT.getFileExtension().getContentType())) {
				throw new BusinessException(BusinessCatalog.BUSI002, "El envio de un archivo de tipo: LAYOUT, solo se permite en formato: txt");
			}
			break;
		case "ANEXO":
			if(!file.getContentType().equalsIgnoreCase(FileInstruction.ANEXO.getFileExtension().getContentType())) {
				throw new BusinessException(BusinessCatalog.BUSI002, "El envio de un archivo de tipo: ANEXO, solo se permite en formato: pdf");
			}
			break;
		
		default:
			LOGGER.error("Operacion: saveInstructions, subOperacion: validateFormatFiles, error tipo de archivo no valido!");
		}

	}
}
