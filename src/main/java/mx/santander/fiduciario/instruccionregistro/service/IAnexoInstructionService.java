package mx.santander.fiduciario.instruccionregistro.service;

import org.springframework.web.multipart.MultipartFile;

import mx.santander.fiduciario.instruccionregistro.model.InstruccionAnexoModel;

public interface IAnexoInstructionService {

	InstruccionAnexoModel save(Long idInstrNvas, Long folio, MultipartFile file, String tipoArchivo);
	
}
