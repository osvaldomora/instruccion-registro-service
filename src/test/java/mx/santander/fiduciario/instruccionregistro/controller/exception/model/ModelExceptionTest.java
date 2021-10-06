package mx.santander.fiduciario.instruccionregistro.controller.exception.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ModelExceptionTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newModelException_success1() {
		ModelException modelException = new ModelException(
											HttpStatus.CONFLICT, 
											"BUSI.001",
											"Error general servidor",
											"ERROR",
											"Descripcion de error");
		assertAll(
					() -> assertEquals(HttpStatus.CONFLICT, modelException.getHttpStatus()),
					() -> assertEquals("BUSI.001", modelException.getCode()),
					() -> assertEquals("Error general servidor", modelException.getMessage()),
					() -> assertEquals("ERROR", modelException.getLevel()),
					() -> assertEquals("Descripcion de error", modelException.getDescription()),
					() -> assertNotNull(ModelException.getSerialversionuid()),
					() -> assertNotEquals("",modelException.toString())
				);
		
	}


	@Test
	@DisplayName("Crea Objecto todos los parametros sin descripcion, CASO_EXITO")
	void newModelException_success2() {
		ModelException modelException = new ModelException(
												HttpStatus.CONFLICT, 
												"BUSI.001",
												"Error general servidor",
												"ERROR");
		assertAll(
					() -> assertEquals(HttpStatus.CONFLICT, modelException.getHttpStatus()),
					() -> assertEquals("BUSI.001", modelException.getCode()),
					() -> assertEquals("Error general servidor", modelException.getMessage()),
					() -> assertEquals("ERROR", modelException.getLevel()),
					() -> assertNull(modelException.getDescription()),
					() -> assertNotNull(ModelException.getSerialversionuid()),
					() -> assertNotEquals("",modelException.toString())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newModelException_fail1() {
		ModelException modelException = new  ModelException(
												null, 
												null,
												null,
												null,
												null);
		assertAll(
				() -> assertNull(modelException.getHttpStatus()),
				() -> assertNull(modelException.getCode()),
				() -> assertNull(modelException.getMessage()),
				() -> assertNull(modelException.getLevel()),
				() -> assertNull(modelException.getDescription())
			);	
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newModelException_fail2() {
		ModelException modelException = null;
		assertNull(modelException);
	}

}
