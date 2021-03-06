package mx.santander.fiduciario.instruccionregistro.util;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

/**
 * Esta clase permite trabajr con archivos, sus diferentes funcion son:
 * codificar y decodificar archivos en base64 y obtener el nombre de a extension
 * @author 
 */
public final class FileTool {

	/**
	 * Constructor privado que no permite hacer instancia
	 */
	private FileTool() {}//Fin del constructor 
	
	/**
	 * Este metodo permite encriptar un archivo multipart en base64
	 * @param file archivo a encriptar
	 * @return String cadena de archivo encriptado
	 * @throws IOException error al tratar de encriptar
	 */
	public static String encode64(MultipartFile file) throws IOException {
		StringBuilder fileEncode = new StringBuilder();

		byte [] fileBytes = file.getBytes();
		String encodeBytes = Base64.getEncoder().encodeToString(fileBytes);
		fileEncode.append(encodeBytes);

		return fileEncode.toString();
	}//Fin del metodo 
	
	/**
	 * Este metodo permite decodificar una cadena en base 64
	 * @param fileEncode cadena codificada
	 * @return byte[] arreglo decodificado
	 */
	public static byte[] decode64 (String fileEncode) {
		byte[] bytesDecode = Base64.getDecoder().decode(fileEncode);
		return bytesDecode;
	}//Fin del metodo 
	
	/**
	 * Este metodo permite obtener el nombre de la extension del archivo
	 * @param fullNameFile nombre completo del archivo
	 * @return String nombre de la extension
	 */
	public static String getFileExtension(String fullNameFile) {
		String extension = "";
		extension = fullNameFile.substring(fullNameFile.indexOf(".")+1);
		return extension;
	}//Fin del metodo 
}//Fin de la clase 