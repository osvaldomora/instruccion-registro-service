package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se transforman los datos del envio de la instruccion del archivo
 * Este DTO contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendInstrFileDto implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	// La variable type
	private String type;
	//La variable size 
    private Long size;
    //La variable name 
    private String name;
}//Fin de la clase 
