package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SendInstrResDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newSendInstrResDto_success1() {
		SendInstrResDto sendInstrResDto = SendInstrResDto.builder()
											.data(new SendInstrDataDto())
											.build();
		assertAll(
					() -> assertNotNull(sendInstrResDto.getData()),
					() -> assertNotEquals("",sendInstrResDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newSendInstrResDto_success2() {
		SendInstrResDto sendInstrResDto = new SendInstrResDto();
		SendInstrResDto sendInstrResDto2 = new SendInstrResDto();
		assertAll(
				() -> assertTrue(sendInstrResDto.canEqual(sendInstrResDto2)),
				() -> assertTrue(sendInstrResDto.equals(sendInstrResDto2)),
				() -> assertEquals(sendInstrResDto.hashCode(), sendInstrResDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newSendInstrResDto_success3() {
		SendInstrResDto sendInstrResDto = new SendInstrResDto();
		sendInstrResDto.setData(new SendInstrDataDto());
		
		assertNotNull(sendInstrResDto.getData());
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendInstrResDto_fail1() {
		SendInstrResDto sendInstrResDto = SendInstrResDto.builder()
											.data(null)
											.build();
		assertNull(sendInstrResDto.getData());
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newSendInstrResDto_fail2() {
		SendInstrResDto sendInstrResDto = new SendInstrResDto();
		
		assertNull(sendInstrResDto.getData());	
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newSendInstrResDto_fail3() {
		SendInstrResDto sendInstrResDto = null;
		assertNull(sendInstrResDto);
	}

}
