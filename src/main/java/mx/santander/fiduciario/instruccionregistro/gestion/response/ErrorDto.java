
package mx.santander.fiduciario.instruccionregistro.gestion.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * Clase ErrorDto
 *  
 * @author
 */
public class ErrorDto implements Serializable{
	//La variable code 
    public String code;
    //La variable message
    public String message;
    //La variable level
    public String level;
    //La variable description
    public String description;
    //La variable mreInfo
    public String moreInfo;
 // Variable para serializar la clase.
    private final static long serialVersionUID = -3365212127534543305L;
}//Fin de la clase 
