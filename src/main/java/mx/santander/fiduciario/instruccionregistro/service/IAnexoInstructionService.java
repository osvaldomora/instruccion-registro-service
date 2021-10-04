package mx.santander.fiduciario.instruccionregistro.service;

import org.springframework.web.multipart.MultipartFile;

import mx.santander.fiduciario.instruccionregistro.model.InstruccionAnexoModel;

/**
 * Interface IAnexoInstructionService
 * Se encarga de gestionar todas las operaciones de persistencia contra una tabla en base de datos
 * @author
 */
public interface IAnexoInstructionService {

	/**
	 * Metodo InstruccionAnexoModel
	 * @param idInstrNvas Id de instrucciones 
	 * @param folio folio del archivo 
	 * @param file archivo 
	 * @param tipoArchivo tipo de archivo 
	 * @return InstruccionAnexoModel retorna un archivo anexo  
	 */
	InstruccionAnexoModel save(Long idInstrNvas, Long folio, MultipartFile file, String tipoArchivo);
}//Fin de la interface 
