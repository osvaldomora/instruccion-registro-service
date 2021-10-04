package mx.santander.fiduciario.instruccionregistro.exception;

import mx.santander.fiduciario.instruccionregistro.controller.exception.model.ModelException;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.InvalidDataCatalog;

/**
 * Clase InvalidDataException
 * Manejo de excepciones 
 * @author 
 */
public class InvalidDataException extends ModelException{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor InvalidDataException
	 * @param catalog Excepcion del catalogo de InvalidDataCatalog
	 * @param description Descripcion detallada de la excepcion
	 */
	public InvalidDataException(InvalidDataCatalog catalog, String description) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString(), description);
	}//Fin del constructor 
	
	
	/**
	 * Constructor InvalidDataException
	 * @param catalog Descripcion detallada de la excepcion
	 */
	public InvalidDataException(InvalidDataCatalog catalog) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString());
	}//Fin del constructor 
}//Fin de la clase 
