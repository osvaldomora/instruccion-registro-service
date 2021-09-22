package mx.santander.fiduciario.instruccionregistro.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import mx.santander.fiduciario.instruccionregistro.model.InstruccionRegistro;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * Interface que extiende las operaciones CRUD del patron repository utilizado por Spring Data
 */
public interface IInstruccionRegistroRepository extends CrudRepository<InstruccionRegistro, Long> {
    
	@Cacheable("instruccionregistro")
	Optional<InstruccionRegistro> findById(Long id);
	
    @Cacheable("instruccionregistro")
    @CacheEvict(value = "instruccionregistro", allEntries = true)
    Iterable<InstruccionRegistro> findAll();

    @CachePut("instruccionregistro")
    <S extends InstruccionRegistro> S  save(S entity);

    @CacheEvict("instruccionregistro")
    void deleteById(Long id);

}
