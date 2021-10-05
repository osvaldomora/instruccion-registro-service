package mx.santander.fiduciario.instruccionregistro.service;

import mx.santander.fiduciario.instruccionregistro.notification.response.NotificacionResponseDto;

public interface INotificationService {
	
	public NotificacionResponseDto notification(String jsonRequest);
	
	

}
