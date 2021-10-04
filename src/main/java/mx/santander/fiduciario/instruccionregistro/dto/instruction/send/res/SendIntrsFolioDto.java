package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se transforman los datos de envio de instrucciones del folio
 * Este DTO contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendIntrsFolioDto implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	//La variable folio
	private Long folio;
	//La variable folioRequest
    private Long folioRequest;
    //La variable fileName 
    private String fileName;
    //La variable type
    private String type;
    //La variable dateOperation
    private Date dateOperation;
}//Fin de la clase 
