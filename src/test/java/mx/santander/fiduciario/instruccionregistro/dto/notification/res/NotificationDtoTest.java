package mx.santander.fiduciario.instruccionregistro.dto.notification.res;

import static org.assertj.core.api.Assertions.not;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotificationDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newNotificationDto_success1() {
		NotificationDto notificationDto = NotificationDto.builder()
											.notification(new Notification())
											.build();
		assertAll(
					() -> assertNotNull(notificationDto.getNotification()),
					() -> assertNotEquals("",notificationDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newNotificationDto_success2() {
		NotificationDto notificationDto = new NotificationDto();
		NotificationDto notificationDto2 = new NotificationDto();
		assertAll(
				() -> assertTrue(notificationDto.canEqual(notificationDto2)),
				() -> assertTrue(notificationDto.equals(notificationDto2)),
				() -> assertEquals(notificationDto.hashCode(), notificationDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newNotificationDto_success3() {
		NotificationDto notificationDto = new NotificationDto();
		notificationDto.setNotification(new Notification());
		
		assertNotNull(notificationDto.getNotification());
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newNotificationDto_fail1() {
		NotificationDto notificationDto = NotificationDto.builder()
											.notification(null)
											.build();
		
		assertNull(notificationDto.getNotification());
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newNotificationDto_fail2() {
		NotificationDto notificationDto = new NotificationDto();

		assertNull(notificationDto.getNotification());
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newNotificationDto_fail3() {
		NotificationDto notificationDto = null;
		assertNull(notificationDto);
	}

}
