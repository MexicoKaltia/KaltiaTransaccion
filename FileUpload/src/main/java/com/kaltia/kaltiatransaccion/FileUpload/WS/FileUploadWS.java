package com.kaltia.kaltiatransaccion.FileUpload.WS;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kaltia.kaltiatransaccion.FileUpload.VO.ResultVO;

@RestController
public class FileUploadWS {
	

	protected final Log logger = LogFactory.getLog(getClass());

	
	@Autowired
	private ResultVO resultVO;
	
	/* Metodo por RequestMapping */	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiamx.xyz", "http://www.kaltiamx.xyz", "http://localhost:8080"})
	@RequestMapping(
            method = RequestMethod.POST, path = "/fileUpload/{idEmpresa}",  consumes = "multipart/form-data", produces = "application/json")
		public ResultVO fileUpload(@PathVariable String idEmpresa, @RequestParam("uploadfile") MultipartFile uploadfile){
	   try {
		    // Get the filename and build the local file path (be sure that the 
		    // application have write permissions on such directory)
		    String filename = uploadfile.getOriginalFilename();

		    String directory = "/kaltia/empresa/"+idEmpresa+"/images/";
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
