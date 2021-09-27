package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.res;

import java.io.Serializable;
import java.util.Date;

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
public class SendIntrsFolioDto implements Serializable{

	private static final long serialVersionUID = 1L;
	public Long folio;
    public Long folioRequest;
    public String type;
    public Date dateOperation;

}
