package com.kaltia.kaltiatransaccion.Edicion.WS;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaltia.kaltiatransaccion.Edicion.Service.CitaEmpresaService;
import com.kaltia.kaltiatransaccion.Edicion.Service.EdicionService;
import com.kaltia.kaltiatransaccion.Edicion.Service.EmpresaService;
import com.kaltia.kaltiatransaccion.Edicion.Service.UserEmpresaService;
import com.kaltia.kaltiatransaccion.Edicion.Util.EdicionUtil;
import com.kaltia.kaltiatransaccion.Edicion.VO.EmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultArrayVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.UserEmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;


@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz",  "*"})
@RestController
public class WSEdicion {

	@Autowired
	@Qualifier("edicionServiceImpl")
	EdicionService edicionService;
	@Autowired
//	@Qualifier("userEmpresaServiceImpl")
	UserEmpresaService userEmpresaService;
	@Autowired
	ResultVO resultVO;
	@Autowired
	ResultArrayVO resultArrayVO;
	@Autowired
	EmpresaService empresaService;
	@Autowired
	CitaEmpresaService citaEmpresaService;
	UserEmpresaEntity userEmpresaEntity;
	EmpresaEntity empresaEntity;

	protected final Log logger = LogFactory.getLog(getClass());
	private final String[] CORS = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080","*"};
//	@CrossOrigin(origins = CORS)
	@GetMapping("/version")
	public  String version() {
		return  "23012020";
	}


//	@CrossOrigin(origins = CORS)
	@PostMapping("/edicionSeccion")
	public  ResultVO updateSeccion(@RequestBody ValoresJsonVO valoresJsonVO) {

		/* ValoresJsonVO
		 *
		 * {action: "bronea",
		 * idEmpresa: "EUM",
		 * seccion: "headerSeccion1",
		 * valoresFinales: "ACERCA DE NOSOTROS.null++CONTACTO.null++REGISTRO.null++INGRESA.null"}
		 */
		EdicionUtil.printWSEdicion(valoresJsonVO, "/edicionSeccion");
			
			resultVO = edicionService.edicionServiceUpdate(valoresJsonVO);
			logger.info(resultVO.toString());
		return  resultVO;
	}

//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080","*"})
	@PostMapping("/createUserEmpresa")
	public  ResultVO createUserEmpresa(@RequestBody ValoresJsonVO valoresJsonVO) {

		/* ValoresJsonVO
		 *
		 * {action: "bronea",
		 * idEmpresa: "EUM",
		 * seccion: "headerSeccion1",
		 * valoresFinales: "nombreRegistro + apellidoRegistro + emailRegistro + telefonoRegistro + usuarioRegistro + passRegistro1 + messageRegistro"}
		 */
		EdicionUtil.printWSEdicion(valoresJsonVO, "/createUserEmpresa");
			resultVO = userEmpresaService.userEmpresaCreate(valoresJsonVO);
			logger.info(resultVO.toString());
		return  resultVO;
	}
	
//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080", "http://localhost:8081","*"})
	@GetMapping("/readUserEmpresa/{idAction}/{idUserEmpresa}")
	public  List<UserEmpresaEntity> readUserEmpresa(@PathVariable String idAction, @PathVariable String idUserEmpresa ) throws Exception {
		EdicionUtil.printWSEdicion(new ValoresJsonVO(idUserEmpresa), "/readUserEmpresa");
		logger.info(resultVO.toString());
		return  userEmpresaService.userEmpresaReadList(idAction, idUserEmpresa);
	}
	
//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080"})
	@PostMapping("/updateUserEmpresa")
	public  ResultVO updateUserEmpresa(@RequestBody ValoresJsonVO valoresJsonVO) throws Exception {
		EdicionUtil.printWSEdicion(valoresJsonVO, "/updateUserEmpresa");
		try {
			resultVO = userEmpresaService.userEmpresaUpdate(valoresJsonVO);
			logger.info(resultVO.toString());
		} catch (Exception e) {
			resultVO.setCodigo(99);
			resultVO.setMensaje("Error de ENLACE");
		}
		
	return  resultVO;
	}

	


//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080"})
	@GetMapping("/registroUser2")
	public  String registroUser2(@RequestParam("userSetup") String idUserEmpresa) {

		EdicionUtil.printWSEdicion(new ValoresJsonVO(idUserEmpresa), "/registroUser2");
			resultVO = userEmpresaService.userEmpresaUpdate(idUserEmpresa);
			logger.info(resultVO.toString());
		return  "Status Usuario: " + idUserEmpresa.substring(idUserEmpresa.indexOf("--")+2, idUserEmpresa.length()) +
				"-" + resultVO.getMensaje() + " \n \n Gracias por registrarte, en breve un asesor se pondrá en contacto";
	}

//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080", "http://localhost:8081", "http://localhost:8081"})
	@PostMapping("/deleteUserEmpresa")
	public  ResultVO deleteUserEmpresa(@RequestBody ValoresJsonVO valoresJsonVO) {
		EdicionUtil.printWSEdicion(valoresJsonVO, "/deleteUserEmpresa");

			resultVO = userEmpresaService.userEmpresaDelete(valoresJsonVO.getValoresFinales());
			logger.info(resultVO.toString());
		return  resultVO;
	}


//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080"})
	@PostMapping("/ingresaUser")
	public  ResultVO ingresaUser(@RequestBody ValoresJsonVO valoresJsonVO) {

		/* ValoresJsonVO
		 *
		 * {action: "bronea",
		 * idEmpresa: "EUM",
		 * seccion: "headerSeccion1",
		 * valoresFinales: "nombreRegistro + apellidoRegistro + emailRegistro + telefonoRegistro + usuarioRegistro + passRegistro1 + messageRegistro"}
		 */
		EdicionUtil.printWSEdicion(valoresJsonVO, "/ingresaUser");
			resultVO = userEmpresaService.userEmpresaRead(valoresJsonVO);
			logger.info(resultVO.toString());
		return  resultVO;
	}


//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080"})
	@GetMapping("/empresaRead")
	public  EmpresaEntity empresaRead(@RequestParam("idEmpresa") String idEmpresa) {

		EdicionUtil.printWSEdicion(new ValoresJsonVO(idEmpresa), "/empresaRead");
			empresaEntity = empresaService.empresaServiceRead(idEmpresa);

		return  empresaEntity;
	}

//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080"})
	@PostMapping("/cita1")
	public  ResultVO guardaCita1(@RequestBody ValoresJsonVO valoresJsonVO) throws Exception {
		EdicionUtil.printWSEdicion(valoresJsonVO, "/cita1");
			resultVO = citaEmpresaService.citaEmpresaServiceUpdate(valoresJsonVO);
			logger.info(resultVO.toString());
		return  resultVO;
	}

//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080"})
	@PostMapping("/empresaModulosCreate")
	public  ResultVO empresaCreate(@RequestBody ValoresJsonVO valoresJsonVO) throws Exception {
		EdicionUtil.printWSEdicion(valoresJsonVO, "/empresaModulosCreate");
		return  empresaService.empresaServiceCreateModulos(valoresJsonVO);
	}
	
	
//	@CrossOrigin(origins = {"http://kaltia.site", "http://www.kaltia.site", "http://kaltiacontrol.site", "http://www.kaltiacontrol.site", "http://localhost:8080"})
	@PostMapping("/readCita")
	public  ResultVO citaServiceRead(@RequestBody ValoresJsonVO valoresJsonVO) throws Exception {
		EdicionUtil.printWSEdicion(valoresJsonVO, "/readCita");
		return  citaEmpresaService.citaEmpresaServiceRead(valoresJsonVO.getAction());
	}


	
//	
//	@GetMapping(value ="/consultaVideos")
////	public  List<JSONObject> getVideos(@PathVariable String idEmpresa) {
//	public  List<EmpresaEntity> consultaVideos(@RequestParam("idEmpresa")  String idEmpresa, @RequestParam("order")  String order) {
//	
//		logger.info("----Inicio metodo getVideos----0");
//		empresaEntity = new EmpresaEntity();
//		empresaEntity.setIdEmpresa("hola");
//		List<EmpresaEntity> listEmpresas = new ArrayList<EmpresaEntity>();
////		ArrayList<JSONObject> arrayJson = new ArrayList();
////		JSONObject json = new JSONObject();
////		json.put("videoTitulo", "titulo1");
////		json.put("videoURL", "url1");
////		arrayJson.add(json);
////		
////		JSONObject json2 = new JSONObject();
////		json2.put("videoTitulo", "titulo2");
////		json2.put("videoURL", "url2");
////		arrayJson.add(json2);
////		
////		JSONObject json3 = new JSONObject();
////		json3.put("json3", arrayJson);
//		
//		return empresaEntity;
//	}




}
