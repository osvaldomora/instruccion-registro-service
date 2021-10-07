package mx.santander.fiduciario.instruccionregistro.util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

class FileToolTest {

	//Archivo precargado para validar en base64
	private String fileBase64; 
	
	@BeforeEach
	void setUp() {
		fileBase64 = "QVJDSElWTyBQUlVFQkEgVEVTVA==";
	}
	
	@Test
	@DisplayName("Codificar archivo base64, CASO_EXITO")
	void getEncodeFIleBase64_success1() {
		//Se crea archivo multipart
		File file = new File("src/test/java/mx/santander/fiduciario/instruccionregistro/util/fileTest.txt");
		FileInputStream input;
		MultipartFile multipartFile;
		try {
			input = new FileInputStream(file);
			multipartFile = new MockMultipartFile(file.getName(),file.getName(),"",input.readAllBytes());
			
			//Comprueba respuesta
			assertEquals(fileBase64, FileTool.encode64(multipartFile));
		
		} catch (IOException e) {}
	}
	
	@Test
	@DisplayName("Decodificar archivo base64 a arreglo bytes, CASO_EXITO")
	void getDecodeFileBase64_success2() {
		//Arreglo de bytes precargado de la variable fileBase64
		byte arreglo [] = {65,82,67,72,73,86,79,32,80,82,85,69,66,65,32,84,69,83,84};

		assertEquals(arreglo.length, FileTool.decode64(fileBase64).length);
	}
	
	@Test
	@DisplayName("Obtener extension nombre archivo, CASO_EXITO")
	void getFileExtension_success3() {
		//Valor que se espera
		String extensionResult= "txt";
		//Nombre del archivo a evaluar
		String fileNameToEvaluate = "fileTest.txt";
		
		assertEquals(extensionResult, FileTool.getFileExtension(fileNameToEvaluate));

	}
	
}
