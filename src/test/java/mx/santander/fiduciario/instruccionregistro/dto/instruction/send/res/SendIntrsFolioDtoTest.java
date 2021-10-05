package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SendIntrsFolioDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newSendIntrsFolioDto_success1() {
		SendIntrsFolioDto sendIntrsFolioDto = SendIntrsFolioDto.builder()
											.folio(1234L)
											.folioRequest(123L)
											.fileName("archivo.pdf")
											.type("INSTRUCCION")
											.dateOperation(new Date())
											.build();
		assertAll(
					() -> assertEquals((Long)1234L,sendIntrsFolioDto.getFolio()),
					() -> assertEquals((Long)123L, sendIntrsFolioDto.getFolioRequest()),
					() -> assertEquals("archivo.pdf", sendIntrsFolioDto.getFileName()),
					() -> assertEquals("INSTRUCCION", sendIntrsFolioDto.getType()),
					() -> assertNotEquals("",sendIntrsFolioDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newSendIntrsFolioDto_success2() {
		SendIntrsFolioDto sendIntrsFolioDto = new SendIntrsFolioDto();
		SendIntrsFolioDto sendIntrsFolioDto2 = new SendIntrsFolioDto();
		assertAll(
				() -> assertTrue(sendIntrsFolioDto.canEqual(sendIntrsFolioDto2)),
				() -> assertTrue(sendIntrsFolioDto.equals(sendIntrsFolioDto2)),
				() -> assertEquals(sendIntrsFolioDto.hashCode(), sendIntrsFolioDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newSendIntrsFolioDto_success3() {
		SendIntrsFolioDto sendIntrsFolioDto = new SendIntrsFolioDto();
		sendIntrsFolioDto.setFolio(1234L);
		sendIntrsFolioDto.setFolioRequest(123L);
		sendIntrsFolioDto.setType("INSTRUCCION");
		sendIntrsFolioDto.setFileName("archivo.pdf");
		assertAll(
				() -> assertEquals((Long)1234L,sendIntrsFolioDto.getFolio()),
				() -> assertEquals((Long)123L, sendIntrsFolioDto.getFolioRequest()),
				() -> assertEquals("archivo.pdf", sendIntrsFolioDto.getFileName()),
				() -> assertEquals("INSTRUCCION", sendIntrsFolioDto.getType())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendIntrsFolioDto_fail1() {
		SendIntrsFolioDto sendIntrsFolioDto = SendIntrsFolioDto.builder()
													.folio(null)
													.folioRequest(null)
													.fileName(null)
													.type(null)
													.dateOperation(null)
													.build();
		assertAll(
				() -> assertNull(sendIntrsFolioDto.getFolio()),
				() -> assertNull(sendIntrsFolioDto.getFolioRequest()),
				() -> assertNull(sendIntrsFolioDto.getFileName()),
				() -> assertNull(sendIntrsFolioDto.getType())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newSendIntrsFolioDto_fail2() {
		SendIntrsFolioDto sendIntrsFolioDto = new SendIntrsFolioDto();
		assertAll(
				() -> assertNull(sendIntrsFolioDto.getFolio()),
				() -> assertNull(sendIntrsFolioDto.getFolioRequest()),
				() -> assertNull(sendIntrsFolioDto.getFileName()),
				() -> assertNull(sendIntrsFolioDto.getType())
			);	
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newSendIntrsFolioDto_fail3() {
		SendIntrsFolioDto sendIntrsFolioDto = null;
		assertNull(sendIntrsFolioDto);
	}
	
}
