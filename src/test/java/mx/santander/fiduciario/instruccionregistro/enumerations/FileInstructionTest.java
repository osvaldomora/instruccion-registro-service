package mx.santander.fiduciario.instruccionregistro.enumerations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileInstructionTest {

	
	@Test
	@DisplayName("Obtiene instruccionn-archivo: INSTRUCCION, CASO_EXITO")
	void getFileInstructionInstruccion_success1() {
		
		assertAll(
					() -> assertEquals("INSTRUCCION", FileInstruction.INSTRUCCION.getName()),
					() -> assertEquals(FileExtension.PDF,FileInstruction.INSTRUCCION.getFileExtension())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene instruccionn-archivo: LAYOUT, CASO_EXITO")
	void getFileInstructionLayout_success2() {
		
		assertAll(
					() -> assertEquals("LAYOUT", FileInstruction.LAYOUT.getName()),
					() -> assertEquals(FileExtension.TXT,FileInstruction.LAYOUT.getFileExtension())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene instruccionn-archivo: ANEXO, CASO_EXITO")
	void getFileInstructionAnexo_success3() {
		
		assertAll(
					() -> assertEquals("ANEXO", FileInstruction.ANEXO.getName()),
					() -> assertEquals(FileExtension.PDF,FileInstruction.ANEXO.getFileExtension())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene instruccionn-archivo: PLANTILLA_DOC, CASO_EXITO")
	void getFileInstructionPlantillaDoc_success4() {
		
		assertAll(
					() -> assertEquals("PLANTILLA", FileInstruction.PLANTILLA_DOC.getName()),
					() -> assertEquals(FileExtension.DOC,FileInstruction.PLANTILLA_DOC.getFileExtension())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene instruccionn-archivo: PLANTILLA_DOCX, CASO_EXITO")
	void getFileInstructionPlantillaDocx_success1() {
		
		assertAll(
					() -> assertEquals("PLANTILLA", FileInstruction.PLANTILLA_DOCX.getName()),
					() -> assertEquals(FileExtension.DOCX,FileInstruction.PLANTILLA_DOCX.getFileExtension())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene cantidad instruccionn-archivo, CASO_EXITO")
	void getFileInstruction_success5() {
		FileInstruction filesInstruction[] = FileInstruction.values();
	
		assertEquals(5, filesInstruction.length);
	}


}
