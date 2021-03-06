package mx.santander.fiduciario.instruccionregistro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Esta es la clase principal que inicia la aplicacion de Spring Boot.
 * En ella se puede agregar el escaneo de distintos paquetes para que sean cargados en el contexto de Spring
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 */
@SpringBootApplication
@ComponentScan("mx.santander.fiduciario")
@ComponentScan("com.santander")
@EnableSwagger2
@EnableCaching
public class InstruccionRegistroApplication {

	/**
	 * Metodo main para inicializar la aplicacion Spring Boot
	 * @param args Argumentos opcionales de envio al programa
	 */
    public static void main(String[] args) {
		SpringApplication.run(InstruccionRegistroApplication.class, args);
	}//Fin del metodo 

	
	/**
	 * Metodo para permitir que el bean RestTemplate este disponible en el contexto de Spring
	 * @return RestTemplate El bean de RestTemplate disponible en contexto
	 */
	@Bean
	public RestTemplate restTemplate() {
		//Inicializa un RestTemplate por default
		return new RestTemplate();
	}//Fin del metodo 
}//Fin de la clase 