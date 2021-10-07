package mx.santander.fiduciario.instruccionregistro.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import mx.santander.fiduciario.instruccionregistro.model.InstruccionAnexoModel;
import mx.santander.fiduciario.instruccionregistro.repository.IAnexoInstructionRepository;

class AnexoInstructionServiceTest {

	//Variable service
	private AnexoInstructionService anexoInstructionService ;
	
	//Variable repositorio
	private IAnexoInstructionRepository anexoInstructionRepository;
	
	//
	private InstruccionAnexoModel model = Mockito.mock(InstruccionAnexoModel.class);
	
	//Archivo precargado para validar en base64
	private String fileBase64; 
	
	//Variable a enviar
	private MultipartFile multipartFile;
	
	//Variable que regresa el repositorio
	private InstruccionAnexoModel instruccionAnexoModelRes;
	
	@BeforeEach
	void setUp() {
		//Inicializan mocks
		anexoInstructionRepository = Mockito.mock(IAnexoInstructionRepository.class);
		anexoInstructionService = Mockito.mock(AnexoInstructionService.class);
		anexoInstructionService.setAnexoInstructionRepository(anexoInstructionRepository);
		//Objetos a enviar
		File file = new File("src/test/java/mx/santander/fiduciario/instruccionregistro/util/fileTest.txt");
		FileInputStream input;				
		try {
			input = new FileInputStream(file);
			multipartFile = new MockMultipartFile(file.getName(),file.getName(),"",input.readAllBytes());	
		} catch (IOException e) {
			multipartFile = null;
		}
		//Se crea respuesta
		instruccionAnexoModelRes = InstruccionAnexoModel.builder()
										.idAnexo(1L)
										.idFkInstrNvas(1L)
										.idFolio(123L)
										.dsc_Tipo("INSTRUCCION")
										.fchRegisInst(new Date())
										.build();
	}
	
	@Test
	@DisplayName("Guarda Anexo model en Repositorio, CASO_EXITO")
	@Disabled
	void saveAnexoModel() {
		
		InstruccionAnexoModel instruccionAnexoModel = Mockito.mock(InstruccionAnexoModel.class, Mockito.RETURNS_DEEP_STUBS);
		
		when(instruccionAnexoModel.builder()
				.idFkInstrNvas(Mockito.anyLong())
				.dscDocNombr(Mockito.anyString())
				.dsc_Tipo(Mockito.anyString())
				.idFolio(Mockito.anyLong())
				.fchRegisInst(null)
				.build()).thenReturn(instruccionAnexoModelRes);
		when(anexoInstructionRepository.save(Mockito.anyObject())).thenReturn(instruccionAnexoModelRes);
		InstruccionAnexoModel anexoModel = anexoInstructionService.save(1L,123L,multipartFile,"INSTRUCCION");

		

		
		
		assertEquals(instruccionAnexoModelRes.getIdAnexo(), anexoModel.getIdAnexo());
		
		
	}

}
