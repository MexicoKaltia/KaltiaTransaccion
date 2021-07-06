package com.kaltia.kaltiatransaccion.FileUpload.WS;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kaltia.kaltiatransaccion.FileUpload.VO.ResultVO;

@RestController
@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz",  "*"})
public class FileUploadWS {
	

	protected final Log logger = LogFactory.getLog(getClass());

	
	@Autowired
	private ResultVO resultVO;
	
	@GetMapping("/version")
	public  LocalDateTime  version() {
		return  LocalDateTime.now();
	}

	/* Metodo por RequestMapping */	
	
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
		    
		    
		    resultVO.setCodigo("00");
		    resultVO.setMensaje("ExitoFileUpload");
		    if(resultVO.getCodigo().equals("00")) {
				try {
					
					Runtime rt = Runtime.getRuntime();
				    String commands = ("/kaltia/shell/EmpresaActualiza.sh "+ idEmpresa +" "+ filename);
				    Process proc = rt.exec(commands);
				    BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				    BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
				    logger.info("Salida EmpresaActualiza:\n");
				    String s = null;
				    resultVO.setCodigo("00");
				    resultVO.setMensaje("Exito Carga Imagen Repositorio");
				    while ((s = stdInput.readLine()) != null) {
				    	logger.info(s);
				    }

				    while ((s = stdError.readLine()) != null) {
				    	logger.info(s);
				                }
				    } catch (IOException ioe) {
				    	logger.info("ERROR Ejecutando script EmpresaActualiza.sh");
				    	logger.info(ioe);
				    	resultVO.setCodigo("99");
					    resultVO.setMensaje("FALLO Carga Imagen Repositorio. :"+ioe);

				    }
			}
		    logger.info(resultVO.getMensaje());
		  }
		  catch (Exception e) {
		    logger.info("exception : "+e.getMessage());
		    resultVO.setCodigo("99");
		    resultVO.setMensaje(e.getMessage());
		    return resultVO;//new ResultVO(99, "fallo");
		  }
	      return resultVO;//new ResultVO(1, "ExitoFileUpload");
		}
}
