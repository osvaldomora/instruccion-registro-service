package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SendInstrFileDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newSendInstrFileDto_success1() {
		SendInstrFileDto sendInstrFileDto = SendInstrFileDto.builder()
											.type("INSTRUCCION")
											.size(123L)
											.name("archivo.pdf")
											.build();
		assertAll(
					() -> assertEquals("INSTRUCCION", sendInstrFileDto.getType()),
					() -> assertEquals("archivo.pdf", sendInstrFileDto.getName()),
					() -> assertEquals((Long)123L, sendInstrFileDto.getSize()),
					() -> assertNotEquals("",sendInstrFileDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newSendInstrFileDto_success2() {
		SendInstrFileDto sendInstrFileDto = new SendInstrFileDto();
		SendInstrFileDto sendInstrFileDto2 = new SendInstrFileDto();
		assertAll(
				() -> assertTrue(sendInstrFileDto.canEqual(sendInstrFileDto2)),
				() -> assertTrue(sendInstrFileDto.equals(sendInstrFileDto2)),
				() -> assertEquals(sendInstrFileDto.hashCode(), sendInstrFileDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newSendInstrFileDto_success3() {
		SendInstrFileDto sendInstrFileDto = new SendInstrFileDto();
		sendInstrFileDto.setType("INSTRUCCION");
		sendInstrFileDto.setSize(123L);
		sendInstrFileDto.setName("archivo.pdf");
		
		assertAll(
					() -> assertNotNull(sendInstrFileDto.getType()),
					() -> assertNotNull(sendInstrFileDto.getSize()),
					() -> assertNotNull(sendInstrFileDto.getName())
				);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendInstrFileDto_fail1() {
		SendInstrFileDto sendInstrFileDto = SendInstrFileDto.builder()
												.type(null)
												.size(null)
												.name(null)
												.build();
		assertAll(
				() -> assertNull(sendInstrFileDto.getType()),
				() -> assertNull(sendInstrFileDto.getSize()),
				() -> assertNull(sendInstrFileDto.getName())
			);	
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendInstrFileDto_fail2() {
		SendInstrFileDto sendInstrFileDto = new SendInstrFileDto();
		assertAll(
				() -> assertNull(sendInstrFileDto.getType()),
				() -> assertNull(sendInstrFileDto.getSize()),
				() -> assertNull(sendInstrFileDto.getName())
			);		
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newSendInstrFileDto_fail3() {
		SendInstrFileDto sendInstrFileDto = null;
		assertNull(sendInstrFileDto);
	}

}
