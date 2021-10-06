package mx.santander.fiduciario.instruccionregistro.notification.response;

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
public class NotificacionResponseDto implements Serializable{
	
	private StatusDto status;
	private static final long serialVersionUID = 1L;
	

}
