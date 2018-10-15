package com.kaltia.kaltiatransaccion.Edicion.WS;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kaltia.kaltiatransaccion.Edicion.Service.EdicionService;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;



@RestController
public class WSEdicion {
	
	@Autowired
	EdicionService edicionService;
	@Autowired
	ResultVO resultVO;

	protected final Log logger = LogFactory.getLog(getClass());
	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://localhost:8080"})
//	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(
            method = RequestMethod.POST, path = "/{idEmpresa}/{seccion}",  consumes = "application/json", produces = "application/json")
	public  ResultVO updateEdicion(@PathVariable String idEmpresa, @PathVariable String seccion, @RequestBody Object objeto) {
		
		if(idEmpresa.equals("create")) {
			logger.info("create");
//			resultVO = edicionService.edicionServiceCreate();
			
		}else if(idEmpresa.equals("read")) {
			logger.info("read");
		}else if(idEmpresa.equals("update")) {
			logger.info("update");
		}else if(idEmpresa.equals("delete")) {
			logger.info("delete");
		}else {
			logger.info("any");
			
		}
		
		
		return  resultVO;// new ResultVO(2, action+"-"+seccion);
//		voStatus.setCodigo();
//		voStatus.setMensaje();
		
		
		
		//return voStatus;
		
	}
/* Metodo por RequestMapping */	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://localhost:8080"})
	@RequestMapping(
            method = RequestMethod.POST, path = "/fileUpload",  consumes = "multipart/form-data", produces = "application/json")
	/* Metodo por PostMapping */
//	 @PostMapping("/fileUpload")
	/* Metodo por POST */
//	   public ResponseEntity<Object> fileUpload(@RequestParam("uploadfile") MultipartFile uploadfile){
//		public VOStatus fileUpload(@RequestBody MultipartFile uploadfile){
		public ResultVO fileUpload(@RequestParam("uploadfile") MultipartFile uploadfile){
	   try {
		    // Get the filename and build the local file path (be sure that the 
		    // application have write permissions on such directory)
		    String filename = uploadfile.getOriginalFilename();
//		    String directory = "C:/Kaltia/X _ Borrrador";
		    String directory = "/kaltia/directorio";
		    String filepath = Paths.get(directory, filename).toString();
		    
		    // Save the file locally
		    BufferedOutputStream stream =
		        new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		    stream.write(uploadfile.getBytes());
		    stream.close();
		    System.out.println("Exito");
		  }
		  catch (Exception e) {
		    System.out.println("exception : "+e.getMessage());
		    return resultVO;//new ResultVO(99, "fallo");
		  }
	      return resultVO;//new ResultVO(1, "ExitoFileUpload");
		} 
}