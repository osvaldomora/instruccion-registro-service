package mx.santander.fiduciario.instruccionregistro.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mx.santander.fiduciario.instruccionregistro.exception.catalog.PersistenDataCatalog;

class PersistenDataExceptionTest {

	@Test
	@DisplayName("Constructor con parametros descripcion, excepcion-persistencia, CASO_EXITO")
	void createPersistenDataException_success1() {
		
		PersistenDataException persistenDataException = new PersistenDataException(
													PersistenDataCatalog.PSID001,
													"Descripcion");
		
		assertAll(
					() -> assertNotNull(persistenDataException),
					() -> assertNotNull(persistenDataException.getCode()),
					() -> assertNotNull(persistenDataException.getDescription()),
					() -> assertNotNull(persistenDataException.getHttpStatus()),
					() -> assertNotNull(persistenDataException.getLevel()),
					() -> assertNotNull(persistenDataException.getMessage())
				);
		
	}
	
	@Test
	@DisplayName("Constructor con parametros sin descripcion, excepcion-persistencia, CASO_EXITO")
	void createPersistenDataException_success2() {
		
		PersistenDataException persistenDataException = new PersistenDataException(PersistenDataCatalog.PSID001);
		
		assertAll(
					() -> assertNotNull(persistenDataException),
					() -> assertNotNull(persistenDataException.getCode()),
					() -> assertNull(persistenDataException.getDescription()),
					() -> assertNotNull(persistenDataException.getHttpStatus()),
					() -> assertNotNull(persistenDataException.getLevel()),
					() -> assertNotNull(persistenDataException.getMessage())
				);
		
	}

}
