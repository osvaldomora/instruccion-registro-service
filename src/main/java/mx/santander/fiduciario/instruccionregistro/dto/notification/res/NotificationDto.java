package mx.santander.fiduciario.instruccionregistro.dto.notification.res;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase Notification
 * Se transforman los datos de notificaciones
 * Este DTO contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationDto implements Serializable {
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	//La variable notification
	private Notification notification;
}//Fin de la clase 
