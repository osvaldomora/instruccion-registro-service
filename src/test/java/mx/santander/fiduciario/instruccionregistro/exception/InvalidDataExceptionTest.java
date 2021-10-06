package mx.santander.fiduciario.instruccionregistro.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mx.santander.fiduciario.instruccionregistro.exception.catalog.InvalidDataCatalog;

class InvalidDataExceptionTest {

	@Test
	@DisplayName("Constructor con parametros descripcion, excepcion-dato-invalido, CASO_EXITO")
	void createInvalidDataException_success1() {
		
		InvalidDataException invalidDataException = new InvalidDataException(
													InvalidDataCatalog.INVD001,
													"Descripcion");
		
		assertAll(
					() -> assertNotNull(invalidDataException),
					() -> assertNotNull(invalidDataException.getCode()),
					() -> assertNotNull(invalidDataException.getDescription()),
					() -> assertNotNull(invalidDataException.getHttpStatus()),
					() -> assertNotNull(invalidDataException.getLevel()),
					() -> assertNotNull(invalidDataException.getMessage())
				);
		
	}
	
	@Test
	@DisplayName("Constructor con parametros sin descripcion, excepcion-dato-invalido, CASO_EXITO")
	void createInvalidDataException_success2() {
		
		InvalidDataException invalidDataException = new InvalidDataException(InvalidDataCatalog.INVD001);
		
		assertAll(
					() -> assertNotNull(invalidDataException),
					() -> assertNotNull(invalidDataException.getCode()),
					() -> assertNull(invalidDataException.getDescription()),
					() -> assertNotNull(invalidDataException.getHttpStatus()),
					() -> assertNotNull(invalidDataException.getLevel()),
					() -> assertNotNull(invalidDataException.getMessage())
				);
		
	}

}
