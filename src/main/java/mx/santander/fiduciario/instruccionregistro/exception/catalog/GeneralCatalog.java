package mx.santander.fiduciario.instruccionregistro.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria General
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible.
 * @author 
 */
public enum GeneralCatalog {
	//GRAL001
	GRAL001("GeneralException001","GRAL.001","Error generico de servidor.",HttpStatus.INTERNAL_SERVER_ERROR,LevelException.ERROR),
	//GRAL002
	GRAL002("GeneralException002","GRAL.002","Error al enviar Query Parameters.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//GRAL003
	GRAL003("GeneralException003","GRAL.003","URI parameters no valido.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//GRAL004
	GRAL004("GeneralException004","GRAL.004","Conflicto al realizar la operación.",HttpStatus.CONFLICT,LevelException.ERROR),
	//GRAL005
	GRAL005("GeneralException005","GRAL.005","Consulta duplicada.",HttpStatus.BAD_REQUEST,LevelException.WARN),
	//GRAL006
	GRAL006("GeneralException006","GRAL.006","Error al enviar parametros.",HttpStatus.BAD_REQUEST,LevelException.WARN)	;
	//La variable ttype
	private final String ttype;
	//La variable ccode
	private final String ccode;
	//La variable mmessage
	private final String mmessage;
	//La variable hhtttpStatus
	private final HttpStatus hhtttpStatus;
	//La variable llevelException
	private final LevelException llevelException;
	
	/**
	 * Constructor GeneralCatalog
	 * @param type tipo
	 * @param code codigo 
	 * @param message mensaje 
	 * @param htttpStatus estado del htpp 
	 * @param levelException levelExcepcion 
	 */
	GeneralCatalog(String type, String code, String message, HttpStatus htttpStatus,
			LevelException levelException) {
		this.ttype = type;
		this.ccode = code;
		this.mmessage = message;
		this.hhtttpStatus = htttpStatus;
		this.llevelException = levelException;
	}//Fin del constructor 
	
	/**
	 * Obtiene valor de la variable ttype
	 * @return String tipo
	 */
	public String getType() {
		return ttype;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable ccode
	 * @return String codigo
	 */
	public String getCode() {
		return ccode;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable mmessage
	 * @return String mensaje 
	 */
	public String getMessage() {
		return mmessage;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable hhtttpStatus
	 * @return HttpStatus estado de http 
	 */
	public HttpStatus getHtttpStatus() {
		return  hhtttpStatus;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable llevelException
	 * @return LevelException levelExcepcion 
	 */
	public LevelException getLevelException() {
		return llevelException;
	}//Fin del metodo 
}//Fin del ENUM