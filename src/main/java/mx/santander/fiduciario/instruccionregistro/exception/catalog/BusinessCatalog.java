package mx.santander.fiduciario.instruccionregistro.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria Business
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible.
 * @author 
 */
public enum BusinessCatalog {
	//BUSI001
	BUSI001("BusinessException001","BUSI.001","Error el documento no puede exceder el minimo y maximo de tamaño.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//BUSI002
	BUSI002("BusinessException002","BUSI.002","Formato de archivo no soportado.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//BUSI003
	BUSI003("BusinessException003","BUSI.003","Se ha excedido el limite de archivos.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//BUSI004
	BUSI004("BusinessException004","BUSI.004","Formato no valido.",HttpStatus.BAD_REQUEST,LevelException.WARN);
	//La variable type 
	private final String type;
	//La variable code 
	private final String code;
	//La variable message
	private final String message;
	//La variable htttpStatus
	private final HttpStatus htttpStatus;
	//La variable levelException
	private final LevelException levelException;
	
	/**
	 * Constructor BusinessCatalog
	 * @param type tipo
	 * @param code codigo  
	 * @param message mensaje 
	 * @param htttpStatus estado del http
	 * @param levelException levelExcepciones
	 */
	BusinessCatalog(String type, String code, String message, HttpStatus htttpStatus,
			LevelException levelException) {
		this.type = type;
		this.code = code;
		this.message = message;
		this.htttpStatus = htttpStatus;
		this.levelException = levelException;
	}//Fin del constructor 

	/**
	 * Obtener valor de la variable type
	 * @return String tipo
	 */
	public String getType() {
		return type;
	}//Fin del metodo 

	/**
	 * Obtener valor de la variable code
	 * @return String codigo
	 */
	public String getCode() {
		return code;
	}//Fin del metodo 
	
	/**
	 * Obtener valor de la variable message 
	 * @return String mensaje 
	 */
	public String getMessage() {
		return message;
	}//Fin del metodo 

	/**
	 * Obtener valor de la variable htttpStatus
	 * @return HttpStatus estado del http
	 */
	public HttpStatus getHtttpStatus() {
		return htttpStatus;
	}//Fin del metodo 

	/**
	 * Obtener valor de la variable  levelException
	 * @return LevelException levelExcepcion 
	 */
	public LevelException getLevelException() {
		return levelException;
	}//Fin del metodo 
}//Fin del ENUM