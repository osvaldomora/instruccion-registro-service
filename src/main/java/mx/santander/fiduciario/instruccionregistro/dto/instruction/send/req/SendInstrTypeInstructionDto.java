package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se transforman los datos del envio de tipo de instruccion 
 * Este DTO contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendInstrTypeInstructionDto implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	// La variable id
	@NotNull
	private Long id;
	//La variable codeDoc
	@NotNull
    private Long codeDoc;
	//La variable name
	@NotNull
    private String name;
}//Fin de la clase 
