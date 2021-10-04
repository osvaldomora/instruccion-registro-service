package mx.santander.fiduciario.instruccionregistro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.santander.fiduciario.instruccionregistro.model.InstruccionEnviadaModel;

/**
 * Interface IInstructionSendRepository
 * Se encarga de gestionar todas las operaciones de persistencia contra una tabla en base de datos
 * @author 
 */
@Repository
public interface IInstructionSendRepository extends JpaRepository<InstruccionEnviadaModel, Long>{

}//Fin de la interface 
