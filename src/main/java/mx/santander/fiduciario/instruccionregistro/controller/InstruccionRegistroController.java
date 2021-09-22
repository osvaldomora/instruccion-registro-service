package mx.santander.fiduciario.instruccionregistro.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import mx.santander.fiduciario.instruccionregistro.exception.InstruccionRegistroInexistenteException;

import org.springframework.web.bind.annotation.GetMapping;
import java.net.URI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import mx.santander.fiduciario.instruccionregistro.model.InstruccionRegistro;
import mx.santander.fiduciario.instruccionregistro.service.IInstruccionRegistroService;

import org.owasp.encoder.Encode;


/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Esta clase se encarga de exponer los endpoints de acceso basado principios REST
 * Existen ciertas consultas, bajas, altas y actualizaciones a una coleccion de recursos de instruccionRegistro
 */
@RestController
@RequestMapping("/instruccionregistro")
public class InstruccionRegistroController {
	 
	/** La Constante LOGGER. Obtiene el Logger de la clase */
    private static final Logger LOGGER = LoggerFactory.getLogger(InstruccionRegistroController.class);
	
	@Autowired
	private IInstruccionRegistroService instruccionRegistroService;
	

	
    /**
     * Este es un ejemplo de un metodo HTTP GET consultando por id del recurso de tipo InstruccionRegistro
	 * y en la implementacion de la interfaz de negocio instruccionRegistroService 
	 * puede realizar ciertas transformaciones/agregaciones a la consulta para enriquecer la presentacion.
	 * 
	 * Este metodo es idempotente, y sus procesos derivados NUNCA deben modificar el estado de algun recurso en el servidor. 
	 * TODOS los procesos desencadenados deben ser solo de consulta.
	 * 
     * @param id Id de instruccionregistro a dar de alta
     * @return Codigo de la operacion y objeto JSON obtenido
     * @throws InstruccionRegistroInexistenteException Excepcion de recurso inexistente
     */
	@ApiOperation(value = "Listar los InstruccionRegistro disponibles", notes = "Lista de InstruccionRegistro", response=ResponseEntity.class, httpMethod="GET", authorizations = {@Authorization(value="apiKey")})
		@GetMapping(value = "/{id}",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<InstruccionRegistro> consultarInstruccionRegistroPorId(@PathVariable("id") Long id) 
							throws InstruccionRegistroInexistenteException{
								
        LOGGER.debug("Entra a controller para consulta de la entidad");
        InstruccionRegistro instruccionregistro;
        
		instruccionregistro = instruccionRegistroService.consultarInstruccionRegistro(id);
        return new ResponseEntity<>(instruccionregistro, HttpStatus.OK);
		
    }

    

    /**
     * Este es un ejemplo de un metodo HTTP POST, el cual en la implementacion de la interfaz de negocio instruccionRegistroService 
	 * crea un nuevo recurso bajo la coleccion /instruccionregistro y puede realizar cierta logica de negocio adicional
	 * 
 	 * Este metodo es non-safe y NO es idempotente, por lo cual sus procesos derivados SIEMPRE afectaran el estado de un recurso en el servidor.
	 * En conjunto con un mecanismo de control de transaccionalidad en repositorios con estado, 
	 * puede es usado por ejemplo para orquestar transacciones financieras o de otro tipo
	 * 
     * @param instruccionregistro InstruccionRegistro a dar de alta
     * @param ucBuilder Generador de URIs
     * @return Codigo de la operacion, y header con la URI de la ubicacion de nuevo recurso
     */
	@ApiOperation(value = "Alta de InstruccionRegistro", notes = "En el header Location devuelve el recurso que fue registrado", response=ResponseEntity.class, httpMethod="POST", authorizations = {@Authorization(value="apiKey")})				    
		@PostMapping(value = "",
						consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<Long> crearInstruccionRegistro(@Valid @RequestBody InstruccionRegistro instruccionregistro, 
								UriComponentsBuilder ucBuilder) {

    	LOGGER.debug("Entra a controller, creacion : {}", Encode.forJava(instruccionregistro.toString()));
    	InstruccionRegistro instruccionregistroGen;
    
    	instruccionregistroGen = instruccionRegistroService.crearInstruccionRegistro(instruccionregistro);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(instruccionregistroGen.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
    }



    /**
     * Este es un ejemplo de un metodo HTTP PUT, el cual en la implementacion de la interfaz de negocio instruccionRegistroService 
	 * se encarga de actualizar el estado de un recurso en particular de la coleccion /instruccionregistro
	 * 
	 * Este metodo es idempotente y sus procesos derivados son idoneos para actualizar el estado de algun recurso EXISTENTE en el servidor
     * 
     * @param id Id de instruccionregistro
     * @param instruccionregistro InstruccionRegistro a dar de alta
     * @return Codigo http indicando si la actualizacion fue exitosa
     * @throws InstruccionRegistroInexistenteException Excepcion de recurso inexistente
     */
	@ApiOperation(value = "Actualizacion de InstruccionRegistro", notes = "Actualizacion de InstruccionRegistro", response=ResponseEntity.class, httpMethod="PUT", authorizations = {@Authorization(value="apiKey")})					    
		@PutMapping(value = "/{id}",
					consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<InstruccionRegistro> actualizarInstruccionRegistro(@PathVariable("id") Long id, 
				@Valid @RequestBody InstruccionRegistro instruccionregistro) throws InstruccionRegistroInexistenteException{
		
    	LOGGER.debug("Entra a controller, actualizacion : {}", Encode.forJava(instruccionregistro.toString()));
        
    	instruccionregistro.setId(id);
		instruccionRegistroService.actualizarInstruccionRegistro(instruccionregistro);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
    }


    /**
     * Este es un ejemplo de un metodo HTTP DELETE, el cual en la implementacion de la interfaz de negocio instruccionRegistroService 
	 * se encarga de eliminar un recurso en particular de la coleccion /instruccionregistro
	 * 
	 * Este metodo es idempotente, y sus procesos derivados son idoneos para eliminar algun recurso existente en el servidor
	 * 
     * @param id Id de instruccionregistro
     * @param instruccionregistro InstruccionRegistro a dar de alta
     * @return Codigo http indicando si la eliminacion fue exitosa
     * @throws InstruccionRegistroInexistenteException Excepcion de recurso inexistente
     */
	@ApiOperation(value = "Eliminacion de InstruccionRegistro", notes = "Eliminacion de InstruccionRegistro", response=ResponseEntity.class, httpMethod="DELETE", authorizations = {@Authorization(value="apiKey")})    
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<InstruccionRegistro> eliminarInstruccionRegistro(@PathVariable("id") Long id) 
    						throws InstruccionRegistroInexistenteException{
					
    	LOGGER.debug("Entra a controller, eliminacion de instruccionregistro");
        
		instruccionRegistroService.eliminarInstruccionRegistro(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
    }





}