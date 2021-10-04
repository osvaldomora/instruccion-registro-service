package mx.santander.fiduciario.instruccionregistro.exception;

import mx.santander.fiduciario.instruccionregistro.controller.exception.model.ModelException;
import mx.santander.fiduciario.instruccionregistro.exception.catalog.PersistenDataCatalog;

/**
 * Clase PersistenDataException
 * Manejo de excepciones 
 * @author 
 */
public class PersistenDataException extends ModelException{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor PersistenDataException
	 * @param catalog Excepcion del catalogo de PersistendDataCatalog
	 * @param description Descripcion detallada de la excepcion
	 */
	public PersistenDataException(PersistenDataCatalog catalog, String description) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString(), description);
	}//Fin del constructor 
	
	/**
	 * Constructor PersistenDataException
	 * @param catalog Descripcion detallada de la excepcion
	 */
	public PersistenDataException(PersistenDataCatalog catalog) {
		super(catalog.getHtttpStatus(), catalog.getCode(), catalog.getMessage(), catalog.getLevelException().toString());
	}//Fin del constructor 
}//Fin de la clase 