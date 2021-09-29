package mx.santander.fiduciario.instruccionregistro.service;

import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrFileDto;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrReqDto;
import mx.santander.fiduciario.instruccionregistro.model.RegistroDocumentoModel;

public interface IDocumentRegistrationService {

	RegistroDocumentoModel save(RegistroDocumentoModel documentoModel);
	
	RegistroDocumentoModel saveRegistrationDoc(SendInstrReqDto instrReqDto, SendInstrFileDto fileDto);
	
}
