package mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La Clase se encarga de transformar datos de envio de Instrucciones de contrato
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendInstrBusinessDto implements Serializable{

	// Variable para serializar la clase.
	private static final long serialVersionUID = 1L;
	//La variable id
	@NotNull
	private Long id;
	//La variable subBusiness
	@NotNull
    private SendInstrSubBusinessDto subBusiness;
}//Fin de la clase 
