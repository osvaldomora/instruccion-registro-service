package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mx.santander.fiduciario.instruccionregistro.dto.notification.res.NotificationDto;

class SendInstrDataDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newSendInstrDataDto_success1() {
		SendInstrDataDto sendInstrDataDto = SendInstrDataDto.builder()
											.notification(new NotificationDto())
											.build();
		assertAll(
					() -> assertTrue(sendInstrDataDto.getFolios().isEmpty()),
					() -> assertNotNull(sendInstrDataDto.getNotification()),
					() -> assertNotEquals("",sendInstrDataDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newSendInstrDataDto_success2() {
		SendInstrDataDto sendInstrDataDto = new SendInstrDataDto();
		SendInstrDataDto sendInstrDataDto2 = new SendInstrDataDto();
		assertAll(
				() -> assertTrue(sendInstrDataDto.canEqual(sendInstrDataDto2)),
				() -> assertTrue(sendInstrDataDto.equals(sendInstrDataDto2)),
				() -> assertEquals(sendInstrDataDto.hashCode(), sendInstrDataDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newSendInstrDataDto_success3() {
		SendInstrDataDto sendInstrDataDto = new SendInstrDataDto();
		sendInstrDataDto.setNotification(new NotificationDto());
		assertAll(
				() -> assertTrue(sendInstrDataDto.getFolios().isEmpty()),
				() -> assertNotNull(sendInstrDataDto.getNotification())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendInstrDataDto_fail1() {
		SendInstrDataDto sendInstrDataDto = SendInstrDataDto.builder()
												.notification(null)
												.build();
		assertAll(
				() -> assertTrue(sendInstrDataDto.getFolios().isEmpty()),
				() -> assertNull(sendInstrDataDto.getNotification())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newSendInstrDataDto_fail2() {
		SendInstrDataDto sendInstrDataDto = new SendInstrDataDto();
		assertAll(
				() -> assertTrue(sendInstrDataDto.getFolios().isEmpty()),
				() -> assertNull(sendInstrDataDto.getNotification())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newSendInstrDataDto_fail3() {
		SendInstrDataDto sendInstrDataDto = null;
		assertNull(sendInstrDataDto);
	}

}
