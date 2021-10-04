package mx.santander.fiduciario.instruccionregistro.exception;

import mx.santander.fiduciario.instruccionregistro.controller.exception.model.ModelException;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.GeneralCatalog;

/**
 * Clase GeneralException
 * Para manejo de excepciones 
 * @author
 */
public class GeneralException extends ModelException{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor GeneralException
	 * @param catalog Excepcion del catalogo de GeneralCatalog
	 * @param description Descripcion detallada de la excepcion
	 */
	public GeneralException(GeneralCatalog catalog, String description) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString(), description);
	}//Fin del constructor 
	
	/**
	 * Constructor GeneralException
	 * @param catalog Descripcion detallada de la excepcion
	 */
	public GeneralException(GeneralCatalog catalog) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString());
	}//Fin del construtor 
}//Fin de la clase 
