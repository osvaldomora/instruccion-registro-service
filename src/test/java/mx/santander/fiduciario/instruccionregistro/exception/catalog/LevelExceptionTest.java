package mx.santander.fiduciario.instruccionregistro.exception.catalog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LevelExceptionTest {

	@Test
	@DisplayName("Obtiene catalogo-nivel-excepcion: ERROR, CASO_EXITO")
	void getLevelExceptionError_success1() {
		
		assertEquals("ERROR", LevelException.ERROR.toString());
	}
	
	@Test
	@DisplayName("Obtiene catalogo-nivel-excepcion: WARN, CASO_EXITO")
	void getLevelExceptionWarn_success2() {
		
		assertEquals("WARN", LevelException.WARN.toString());
	}
	
	@Test
	@DisplayName("Obtiene cantidad  catalogo-nivel-excepcion, CASO_EXITO")
	void getLevelException_success3() {
		LevelException levelExceptions[] = LevelException.values();
	
		assertEquals(2, levelExceptions.length);
	}
}
