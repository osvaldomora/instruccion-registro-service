
package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Se transforman los datos del envio de la instruccion 
 * Este DTO contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendInstrReqDto implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	//La variable buc
	@NotNull
	private SendIntrsBucDto buc;
	//La variable typeInstruction
	@NotNull
    private SendInstrTypeInstructionDto typeInstruction;
	//La variable business
	@NotNull
    private SendInstrBusinessDto business;
	//Files
    @Builder.Default
	@NotNull
    private List<SendInstrFileDto> files = new ArrayList<>();
}//Fin de la clase 
