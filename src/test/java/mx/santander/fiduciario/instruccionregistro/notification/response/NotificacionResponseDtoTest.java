package mx.santander.fiduciario.instruccionregistro.notification.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotificacionResponseDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newNotificacionResponseDto_success1() {
		NotificacionResponseDto notificacionResponseDto = NotificacionResponseDto.builder()
															.status(new StatusDto())
															.build();
		assertAll(
					() -> assertNotNull(notificacionResponseDto.getStatus()),
					() -> assertNotEquals("",notificacionResponseDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newNotificacionResponseDto_success2() {
		NotificacionResponseDto notificacionResponseDto = new NotificacionResponseDto();
		NotificacionResponseDto notificacionResponseDto2 = new NotificacionResponseDto();
		assertAll(
				() -> assertTrue(notificacionResponseDto.canEqual(notificacionResponseDto2)),
				() -> assertTrue(notificacionResponseDto.equals(notificacionResponseDto2)),
				() -> assertEquals(notificacionResponseDto.hashCode(), notificacionResponseDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newNotificacionResponseDto_success3() {
		NotificacionResponseDto notificacionResponseDto = new NotificacionResponseDto();
		notificacionResponseDto.setStatus(new StatusDto());
		
		assertNotNull(notificacionResponseDto.getStatus());
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newNotificacionResponseDto_fail1() {
		NotificacionResponseDto notificacionResponseDto = NotificacionResponseDto.builder()
																.status(null)
																.build();
		assertNull(notificacionResponseDto.getStatus());	
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newNotificacionResponseDto_fail2() {
		NotificacionResponseDto notificacionResponseDto = new NotificacionResponseDto();
		
		assertNull(notificacionResponseDto.getStatus());		
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newNotificacionResponseDto_fail3() {
		NotificacionResponseDto notificacionResponseDto = null;
		assertNull(notificacionResponseDto);
	}

}
