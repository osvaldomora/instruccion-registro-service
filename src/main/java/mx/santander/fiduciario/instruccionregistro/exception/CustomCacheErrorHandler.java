package mx.santander.fiduciario.instruccionregistro.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * Clase para la implementacion de manejo de errores de cache
 * (Arquetipo creado por Santander Tecnologia Mexico)
 * @author David Gonzalez 
 */
public class CustomCacheErrorHandler implements CacheErrorHandler{
	//La Constante LOGGER. Obtiene el Logger de la clase 
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomCacheErrorHandler.class);
    
    /**
     * Para canchar los errores
     * @param exception excepcion 
     * @param cache memoria
     * @param key clave
     */
    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        handleTimeOutException(exception);
        LOGGER.error("Unable to get from cache " + cache.getName() + " : " + exception.getMessage());
    }//Fin del metodo 

    /**
     * Para canchar los errores
     * @param exception excepcion 
     * @param cache memoria
     * @param key clave
     * @param value valor
     */
    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
        handleTimeOutException(exception);
        LOGGER.error("Unable to put into cache " + cache.getName() + " : " + exception.getMessage());
    }//Fin del metod 
    
    /**
     * Para canchar los errores
     * @param exception excepcion 
     * @param cache memoria
     * @param key clave
     */
    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
        handleTimeOutException(exception);
        LOGGER.error("Unable to evict from cache " + cache.getName() + " : " + exception.getMessage());
    }//Fin del metodo 

    /**
     * Para canchar los errores
     * @param exception excepcion 
     * @param cache memoria
     */
    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {
        handleTimeOutException(exception);
        LOGGER.error("Unable to clean cache " + cache.getName() + " : " + exception.getMessage());
    }//Fin del metodo 

    /**
     * We handle redis connection timeout exception , if the exception is handled then it is treated as a cache miss and
     * gets the data from actual storage
     * @param exception Excepcion ocurrida en runtime
     */
    private void handleTimeOutException(RuntimeException exception) {
//        if (exception instanceof RedisCommandTimeoutException) {
//            return;
//        }
    }//Fin del metodo 
}//Fin de la clase 