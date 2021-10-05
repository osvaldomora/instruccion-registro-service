package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SendInstrTypeInstructionDtoTest {

	@Test
	@DisplayName("Crea Objeto DTO todos los parametros, CASO_EXITO")
	void newSendTypeInsDto_success1() {
		SendInstrTypeInstructionDto typeInstructionDto = SendInstrTypeInstructionDto.builder()
															.id(1L)
															.codeDoc(205L)
															.name("Nombre de Instruccion")
															.build();
		assertAll(
				() -> assertEquals((Long)1L, typeInstructionDto.getId()),
				() -> assertEquals((Long)205L, typeInstructionDto.getCodeDoc()),
			    () -> assertEquals("Nombre de Instruccion", typeInstructionDto.getName()),
			    () -> assertNotEquals("", typeInstructionDto.toString())
				);
	}
	
	@Test
	@DisplayName("Crea Objeto DTO contructor vacio, CASO_EXITO")
	void newSendTypeInsDto_success2() {
		SendInstrTypeInstructionDto typeInstructionDto = new SendInstrTypeInstructionDto();
		SendInstrTypeInstructionDto typeInstructionDto2= new SendInstrTypeInstructionDto();
		assertAll(
					() -> assertTrue(typeInstructionDto.canEqual(typeInstructionDto2)),
					() -> assertTrue(typeInstructionDto.equals(typeInstructionDto2)),
					() -> assertEquals(typeInstructionDto.hashCode(), typeInstructionDto2.hashCode())
				);
	}
	
	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newSendTypeInsDto_success3() {
		SendInstrTypeInstructionDto typeInstructionDto = new SendInstrTypeInstructionDto();
		typeInstructionDto.setId(1234L);
		typeInstructionDto.setCodeDoc(205L);
		typeInstructionDto.setName("Nombre de Instruccion");
		assertAll(
					() -> assertNotNull(typeInstructionDto.getId()),
					() -> assertNotNull(typeInstructionDto.getCodeDoc()),
					() -> assertNotNull(typeInstructionDto.getName())
				);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendTypeInsDto_fail1() {
		SendInstrTypeInstructionDto typeInstructionDto = SendInstrTypeInstructionDto.builder()
															.id(null)
															.codeDoc(null)
															.name(null)
															.build();
		assertAll(
					() -> assertNull(typeInstructionDto.getName()),
					() -> assertNull(typeInstructionDto.getCodeDoc()),
					() -> assertNull(typeInstructionDto.getId())
				);
	}
	
	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newSendTypeInsDto_fail2() {
		SendInstrTypeInstructionDto typeInstructionDto = new SendInstrTypeInstructionDto();
		assertAll(
					() -> assertNull(typeInstructionDto.getName()),
					() -> assertNull(typeInstructionDto.getCodeDoc()),
					() -> assertNull(typeInstructionDto.getId())
				);
	}
	

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newSendTypeInsDto_fail3() {
		SendInstrTypeInstructionDto typeInstructionDto = null;
		assertNull(typeInstructionDto);
	}
	
}
