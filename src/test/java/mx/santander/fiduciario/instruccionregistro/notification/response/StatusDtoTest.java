package mx.santander.fiduciario.instruccionregistro.notification.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatusDtoTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newStatusDto_success1() {
		StatusDto statusDto = StatusDto.builder()
								.statusCode("200")
								.success(true)
								.description("Exito")
								.build();
		assertAll(
					() -> assertEquals("200", statusDto.getStatusCode()),
					() -> assertEquals(true, statusDto.getSuccess()),
					() -> assertEquals("Exito", statusDto.getDescription()),
					() -> assertNotEquals("",statusDto.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newStatusDto_success2() {
		StatusDto statusDto = new StatusDto();
		StatusDto statusDto2 = new StatusDto();
		assertAll(
					() -> assertTrue(statusDto.canEqual(statusDto2)),
					() -> assertTrue(statusDto.equals(statusDto2)),
					() -> assertEquals(statusDto.hashCode(), statusDto2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newStatusDto_success3() {
		StatusDto statusDto = new StatusDto();
		statusDto.setStatusCode("200");
		statusDto.setSuccess(true);
		statusDto.setDescription("Exito");
		
		assertAll(
				() -> assertEquals("200", statusDto.getStatusCode()),
				() -> assertEquals(true, statusDto.getSuccess()),
				() -> assertEquals("Exito", statusDto.getDescription())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newStatusDto_fail1() {
		StatusDto statusDto = StatusDto.builder()
									.statusCode(null)
									.success(null)
									.description(null)
									.build();
		assertAll(
				() -> assertNull(statusDto.getStatusCode()),
				() -> assertNull(statusDto.getSuccess()),
				() -> assertNull(statusDto.getDescription())
			);	
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newStatusDto_fail2() {
		StatusDto statusDto = new StatusDto();
		
		assertAll(
				() -> assertNull(statusDto.getStatusCode()),
				() -> assertNull(statusDto.getSuccess()),
				() -> assertNull(statusDto.getDescription())
			);		
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newStatusDto_fail3() {
		StatusDto statusDto = null;
		assertNull(statusDto);
	}

}
