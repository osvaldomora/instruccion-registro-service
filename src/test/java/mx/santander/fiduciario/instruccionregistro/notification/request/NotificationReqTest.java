package mx.santander.fiduciario.instruccionregistro.notification.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotificationReqTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newNotificationReq_success1() {
		NotificationReq notificationReq = NotificationReq.builder()
											.buc("1234567890")
											.build();
		assertAll(
					() -> assertEquals("1234567890", notificationReq.getBuc()),
					() -> assertNotEquals("",notificationReq.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newNotificationReq_success2() {
		NotificationReq notificationReq = new NotificationReq();
		NotificationReq notificationReq2 = new NotificationReq();
		assertAll(
				() -> assertTrue(notificationReq.canEqual(notificationReq2)),
				() -> assertTrue(notificationReq.equals(notificationReq2)),
				() -> assertEquals(notificationReq.hashCode(), notificationReq2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newNotificationReq_success3() {
		NotificationReq notificationReq = new NotificationReq();
		notificationReq.setBuc("1234567890");
		
		assertEquals("1234567890", notificationReq.getBuc());
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newNotificationReq_fail1() {
		NotificationReq notificationReq = NotificationReq.builder()
											.buc(null)
											.build();
		
		assertNull(notificationReq.getBuc());
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newNotificationReq_fail2() {
		NotificationReq notificationReq = new NotificationReq();
		
		assertNull(notificationReq.getBuc());
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newNotificationReq_fail3() {
		NotificationReq notificationReq = null;
		assertNull(notificationReq);
	}

}
