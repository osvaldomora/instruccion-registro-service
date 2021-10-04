package mx.santander.fiduciario.instruccionregistro.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import lombok.Setter;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res.SendInstrResDto;
import mx.santander.fiduciario.instruccionregistro.service.IInstructionSendService;

/**
 * Este controlador permite realizar diferentes operaciones HTTP, asociado al
 * recurso intructions Se cuenta con los service: 1.- typeInstruction: Servicio
 * encargado de manejar recurso de tipo de instrucciones
 * @author 
 */
@Setter
@RestController
@RequestMapping("/instructions/v1")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST }, allowedHeaders = "*")
public class InstructionController {

	// La Constante LOGGER. Obtiene el Logger de la clase
	private static final Logger LOGGER = LoggerFactory.getLogger(InstructionController.class);

	//Variabl de servicio instrucciones
	@Autowired
	private IInstructionSendService instructionSendService;
	
	/**
	 * Este es un metodo HTTP GET consulta el recurso de tipo de instruccion y en la
	 * implementacion de la interfaz de negocio typeInstructionService puede
	 * realizar ciertas transformaciones DTO a la consulta para enriquecer la
	 * presentacion.
	 * Este metodo es idempotente, y sus procesos derivados NUNCA deben modificar el
	 * estado de algun recurso en el servidor. TODOS los procesos desencadenados
	 * deben ser solo de consulta.
	 * @param files archivo 
	 * @param instruction instruccion 
	 * @return ResponseEntity<?> Una lista de typeInstructions en un objeto JSON obtenido
	 */
	@PostMapping(value = "/instructions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> saveInstructions(@RequestParam(name = "files", required = true) List<MultipartFile> files,
			@RequestParam(name = "instruction", required = true) String instruction) {
		
		LOGGER.info("Metodo: POST, Operacion: saveInstructions, tamanio files: {}, JSON entrada: {}",files.size(),instruction);
		
		SendInstrResDto instrResDto = instructionSendService.saveInstructions(instruction, files);
		
		if (instrResDto.getData().getFolios().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(instrResDto);
	}//Fin del metodo 
}//Fin de la clase 