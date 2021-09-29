package mx.santander.fiduciario.instruccionregistro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrReqDto;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res.SendInstrResDto;
import mx.santander.fiduciario.instruccionregistro.model.InstruccionEnviadaModel;

public interface IInstructionSendService {
	
	InstruccionEnviadaModel saveInstruction(SendInstrReqDto instrReqDto, Long folio);
	
	
	SendInstrResDto saveInstructions(String jsonRequest, List<MultipartFile> files);

}
