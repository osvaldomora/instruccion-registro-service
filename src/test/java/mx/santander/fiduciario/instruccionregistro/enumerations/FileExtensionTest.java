package mx.santander.fiduciario.instruccionregistro.enumerations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileExtensionTest {

	@Test
	@DisplayName("Obtiene extension-archivo: PDF, CASO_EXITO")
	void getFileRequirePdf_success1() {
		
		assertAll(
					() -> assertEquals("pdf", FileExtension.PDF.getName()),
					() -> assertEquals("pdf", FileExtension.PDF.getExtension()),
					() -> assertEquals("type=application/pdf", FileExtension.PDF.getMimeType()),
					() -> assertEquals("application/pdf", FileExtension.PDF.getContentType())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene extension-archivo: TXT, CASO_EXITO")
	void getFileRequireTxt_success2() {
		
		assertAll(
					() -> assertEquals("txt", FileExtension.TXT.getName()),
					() -> assertEquals("txt", FileExtension.TXT.getExtension()),
					() -> assertEquals("type=text/plain", FileExtension.TXT.getMimeType()),
					() -> assertEquals("text/plain", FileExtension.TXT.getContentType())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene extension-archivo: DOC, CASO_EXITO")
	void getFileRequireDoc_success3() {
		
		assertAll(
					() -> assertEquals("doc", FileExtension.DOC.getName()),
					() -> assertEquals("doc", FileExtension.DOC.getExtension()),
					() -> assertEquals("application/msword", FileExtension.DOC.getMimeType()),
					() -> assertEquals("application/msword", FileExtension.DOC.getContentType())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene extension-archivo: DOCX, CASO_EXITO")
	void getFileRequireDocx_success4() {
		
		assertAll(
					() -> assertEquals("docx", FileExtension.DOCX.getName()),
					() -> assertEquals("docx", FileExtension.DOCX.getExtension()),
					() -> assertEquals("application/vnd.openxmlformats-officedocument.wordprocessingml.document", FileExtension.DOCX.getMimeType()),
					() -> assertEquals("application/vnd.openxmlformats-officedocument.wordprocessingml.document", FileExtension.DOCX.getContentType())
				);
		
	}
	
	@Test
	@DisplayName("Obtiene cantidad extension-archivo, CASO_EXITO")
	void getFileExtension_success5() {
		FileExtension filesExtension[] = FileExtension.values();
	
		assertEquals(4, filesExtension.length);
	}

}
