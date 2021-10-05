package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SendIntrsBucDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newSendIntrsBucDto_success1() {
		SendIntrsBucDto sendIntrsBucDto = SendIntrsBucDto.builder()
											.id("12345")
											.clavePo(123L)
											.build();
		assertAll(
				() -> assertEquals("12345", sendIntrsBucDto.getId()),
				() -> assertEquals((Long)123L, sendIntrsBucDto.getClavePo()),
				() -> assertNotEquals("",sendIntrsBucDto.toString())
				);
		
	}
	
	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newSendIntrsBucDto_success2() {
		SendIntrsBucDto sendIntrsBucDto = new SendIntrsBucDto();
		SendIntrsBucDto sendIntrsBucDto2 = new SendIntrsBucDto();
		assertAll(
				() -> assertTrue(sendIntrsBucDto.canEqual(sendIntrsBucDto2)),
				() -> assertTrue(sendIntrsBucDto.equals(sendIntrsBucDto2)),
				() -> assertEquals(sendIntrsBucDto.hashCode(), sendIntrsBucDto2.hashCode())
				);
	}
	
	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newSendIntrsBucDto_success3() {
		SendIntrsBucDto sendIntrsBucDto = new SendIntrsBucDto();
		sendIntrsBucDto.setId("12345");
		sendIntrsBucDto.setClavePo(123L);
		assertAll(
				() -> assertNotNull(sendIntrsBucDto.getId()),
				() -> assertNotNull(sendIntrsBucDto.getClavePo())
				);
	}
	
	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendIntrsBucDto_fail1() {
		SendIntrsBucDto sendIntrsBucDto = SendIntrsBucDto.builder()
											.id(null)
											.clavePo(null)
											.build();
		assertAll(
				() -> assertNull(sendIntrsBucDto.getId()),
				() -> assertNull(sendIntrsBucDto.getClavePo())
				);	
	}
	
	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendIntrsBucDto_fail2() {
		SendIntrsBucDto sendIntrsBucDto = new SendIntrsBucDto();
		assertAll(
				() -> assertNull(sendIntrsBucDto.getId()),
				() -> assertNull(sendIntrsBucDto.getClavePo())
				);	
	}
	
	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newSendIntrsBucDto_fail3() {
		SendIntrsBucDto sendIntrsBucDto = null;
		assertNull(sendIntrsBucDto);
	}

}
