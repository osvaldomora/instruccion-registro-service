package mx.santander.fiduciario.instruccionregistro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrReqDto;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res.SendInstrResDto;
import mx.santander.fiduciario.instruccionregistro.model.InstruccionEnviadaModel;

/**
 * Interface IInstructionSendService
 * Se encarga de gestionar todas las operaciones de persistencia contra una tabla en base de datos
 * @author 
 */
public interface IInstructionSendService {
	
	/**
	 * Metodo saveInstruction
	 * @param instrReqDto instruccion
	 * @param folio identiicador
	 * @return InstruccionEnviadaModel modelo al enviar una instruccion
	 */
	InstruccionEnviadaModel saveInstruction(SendInstrReqDto instrReqDto, Long folio);
	
	/**
	 * Metodo saveInstructions
	 * @param jsonRequest Envio de un json al guardar una instruccion
	 * @param files archivo 
	 * @return SendInstrResDto
	 */
	SendInstrResDto saveInstructions(String jsonRequest, List<MultipartFile> files);
}//Fin de la interface 
