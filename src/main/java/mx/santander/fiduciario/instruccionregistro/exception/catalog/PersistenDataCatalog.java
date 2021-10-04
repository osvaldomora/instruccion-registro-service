package mx.santander.fiduciario.instruccionregistro.exception.catalog;

import org.springframework.http.HttpStatus;

/**
 * Este ENUM define el catalog de errores de la categoria Persistent
 * Esta clase permite la enumeracion de diferentes mensajes de excepcion
 * utilizados en los cuerpos de respuesta HTTP arrojados por el servicio
 * Es posible agregar nuevos mensajes personalizados
 * para permitir que el servicio sea mas explicito,
 * recordando siempre que es importante evitar arrojar informacion sensible.
 * @author 
 */
public enum PersistenDataCatalog {
	//PSID001
	PSID001("PersistentDataException001","PSID.001","Error al realizar la transaccion.",HttpStatus.CONFLICT,LevelException.ERROR),
	//PSID001
	PSID002("PersistentDataException002","PSID.002","Error de conexion en origen de datos.",HttpStatus.CONFLICT,LevelException.ERROR),
	//PSID001
	PSID003("PersistentDataException003","PSID.003","Recurso no encontrado.",HttpStatus.CONFLICT,LevelException.ERROR);
	
	//La variable typpe
	private final String typpe;
	//La variable codde
	private final String codde;
	//La variable messsage
	private final String messsage;
	//La variable htttppStatus
	private final HttpStatus htttppStatus;
	//La variable levvelException
	private final LevelException levvelException;
	
	/**
	 * Constructor PersistenDataCatalog
	 * @param type tipo
	 * @param code codigo
	 * @param message mensaje 
	 * @param htttpStatus estado de http 
	 * @param levelException levelExcepcion 
	 */
	PersistenDataCatalog(String type, String code, String message, HttpStatus htttpStatus,
			LevelException levelException) {
		this.typpe = type;
		this.codde = code;
		this.messsage = message;
		this.htttppStatus = htttpStatus;
		this.levvelException = levelException;
	}//Fin del constructor 
	
	/**
	 * Obtiene valor de la variable typpe
	 * @return String retorna tipo
	 */
	public String getType() {
		return typpe;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable codde
	 * @return String retorna codigo 
	 */
	public String getCode() {
		return codde;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable messsage
	 * @return String retorna mensaje 
	 */
	public String getMessage() {
		return messsage;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable htttppStatus
	 * @return HttpStatus retorna estado de http 
	 */
	public HttpStatus getHtttpStatus() {
		return htttppStatus;
	}//Fin del metodo 
	
	/**
	 * Obtiene valor de la variable levvelException
	 * @return LevelException retorna levelExcepcion 
	 */
	public LevelException getLevelException() {
		return levvelException;
	}//Fin del metodo 
}//Fin del ENUM 