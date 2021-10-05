package mx.santander.fiduciario.instruccionregistro.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InstruccionAnexoModelTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newInstruccionAnexoModel_success1() {
		InstruccionAnexoModel instruccionAnexoModel = InstruccionAnexoModel.builder()
											.idAnexo(12L)
											.idFkInstrNvas(10L)
											.dscDocNombr("Nombre anexo")
											.dsc_Tipo("INSTRUCCION")
											.idFolio(1234L)
											.fchRegisInst(new Date())
											.valInstr("qwertyuiop")
											.build();
		assertAll(
					() -> assertEquals((Long)12L, instruccionAnexoModel.getIdAnexo()),
					() -> assertEquals((Long)10L, instruccionAnexoModel.getIdFkInstrNvas()),
					() -> assertEquals("Nombre anexo", instruccionAnexoModel.getDscDocNombr()),
					() -> assertEquals("INSTRUCCION", instruccionAnexoModel.getDsc_Tipo()),
					() -> assertEquals((Long)1234L, instruccionAnexoModel.getIdFolio()),
					() -> assertNotNull(instruccionAnexoModel.getFchRegisInst()),
					() -> assertEquals("qwertyuiop", instruccionAnexoModel.getValInstr()),
					() -> assertNotEquals("",instruccionAnexoModel.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newInstruccionAnexoModel_success2() {
		InstruccionAnexoModel instruccionAnexoModel = new InstruccionAnexoModel();
		InstruccionAnexoModel instruccionAnexoModel2 = new InstruccionAnexoModel();
		assertAll(
				() -> assertTrue(instruccionAnexoModel.canEqual(instruccionAnexoModel2)),
				() -> assertTrue(instruccionAnexoModel.equals(instruccionAnexoModel2)),
				() -> assertEquals(instruccionAnexoModel.hashCode(), instruccionAnexoModel2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newInstruccionAnexoModel_success3() {
		InstruccionAnexoModel instruccionAnexoModel = new InstruccionAnexoModel();
		instruccionAnexoModel.setIdAnexo(12L);
		instruccionAnexoModel.setIdFkInstrNvas(10L);
		instruccionAnexoModel.setDscDocNombr("Nombre anexo");
		instruccionAnexoModel.setDsc_Tipo("INSTRUCCION");
		instruccionAnexoModel.setIdFolio(1234L);
		instruccionAnexoModel.setFchRegisInst(new Date());
		instruccionAnexoModel.setValInstr("qwertyuiop");
		
		assertAll(
				() -> assertEquals((Long)12L, instruccionAnexoModel.getIdAnexo()),
				() -> assertEquals((Long)10L, instruccionAnexoModel.getIdFkInstrNvas()),
				() -> assertEquals("Nombre anexo", instruccionAnexoModel.getDscDocNombr()),
				() -> assertEquals("INSTRUCCION", instruccionAnexoModel.getDsc_Tipo()),
				() -> assertEquals((Long)1234L, instruccionAnexoModel.getIdFolio()),
				() -> assertNotNull(instruccionAnexoModel.getFchRegisInst()),
				() -> assertEquals("qwertyuiop", instruccionAnexoModel.getValInstr())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newInstruccionAnexoModel_fail1() {
		InstruccionAnexoModel instruccionAnexoModel = InstruccionAnexoModel.builder()
															.idAnexo(null)
															.idFkInstrNvas(null)
															.dscDocNombr(null)
															.dsc_Tipo(null)
															.idFolio(null)
															.fchRegisInst(null)
															.valInstr(null)
															.build();
		assertAll(
					() -> assertNull(instruccionAnexoModel.getIdAnexo()),
					() -> assertNull(instruccionAnexoModel.getIdFkInstrNvas()),
					() -> assertNull(instruccionAnexoModel.getDscDocNombr()),
					() -> assertNull(instruccionAnexoModel.getDsc_Tipo()),
					() -> assertNull(instruccionAnexoModel.getIdFolio()),
					() -> assertNull(instruccionAnexoModel.getFchRegisInst()),
					() -> assertNull(instruccionAnexoModel.getValInstr())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newInstruccionAnexoModel_fail2() {
		InstruccionAnexoModel instruccionAnexoModel = new InstruccionAnexoModel();
		
		assertAll(
				() -> assertNull(instruccionAnexoModel.getIdAnexo()),
				() -> assertNull(instruccionAnexoModel.getIdFkInstrNvas()),
				() -> assertNull(instruccionAnexoModel.getDscDocNombr()),
				() -> assertNull(instruccionAnexoModel.getDsc_Tipo()),
				() -> assertNull(instruccionAnexoModel.getIdFolio()),
				() -> assertNull(instruccionAnexoModel.getFchRegisInst()),
				() -> assertNull(instruccionAnexoModel.getValInstr())
			);	
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newInstruccionAnexoModel_fail3() {
		InstruccionAnexoModel instruccionAnexoModel = null;
		assertNull(instruccionAnexoModel);
	}

}
