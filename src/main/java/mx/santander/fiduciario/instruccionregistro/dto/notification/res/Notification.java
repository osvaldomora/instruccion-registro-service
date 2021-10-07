package mx.santander.fiduciario.instruccionregistro.dto.notification.res;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase Notification
 * Contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author glenn
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Notification implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	//La variable success
	private Boolean success;
	//La variable description
	private String description;
}//Fin de la clase 
