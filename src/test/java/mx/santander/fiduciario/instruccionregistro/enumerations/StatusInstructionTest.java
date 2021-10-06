package mx.santander.fiduciario.instruccionregistro.enumerations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatusInstructionTest {

	@Test
	@DisplayName("Obtiene estatus-instruccion: SOLICITADA, CASO_EXITO")
	void getStatusInstructionSolicitada_success1() {
		
		assertAll(
					() -> assertEquals("SO", StatusInstruction.SOLICITADA.getId()),
					() -> assertEquals("SOLICITADA", StatusInstruction.SOLICITADA.getDescription()),
					() -> assertEquals((Long)1L,  StatusInstruction.SOLICITADA.getValue())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene estatus-instruccion: ENTREGADA, CASO_EXITO")
	void getStatusInstructionEntregada_success3() {
		
		assertAll(
					() -> assertEquals("EN", StatusInstruction.ENTREGADA.getId()),
					() -> assertEquals("ENTREGADA", StatusInstruction.ENTREGADA.getDescription()),
					() -> assertEquals((Long)2L,  StatusInstruction.ENTREGADA.getValue())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene estatus-instruccion: PROCESO, CASO_EXITO")
	void getStatusInstructionEnProceso_success3() {
		
		assertAll(
					() -> assertEquals("PR", StatusInstruction.PROCESO.getId()),
					() -> assertEquals("EN PROCESO", StatusInstruction.PROCESO.getDescription()),
					() -> assertEquals((Long)3L,  StatusInstruction.PROCESO.getValue())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene estatus-instruccion: ATENDIDA, CASO_EXITO")
	void getStatusInstructionAtendida_success4() {
		
		assertAll(
					() -> assertEquals("AT", StatusInstruction.ATENDIDA.getId()),
					() -> assertEquals("ATENDIDA", StatusInstruction.ATENDIDA.getDescription()),
					() -> assertEquals((Long)4L,  StatusInstruction.ATENDIDA.getValue())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene estatus-instruccion: RECHAZADA, CASO_EXITO")
	void getStatusInstructionRechazada_success5() {
		
		assertAll(
					() -> assertEquals("RE", StatusInstruction.RECHAZADA.getId()),
					() -> assertEquals("RECHAZADA", StatusInstruction.RECHAZADA.getDescription()),
					() -> assertEquals((Long)5L,  StatusInstruction.RECHAZADA.getValue())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene cantidad estatus-instruccion, CASO_EXITO")
	void getStatusInstruction_success6() {
		StatusInstruction status[] = StatusInstruction.values();
	
		assertEquals(5, status.length);
	}

}
