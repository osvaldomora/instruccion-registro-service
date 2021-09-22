package mx.santander.fiduciario.instruccionregistro.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import mx.santander.fiduciario.instruccionregistro.config.InstruccionRegistroConfig;
import mx.santander.fiduciario.instruccionregistro.exception.InstruccionRegistroInexistenteException;
import mx.santander.fiduciario.instruccionregistro.model.InstruccionRegistro;
import mx.santander.fiduciario.instruccionregistro.service.IInstruccionRegistroService;
import mx.santander.fiduciario.instruccionregistro.service.InstruccionRegistroService;
import mx.santander.fiduciario.instruccionregistro.repository.IInstruccionRegistroRepository;


@RunWith(SpringRunner.class)
public class InstruccionRegistroServiceTest {


	@TestConfiguration
    static class InstruccionRegistroServiceConfig {
        @Bean
        public IInstruccionRegistroService instruccionregistroService() {
            return new InstruccionRegistroService();
        }
    }


	/** La Constante LOGGER. Obtiene el Logger de la clase */
	private static final Logger LOGGER = LoggerFactory.getLogger(InstruccionRegistroServiceTest.class);	

	private static final Long ID = 1L;
	
	private static final String NOMBRE = "NOMBRE";


    @Autowired
    private IInstruccionRegistroService service;

    @MockBean
	private InstruccionRegistroConfig config;
    
    @MockBean
    private IInstruccionRegistroRepository instruccionregistroRepository;
    





    @Test
    public void consultarInstruccionRegistro() throws InstruccionRegistroInexistenteException {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionRegistro> instruccionregistroMock = Optional.of(new InstruccionRegistro(ID, NOMBRE));
    	when(instruccionregistroRepository.findById(ID)).thenReturn(instruccionregistroMock);
    	
    	//ejecuta service
    	InstruccionRegistro instruccionregistro = service.consultarInstruccionRegistro(ID);
    	
    	LOGGER.info("Se ejecuta service");
    	//En este caso, solamente valida que el objeto retornado por el repository sea igual que el objeto devuelto por el service
    	assertThat(instruccionregistro).isEqualToComparingFieldByField(instruccionregistroMock.get());
    }
    
    
    @Test
    (expected = InstruccionRegistroInexistenteException.class)
    public void consultarInstruccionRegistroInexistenteException() throws InstruccionRegistroInexistenteException{

    	//mock de bean no existente al consultar el repositorio
    	Optional<InstruccionRegistro> instruccionregistroMock = Optional.ofNullable(null);
    	when(instruccionregistroRepository.findById(ID)).thenReturn(instruccionregistroMock);

    	LOGGER.info("Se ejecuta service");
    	//en este caso, debe arrojarse una excepcion de InstruccionRegistroInexistenteException
    	service.consultarInstruccionRegistro(ID);
    	
    }





	@Test
	public void crearInstruccionRegistro() {

		//mock de bean encontrado al consultar el repositorio
		InstruccionRegistro instruccionregistroMockEntrada = new InstruccionRegistro();
		instruccionregistroMockEntrada.setNombre(NOMBRE);
		InstruccionRegistro instruccionregistroMockSalida = new InstruccionRegistro(ID, instruccionregistroMockEntrada.getNombre());
		when(instruccionregistroRepository.save(instruccionregistroMockEntrada)).thenReturn(instruccionregistroMockSalida);
		
		//ejecuta service
		InstruccionRegistro instruccionregistro = service.crearInstruccionRegistro(instruccionregistroMockEntrada);


    	LOGGER.info("Se ejecuta service");
		//En este caso, solamente valida que el id del objeto retornado por el repository sea igual que el id objeto devuelto por el service
		assertThat(instruccionregistro).isEqualTo(instruccionregistroMockSalida);

	}






    @Test
    public void actualizarInstruccionRegistro() throws InstruccionRegistroInexistenteException  {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionRegistro> instruccionregistroMock = Optional.of(new InstruccionRegistro(ID, NOMBRE));
    	when(instruccionregistroRepository.findById(ID)).thenReturn(instruccionregistroMock);
    	when(instruccionregistroRepository.save(instruccionregistroMock.get())).thenReturn(new InstruccionRegistro(ID, NOMBRE));

    	LOGGER.info("Se ejecuta service");
    	service.actualizarInstruccionRegistro(instruccionregistroMock.get());
    }

    
    @Test
	(expected = InstruccionRegistroInexistenteException.class)
    public void actualizarInstruccionRegistroInexistenteException() throws InstruccionRegistroInexistenteException  {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionRegistro> instruccionregistroMock = Optional.ofNullable(null);
    	when(instruccionregistroRepository.findById(ID)).thenReturn(instruccionregistroMock);

    	LOGGER.info("Se ejecuta service");
    	service.actualizarInstruccionRegistro(new InstruccionRegistro(ID, NOMBRE));
    }

    
    
    
   

    @Test
    public void eliminarInstruccionRegistro() throws InstruccionRegistroInexistenteException  {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionRegistro> instruccionregistroMock = Optional.of(new InstruccionRegistro(ID, NOMBRE));
    	when(instruccionregistroRepository.findById(ID)).thenReturn(instruccionregistroMock);

    	LOGGER.info("Se ejecuta service");
    	service.eliminarInstruccionRegistro(ID);
    }

    
    @Test
    (expected = InstruccionRegistroInexistenteException.class)
    public void eliminarInstruccionRegistroInexistenteException() throws InstruccionRegistroInexistenteException  {

    	//mock de bean encontrado al consultar el repositorio
    	Optional<InstruccionRegistro> instruccionregistroMock = Optional.ofNullable(null);
    	when(instruccionregistroRepository.findById(ID)).thenReturn(instruccionregistroMock);

    	LOGGER.info("Se ejecuta service");
    	service.eliminarInstruccionRegistro(ID);
    }



}