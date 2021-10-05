package mx.santander.fiduciario.instruccionregistro.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrReqDto;
import mx.santander.fiduciario.instruccionregistro.exception.GeneralException;
import mx.santander.fiduciario.instruccionregistro.exception.InvalidDataException;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.GeneralCatalog;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.InvalidDataCatalog;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.LevelException;
import mx.santander.fiduciario.instruccionregistro.gestion.response.ErrorList;
import mx.santander.fiduciario.instruccionregistro.gestion.response.UserModel;
import mx.santander.fiduciario.instruccionregistro.notification.request.NotificationReq;
import mx.santander.fiduciario.instruccionregistro.notification.response.NotificacionResponseDto;


@Service
public class NotificationService implements INotificationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

	@Autowired
	private RestTemplate clienteRest;
	private ObjectMapper mapper = new ObjectMapper();	
	@Value("${config.uri.notification}")
	private String uri;
	@Value("${config.uri.email}")
	private String uriEmail;
	@Override
	public NotificacionResponseDto notification(String jsonRequest) {
		
		// Objeto entrada Request DTO
		SendInstrReqDto instrReqDto = null;
		// Objeto mapeer String to DTO
		ObjectMapper mapper = new ObjectMapper();
		try {System.out.println(jsonRequest);
			instrReqDto = mapper.readValue(jsonRequest, SendInstrReqDto.class);
			System.out.println("mundo");
		} catch (IOException | IllegalArgumentException e) { // Error al Mapear JSON a DTO
			LOGGER.error("Operacion: saveInstructions, error en la estructura del JSON de entrada.");
			throw new InvalidDataException(InvalidDataCatalog.INVD001, "Error en la estructura del JSON de entrada.");
		}

		
		NotificationReq req=NotificationReq.builder().buc(instrReqDto.getBuc().getId()).build();
		req.setEmail(getEmail(req.getBuc()));
		getEmail(req.getBuc());
		HttpEntity<NotificationReq> body = new HttpEntity<NotificationReq>(req);
		ResponseEntity<NotificacionResponseDto> response=null;
		try {
			response = clienteRest.exchange(uri, HttpMethod.POST, body,
					NotificacionResponseDto.class);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	


		System.out.println(response.getBody());
		return response.getBody();
	}
	private String getEmail(String buc) {
		UserModel userModel;
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("buc", buc);

		try {
			userModel = clienteRest.getForObject("https://authcontroller.herokuapp.com/authcontrol/v1/users/{buc}", UserModel.class,
					pathVariable);
		} catch (HttpClientErrorException e) {
			LOGGER.error("No se encontro recurso, buc: {}", buc);

			ErrorList errorList = null;
			LOGGER.error("ERROR OBTENIDO DEL SERVICIO: {}", e.getResponseBodyAsString());
			try {
				errorList = mapper.readValue(e.getResponseBodyAsString(), ErrorList.class);
				LOGGER.error("ERROR OBTENIDO2: {}", errorList.toString());
			} catch (Exception e1) {
				throw new GeneralException(GeneralCatalog.GRAL001, "error generico");

			}

			throw new GeneralException(errorList.getErrors().get(0).getCode(),
					errorList.getErrors().get(0).getMessage(), errorList.getErrors().get(0).getDescription(),
					HttpStatus.FORBIDDEN, LevelException.valueOf(errorList.getErrors().get(0).getLevel()));

		}
		
		
	return userModel.getMail();	
	}

}
