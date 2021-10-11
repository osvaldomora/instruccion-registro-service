
package  mx.santander.fiduciario.instruccionregistro.dto.validateinstruction;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase DataDto
 * Contiene las propiedades del objeto para 
 * poder tener acceso a las propiedades.
 * @author glenn
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataDto implements Serializable{
	//Variable de validation
	public Boolean validation;
	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;

}
