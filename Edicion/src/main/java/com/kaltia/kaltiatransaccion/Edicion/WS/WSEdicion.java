package com.kaltia.kaltiatransaccion.Edicion.WS;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaltia.kaltiatransaccion.Edicion.VO.VOStatus;

@RestController
public class WSEdicion {
	
//	@Autowired
//	VOStatus voStatus;
	
	@RequestMapping(
            method = RequestMethod.POST, path = "/{modelo}/{seccion}",  consumes = "application/json", produces = "application/json")
	public  VOStatus updateEdicion(@PathVariable String modelo, @PathVariable String seccion, @RequestBody Object objeto) {
		return new VOStatus(10, modelo+"-"+seccion);
//		voStatus.setCodigo();
//		voStatus.setMensaje();
		
		
		
		//return voStatus;
		
	}

}
