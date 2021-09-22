package mx.santander.fiduciario.instruccionregistro.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.santander.fiduciario.instruccionregistro.exception.InstruccionRegistroInexistenteException;
import mx.santander.fiduciario.instruccionregistro.config.InstruccionRegistroConfig;

import java.util.Optional;

import mx.santander.fiduciario.instruccionregistro.util.ErrorEnum;
import mx.santander.fiduciario.instruccionregistro.repository.IInstruccionRegistroRepository;



import mx.santander.fiduciario.instruccionregistro.model.InstruccionRegistro;

import org.owasp.encoder.Encode;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Esta es la clase principal de este microservicio, encargada de orquestador la logica de negocio relacionada 
 * solamente a instruccionRegistro y sus datos (persistencia)
 * 
 * En esta clase puede haber invocacion a otros componentes con sufijo *Service,
 * los cuales a su vez pudieran invocar a otros microservicios o APIs, pero sin contener logica de negocio.
 */
@Service
public class InstruccionRegistroService implements IInstruccionRegistroService {


	/** La Constante LOGGER. Obtiene el Logger de la clase */
    private static final Logger LOGGER = LoggerFactory.getLogger(InstruccionRegistroService.class);
	
	@Autowired
	private IInstruccionRegistroRepository instruccionRegistroRepository;

	@Autowired
	private InstruccionRegistroConfig config;



	@Override
	public InstruccionRegistro consultarInstruccionRegistro(Long id) 
								throws InstruccionRegistroInexistenteException{

		Optional<InstruccionRegistro> instruccionregistro;
						

		//Consulta repositorio por id de la entidad
		instruccionregistro = instruccionRegistroRepository.findById(id);
		
		//En caso de no encontrarlo, arroja excepcion especifica
		if(!instruccionregistro.isPresent()){
			throw new InstruccionRegistroInexistenteException(ErrorEnum.EXC_INEXISTENTE);
		}
		
		LOGGER.info("Consulta realizada: {}", Encode.forJava(instruccionregistro.toString()));

		
		

		//TODO: Colocar logica de negocio relacionada al dominio funcional de InstruccionRegistro


		return instruccionregistro.get();

	}
		
								


	@Override
	public InstruccionRegistro crearInstruccionRegistro(InstruccionRegistro instruccionregistro) {

		//Realiza creacion de entidad en el repositorio
		InstruccionRegistro instruccionregistroGen = instruccionRegistroRepository.save(instruccionregistro);
		LOGGER.info("Creacion realizada: {}", Encode.forJava(instruccionregistroGen.toString()));


	
		return instruccionregistroGen;

	}

	


	@Override
	public InstruccionRegistro actualizarInstruccionRegistro(InstruccionRegistro instruccionregistro) 
							throws InstruccionRegistroInexistenteException{

		//Consulta repositorio por id, y en caso de no encontrarlo, arroja excepcion especifica
		if(!instruccionRegistroRepository.findById(instruccionregistro.getId()).isPresent()){
			throw new InstruccionRegistroInexistenteException(ErrorEnum.EXC_INEXISTENTE);
		}

		//Realiza actualizacion de entidad en el repositorio
		InstruccionRegistro instruccionregistroGen = instruccionRegistroRepository.save(instruccionregistro);
		LOGGER.info("Actualizacion realizada: {}", Encode.forJava(instruccionregistroGen.toString()));



		return instruccionregistroGen;

	}

		


	@Override
	public void eliminarInstruccionRegistro(Long id) 
							throws InstruccionRegistroInexistenteException{

		//Consulta repositorio por id, y en caso de no encontrarlo, arroja excepcion especifica
		if(!instruccionRegistroRepository.findById(id).isPresent()){
			throw new InstruccionRegistroInexistenteException(ErrorEnum.EXC_INEXISTENTE);
		}

		//Realiza eliminacion de entidad en el repositorio
		instruccionRegistroRepository.deleteById(id);
		LOGGER.info("Eliminacion realizada");

		


	}
		

}
