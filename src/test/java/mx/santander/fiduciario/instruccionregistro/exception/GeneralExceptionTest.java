package mx.santander.fiduciario.instruccionregistro.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import mx.santander.fiduciario.instruccionregistro.exception.catalog.GeneralCatalog;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.LevelException;

class GeneralExceptionTest {

	@Test
	@DisplayName("Constructor con parametros descripcion, excepcion-general, CASO_EXITO")
	void createGeneralException_success1() {
		
		GeneralException generalException = new GeneralException(
													GeneralCatalog.GRAL001,
													"Descripcion");
		
		assertAll(
					() -> assertNotNull(generalException),
					() -> assertNotNull(generalException.getCode()),
					() -> assertNotNull(generalException.getDescription()),
					() -> assertNotNull(generalException.getHttpStatus()),
					() -> assertNotNull(generalException.getLevel()),
					() -> assertNotNull(generalException.getMessage())
				);
		
	}
	
	@Test
	@DisplayName("Constructor con parametros sin descripcion, excepcion-general, CASO_EXITO")
	void createGeneralException_success2() {
		
		GeneralException generalException = new GeneralException(GeneralCatalog.GRAL001);
		
		assertAll(
					() -> assertNotNull(generalException),
					() -> assertNotNull(generalException.getCode()),
					() -> assertNull(generalException.getDescription()),
					() -> assertNotNull(generalException.getHttpStatus()),
					() -> assertNotNull(generalException.getLevel()),
					() -> assertNotNull(generalException.getMessage())
				);
		
	}
	
	@Test
	@DisplayName("Constructor con parametros, excepcion-general, CASO_EXITO")
	void createGeneralException_success3() {
		
		GeneralException generalException = new GeneralException(
													"GRAL.001","Error generico de servidor.",
													"Descripcion errror General",
													HttpStatus.INTERNAL_SERVER_ERROR,
													LevelException.ERROR);
		
		assertAll(
					() -> assertNotNull(generalException),
					() -> assertNotNull(generalException.getCode()),
					() -> assertNotNull(generalException.getDescription()),
					() -> assertNotNull(generalException.getHttpStatus()),
					() -> assertNotNull(generalException.getLevel()),
					() -> assertNotNull(generalException.getMessage())
				);
		
	}

}
