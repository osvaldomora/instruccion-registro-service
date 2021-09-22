package mx.santander.fiduciario.instruccionregistro.exception;

import mx.santander.fiduciario.instruccionregistro.util.ErrorEnum;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Clase de excepcion de negocio cuando no existe InstruccionRegistro 
 */
public class InstruccionRegistroInexistenteException extends Exception {

    private static final long serialVersionUID = 1303454450535514738L;
    


    /**
     * Constructor
     * @param message Mensaje de error
     */
    public InstruccionRegistroInexistenteException(String message) {
        super(message);
    }
    

    /**
     * Constructor
     * @param message Mensaje de error
     * @param causa Causa completa del error
     */
    public InstruccionRegistroInexistenteException(String message, Throwable causa) {
        super(message, causa);
    }
    


    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     */
    public InstruccionRegistroInexistenteException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
    }
    
    
    /**
     * Constructor que la interfaz del enumerador de error
     * @param errorEnum Interfaz de enumerador de error
     * @param causa Causa completa del error
     */
    public InstruccionRegistroInexistenteException(ErrorEnum errorEnum, Throwable causa) {
        super(errorEnum.getMessage(), causa);
    }
    
}