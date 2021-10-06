package mx.santander.fiduciario.instruccionregistro.exception.catalog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class PersistenDataCatalogTest {

	@Test
	@DisplayName("Obtiene catalogo-persistencia: PSID001, CASO_EXITO")
	void getPersistenDataCatalogPsid001_success1() {
		
		assertAll(
				() -> assertEquals("PersistentDataException001", PersistenDataCatalog.PSID001.getType()),
				() -> assertEquals("PSID.001", PersistenDataCatalog.PSID001.getCode()),
				() -> assertEquals("Error al realizar la transaccion.", PersistenDataCatalog.PSID001.getMessage()),
				() -> assertEquals(HttpStatus.CONFLICT,PersistenDataCatalog.PSID001.getHtttpStatus()),
				() -> assertEquals(LevelException.ERROR, PersistenDataCatalog.PSID001.getLevelException())
			);
	}
	
	@Test
	@DisplayName("Obtiene catalogo-persistencia: PSID002, CASO_EXITO")
	void getPersistenDataCatalogPsid002_success2() {
		
		assertAll(
				() -> assertEquals("PersistentDataException002", PersistenDataCatalog.PSID002.getType()),
				() -> assertEquals("PSID.002", PersistenDataCatalog.PSID002.getCode()),
				() -> assertEquals("Error de conexion en origen de datos.", PersistenDataCatalog.PSID002.getMessage()),
				() -> assertEquals(HttpStatus.CONFLICT,PersistenDataCatalog.PSID002.getHtttpStatus()),
				() -> assertEquals(LevelException.ERROR, PersistenDataCatalog.PSID002.getLevelException())
			);
	}
	
	@Test
	@DisplayName("Obtiene catalogo-persistencia: PSID003, CASO_EXITO")
	void getPersistenDataCatalogPsid003_success3() {
		
		assertAll(
				() -> assertEquals("PersistentDataException003", PersistenDataCatalog.PSID003.getType()),
				() -> assertEquals("PSID.003", PersistenDataCatalog.PSID003.getCode()),
				() -> assertEquals("Recurso no encontrado.", PersistenDataCatalog.PSID003.getMessage()),
				() -> assertEquals(HttpStatus.CONFLICT,PersistenDataCatalog.PSID003.getHtttpStatus()),
				() -> assertEquals(LevelException.ERROR, PersistenDataCatalog.PSID003.getLevelException())
			);
	}
	
	@Test
	@DisplayName("Obtiene cantidad catalogo-persistencia, CASO_EXITO")
	void getPersistenDataCatalog_success4() {
		PersistenDataCatalog persistenDataCatalogs[] = PersistenDataCatalog.values();
	
		assertEquals(3, persistenDataCatalogs.length);
	}

}
