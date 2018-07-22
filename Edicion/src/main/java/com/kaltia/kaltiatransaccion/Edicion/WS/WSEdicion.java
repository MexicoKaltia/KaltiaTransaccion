package com.kaltia.kaltiatransaccion.Edicion.WS;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
