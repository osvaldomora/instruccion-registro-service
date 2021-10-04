package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase SendInstrSubBusinessDto
 * Se transforman los datos del envio 
 * de instruccion de subcontrato
 * Este DTO contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendInstrSubBusinessDto implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	//La variable id
	@NotNull
	private Long id;
}//Fin de la clase 
