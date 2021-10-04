package mx.santander.fiduciario.instruccionregistro.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *Este enum permite saber si un archivo es requerido
 *@author 
 */
@Getter
@AllArgsConstructor
public enum FileRequired {
	//TRUE
	TRUE("TRUE",true),
	//OPCIONAL 
	OPCIONAL("OPTIONAL",false);
	//La variable name 
	private final String name;
	//La variable value
	private final boolean value;
}//Fin de la clase 
