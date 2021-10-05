package mx.santander.fiduciario.instruccionregistro.dto.notification.res;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotificationTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newNotification_success1() {
		Notification notification = Notification.builder()
											.success(true)
											.description("Mensaje notificacion")
											.build();
		assertAll(
					() -> assertTrue(notification.getSuccess()),
					() -> assertEquals("Mensaje notificacion", notification.getDescription()),
					() -> assertNotEquals("",notification.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newNotification_success2() {
		Notification notification = new Notification();
		Notification notification2 = new Notification();
		assertAll(
				() -> assertTrue(notification.canEqual(notification2)),
				() -> assertTrue(notification.equals(notification2)),
				() -> assertEquals(notification.hashCode(), notification2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newNotification_success3() {
		Notification notification = new Notification();
		notification.setSuccess(true);
		notification.setDescription("Mensaje notificacion");
		
		assertAll(
				() -> assertTrue(notification.getSuccess()),
				() -> assertEquals("Mensaje notificacion", notification.getDescription())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newNotification_fail1() {
		Notification notification = Notification.builder()
										.success(null)
										.description(null)
										.build();
		assertAll(
					() -> assertNull(notification.getSuccess()),
					() -> assertNull(notification.getDescription())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newNotification_fail2() {
		Notification notification = new Notification();
		
		assertAll(
				() -> assertNull(notification.getSuccess()),
				() -> assertNull(notification.getDescription())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newNotification_fail3() {
		Notification notification = null;
		assertNull(notification);
	}
	
}
