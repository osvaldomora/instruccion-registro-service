package mx.santander.fiduciario.instruccionregistro.exception.catalog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class GeneralCatalogTest {
	
	@Test
	@DisplayName("Obtiene catalogo-general: GRAL001, CASO_EXITO")
	void getGeneralCatalogGral001_success1() {
		
		assertAll(
					() -> assertEquals("GeneralException001", GeneralCatalog.GRAL001.getType()),
					() -> assertEquals("GRAL.001", GeneralCatalog.GRAL001.getCode()),
					() -> assertEquals("Error generico de servidor.", GeneralCatalog.GRAL001.getMessage()),
					() -> assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,GeneralCatalog.GRAL001.getHtttpStatus()),
					() -> assertEquals(LevelException.ERROR, GeneralCatalog.GRAL001.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene catalogo-general: GRAL002, CASO_EXITO")
	void getGeneralCatalogGral002_success2() {
		
		assertAll(
					() -> assertEquals("GeneralException002", GeneralCatalog.GRAL002.getType()),
					() -> assertEquals("GRAL.002", GeneralCatalog.GRAL002.getCode()),
					() -> assertEquals("Error al enviar Query Parameters.", GeneralCatalog.GRAL002.getMessage()),
					() -> assertEquals(HttpStatus.BAD_REQUEST,GeneralCatalog.GRAL002.getHtttpStatus()),
					() -> assertEquals(LevelException.WARN, GeneralCatalog.GRAL002.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene catalogo-general: GRAL003, CASO_EXITO")
	void getGeneralCatalogGral003_success3() {
		
		assertAll(
					() -> assertEquals("GeneralException003", GeneralCatalog.GRAL003.getType()),
					() -> assertEquals("GRAL.003", GeneralCatalog.GRAL003.getCode()),
					() -> assertEquals("URI parameters no valido.", GeneralCatalog.GRAL003.getMessage()),
					() -> assertEquals(HttpStatus.BAD_REQUEST,GeneralCatalog.GRAL003.getHtttpStatus()),
					() -> assertEquals(LevelException.WARN, GeneralCatalog.GRAL003.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene catalogo-general: GRAL004, CASO_EXITO")
	void getGeneralCatalogGral004_success4() {
		
		assertAll(
					() -> assertEquals("GeneralException004", GeneralCatalog.GRAL004.getType()),
					() -> assertEquals("GRAL.004", GeneralCatalog.GRAL004.getCode()),
					() -> assertEquals("Conflicto al realizar la operación.", GeneralCatalog.GRAL004.getMessage()),
					() -> assertEquals(HttpStatus.CONFLICT,GeneralCatalog.GRAL004.getHtttpStatus()),
					() -> assertEquals(LevelException.ERROR, GeneralCatalog.GRAL004.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene catalogo-general: GRAL005, CASO_EXITO")
	void getGeneralCatalogGral005_success5() {
		
		assertAll(
					() -> assertEquals("GeneralException005", GeneralCatalog.GRAL005.getType()),
					() -> assertEquals("GRAL.005", GeneralCatalog.GRAL005.getCode()),
					() -> assertEquals("Consulta duplicada.", GeneralCatalog.GRAL005.getMessage()),
					() -> assertEquals(HttpStatus.BAD_REQUEST,GeneralCatalog.GRAL005.getHtttpStatus()),
					() -> assertEquals(LevelException.WARN, GeneralCatalog.GRAL005.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene catalogo-general: GRAL006, CASO_EXITO")
	void getGeneralCatalogGral006_success6() {
		
		assertAll(
					() -> assertEquals("GeneralException006", GeneralCatalog.GRAL006.getType()),
					() -> assertEquals("GRAL.006", GeneralCatalog.GRAL006.getCode()),
					() -> assertEquals("Error al enviar parametros.", GeneralCatalog.GRAL006.getMessage()),
					() -> assertEquals(HttpStatus.BAD_REQUEST,GeneralCatalog.GRAL006.getHtttpStatus()),
					() -> assertEquals(LevelException.WARN, GeneralCatalog.GRAL006.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene cantidad  catalogo-general, CASO_EXITO")
	void getGeneralCatalog_success7() {
		GeneralCatalog generalCatalogs[] = GeneralCatalog.values();
	
		assertEquals(6, generalCatalogs.length);
	}
}
