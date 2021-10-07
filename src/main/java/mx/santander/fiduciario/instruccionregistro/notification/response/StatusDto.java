package mx.santander.fiduciario.instruccionregistro.notification.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase StatusDto
 * Modelo response que devolvera la API
 * Contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusDto implements Serializable{
	//La variable statusCode
	private String  statusCode;
	//La variable success
	private Boolean success;
	//La variable description
	private String description;
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
}//Fin de la clase 
