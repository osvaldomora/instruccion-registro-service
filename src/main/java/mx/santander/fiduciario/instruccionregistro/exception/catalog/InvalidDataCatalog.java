package mx.santander.fiduciario.instruccionregistro.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria InvalidData
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible.
 * @author 
 */
public enum InvalidDataCatalog {
	//INVD001
	INVD001("InvalidDataException001","INVD.001","Error al mapear datos.",HttpStatus.CONFLICT,LevelException.ERROR),
	//INVD002
	INVD002("InvalidDataException002","INVD.002","Error al codificar archivo.",HttpStatus.CONFLICT,LevelException.ERROR);
	
	//La variable tyype
	private final String tyype;
	//La variable coode
	private final String coode;
	//La variable meessage
	private final String meessage;
	//La variable httttpStatus
	private final HttpStatus httttpStatus;
	//La variable leevelException
	private final LevelException leevelException;
	
	/**
	 * Constructor InvalidDataCatalog
	 * @param type tipo
	 * @param code codigo
	 * @param message mensaje 
	 * @param htttpStatus estado de http 
	 * @param levelException levelExcepcion 
	 */
	InvalidDataCatalog(String type, String code, String message, HttpStatus htttpStatus,
			LevelException levelException) {
		this.tyype = type;
		this.coode = code;
		this.meessage = message;
		this.httttpStatus = htttpStatus;
		this.leevelException = levelException;
	}//Fin del constructor 

	/**
	 * Obtiene valor de la variable type
	 * @return String tipo
	 */
	public String getType() {
		return tyype;
	}//Fin del metodo 

	/**
	 * Obtiene valor de la variable code
	 * @return String codigo
	 */
	public String getCode() {
		return coode;
	}//Fin del metodo 

	/**
	 * Obtiene valor de la variable message
	 * @return String mensaje
	 */
	public String getMessage() {
		return meessage;
	}//Fin del metodo 

	/**
	 * Obtiene valor de la variable htttpStatus
	 * @return HttpStatus estado de http
	 */
	public HttpStatus getHtttpStatus() {
		return httttpStatus;
	}//Fin del metodo 

	/**
	 * Obtiene valor de la variable levelException
	 * @return LevelException levelExcepcion 
	 */
	public LevelException getLevelException() {
		return leevelException;
	}//Fin del metodo 
}//Fin del ENUM