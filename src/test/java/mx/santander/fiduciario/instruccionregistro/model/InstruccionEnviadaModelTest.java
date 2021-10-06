package mx.santander.fiduciario.instruccionregistro.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InstruccionEnviadaModelTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newInstruccionEnviadaModel_success1() {
		InstruccionEnviadaModel instruccionEnviadaModel = InstruccionEnviadaModel.builder()
											.idIntrsNvas(100L)
											.idList(1L)
											.buc("1234567890")
											.idNoContr(1L)
											.idNoSubContr(2L)
											.IdFolio(123L)
											.idEstat(1L)
											.fchRegisInsct(new Date())
											.build();
		assertAll(
					() -> assertEquals((Long)100L, instruccionEnviadaModel.getIdIntrsNvas()),
					() -> assertEquals((Long)1L, instruccionEnviadaModel.getIdList()),
					() -> assertEquals("1234567890", instruccionEnviadaModel.getBuc()),
					() -> assertEquals((Long)1L, instruccionEnviadaModel.getIdNoContr()),
					() -> assertEquals((Long)2L, instruccionEnviadaModel.getIdNoSubContr()),
					() -> assertEquals((Long)1L, instruccionEnviadaModel.getIdEstat()),
					() -> assertNotNull(instruccionEnviadaModel.getFchRegisInsct()),
					() -> assertNotEquals("",instruccionEnviadaModel.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newInstruccionEnviadaModel_success2() {
		InstruccionEnviadaModel instruccionEnviadaModel = new InstruccionEnviadaModel();
		InstruccionEnviadaModel instruccionEnviadaModel2 = new InstruccionEnviadaModel();
		assertAll(
				() -> assertTrue(instruccionEnviadaModel.canEqual(instruccionEnviadaModel2)),
				() -> assertTrue(instruccionEnviadaModel.equals(instruccionEnviadaModel2)),
				() -> assertEquals(instruccionEnviadaModel.hashCode(), instruccionEnviadaModel2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newInstruccionEnviadaModel_success3() {
		InstruccionEnviadaModel instruccionEnviadaModel = new InstruccionEnviadaModel();
		instruccionEnviadaModel.setIdIntrsNvas(100L);
		instruccionEnviadaModel.setIdList(1L);
		instruccionEnviadaModel.setBuc("1234567890");
		instruccionEnviadaModel.setIdNoContr(1L);
		instruccionEnviadaModel.setIdNoSubContr(2L);
		instruccionEnviadaModel.setIdEstat(1L);
		instruccionEnviadaModel.setFchRegisInsct(new Date());
		
		assertAll(
				() -> assertEquals((Long)100L, instruccionEnviadaModel.getIdIntrsNvas()),
				() -> assertEquals((Long)1L, instruccionEnviadaModel.getIdList()),
				() -> assertEquals("1234567890", instruccionEnviadaModel.getBuc()),
				() -> assertEquals((Long)1L, instruccionEnviadaModel.getIdNoContr()),
				() -> assertEquals((Long)2L, instruccionEnviadaModel.getIdNoSubContr()),
				() -> assertEquals((Long)1L, instruccionEnviadaModel.getIdEstat()),
				() -> assertNotNull(instruccionEnviadaModel.getFchRegisInsct())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newInstruccionEnviadaModel_fail1() {
		InstruccionEnviadaModel instruccionEnviadaModel = InstruccionEnviadaModel.builder()
																.idIntrsNvas(null)
																.idList(null)
																.buc(null)
																.idNoContr(null)
																.idNoSubContr(null)
																.IdFolio(null)
																.idEstat(null)
																.fchRegisInsct(null)
																.build();
		assertAll(
					() -> assertNull(instruccionEnviadaModel.getIdIntrsNvas()),
					() -> assertNull(instruccionEnviadaModel.getIdList()),
					() -> assertNull(instruccionEnviadaModel.getBuc()),
					() -> assertNull(instruccionEnviadaModel.getIdNoContr()),
					() -> assertNull(instruccionEnviadaModel.getIdNoSubContr()),
					() -> assertNull(instruccionEnviadaModel.getIdFolio()),
					() -> assertNull(instruccionEnviadaModel.getIdEstat()),
					() -> assertNull(instruccionEnviadaModel.getFchRegisInsct())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newInstruccionEnviadaModel_fail2() {
		InstruccionEnviadaModel instruccionEnviadaModel = new InstruccionEnviadaModel();
		assertAll(
				() -> assertNull(instruccionEnviadaModel.getIdIntrsNvas()),
				() -> assertNull(instruccionEnviadaModel.getIdList()),
				() -> assertNull(instruccionEnviadaModel.getBuc()),
				() -> assertNull(instruccionEnviadaModel.getIdNoContr()),
				() -> assertNull(instruccionEnviadaModel.getIdNoSubContr()),
				() -> assertNull(instruccionEnviadaModel.getIdFolio()),
				() -> assertNull(instruccionEnviadaModel.getIdEstat()),
				() -> assertNull(instruccionEnviadaModel.getFchRegisInsct())
			);	
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newInstruccionEnviadaModel_fail3() {
		InstruccionEnviadaModel instruccionEnviadaModel = null;
		assertNull(instruccionEnviadaModel);
	}

}
