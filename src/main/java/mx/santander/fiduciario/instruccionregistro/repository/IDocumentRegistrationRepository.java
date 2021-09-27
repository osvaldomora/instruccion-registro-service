package mx.santander.fiduciario.instruccionregistro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.santander.fiduciario.instruccionregistro.model.RegistroDocumentoModel;

@Repository
public interface IDocumentRegistrationRepository extends JpaRepository<RegistroDocumentoModel, Long>{

}
