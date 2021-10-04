package mx.santander.fiduciario.instruccionregistro.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Este enum permite recuperar las extension de los archivos validos
 * @author
 */
@Getter
@AllArgsConstructor
public enum FileExtension {
	//PDF
	PDF("pdf","pdf","type=application/pdf","application/pdf"),
	//TXT
	TXT("txt","txt", "type=text/plain", "text/plain"),
	//DOC
	DOC("doc","doc","application/msword", "application/msword"),
	//DOCX
	DOCX("docx","docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document","application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	//La variable name 
	private final String name;
	//La variable extension
	private final String extension;
	//La variable mimeType
	private final String mimeType;
	//La variable contentType
	private final String contentType;
}//Fin de la clase 