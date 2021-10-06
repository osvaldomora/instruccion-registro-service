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
import mx.santander.fiduciario.instruccionregistro.dto.notification.res.Notification;
import mx.santander.fiduciario.instruccionregistro.enumerations.FileInstruction;
import mx.santander.fiduciario.instruccionregistro.enumerations.StatusInstruction;
import mx.santander.fiduciario.instruccionregistro.exception.BusinessException;
import mx.santander.fiduciario.instruccionregistro.exception.InvalidDataException;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.BusinessCatalog;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.InvalidDataCatalog;
import mx.santander.fiduciario.instruccionregistro.model.InstruccionEnviadaModel;
import mx.santander.fiduciario.instruccionregistro.notification.response.NotificacionResponseDto;
import mx.santander.fiduciario.instruccionregistro.repository.IInstructionSendRepository;

/**
 * Clase InstructionSendService
 * Este microservicio,encargada de 
 * orquestador la logica de negocio 
 * relacionada con instruccion con anexos 
 * y sus datos (persistencia).
 * @author 
 */
@Setter
@Service
public class InstructionSendService implements IInstructionSendService {

	// La Constante LOGGER. Obtiene el Logger de la clase
	private static final Logger LOGGER = LoggerFactory.getLogger(InstructionSendService.class);

	//Variable de tamaño de archivos 15MB
	private static final Long MAX_SIZE_FILE_BYTES = 15728640L;
	
	//Vatuable de comite tecnico
	private static final boolean COMITE_TECNICO = false;
	
	//Variable de servicio Registro de Documento
	@Autowired
	private IDocumentRegistrationService documentRegistrationService;
	
	// Variable de repositorio de Instrucciones enviadas
	@Autowired
	private IInstructionSendRepository instructionSendRepository;
	
	//Variablde de servicio de Instruccion anexo
	@Autowired
	private IAnexoInstructionService anexoInstructionService;
	
	@Autowired
	private INotificationService notificationService;

	/**
	 * Este metodo permite guardar en el repositorio una instruccion
	 * @param instrReqDto	informacion de la instruccion a guardar
	 * @param folio valor del folio generado
	 * @return InstruccionEnviadaModel modelo de la instruccion guardada
	 */
	@Override
	public InstruccionEnviadaModel saveInstruction(SendInstrReqDto instrReqDto, Long folio) {
		InstruccionEnviadaModel instrSendModelReq = null;
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
	}//Fin del metodo 

	/**
	 * Este metodo es el encargado de la logica de negocio al enviar una instruccion 
	 * y sus diferentes registristros en sus respectivos repositorios, ademas realiza
	 * las validaciones necesarias para el envio de archivos.
	 * @param jsonRequest JSON de entrada
	 * @param files archivos enviados a guardar
	 * @return SendInstrResDto respuesta con los folios generados
	 */
	@Override
	public SendInstrResDto saveInstructions(String jsonRequest, List<MultipartFile> files) {
		//Instancia de objetos a trabajar
		List<SendInstrFileDto> filesDtoTemp  = new ArrayList<>();
		List<MultipartFile> filesTemp = new ArrayList<>();
		List<SendIntrsFolioDto> foliosObtenidos = new ArrayList<>(); //Lista de folios para respuesta final
		//DTO respuesta final
		SendInstrResDto instrResDto = SendInstrResDto.builder()
										.data(SendInstrDataDto.builder()
												.build())
										.build();
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
		
		//Valida que no se envien archivos y arreglo vacio
		if(instrReqDto.getFiles().isEmpty() || files.isEmpty()) {
			LOGGER.error("Operacion: saveInstructions, error no se ha enviado una INSTRUCCION");
			throw new InvalidDataException(InvalidDataCatalog.INVD001, "Error se debe enviar un archivo y un item de tipo INSTRUCCION");
		}
		
		//Validar cantidad de archivos, con arreglo de arhivos sean iguales
		if(files.size() != instrReqDto.getFiles().size()) {
			LOGGER.error("Operacion: saveInstructions, error en la estructura del JSON de entrada, los archivos enviados no corresponden con la estructura JSON.");
			throw new InvalidDataException(InvalidDataCatalog.INVD001, "Error en la estructura del JSON de entrada, la cantidad de archivos enviados no corresponden con la estructura JSON.");
		}
		
		//Obtenemos archivos temporales a procesar
		filesDtoTemp = instrReqDto.getFiles();
		filesTemp = files;
		
		/*Validaciones de archivos*/
		int contTypeInstr = 0;
		for(int i=0; i<filesDtoTemp.size();i++) {
			SendInstrFileDto fileDtoToEvaluate = filesDtoTemp.get(i);
			MultipartFile fileGoEvaluate = filesTemp.get(i);
			//Validaciones de tamanio de archivo
			this.validateSizeFiles(fileGoEvaluate,fileDtoToEvaluate);
			//Validacion de formato de archivo
			this.validateFormatFiles(fileGoEvaluate, fileDtoToEvaluate);
			if(FileInstruction.INSTRUCCION.getName().equalsIgnoreCase(fileDtoToEvaluate.getType())) {
				contTypeInstr++;
			}
		}
		//Valida que exista solo un tipo de INSTRUCCION
		if(contTypeInstr != 1) {
			LOGGER.error("Operacion: saveInstructions, Error se necesita enviar solo 1 archivo de tipo INSTRUCCION");
			throw new BusinessException(BusinessCatalog.BUSI002, "Error se necesita enviar solo 1 archivo de tipo INSTRUCCION");
		}		
		
		//Ordena lista, para que instruccion sea la primera
		this.sortList(filesDtoTemp, filesTemp);
		
		/*Inicio insertar instruccion
		 * SIEMPRE, se envia primero la INSTRUCCION
		 * para obtener el id temporal de la instruccion enviada (IdIntrsNvas), 
		 * este ID sirve para asociar a los archivos con la instruccion
		 */
		SendInstrFileDto fileDtoInstruction = filesDtoTemp.get(0);	//Se obtiene el item de INSTRUCCION
		Long folioTemp = null;
		Long idInstrTemp = null;
		
		//Registar documento  BD (Registro Documento) y obtiene Folio
		if(!COMITE_TECNICO) {
			//Sin comite tecnico
			folioTemp = this.documentRegistrationService.saveRegistrationDoc(instrReqDto, fileDtoInstruction).getNumeroUnicoDoc();
		}
		//Registrar instruccion BD (Instruccion Enviada)
		idInstrTemp = this.saveInstruction(instrReqDto, folioTemp).getIdIntrsNvas();
		/*Fin: Inicio insertar instruccion*/
		
		LOGGER.info("Se registran archivos ANEXOS y LAYOUT: ");
		//Se guardan archivo (Instruccion Anexo Model)
		this.insertDocAnexosAndLayout(filesDtoTemp, filesTemp, foliosObtenidos, instrReqDto, folioTemp, idInstrTemp);

		//Agregamos lista de folios a respuesta final
		instrResDto.getData().setFolios(foliosObtenidos);
		
		instrResDto.getData().getFolios().forEach(x->System.out.println(x));
		//Se envia notificacion al usuario que envio la instruccion.
		if (!instrResDto.getData().getFolios().isEmpty()) {
			  instrResDto=validateNotification(jsonRequest,instrResDto);		
		}
		else {
			
			/**
			 *
			 * 1*-se va a tenr un setvicio que envie las notificaciones para obtener las notificaciones por informar.
			 * 2.- en el servicio de envio de instruccion se ira a la tabla de comites tecnicos para ir por una lista de bucs
			 *     asociados a la instruccion.
			 * 3.- Setear los datos en la tabla de NOTIFICACIONES con el estatus 0 que indica no leido.
			 * 4.- Cuando se de click al mensaje se va a realizar un update la tabla de Notificaciones para cambiar la bandera 
		
			   
			 */
			
			
			//llamar al metodo que me obtendra los bucs de los comites tecnicos.
			
		}

		return instrResDto;
	}//Fin del metodo 
 /**
  * 
  * @param jsonRequest reques enviado
  * @param instrResDto objeto SendInstrResDto
  * @return
  */
	private SendInstrResDto  validateNotification(String jsonRequest,SendInstrResDto instrResDto) {
        
		//se hace el llamado a la api de notificaciones
		NotificacionResponseDto response=notificationService.notification(jsonRequest );
		
		instrResDto.getData().setNotification(Notification.builder().build());
		//si el correo fue enviado correctamente
		if(response.getStatus().getSuccess()) {
			instrResDto.getData().getNotification().setDescription(response.getStatus().getDescription());
			instrResDto.getData().getNotification().setSuccess(response.getStatus().getSuccess());
		}
		else {
			instrResDto.getData().getNotification().setDescription(response.getStatus().getDescription());
			instrResDto.getData().getNotification().setSuccess(response.getStatus().getSuccess());
		
		}

		
	return instrResDto;
	}

	/**
	 * Este metodo permite insertar los archivos en la tabla de Instrucciones anexas, valida existe comite tecnico
	 * @param filesDtoTemp lista de archivos con la informacion en el DTO
	 * @param filesTemp lista de archivos
	 * @param foliosObtenidos arreglo de folios a guardar
	 * @param instrReqDto informacion del tipo de instruccion del request
	 * @param folioTemp folio temporal generado
	 * @param idInstrTemp identificador de instruccion enviada, para asociacion de los archivos anexos
	 */
	private void insertDocAnexosAndLayout(List<SendInstrFileDto> filesDtoTemp, List<MultipartFile> filesTemp,List<SendIntrsFolioDto> foliosObtenidos,SendInstrReqDto instrReqDto, Long folioTemp, Long idInstrTemp) {
		Date dateInsert = null;
		//Se recorre archivos para guardar
		for(int i=0; i<filesTemp.size();i++) {
			//Archivo JSON a validar
			SendInstrFileDto fileDto = filesDtoTemp.get(i);
			//Archivo a validar
			MultipartFile file = filesTemp.get(i);			
			//Registar documento  BD (Registro Documento LAYOUT y ANEXO) y obtiene Folio, sin COMITE TECNICO
			if(!COMITE_TECNICO) {
				if (!FileInstruction.INSTRUCCION.getName().equalsIgnoreCase(fileDto.getType())) {
					folioTemp = this.documentRegistrationService.saveRegistrationDoc(instrReqDto, fileDto).getNumeroUnicoDoc();
				}
			}
			//Se registra documentos
			if(fileDto.getType().equalsIgnoreCase(FileInstruction.INSTRUCCION.getName())) {	//(Instruccion)
				dateInsert = this.anexoInstructionService.save(idInstrTemp, folioTemp, file,FileInstruction.INSTRUCCION.getName()).getFchRegisInst();
			}else if(fileDto.getType().equalsIgnoreCase(FileInstruction.ANEXO.getName())) {	//(Anexo)
				dateInsert = this.anexoInstructionService.save(idInstrTemp, folioTemp, file,FileInstruction.ANEXO.getName()).getFchRegisInst();
			}else {// (Layout)
				dateInsert = this.anexoInstructionService.save(idInstrTemp, folioTemp, file,FileInstruction.LAYOUT.getName()).getFchRegisInst();
			}
			//Guardamos folio y solicitud de folio
			foliosObtenidos.add(SendIntrsFolioDto.builder()
									.folio(folioTemp)	//Folio
									.folioRequest(idInstrTemp)	//Solicitud de Folio
									.type(fileDto.getType())	//Tipo de archivo
									.fileName(file.getOriginalFilename()) 	//Nombre de archivo
									.dateOperation(dateInsert)	//Fecha de transsaccion
									.build());	
		}
	}//Fin del metodo 
	
	/**
	 * Este metodo ordena una lista de archivos, poniendo el tipo como INSTRUCCION al inicio de la lista
	 * @param filesDtoTemp lista de archivos con la informacion en el DTO
	 * @param filesTemp lista de archivos
	 */
	private void sortList(List<SendInstrFileDto> filesDtoTemp, List<MultipartFile> filesTemp) {
		//Ordena el arreglo para que instruccion sea primera posicion
		for(int i=0;i<filesDtoTemp.size();i++) {
			//Valida si existe archivo tipo INSTRUCCION
			if(FileInstruction.INSTRUCCION.getName().equalsIgnoreCase(filesDtoTemp.get(i).getType())) {
				//Se ordena archivo tipo INSTRUCCION al inicio
				filesDtoTemp.add(0, filesDtoTemp.get(i));
				filesTemp.add(0,filesTemp.get(i));
				//Se elimina archivo tipo INSTRUCCION de a posicion que se obtuvo
				filesDtoTemp.remove(i+1);
				filesTemp.remove(i+1);
			}
		}
	}//Fin del metodo
	
	/**
	 * Este metodo valida el archivo y la informacion del archivo sean correctas y validan los tamanios de los archivos.
	 * @param file archivo a evaluar
	 * @param fileDto informacion de archivo a evaluar
	 */
	private void validateSizeFiles(MultipartFile file, SendInstrFileDto fileDto) {
		Long fileSize = file.getSize();
		if(fileSize > MAX_SIZE_FILE_BYTES) {	//Valida tamanio de archivo, tiene que se menor a 15MB
			LOGGER.warn("Operacion: saveInstructions, subOperacion: validateSizeFiles, se supero peso de archivo: {}, archivo: {}"+file.getSize(),file.getName());
			throw new BusinessException(BusinessCatalog.BUSI001, "El archivo ha superado el limite de MB, archivo: "+file.getOriginalFilename());
		}
		if(fileSize == 0) {	//Valida que el archivo no este vacio
			LOGGER.warn("Operacion: saveInstructions, subOperacion: validateSizeFiles, el archivo esta vacio: {}, archivo: "+file.getSize(),file.getName());
			throw new BusinessException(BusinessCatalog.BUSI001, "El archivo no puede estar vacio, archivo: "+file.getOriginalFilename());
		}
		//Validacion de tamaño arreglo de JSON con archivo actual
		if(file.getSize() != fileDto.getSize()) {
			LOGGER.warn("Operacion: saveInstructions, subOperacion: validateSizeFiles, error archivo enviado no concuerda con el tamanio de bytes enviado en JSON: {}",file.getName());
			throw new BusinessException(BusinessCatalog.BUSI001, "Error archivo enviado no con cuerda con el tamanio de bytes enviado en JSON: "+file.getOriginalFilename());
		}
	}//Fin del metodo 
	
	/**
	 * Este metodo valida el formato de los archivos y la informacion del archivo enviado
	 * @param file archivo a evaluar 
	 * @param fileDto informacion del archivo a evaluar
	 */
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
	}//Fin del metodo 
}//Fin de la clase 
