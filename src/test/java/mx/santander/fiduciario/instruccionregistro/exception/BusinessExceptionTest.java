package mx.santander.fiduciario.instruccionregistro.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mx.santander.fiduciario.instruccionregistro.exception.catalog.BusinessCatalog;

class BusinessExceptionTest {

	@Test
	@DisplayName("Constructor con parametros descripcion, excepcion-negocio, CASO_EXITO")
	void createBusinessException_success1() {
		
		BusinessException businessException = new BusinessException(
													BusinessCatalog.BUSI001,
													"Descripcion");
		
		assertAll(
					() -> assertNotNull(businessException),
					() -> assertNotNull(businessException.getCode()),
					() -> assertNotNull(businessException.getDescription()),
					() -> assertNotNull(businessException.getHttpStatus()),
					() -> assertNotNull(businessException.getLevel()),
					() -> assertNotNull(businessException.getMessage())
				);
		
	}
	
	@Test
	@DisplayName("Constructor con parametros sin descripcion, excepcion-negocio, CASO_EXITO")
	void createBusinessException_success2() {
		
		BusinessException businessException = new BusinessException(BusinessCatalog.BUSI001);
		
		assertAll(
					() -> assertNotNull(businessException),
					() -> assertNotNull(businessException.getCode()),
					() -> assertNull(businessException.getDescription()),
					() -> assertNotNull(businessException.getHttpStatus()),
					() -> assertNotNull(businessException.getLevel()),
					() -> assertNotNull(businessException.getMessage())
				);
		
	}
	
}
