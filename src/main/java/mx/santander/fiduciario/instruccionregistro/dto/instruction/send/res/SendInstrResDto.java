package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se transforman los datos de envio de instrucciones 
 * Este DTO contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendInstrResDto implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	// Variable data 
	public SendInstrDataDto data;
}//Fin de la clase 
