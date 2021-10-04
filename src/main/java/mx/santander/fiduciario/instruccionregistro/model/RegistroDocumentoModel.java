package mx.santander.fiduciario.instruccionregistro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase RegistroDocumentoModel
 * Para enviar los datos 
 * de registro de documento
 * Clase modelo 
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "registro_documento")
public class RegistroDocumentoModel {

	//La variable numeroUnicoDoc
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGISTRO_DOCUMENTO_SEQ")
    @SequenceGenerator(sequenceName = "SEQREGISTRO_DOCUMENTO", allocationSize = 1, name = "REGISTRO_DOCUMENTO_SEQ")
	@Column(name = "NUMERO_UNICO_DOCUMENTO")
	private Long numeroUnicoDoc;
	
	//La variable claveTipoDoc
	@Column(name = "CLAVE_TIPO_DOCUMENTO")
	private String claveTipoDoc;
	
	//La variable numeroDoc
	@Column(name = "NUMERO_DOCUMENTO")
	private String numeroDoc;
	
	//La variable conceptoDoc
	@Column(name = "CONCEPTO_DOCUMENTO")
	private String conceptoDoc;
	
	//La variable parteContrato
	@Column(name = "PARTE_CONTRATO")
	private String parteContrato;	//FIDEICOMITENTE|FIDEICOMISARIO

	//La variable clavePo
	@Column(name = "CLAVE_PO")
	private Long clavePo;
	
	//La variable testimonioCertifSimple
	@Column(name = "TESTIMONIO_CERTIFICADA_SIMPLE")
	private String testimonioCertifSimple;	//T|S
	
	//La variable fechaVencimientoDoc
	@Column(name = "FECHA_VENCIMIENTO_DOCUMENTO")
	private Date fechaVencimientoDoc;

	//La variable fechaRecepcion
	@Column(name = "FECHA_RECEPCION")
	private Date fechaRecepcion;
	
	//La variable fechaExpedicion
	@Column(name = "FECHA_EXPEDICION")
	private Date fechaExpedicion;
	
	//La variable fechaEntradaArchivo
	@Column(name = "FECHA_ENTRADA_ARCHIVO")
	private Date fechaEntradaArchivo;

	//La variable individualMasivo
	@Column(name = "INDIVIDUAL_MASIVO")
	private String individualMasivo;
	
	//La variable cifraControl
	@Column(name = "CIFRA_CONTROL")
	private Long cifraControl;
	
	//La variable estatusAplicacionDoc
	@Column(name = "ESTATUS_APLICACION_DOCUMENTO")
	private String estatusAplicacionDoc;
	
	//La variable estatusDoc
	@Column(name = "ESTATUS_DOCUMENTO")
	private String estatusDoc;
	
	//La variable claveInmueble
	@Column(name = "CLAVE_INMUEBLE")
	private String claveInmueble;
	
	//La variable copiaOriginal
	@Column(name = "COPIA_ORIGINAL")
	private String copiaOriginal;
	
	//La variable flgDetnt
	@Column(name = "FLG_DETNT")
	private String flgDetnt;
	
	//La variable idDocDetnt
	@Column(name = "ID_DOC_DETNT")
	private String idDocDetnt;
	
	//La variable valEstInteg
	@Column(name = "VAL_EST_INTEG")
	private String valEstInteg;
	
	//La variable flgReqTraza
	@Column(name = "FLG_REQ_TRAZA")
	private String flgReqTraza;
	
	//La variable flgReqOper
	@Column(name = "FLG_REQ_OPER")
	private String flgReqOper;
}//Fin de la clase 
