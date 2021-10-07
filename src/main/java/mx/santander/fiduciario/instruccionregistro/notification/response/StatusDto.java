package mx.santander.fiduciario.instruccionregistro.notification.response;

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
public class StatusDto {
	
	private String  statusCode;
	private Boolean success;
	private String description;
	private static final long serialVersionUID = 1L;
	
}
