package mx.santander.fiduciario.instruccionregistro.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegistroDocumentoModelTest {

	@Test
	@DisplayName("Crea Objecto todos los parametros, CASO_EXITO")
	void newRegistroDocumentoModel_success1() {
		RegistroDocumentoModel registroDocumentoModel = RegistroDocumentoModel.builder()
											.numeroUnicoDoc(100L)
											.claveTipoDoc("205")
											.numeroDoc("12345")
											.conceptoDoc("Nombre instruccion + contrato + subcontrato")
											.parteContrato("FIDEICOMITENTE")
											.clavePo(123L)
											.testimonioCertifSimple("S")
											.fechaEntradaArchivo(new Date())
											.individualMasivo("I")
											.cifraControl(123L)
											.estatusAplicacionDoc("PE")
											.estatusDoc("AR")
											.claveInmueble("12A")
											.copiaOriginal("W")
											.flgDetnt("S")
											.idDocDetnt("1")
											.valEstInteg("Valor estatus int")
											.flgReqTraza("1")
											.flgReqOper("A")
											.build();
		assertAll(
					() -> assertEquals((Long)100L, registroDocumentoModel.getNumeroUnicoDoc()),
					() -> assertEquals("205", registroDocumentoModel.getClaveTipoDoc()),
					() -> assertEquals("12345", registroDocumentoModel.getNumeroDoc()),
					() -> assertEquals("Nombre instruccion + contrato + subcontrato", registroDocumentoModel.getConceptoDoc()),
					() -> assertEquals("FIDEICOMITENTE", registroDocumentoModel.getParteContrato()),
					() -> assertEquals((Long)123L, registroDocumentoModel.getClavePo()),
					() -> assertEquals("S", registroDocumentoModel.getTestimonioCertifSimple()),
					() -> assertNotNull( registroDocumentoModel.getFechaEntradaArchivo()),
					() -> assertEquals("I", registroDocumentoModel.getIndividualMasivo()),
					() -> assertEquals((Long)123L, registroDocumentoModel.getCifraControl()),
					() -> assertEquals("PE", registroDocumentoModel.getEstatusAplicacionDoc()),
					() -> assertEquals("AR", registroDocumentoModel.getEstatusDoc()),
					() -> assertEquals("12A", registroDocumentoModel.getClaveInmueble()),
					() -> assertEquals("W", registroDocumentoModel.getCopiaOriginal()),
					() -> assertEquals("S", registroDocumentoModel.getFlgDetnt()),
					() -> assertEquals("1", registroDocumentoModel.getIdDocDetnt()),
					() -> assertEquals("Valor estatus int", registroDocumentoModel.getValEstInteg()),
					() -> assertEquals("1", registroDocumentoModel.getFlgReqTraza()),
					() -> assertEquals("A", registroDocumentoModel.getFlgReqOper()),
					() -> assertNotEquals("",registroDocumentoModel.toString())
				);
		
	}

	@Test
	@DisplayName("Crea Objecto sin parametros contructor, CASO_EXITO")
	void newRegistroDocumentoModel_success2() {
		RegistroDocumentoModel registroDocumentoModel = new RegistroDocumentoModel();
		RegistroDocumentoModel registroDocumentoModel2 = new RegistroDocumentoModel();
		assertAll(
				() -> assertTrue(registroDocumentoModel.canEqual(registroDocumentoModel2)),
				() -> assertTrue(registroDocumentoModel.equals(registroDocumentoModel2)),
				() -> assertEquals(registroDocumentoModel.hashCode(), registroDocumentoModel2.hashCode())
				);
	}

	@Test
	@DisplayName("Crea Objecto parametros por setters, CASO_EXITO")
	void newRegistroDocumentoModel_success3() {
		RegistroDocumentoModel registroDocumentoModel = new RegistroDocumentoModel();
		registroDocumentoModel.setNumeroUnicoDoc(100L);
		registroDocumentoModel.setClaveTipoDoc("205");
		registroDocumentoModel.setNumeroDoc("12345");
		registroDocumentoModel.setConceptoDoc("Nombre instruccion + contrato + subcontrato");
		registroDocumentoModel.setParteContrato("FIDEICOMITENTE");
		registroDocumentoModel.setClavePo(123L);
		registroDocumentoModel.setTestimonioCertifSimple("S");
		registroDocumentoModel.setFechaEntradaArchivo(new Date());
		registroDocumentoModel.setIndividualMasivo("I");
		registroDocumentoModel.setCifraControl(123L);
		registroDocumentoModel.setEstatusAplicacionDoc("PE");
		registroDocumentoModel.setEstatusDoc("AR");
		registroDocumentoModel.setClaveInmueble("12A");
		registroDocumentoModel.setCopiaOriginal("W");
		registroDocumentoModel.setFlgDetnt("S");
		registroDocumentoModel.setIdDocDetnt("1");
		registroDocumentoModel.setValEstInteg("Valor estatus int");
		registroDocumentoModel.setFlgReqTraza("1");
		registroDocumentoModel.setFlgReqOper("A");
		
		assertAll(
				() -> assertEquals((Long)100L, registroDocumentoModel.getNumeroUnicoDoc()),
				() -> assertEquals("205", registroDocumentoModel.getClaveTipoDoc()),
				() -> assertEquals("12345", registroDocumentoModel.getNumeroDoc()),
				() -> assertEquals("Nombre instruccion + contrato + subcontrato", registroDocumentoModel.getConceptoDoc()),
				() -> assertEquals("FIDEICOMITENTE", registroDocumentoModel.getParteContrato()),
				() -> assertEquals((Long)123L, registroDocumentoModel.getClavePo()),
				() -> assertEquals("S", registroDocumentoModel.getTestimonioCertifSimple()),
				() -> assertNotNull( registroDocumentoModel.getFechaEntradaArchivo()),
				() -> assertEquals("I", registroDocumentoModel.getIndividualMasivo()),
				() -> assertEquals((Long)123L, registroDocumentoModel.getCifraControl()),
				() -> assertEquals("PE", registroDocumentoModel.getEstatusAplicacionDoc()),
				() -> assertEquals("AR", registroDocumentoModel.getEstatusDoc()),
				() -> assertEquals("12A", registroDocumentoModel.getClaveInmueble()),
				() -> assertEquals("W", registroDocumentoModel.getCopiaOriginal()),
				() -> assertEquals("S", registroDocumentoModel.getFlgDetnt()),
				() -> assertEquals("1", registroDocumentoModel.getIdDocDetnt()),
				() -> assertEquals("Valor estatus int", registroDocumentoModel.getValEstInteg()),
				() -> assertEquals("1", registroDocumentoModel.getFlgReqTraza()),
				() -> assertEquals("A", registroDocumentoModel.getFlgReqOper())
			);
	}

	@Test
	@DisplayName("Crea Objeto DTO contructor parametros nulos, CASO_FALLIDO")
	void newRegistroDocumentoModel_fail1() {
		RegistroDocumentoModel registroDocumentoModel = RegistroDocumentoModel.builder()
															.numeroUnicoDoc(null)
															.claveTipoDoc(null)
															.numeroDoc(null)
															.conceptoDoc(null)
															.parteContrato(null)
															.clavePo(null)
															.testimonioCertifSimple(null)
															.fechaEntradaArchivo(null)
															.individualMasivo(null)
															.cifraControl(null)
															.estatusAplicacionDoc(null)
															.estatusDoc(null)
															.claveInmueble(null)
															.copiaOriginal(null)
															.flgDetnt(null)
															.idDocDetnt(null)
															.valEstInteg(null)
															.flgReqTraza(null)
															.flgReqOper(null)
															.build();
		assertAll(
					() -> assertNull(registroDocumentoModel.getNumeroDoc()),
					() -> assertNull(registroDocumentoModel.getClaveTipoDoc()),
					() -> assertNull(registroDocumentoModel.getNumeroDoc()),
					() -> assertNull(registroDocumentoModel.getConceptoDoc()),
					() -> assertNull(registroDocumentoModel.getParteContrato()),
					() -> assertNull(registroDocumentoModel.getClavePo()),
					() -> assertNull(registroDocumentoModel.getTestimonioCertifSimple()),
					() -> assertNull(registroDocumentoModel.getFechaEntradaArchivo()),
					() -> assertNull(registroDocumentoModel.getIndividualMasivo()),
					() -> assertNull(registroDocumentoModel.getCifraControl()),
					() -> assertNull(registroDocumentoModel.getEstatusAplicacionDoc()),
					() -> assertNull(registroDocumentoModel.getEstatusDoc()),
					() -> assertNull(registroDocumentoModel.getClaveInmueble()),
					() -> assertNull(registroDocumentoModel.getCopiaOriginal()),
					() -> assertNull(registroDocumentoModel.getFlgDetnt()),
					() -> assertNull(registroDocumentoModel.getIdDocDetnt()),
					() -> assertNull(registroDocumentoModel.getValEstInteg()),
					() -> assertNull(registroDocumentoModel.getFlgReqTraza()),
					() -> assertNull(registroDocumentoModel.getFlgReqOper())
				);	
	}

	@Test
	@DisplayName("Crea Objeto DTO sin parametros contructor, CASO_FALLIDO")
	void newRegistroDocumentoModel_fail2() {
		RegistroDocumentoModel registroDocumentoModel = new RegistroDocumentoModel();
		
		assertAll(
				() -> assertNull(registroDocumentoModel.getNumeroDoc()),
				() -> assertNull(registroDocumentoModel.getClaveTipoDoc()),
				() -> assertNull(registroDocumentoModel.getNumeroDoc()),
				() -> assertNull(registroDocumentoModel.getConceptoDoc()),
				() -> assertNull(registroDocumentoModel.getParteContrato()),
				() -> assertNull(registroDocumentoModel.getClavePo()),
				() -> assertNull(registroDocumentoModel.getTestimonioCertifSimple()),
				() -> assertNull(registroDocumentoModel.getFechaEntradaArchivo()),
				() -> assertNull(registroDocumentoModel.getIndividualMasivo()),
				() -> assertNull(registroDocumentoModel.getCifraControl()),
				() -> assertNull(registroDocumentoModel.getEstatusAplicacionDoc()),
				() -> assertNull(registroDocumentoModel.getEstatusDoc()),
				() -> assertNull(registroDocumentoModel.getClaveInmueble()),
				() -> assertNull(registroDocumentoModel.getCopiaOriginal()),
				() -> assertNull(registroDocumentoModel.getFlgDetnt()),
				() -> assertNull(registroDocumentoModel.getIdDocDetnt()),
				() -> assertNull(registroDocumentoModel.getValEstInteg()),
				() -> assertNull(registroDocumentoModel.getFlgReqTraza()),
				() -> assertNull(registroDocumentoModel.getFlgReqOper())
			);	
	}

	@Test
	@DisplayName("Crea Objeto DTO nulo, CASO_FALLIDO")
	void newRegistroDocumentoModel_fail3() {
		RegistroDocumentoModel registroDocumentoModel = null;
		assertNull(registroDocumentoModel);
	}

}
