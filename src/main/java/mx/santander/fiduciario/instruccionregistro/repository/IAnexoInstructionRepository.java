package mx.santander.fiduciario.instruccionregistro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.santander.fiduciario.instruccionregistro.model.InstruccionAnexoModel;

/**
 * Interface IAnexoInstructionRepository
 * Se encarga de gestionar todas las operaciones de persistencia contra una tabla en base de datos
 * @author
 */
@Repository
public interface IAnexoInstructionRepository extends JpaRepository<InstruccionAnexoModel, Long>{

}//Fin de la interface 
