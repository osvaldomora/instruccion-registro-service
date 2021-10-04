package mx.santander.fiduciario.instruccionregistro.service;

import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrFileDto;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrReqDto;
import mx.santander.fiduciario.instruccionregistro.model.RegistroDocumentoModel;

/**
 * Interface IDocumentRegistrationService
 * Se encarga de gestionar todas las operaciones de persistencia contra una tabla en base de datos
 * @author glenn
 */
public interface IDocumentRegistrationService {

	/**
	 * Metodo save 
	 * @param documentoModel documento
	 * @return RegistroDocumentoModel Modelo de documento registrado
	 */
	RegistroDocumentoModel save(RegistroDocumentoModel documentoModel);
	/**
	 * Metodo saveRegistrationDoc
	 * @param instrReqDto instruccion 
	 * @param fileDto archivo 
	 * @return RegistroDocumentoModel registro de documento
	 */
	RegistroDocumentoModel saveRegistrationDoc(SendInstrReqDto instrReqDto, SendInstrFileDto fileDto);
}//Fin de la interface 
