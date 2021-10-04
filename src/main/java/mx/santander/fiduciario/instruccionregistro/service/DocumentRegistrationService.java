package mx.santander.fiduciario.instruccionregistro.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrFileDto;
import mx.santander.fiduciario.instruccionregistro.dto.instruction.send.req.SendInstrReqDto;
import mx.santander.fiduciario.instruccionregistro.enumerations.FileInstruction;
import mx.santander.fiduciario.instruccionregistro.model.RegistroDocumentoModel;
import mx.santander.fiduciario.instruccionregistro.repository.IDocumentRegistrationRepository;

/**
 * Clase DocumentRegistrationService
 * Este microservicio,encargada de 
 * orquestador la logica de negocio 
 * relacionada con instruccion con anexos 
 * y sus datos (persistencia).
 * @author 
 */
@Service
public class DocumentRegistrationService implements IDocumentRegistrationService{

	// La Constante LOGGER. Obtiene el Logger de la clase
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentRegistrationService.class);
	
	//Variable de repositorio de Registro de documento
	@Autowired
	private IDocumentRegistrationRepository documentRegistrationRepository;
	
	//Constante quien envia el contrato (parteContrato)
	private static final String PARTE_CONTRATO = "FIDEICOMITENTE";
	
	//Constante archivo individual
	private static final String INDIVIDUAL_MASIVO = "I";
	
	//Contante al enviar archivo, pendiente
	private static final String STATUS_APLI_DOC = "PE";
	
	//Constante del estatus del documento: archivado
	private static final String STATUS_DOC = "AR";
	
	//Constante del documento copia u origial: proviene de Web
	private static final String COPIA_ORIGINAL = "W";
	
	/**
	 * Metodo save
	 * @param documentoModel documento Modelo
	 * @return RegistroDocumentoModel guardar archivo
	 */
	@Override
	public RegistroDocumentoModel save(RegistroDocumentoModel documentoModel) {
		//Se registra en BD
		documentoModel = this.documentRegistrationRepository.save(documentoModel);
		LOGGER.info("Servicio: DocumentRegistrationService, Operacion: save, se guarda registroDocumento con exito: {}",documentoModel.toString());
		return documentoModel;
	}//Fin del metodo 

	/**
	 * Metodo saveRegistrationDoc
	 * @param instrReqDto peticion de instrucciones
	 * @param fileDto archivo 
	 * @return RegistroDocumentoModel registro de documento
	 */
	@Override
	public RegistroDocumentoModel saveRegistrationDoc(SendInstrReqDto instrReqDto, SendInstrFileDto fileDto) {
		//Se obtiene valor de variables
		String claveTipoDoc = String.valueOf(instrReqDto.getTypeInstruction().getCodeDoc());
		String conceptDoc = instrReqDto.getTypeInstruction().getName() + "-" + instrReqDto.getBusiness().getId() + "-" + instrReqDto.getBusiness().getSubBusiness().getId();
		Long clavePo = 999L; 	/*instrReqDto.getBuc().getClavePo(); aun no se envia*/
		String docDetonante = "N";	//Default
		if(FileInstruction.INSTRUCCION.getName().equalsIgnoreCase(fileDto.getType())) {
			docDetonante = "S";
		}
		//Se crea modelo
		RegistroDocumentoModel documentoModel = RegistroDocumentoModel.builder()
													.claveTipoDoc(claveTipoDoc)
													.numeroDoc(null)
													.conceptoDoc(conceptDoc)
													.parteContrato(PARTE_CONTRATO)
													.clavePo(clavePo)
													.testimonioCertifSimple(null)
													.fechaVencimientoDoc(null)
													.fechaRecepcion(new Date())
													.fechaExpedicion(new Date())
													.fechaEntradaArchivo(null)
													.individualMasivo(INDIVIDUAL_MASIVO)
													.cifraControl(null)
													.estatusAplicacionDoc(STATUS_APLI_DOC)
													.estatusDoc(STATUS_DOC)
													.claveInmueble(null)
													.copiaOriginal(COPIA_ORIGINAL)
													.flgDetnt(docDetonante)
													.idDocDetnt(null)
													.valEstInteg(null)
													.flgReqTraza(null)
													.flgReqOper(null)
													.build();
		LOGGER.info("Servicio: DocumentRegistrationService, Operacion: saveRegistrationDoc, se crea RegistraDocumentoModelo: {}",documentoModel.toString());
		//Se procede a registrar
		documentoModel = this.save(documentoModel);
		return documentoModel;
	}//Fin del metodo 
}//Fin de la clase 
