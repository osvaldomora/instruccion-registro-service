package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SendInstrBusinessDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newSendInstrBusinessDto_success1() {
		SendInstrBusinessDto sendInstrBusinessDto = SendInstrBusinessDto.builder()
											.id(12345L)
											.subBusiness(SendInstrSubBusinessDto.builder().build())
											.build();
		assertAll(
					() -> assertEquals((Long)12345L, sendInstrBusinessDto.getId()),
					() -> assertNotNull(sendInstrBusinessDto.getSubBusiness()),
					() -> assertNotEquals("",sendInstrBusinessDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newSendInstrBusinessDto_success2() {
		SendInstrBusinessDto sendInstrBusinessDto = new SendInstrBusinessDto();
		SendInstrBusinessDto sendInstrBusinessDto2 = new SendInstrBusinessDto();
		assertAll(
				() -> assertTrue(sendInstrBusinessDto.canEqual(sendInstrBusinessDto2)),
				() -> assertTrue(sendInstrBusinessDto.equals(sendInstrBusinessDto2)),
				() -> assertEquals(sendInstrBusinessDto.hashCode(), sendInstrBusinessDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newSendInstrBusinessDto_success3() {
		SendInstrBusinessDto sendInstrBusinessDto = new SendInstrBusinessDto();
		sendInstrBusinessDto.setId(12345L);
		sendInstrBusinessDto.setSubBusiness(new SendInstrSubBusinessDto());
		assertAll(
				() -> assertNotNull(sendInstrBusinessDto.getId()),
				() -> assertNotNull(sendInstrBusinessDto.getSubBusiness())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendInstrBusinessDto_fail1() {
		SendInstrBusinessDto sendInstrBusinessDto = SendInstrBusinessDto.builder()
														.id(null)
														.subBusiness(null)
														.build();
		assertAll(
					() -> assertNull(sendInstrBusinessDto.getId()),
					() -> assertNull(sendInstrBusinessDto.getSubBusiness())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendInstrBusinessDto_fail2() {
		SendInstrBusinessDto sendInstrBusinessDto = new SendInstrBusinessDto();
		assertAll(
					() -> assertNull(sendInstrBusinessDto.getId()),
					() -> assertNull(sendInstrBusinessDto.getSubBusiness())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newSendInstrBusinessDto_fail3() {
		SendInstrBusinessDto sendInstrBusinessDto = null;
		assertNull(sendInstrBusinessDto);
	}
}
