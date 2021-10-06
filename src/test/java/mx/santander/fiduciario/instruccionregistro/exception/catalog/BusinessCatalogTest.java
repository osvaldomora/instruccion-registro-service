package mx.santander.fiduciario.instruccionregistro.exception.catalog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class BusinessCatalogTest {

	@Test
	@DisplayName("Obtiene catalogo-negocio: BUSI001, CASO_EXITO")
	void getBusinessCatalogBusi001_success1() {
		
		assertAll(
					() -> assertEquals("BusinessException001", BusinessCatalog.BUSI001.getType()),
					() -> assertEquals("BUSI.001", BusinessCatalog.BUSI001.getCode()),
					() -> assertEquals("Error el documento no puede exceder el minimo y maximo de tamaño.", BusinessCatalog.BUSI001.getMessage()),
					() -> assertEquals(HttpStatus.BAD_REQUEST,BusinessCatalog.BUSI001.getHtttpStatus()),
					() -> assertEquals(LevelException.WARN, BusinessCatalog.BUSI001.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene catalogo-negocio: BUSI002, CASO_EXITO")
	void getBusinessCatalogBusi002_success2() {
		
		assertAll(
					() -> assertEquals("BusinessException002", BusinessCatalog.BUSI002.getType()),
					() -> assertEquals("BUSI.002", BusinessCatalog.BUSI002.getCode()),
					() -> assertEquals("Formato de archivo no soportado.", BusinessCatalog.BUSI002.getMessage()),
					() -> assertEquals(HttpStatus.BAD_REQUEST,BusinessCatalog.BUSI002.getHtttpStatus()),
					() -> assertEquals(LevelException.WARN, BusinessCatalog.BUSI002.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene catalogo-negocio: BUSI003, CASO_EXITO")
	void getBusinessCatalogBusi003_success3() {
		
		assertAll(
					() -> assertEquals("BusinessException003", BusinessCatalog.BUSI003.getType()),
					() -> assertEquals("BUSI.003", BusinessCatalog.BUSI003.getCode()),
					() -> assertEquals("Se ha excedido el limite de archivos.", BusinessCatalog.BUSI003.getMessage()),
					() -> assertEquals(HttpStatus.BAD_REQUEST,BusinessCatalog.BUSI003.getHtttpStatus()),
					() -> assertEquals(LevelException.WARN, BusinessCatalog.BUSI003.getLevelException())
				);
		
	}
	
	
	@Test
	@DisplayName("Obtiene cantidad  catalogo-negocio, CASO_EXITO")
	void getBusinessCatalog_success4() {
		BusinessCatalog businessCatalogs[] = BusinessCatalog.values();
	
		assertEquals(3, businessCatalogs.length);
	}

}
