package com.kaltia.kaltiatransaccion.Edicion.WS;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaltia.kaltiatransaccion.Edicion.DAO.IProductosDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultDAOVO;

@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz",  "*"})
@RestController
public class WSUtil {
	
	
public WSUtil() {
	}

protected final Log logger = LogFactory.getLog(getClass());
    
//    @Autowired
//    IProductosService productosService ;
    @Autowired
    IProductosDAO productosDAO;
    @Autowired
    ResultDAOVO resultDAOVO;
    
    
    
	@GetMapping("/version.htm")
	public  String version() {
		return  (new Date()).toString();
	}

	@CrossOrigin(origins = {"http://localhost:8081", "*"})
	@GetMapping(value ="/consultaVideos")
//	public  List<JSONObject> getVideos(@PathVariable String idEmpresa) {
	public  List<JSONObject> consultaVideos(@RequestParam("idEmpresa")  String idEmpresa, @RequestParam("order")  String order) {
	
		logger.info("----Inicio metodo getVideos----");
		resultDAOVO = productosDAO.getVideosService(idEmpresa); 
		if(resultDAOVO.getCode().equals("00")) {
			List<JSONObject> arrayJson = resultDAOVO.getArrayJson();
			logger.info(arrayJson);
			return  arrayJson ;
		}else {
			return  null;
		}
//		return  resultDAOVO;
	}

	
	
}// fin de clase
