package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.santander.fiduciario.instruccionregistro.dto.notification.res.NotificationDto;

/**
 * Se transforman los datos de envio de instrucciones DATA
 * Este DTO contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendInstrDataDto implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	// La variable folios
	@Builder.Default
	private List<SendIntrsFolioDto> folios = new ArrayList<>();
	private NotificationDto notification;
	
}//Fin de las clases 
