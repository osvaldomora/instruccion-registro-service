package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SendInstrReqDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newSendInstrReqDto_success1() {
		SendInstrReqDto sendInstrReqDto = SendInstrReqDto.builder()
											.buc(new SendIntrsBucDto())
											.typeInstruction(new SendInstrTypeInstructionDto())
											.business(new SendInstrBusinessDto())
											.build();
		assertAll(
					() -> assertNotNull(sendInstrReqDto.getBuc()),
					() -> assertNotNull(sendInstrReqDto.getTypeInstruction()),
					() -> assertNotNull(sendInstrReqDto.getBusiness()),
					() -> assertTrue(sendInstrReqDto.getFiles().isEmpty()),
					() -> assertNotEquals("",sendInstrReqDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newSendInstrReqDto_success2() {
		SendInstrReqDto sendInstrReqDto = new SendInstrReqDto();
		SendInstrReqDto sendInstrReqDto2 = new SendInstrReqDto();
		assertAll(
				() -> assertTrue(sendInstrReqDto.canEqual(sendInstrReqDto2)),
				() -> assertTrue(sendInstrReqDto.equals(sendInstrReqDto2)),
				() -> assertEquals(sendInstrReqDto.hashCode(), sendInstrReqDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newSendInstrReqDto_success3() {
		SendInstrReqDto sendInstrReqDto = new SendInstrReqDto();
		sendInstrReqDto.setBuc(new SendIntrsBucDto());
		sendInstrReqDto.setTypeInstruction(new SendInstrTypeInstructionDto());
		sendInstrReqDto.setBusiness(new SendInstrBusinessDto());
		assertAll(
					() -> assertNotNull(sendInstrReqDto.getBuc()),
					() -> assertNotNull(sendInstrReqDto.getTypeInstruction()),
					() -> assertNotNull(sendInstrReqDto.getBusiness()),
					() -> assertTrue(sendInstrReqDto.getFiles().isEmpty())
				);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendInstrReqDto_fail1() {
		SendInstrReqDto sendInstrReqDto = SendInstrReqDto.builder()
											.buc(null)
											.typeInstruction(null)
											.business(null)
											.build();
		assertAll(
					() -> assertNull(sendInstrReqDto.getBuc()),
					() -> assertNull(sendInstrReqDto.getTypeInstruction()),
					() -> assertNull(sendInstrReqDto.getBusiness())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newSendInstrReqDto_fail2() {
		SendInstrReqDto sendInstrReqDto = new SendInstrReqDto();
		assertAll(
				() -> assertNull(sendInstrReqDto.getBuc()),
				() -> assertNull(sendInstrReqDto.getTypeInstruction()),
				() -> assertNull(sendInstrReqDto.getBusiness())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newSendInstrReqDto_fail3() {
		SendInstrReqDto sendInstrReqDto = null;
		assertNull(sendInstrReqDto);
	}


}
