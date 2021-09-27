package mx.santander.fiduciario.instruccionregistro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.santander.fiduciario.instruccionregistro.model.InstruccionEnviadaModel;

@Repository
public interface IInstructionSendRepository extends JpaRepository<InstruccionEnviadaModel, Long>{

}
