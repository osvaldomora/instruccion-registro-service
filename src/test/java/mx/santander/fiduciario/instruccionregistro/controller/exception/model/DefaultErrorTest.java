package mx.santander.fiduciario.instruccionregistro.controller.exception.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class DefaultErrorTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newDefaultError_success1() {
		DefaultError defaultError = new DefaultError(
											"BUSI.001",
											"Error general servidor",
											"ERROR",
											"Descripcion de error",
											"path:/");
		assertAll(
					() -> assertEquals("BUSI.001", defaultError.getCode()),
					() -> assertEquals("Error general servidor", defaultError.getMessage()),
					() -> assertEquals("ERROR", defaultError.getLevel()),
					() -> assertEquals("Descripcion de error", defaultError.getDescription()),
					() -> assertNotEquals("",defaultError.toString())
				);
		
	}


	@Test
	@DisplayName("Crea Objecto todos los parametros sin descripcion, CASO_EXITO")
	void newDefaultError_success2() {
		DefaultError defaultError = new DefaultError(
										"BUSI.001",
										"Error general servidor",
										"ERROR",
										"path:/");
		assertAll(
					() -> assertEquals("BUSI.001", defaultError.getCode()),
					() -> assertEquals("Error general servidor", defaultError.getMessage()),
					() -> assertEquals("ERROR", defaultError.getLevel()),
					() -> assertNull(defaultError.getDescription()),
					() -> assertNotEquals("",defaultError.toString())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newDefaultError_fail1() {
		DefaultError DefaultError = new  DefaultError(
												null, 
												null,
												null,
												null,
												null);
		assertAll(
				() -> assertNull(DefaultError.getCode()),
				() -> assertNull(DefaultError.getMessage()),
				() -> assertNull(DefaultError.getLevel()),
				() -> assertNull(DefaultError.getDescription())
			);	
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newDefaultError_fail2() {
		DefaultError DefaultError = null;
		assertNull(DefaultError);
	}

}
