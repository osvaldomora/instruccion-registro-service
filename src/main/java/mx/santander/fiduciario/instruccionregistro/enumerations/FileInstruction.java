package mx.santander.fiduciario.instruccionregistro.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Este enum permite recuperar los tipos de archivos de instrucciones
 * @author 
 */
@Getter
@AllArgsConstructor
public enum FileInstruction {

	//INSTRUCCION
	INSTRUCCION("INSTRUCCION",FileExtension.PDF),
	//LAYOUT
	LAYOUT("LAYOUT",FileExtension.TXT),
	//ANEXO
	ANEXO("ANEXO",FileExtension.PDF),
	//PLANTILLA_DOC
	PLANTILLA_DOC("PLANTILLA",FileExtension.DOC),
	//PLANTILLA_DOCX
	PLANTILLA_DOCX("PLANTILLA",FileExtension.DOCX);
	//La variable name 
	private final String name;
	//La variable fileExtension
	private final FileExtension fileExtension;
}//Fin de la clase 
