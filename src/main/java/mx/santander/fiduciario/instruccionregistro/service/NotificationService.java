package mx.santander.fiduciario.instruccionregistro.service;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrReqDto;
import mx.santander.fiduciario.instruccionregistro.exception.GeneralException;
import mx.santander.fiduciario.instruccionregistro.exception.InvalidDataException;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.GeneralCatalog;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.InvalidDataCatalog;
import mx.santander.fiduciario.instruccionregistro.notification.request.NotificationReq;
import mx.santander.fiduciario.instruccionregistro.notification.response.NotificacionResponseDto;
import mx.santander.fiduciario.instruccionregistro.notification.response.StatusDto;

/**
 * La clase NotificationService
 * Este microservicio,encargada 
 * de orquestador la logica 
 * de negocio 
 * @author Z334926
 */
@Service
public class NotificationService implements INotificationService {
	
	// La Constante LOGGER. Obtiene el Logger de la clase
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
	//La variable clienteRest
	@Autowired
	private RestTemplate clienteRest;
	//La variable uri
	@Value("${config.uri.notification}")
	private String uri;
	
	/**
	 * Metodo notification
	 * @param jsonRequest json
	 * @return NotificacionResponseDto respuesta de notificaciones
	 */
	@Override
	public NotificacionResponseDto notification(String jsonRequest) {
		
		// Objeto entrada Request DTO
		SendInstrReqDto instrReqDto = null;
		// Objeto mapeer String to DTO
		ObjectMapper mapper = new ObjectMapper();
		try {
			instrReqDto = mapper.readValue(jsonRequest, SendInstrReqDto.class);
		} catch (IOException | IllegalArgumentException e) { // Error al Mapear JSON a DTO
			LOGGER.error("Operacion: saveInstructions, error en la estructura del JSON de entrada.");
			throw new InvalidDataException(InvalidDataCatalog.INVD001, "Error en la estructura del JSON de entrada.");
		}

		
		NotificationReq req=NotificationReq.builder().buc(instrReqDto.getBuc().getId()).build();
	
		HttpEntity<NotificationReq> body = new HttpEntity<NotificationReq>(req);
		ResponseEntity<NotificacionResponseDto> response=null;
		try {
			response = clienteRest.exchange(uri, HttpMethod.POST, body,
					NotificacionResponseDto.class);
		} catch (RestClientException e) {
			LOGGER.error("Error al consumir la api de notificaciones {}",e);
			//throw new GeneralException( GeneralCatalog.GRAL001,"Error al consumir el servicio de notificaciones");
			return NotificacionResponseDto.builder().status(StatusDto.builder().success(false).description("no se pudo enviar el email").build()).build();
		}
	
		return response.getBody();
	}//Fin del metodo 
}//Fin de la clase
