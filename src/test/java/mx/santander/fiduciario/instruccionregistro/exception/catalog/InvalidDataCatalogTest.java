package mx.santander.fiduciario.instruccionregistro.exception.catalog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class InvalidDataCatalogTest {

	@Test
	@DisplayName("Obtiene catalogo-dato-invalido: INVD001, CASO_EXITO")
	void getInvalidDataCatalogInvd001_success1() {
		
		assertAll(
					() -> assertEquals("InvalidDataException001", InvalidDataCatalog.INVD001.getType()),
					() -> assertEquals("INVD.001", InvalidDataCatalog.INVD001.getCode()),
					() -> assertEquals("Error al mapear datos.", InvalidDataCatalog.INVD001.getMessage()),
					() -> assertEquals(HttpStatus.CONFLICT,InvalidDataCatalog.INVD001.getHtttpStatus()),
					() -> assertEquals(LevelException.ERROR, InvalidDataCatalog.INVD001.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene catalogo-dato-invalido: INVD002, CASO_EXITO")
	void getInvalidDataCatalogInvd002_success2() {
		
		assertAll(
					() -> assertEquals("InvalidDataException002", InvalidDataCatalog.INVD002.getType()),
					() -> assertEquals("INVD.002", InvalidDataCatalog.INVD002.getCode()),
					() -> assertEquals("Error al codificar archivo.", InvalidDataCatalog.INVD002.getMessage()),
					() -> assertEquals(HttpStatus.CONFLICT,InvalidDataCatalog.INVD002.getHtttpStatus()),
					() -> assertEquals(LevelException.ERROR, InvalidDataCatalog.INVD002.getLevelException())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene cantidad  catalogo-dato-invalido, CASO_EXITO")
	void getInvalidDataCatalog_success3() {
		InvalidDataCatalog invalidDataCatalogs[] = InvalidDataCatalog.values();
	
		assertEquals(2, invalidDataCatalogs.length);
	}

}
