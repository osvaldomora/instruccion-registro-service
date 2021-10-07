package mx.santander.fiduciario.instruccionregistro.notification.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase NotificacionResponseDto
 * Modelo response que devolvera la API
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificacionResponseDto implements Serializable{
	//La variable status 
	private StatusDto status;
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
}//Fin de la clase 
