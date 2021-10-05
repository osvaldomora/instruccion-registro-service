package mx.santander.fiduciario.instruccionregistro.gestion.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserModel {
	
	
    private String buc;
    private String name;
    private String surnames;
    private Integer attempts;
    private String description;
    private String password;
    private String status;
    private String mail;
    private Integer count;
    private String message;
    private Date lastConecction;

	
	
	
	

}
