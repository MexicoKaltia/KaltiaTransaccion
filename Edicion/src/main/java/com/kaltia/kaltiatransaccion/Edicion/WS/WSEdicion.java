package com.kaltia.kaltiatransaccion.Edicion.WS;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kaltia.kaltiatransaccion.Edicion.Service.EdicionService;
import com.kaltia.kaltiatransaccion.Edicion.Service.UserEmpresaServiceImpl;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultArrayVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;



@RestController
public class WSEdicion {
	
	@Autowired
	@Qualifier("edicionServiceImpl")
	EdicionService edicionService;
	@Autowired
	@Qualifier("userEmpresaServiceImpl")
	UserEmpresaServiceImpl userEmpresaServiceImpl;
	@Autowired
	ResultVO resultVO;
	@Autowired
	ResultArrayVO resultArrayVO;

	protected final Log logger = LogFactory.getLog(getClass());
	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiamx.xyz", "http://www.kaltiamx.xyz", "http://localhost:8080"})
	@PostMapping("/edicionSeccion")
	public  ResultVO updateSeccion(@RequestBody ValoresJsonVO valoresJsonVO) {
		
		/* ValoresJsonVO
		 * 
		 * {action: "bronea", 
		 * idEmpresa: "EUM", 
		 * seccion: "headerSeccion1", 
		 * valoresFinales: "ACERCA DE NOSOTROS.null++CONTACTO.null++REGISTRO.null++INGRESA.null"}
		 */
			logger.info("EdicionSeccion");
			resultVO = edicionService.edicionServiceUpdate(valoresJsonVO);
		
		return  resultVO;
	}
	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiamx.xyz", "http://www.kaltiamx.xyz", "http://localhost:8080"})
	@PostMapping("/registroUser")
	public  ResultVO registroUser(@RequestBody ValoresJsonVO valoresJsonVO) {
		
		/* ValoresJsonVO
		 * 
		 * {action: "bronea", 
		 * idEmpresa: "EUM", 
		 * seccion: "headerSeccion1", 
		 * valoresFinales: "nombreRegistro + apellidoRegistro + emailRegistro + telefonoRegistro + usuarioRegistro + passRegistro1 + messageRegistro"}
		 */
			logger.info("EdicionSeccion");
			resultVO = userEmpresaServiceImpl.userEmpresaCreate(valoresJsonVO);
		
		return  resultVO;
	}
	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiamx.xyz", "http://www.kaltiamx.xyz", "http://localhost:8080"})
	@PostMapping("/ingresaUser")
	public  ResultArrayVO ingresaUser(@RequestBody ValoresJsonVO valoresJsonVO) {
		
		/* ValoresJsonVO
		 * 
		 * {action: "bronea", 
		 * idEmpresa: "EUM", 
		 * seccion: "headerSeccion1", 
		 * valoresFinales: "nombreRegistro + apellidoRegistro + emailRegistro + telefonoRegistro + usuarioRegistro + passRegistro1 + messageRegistro"}
		 */
			logger.info("EdicionSeccion");
			resultArrayVO = userEmpresaServiceImpl.userEmpresaRead(valoresJsonVO);
		
		return  resultArrayVO;
	}
	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://localhost:8080"})
	@RequestMapping(
            method = RequestMethod.POST, path = "/{idEmpresa}/{seccion}",  consumes = "application/json", produces = "application/json")
	public  ResultVO updateEdicion(@PathVariable String idEmpresa, @PathVariable String seccion, @RequestBody ValoresJsonVO valoresJsonVO) {
		
		if(idEmpresa.equals("create")) {
			logger.info("create");
			resultVO = edicionService.edicionServiceCreate();
			
		}else if(idEmpresa.equals("read")) {
			logger.info("read");
		}else if(idEmpresa.equals("update")) {
			logger.info("update");
		}else if(idEmpresa.equals("delete")) {
			logger.info("delete");
		}else {
			logger.info("any");
			resultVO = edicionService.edicionServiceUpdate(valoresJsonVO);
		}
		
		
		return  resultVO;// new ResultVO(2, action+"-"+seccion);
	}
	
	
/* Metodo por RequestMapping */	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://localhost:8080"})
	@RequestMapping(
            method = RequestMethod.POST, path = "/fileUpload/{idEmpresa}",  consumes = "multipart/form-data", produces = "application/json")
	/* Metodo por PostMapping */
//	 @PostMapping("/fileUpload")
	/* Metodo por POST */
//	   public ResponseEntity<Object> fileUpload(@RequestParam("uploadfile") MultipartFile uploadfile){
//		public VOStatus fileUpload(@RequestBody MultipartFile uploadfile){
		public ResultVO fileUpload(@PathVariable String idEmpresa, @RequestParam("uploadfile") MultipartFile uploadfile){
	   try {
		    // Get the filename and build the local file path (be sure that the 
		    // application have write permissions on such directory)
		    String filename = uploadfile.getOriginalFilename();
//		    String directory = "C:/Kaltia/X _ Borrrador";
		    String directory = "/kaltia/empresa/"+idEmpresa;
//		    String directory = "kaltia-mx.xyz/kaltia/modelo/bronea/images/";
		    String filepath = Paths.get(directory, filename).toString();
		    
		    // Save the file locally
		    BufferedOutputStream stream =
		        new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		    stream.write(uploadfile.getBytes());
		    stream.close();
		    resultVO.setCodigo(0);
		    resultVO.setMensaje("ExitoFileUpload");
		    logger.info(resultVO.getMensaje());
		  }
		  catch (Exception e) {
		    logger.info("exception : "+e.getMessage());
		    resultVO.setCodigo(99);
		    resultVO.setMensaje(e.getMessage());
		    return resultVO;//new ResultVO(99, "fallo");
		  }
	      return resultVO;//new ResultVO(1, "ExitoFileUpload");
		} 
}