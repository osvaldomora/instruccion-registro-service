package mx.santander.fiduciario.instruccionregistro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase InstruccionEnviadaModel
 * Para enviar los datos 
 * de las instrucciones
 * Clase modelo 
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "FID_MX_REL_INSTR_NVAS")
public class InstruccionEnviadaModel {

	//La variable idIntrsNvas
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTR_NVAS_SEQ")
    @SequenceGenerator(sequenceName = "SEQFID_MX_REL_INSTR_NVAS", allocationSize = 1, name = "INSTR_NVAS_SEQ")
	@Column(name = "ID_INSTR_NVAS")
	@NotNull
	private Long idIntrsNvas;
	
	//La variable idList
	@Column(name = "FK_ID_LIST")
	private Long idList;
	
	//La variable buc
	@Column(name = "FK_ID_BUC")
	private String buc;
	
	//La variable idNoContr
	@Column(name = "ID_NO_CONTR")
	private Long idNoContr;
	
	//La variable idNoSubContr
	@Column(name = "ID_NO_SUBCONTR")
	private Long idNoSubContr;
	
	//La variable IdFolio
	@Column(name = "ID_FOLIO")
	private Long IdFolio;
	
	//La variable idEstat
	@Column(name = "FK_ID_ESTAT")
	private Long idEstat;
	
	//La variable fchRegisInsct
	@Column(name = "FCH_REGIS_INSCT")
	private Date fchRegisInsct;
}//Fin de la clase 
