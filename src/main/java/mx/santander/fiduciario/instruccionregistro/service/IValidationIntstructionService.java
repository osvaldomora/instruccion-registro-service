package mx.santander.fiduciario.instruccionregistro.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import mx.santander.fiduciario.instruccionregistro.dto.validateinstruction.DataValidationInstructionResDto;

/**
 * Interface IValidationIntstructionService
 * @author 
 */
public interface IValidationIntstructionService {

	/**
	 * Netodo que permite validar la sintaxis de un 
	 * arhivo enviado
	 * @param files archivos enviados
	 * @return DataValidationInstructionResDto DTO salida de validacion
	 */
	DataValidationInstructionResDto validate (List<MultipartFile> files);	
}
