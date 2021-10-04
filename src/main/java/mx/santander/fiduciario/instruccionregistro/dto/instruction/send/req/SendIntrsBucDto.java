package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se transforman los datos de envio de instrucciones 
 * de buc este DTO contiene las propiedades del objeto 
 * para poder tener acceso a las propiedades.
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendIntrsBucDto implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	//La variable id 
	@NotNull
	private String id;
	//La variable clavePo
	private Long clavePo;
}//Fin de la clase 
