
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendInstrReqDto implements Serializable{

	private static final long serialVersionUID = 1L;
	@NotNull
	private SendIntrsBucDto buc;
	@NotNull
    private SendInstrTypeInstructionDto typeInstruction;
	@NotNull
    private SendInstrBusinessDto business;
    @Builder.Default
	@NotNull
    private List<SendInstrFileDto> files = new ArrayList<>();

}
