package mx.santander.fiduciario.instruccionregistro.notification.request;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase NotificationReq
 * Modelo del Request que consumira la API
 * @author Z334926
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationReq implements Serializable{
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	@NotNull
	private String buc;
//	@NotNull
//	private String email;

}
