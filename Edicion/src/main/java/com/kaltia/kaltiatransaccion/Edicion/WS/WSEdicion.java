package com.kaltia.kaltiatransaccion.Edicion.WS;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kaltia.kaltiatransaccion.Edicion.VO.VOStatus;

@RestController
public class WSEdicion {
	
//	@Autowired
//	VOStatus voStatus;
	
	//@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz"})
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(
            method = RequestMethod.POST, path = "/{modelo}/{seccion}",  consumes = "application/json", produces = "application/json")
	public  VOStatus updateEdicion(@PathVariable String modelo, @PathVariable String seccion, @RequestBody Object objeto) {
		return new VOStatus(10, modelo+"-"+seccion);
//		voStatus.setCodigo();
//		voStatus.setMensaje();
		
		
		
		//return voStatus;
		
	}
/* Metodo por RequestMapping */	
	@CrossOrigin(origins = "http://localhost:7879")
//	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(
            method = RequestMethod.POST, path = "/fileUpload",  consumes = "multipart/form-data", produces = "application/json")
	/* Metodo por PostMapping */
//	 @PostMapping("/fileUpload")
	/* Metodo por POST */
	   public ResponseEntity<Object> fileUpload(@RequestParam("uploadfile") MultipartFile uploadfile){
//		public VOStatus fileUpload(@RequestBody MultipartFile uploadfile){
//		public VOStatus fileUpload(@RequestParam("uploadfile") MultipartFile uploadfile){
	   try {
		    // Get the filename and build the local file path (be sure that the 
		    // application have write permissions on such directory)
		    String filename = uploadfile.getOriginalFilename();
		    String directory = "C:\\Kaltia\\X _ Borrrador";
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
		    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		    return new VOStatus(99, "fallo");
		  }
//	      return new VOStatus(00, "ExitoFileUpload");
		  return new ResponseEntity<>(HttpStatus.OK);
		} // method uploadFile}
}