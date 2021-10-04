package mx.santander.fiduciario.instruccionregistro.config;

import javax.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * Esta es la clase que permite por medio de sus anotaciones
 * inyectar las configuraciones personalizadas externalizadas 
 * (ya sea por medio del archivo bootstrap.yml
 * O bien por el servicio de configuracion referenciado por el mismo)
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 */
@Configuration
@ConfigurationProperties(prefix="instruccion-registro-service")
@Validated
public class InstruccionRegistroConfig {

	//La variable nombreConfig
	@NotEmpty
	private String nombreConfig;
	
	
	
	/**
	 * Obtiene valor de la variable nombreConfig 
	 * @return String La descripcion de la configuracion
	 */
	public String getNombreConfig() {
		return nombreConfig;
	}//Fin del metodo 

	/**
	 * @param nombreConfig La descripcion de la configuracion
	 */
	public void setNombreConfig(String nombreConfig) {
		this.nombreConfig = nombreConfig;
	}//Fin del metodo 
}//Fin de la clase 