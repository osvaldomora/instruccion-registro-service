package mx.santander.fiduciario.instruccionregistro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import mx.santander.fiduciario.instruccionregistro.exception.CustomCacheErrorHandler;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * Clase de configuracion de Redis
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport implements CachingConfigurer {

	//La variable redisHost
    @Value("${spring.redis.host}")
    private String redisHost;

    //La variable redisPort
    @Value("${spring.redis.port}")
    private Integer redisPort;

    //La variable redisPassword
    @Value("${spring.redis.password}")
    private String redisPassword;
    
    /**
     * Metodo que inicializa la fabrica de conexion basado en la configuracion de conexion establecida
     * @return JedisConnectionFactory Fabrica de conexion de Jedis
     */
    @Bean("jedisConnectionFactory")
    @Primary
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration =
                new RedisStandaloneConfiguration(redisHost, redisPort);
        configuration.setPassword(redisPassword);
        return new JedisConnectionFactory(configuration);
    }//Fin del metodo

    /**
     * Metodo de inicializacion de manager de cache
     * @param factory Fabrica de conexion de Redis
     * @return CacheManager Manager de cache RedisCacheManager
     */
    @Bean("redisCacheManager")
    @Primary
    public CacheManager redisCacheManager(RedisConnectionFactory factory) {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
                .RedisCacheManagerBuilder.fromConnectionFactory(factory);
        return builder.build();
    }//Fin del metodo
    
    /**
     * Metodo errorHandler
     * @return CacheErrorHandler retorna un errorHandler personalizado
     */
    @Override
    public CacheErrorHandler errorHandler() {
        return new CustomCacheErrorHandler();
    }//Fin del metodo 
}//Fin de la clase 