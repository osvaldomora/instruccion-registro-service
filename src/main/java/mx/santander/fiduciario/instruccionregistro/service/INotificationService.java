package mx.santander.fiduciario.instruccionregistro.service;

import mx.santander.fiduciario.instruccionregistro.notification.response.NotificacionResponseDto;

/**
 * Interface INotificationService
 * @author 
 */
public interface INotificationService {
	/**
	 * Metodo notification
	 * @param jsonRequest por Json
	 * @return NotificacionResponseDto Respuesta de notificacion
	 */
	 NotificacionResponseDto notification(String jsonRequest);
}//Fin de la interface 
