package mx.santander.fiduciario.instruccionregistro.enumerations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileRequiredTest {

	@Test
	@DisplayName("Obtiene requiere-archivo: TRUE, CASO_EXITO")
	void getFileRequireTrued_success1() {
		
		assertAll(
					() -> assertEquals("TRUE", FileRequired.TRUE.getName()),
					() -> assertTrue(FileRequired.TRUE.isValue())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene requiere-archivo: OPTIONAL, CASO_EXITO")
	void getFileRequireOptional_success2() {
		
		assertAll(
					() -> assertEquals("OPTIONAL", FileRequired.OPCIONAL.getName()),
					() -> assertFalse(FileRequired.OPCIONAL.isValue())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene cantidad require-archivo, CASO_EXITO")
	void getFileRequired_success3() {
		FileRequired filesRequired[] = FileRequired.values();
	
		assertEquals(2, filesRequired.length);
	}

}
