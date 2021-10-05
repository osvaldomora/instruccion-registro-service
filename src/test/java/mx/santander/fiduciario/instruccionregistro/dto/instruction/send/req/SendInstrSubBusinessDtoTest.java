package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SendInstrSubBusinessDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newSendInstrSubBusinessDto_success1() {
		SendInstrSubBusinessDto sendInstrSubBusinessDto = SendInstrSubBusinessDto.builder()
											.id(12345L)
											.build();
		assertAll(
					() -> assertEquals((Long)12345L, sendInstrSubBusinessDto.getId()),
					() -> assertNotEquals("",sendInstrSubBusinessDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newSendInstrSubBusinessDto_success2() {
		SendInstrSubBusinessDto sendInstrSubBusinessDto = new SendInstrSubBusinessDto();
		SendInstrSubBusinessDto sendInstrSubBusinessDto2 = new SendInstrSubBusinessDto();
		assertAll(
				() -> assertTrue(sendInstrSubBusinessDto.canEqual(sendInstrSubBusinessDto2)),
				() -> assertTrue(sendInstrSubBusinessDto.equals(sendInstrSubBusinessDto2)),
				() -> assertEquals(sendInstrSubBusinessDto.hashCode(), sendInstrSubBusinessDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newSendInstrSubBusinessDto_success3() {
		SendInstrSubBusinessDto sendInstrSubBusinessDto = new SendInstrSubBusinessDto();
		sendInstrSubBusinessDto.setId(12345L);
		assertNotNull(sendInstrSubBusinessDto.getId());
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendInstrSubBusinessDto_fail1() {
		SendInstrSubBusinessDto sendInstrSubBusinessDto = SendInstrSubBusinessDto.builder()
																.id(null)
																.build();
		assertAll(
				() -> assertNull(sendInstrSubBusinessDto.getId())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendInstrSubBusinessDto_fail2() {
		SendInstrSubBusinessDto sendInstrSubBusinessDto = new SendInstrSubBusinessDto();
		assertAll(
				() -> assertNull(sendInstrSubBusinessDto.getId())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newSendInstrSubBusinessDto_fail3() {
		SendInstrSubBusinessDto sendInstrSubBusinessDto = null;
		assertNull(sendInstrSubBusinessDto);
	}	

}
