package mx.santander.fiduciario.instruccionregistro.service;

import mx.santander.fiduciario.instruccionregistro.model.InstruccionRegistro;
import mx.santander.fiduciario.instruccionregistro.exception.InstruccionRegistroInexistenteException;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Interfaz publica para las operaciones de negocio de la entidad InstruccionRegistro
 */
public interface IInstruccionRegistroService {


	/**
	 * Consulta de entidad de negocio
	 * 
	 * @param id El id de la entidad a consultar
	 * @return Objeto de la entidad consultada
	 * @throws InstruccionRegistroInexistenteException Excepcion de entidad inexistente
	 */
	InstruccionRegistro consultarInstruccionRegistro(Long id) throws InstruccionRegistroInexistenteException;




	/**
	 * Creacion de entidad de negocio
	 * @param instruccionregistro El objeto de la entidad a crear
	 * @return Entidad creada
	 */
	 InstruccionRegistro crearInstruccionRegistro(InstruccionRegistro instruccionregistro);



	/**
	 * Actualizacion de entidad de negocio
	 * 
	 * @param instruccionregistro El objeto de la entidad a actualizar
	 * @return instruccionregistro El objeto en su estado actual
	 * @throws InstruccionRegistroInexistenteException Excepcion de entidad inexistente
	 */
	 InstruccionRegistro actualizarInstruccionRegistro(InstruccionRegistro instruccionregistro) throws InstruccionRegistroInexistenteException;




	/**
	 * Eliminacion de entidad de negocio
	 * 
	 * @param id El id de la entidad a eliminar
	 * @throws InstruccionRegistroInexistenteException Excepcion de entidad inexistente
	 */
	void eliminarInstruccionRegistro(Long id) throws InstruccionRegistroInexistenteException;


}
