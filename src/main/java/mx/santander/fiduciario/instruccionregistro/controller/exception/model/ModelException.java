package mx.santander.fiduciario.instruccionregistro.controller.exception.model;

import org.springframework.http.HttpStatus;
/**
 * Clase ModelException
 * Modelo para la ejecucion del servicio
 * @author 
 */
public class ModelException extends RuntimeException{

	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	
	//La variable httpStatus
	private final HttpStatus httpStatus;
	//La variable code
	private final String code;
	//La variable message
	private final String message;
	//La variable level
	private final String level;
	//La variable description
	private final String description;
	
	/**
	 * Constructor del error de respuesta
	 * @param httpStatus Estatus HTTP de respuesta del error
	 * @param code Codigo interno del error
	 * @param message Mensaje generico del error
	 * @param level Nivel del error
	 * @param description Descripcion detallada del error
	 */
	public ModelException(HttpStatus httpStatus, String code, String message, String level, String description) {
		super();
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = description;
	}//Fin del constructor 
	
	/**
	 * Constructor del error de respuesta sin descripcion detallada
	 * @param httpStatus Estatus HTTP de respuesta del error
	 * @param code Codigo interno del error
	 * @param message Mensaje generico del error
	 * @param level Nivel del error
	 */
	public ModelException(HttpStatus httpStatus, String code, String message, String level) {
		super();
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
		this.level = level;
		this.description = null;
	}//Fin del constructor 
	
	/**
	 * Obtiene valor de la variable serialVersionUID
	 * @return long serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable httpStatus
	 * @return HttpStatus retorna estado del http
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable code
	 * @return String retorna codigo 
	 */
	public String getCode() {
		return code;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable message  
	 * @return String retorna mensaje 
	 */
	@Override
	public String getMessage() {
		return message;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable level 
	 * @return String retorna level 
	 */
	public String getLevel() {
		return level;
	}//Fin del metodo 
	
	/**
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}//Fin del metodo 
}//Fin de la clase 