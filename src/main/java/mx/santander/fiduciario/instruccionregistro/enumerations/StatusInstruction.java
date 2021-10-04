package mx.santander.fiduciario.instruccionregistro.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Este permite saber el estado en el que se encuentra un archivo
 * @author 
 */
@Getter
@AllArgsConstructor
public enum StatusInstruction {
	//SOLICITADA
	SOLICITADA("SO", "SOLICITADA",1L),
	//ENTREGADA
	ENTREGADA("EN", "ENTREGADA",2L),
	//PROCESO
	PROCESO("PR", "EN PROCESO",3L),
	//ATENDIDA
	ATENDIDA("AT", "ATENDIDA",4L),
	//RECHAZADA
	RECHAZADA("RE", "RECHAZADA",5L);
	//La variable id
	private String id;
	//La variable description
	private String description;
	//La variable value
	private Long value;
}//Fin de la clase 
