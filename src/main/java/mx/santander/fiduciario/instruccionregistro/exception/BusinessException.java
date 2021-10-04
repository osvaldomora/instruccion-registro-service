package mx.santander.fiduciario.instruccionregistro.exception;

import mx.santander.fiduciario.instruccionregistro.controller.exception.model.ModelException;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.BusinessCatalog;

/**
 * Clase BusinessException
 * Manejo de excepciones 
 * @author 
 */
public class BusinessException extends ModelException{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor BusinessException
	 * @param catalog Excepcion del catalogo de BusinessCatalog
	 * @param description Descripcion detallada de la excepcion
	 */
	public BusinessException(BusinessCatalog catalog, String description) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString(), description);
	}//Fin del constructor 
	
	/**
	 * Constructor BusinessException
	 * @param catalog Descripcion detallada de la excepcion
	 */
	public BusinessException(BusinessCatalog catalog) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString());
	}//Fin del constructor 
}//Fin de la clase 
