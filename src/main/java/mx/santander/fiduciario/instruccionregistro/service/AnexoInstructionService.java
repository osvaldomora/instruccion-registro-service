package mx.santander.fiduciario.instruccionregistro.service;

import java.io.IOException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.Setter;
import mx.santander.fiduciario.instruccionregistro.model.InstruccionAnexoModel;
import mx.santander.fiduciario.instruccionregistro.repository.IAnexoInstructionRepository;
import mx.santander.fiduciario.instruccionregistro.util.FileTool;

/**
 * Clase AnexoInstructionService
 * Este microservicio,encargada de 
 * orquestador la logica de negocio 
 * relacionada con instruccion con anexos 
 * y sus datos (persistencia).
 * @author 
 */
@Setter
@Service
public class AnexoInstructionService implements IAnexoInstructionService{

	// La Constante LOGGER. Obtiene el Logger de la clase
	private static final Logger LOGGER = LoggerFactory.getLogger(AnexoInstructionService.class);
	
	//Variable de repositorio de Instruccion anexo
	@Autowired
	private IAnexoInstructionRepository anexoInstructionRepository;
		
	/**
	 * Metodo InstruccionAnexoModel
	 * @param idInstrNvas id de instrucciones
	 * @param folio folio 
	 * @param file archivo 
	 * @param tipoArchivo tipodeArchivo
	 */
	@Override
	public InstruccionAnexoModel save(Long idInstrNvas, Long folio, MultipartFile file, String tipoArchivo) {
		String fileBase64 = null;
		//Se crea modelo
		InstruccionAnexoModel anexoModel = InstruccionAnexoModel.builder()
											.idFkInstrNvas(idInstrNvas)
											.dscDocNombr(file.getOriginalFilename())
											.dsc_Tipo(tipoArchivo)
											.idFolio(folio)
											.fchRegisInst(new Date())
											.build();
		try {
			fileBase64 = FileTool.encode64(file);
		} catch (IOException e) {
			//Se lanza error
			LOGGER.warn("Servicio: AnexoInstructionService, Operacion: save, error al convertir file a base64: {}",e.getMessage());
		}
		//Agregamos file en base64
		anexoModel.setValInstr(fileBase64);
		//Se registra en BD
		anexoModel = this.anexoInstructionRepository.save(anexoModel);
		LOGGER.info("Servicio: AnexoInstructionService, operacion: save, se ha registrado anexoModel: {}",anexoModel.toString());
		return anexoModel;
	}//Fin del metodo
}//Fin de la clase 
