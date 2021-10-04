package mx.santander.fiduciario.instruccionregistro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.santander.fiduciario.instruccionregistro.model.RegistroDocumentoModel;

/**
 * Interface IDocumentRegistrationRepository
 * Se encarga de gestionar todas las operaciones de persistencia contra una tabla en base de datos
 * @author glenn
 *
 */
@Repository
public interface IDocumentRegistrationRepository extends JpaRepository<RegistroDocumentoModel, Long>{

}//Fin de la interface 
