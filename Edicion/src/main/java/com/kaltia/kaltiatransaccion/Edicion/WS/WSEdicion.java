package com.kaltia.kaltiatransaccion.Edicion.WS;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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


@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080", "http://localhost:8081"})
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

	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080"})
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

		return  resultVO;
	}

	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080"})
	@PostMapping("/createUserEmpresa")
	public  ResultVO createUserEmpresa(@RequestBody ValoresJsonVO valoresJsonVO) {

		/* ValoresJsonVO
		 *
		 * {action: "bronea",
		 * idEmpresa: "EUM",
		 * seccion: "headerSeccion1",
		 * valoresFinales: "nombreRegistro + apellidoRegistro + emailRegistro + telefonoRegistro + usuarioRegistro + passRegistro1 + messageRegistro"}
		 */
		EdicionUtil.printWSEdicion(valoresJsonVO, "/registroUser");
			resultVO = userEmpresaService.userEmpresaCreate(valoresJsonVO);

		return  resultVO;
	}
	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080", "http://localhost:8081"})
	@GetMapping("/readUserEmpresa/{idAction}/{idUserEmpresa}")
	public  List<UserEmpresaEntity> readUserEmpresa(@PathVariable String idAction, @PathVariable String idUserEmpresa ) throws Exception {
		EdicionUtil.printWSEdicion(new ValoresJsonVO(idUserEmpresa), "/readUserEmpresa");

		return  userEmpresaService.userEmpresaReadList(idAction, idUserEmpresa);
	}
	


	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080"})
	@GetMapping("/registroUser2")
	public  String registroUser2(@RequestParam("userSetup") String idUserEmpresa) {

		EdicionUtil.printWSEdicion(new ValoresJsonVO(idUserEmpresa), "/edicionSeccion");
			resultVO = userEmpresaService.userEmpresaUpdate(idUserEmpresa);

		return  "Status Usuario: " + idUserEmpresa + "-" + resultVO.getMensaje() + " \n \n Gracias por registrarte, en breve un asesor se pondrá en contacto";
	}

	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080"})
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

		return  resultVO;
	}


	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080"})
	@GetMapping("/empresaRead")
	public  EmpresaEntity empresaRead(@RequestParam("idEmpresa") String idEmpresa) {

		EdicionUtil.printWSEdicion(new ValoresJsonVO(idEmpresa), "/empresaRead");
			empresaEntity = empresaService.empresaServiceRead(idEmpresa);

		return  empresaEntity;
	}

	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080"})
	@PostMapping("/cita1")
	public  ResultVO guardaCita1(@RequestBody ValoresJsonVO valoresJsonVO) throws Exception {
		EdicionUtil.printWSEdicion(valoresJsonVO, "/cita1");
			resultVO = citaEmpresaService.citaEmpresaServiceUpdate(valoresJsonVO);

		return  resultVO;
	}

	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080"})
	@PostMapping("/empresaModulosCreate")
	public  ResultVO empresaCreate(@RequestBody ValoresJsonVO valoresJsonVO) throws Exception {
		EdicionUtil.printWSEdicion(valoresJsonVO, "/empresaModulosCreate");
		return  empresaService.empresaServiceCreateModulos(valoresJsonVO);
	}
	
	
	@CrossOrigin(origins = {"http://kaltia.xyz", "http://www.kaltia.xyz", "http://kaltiacontrol.xyz", "http://www.kaltiacontrol.xyz", "http://localhost:8080"})
	@PostMapping("/readCita")
	public  ResultVO citaServiceRead(@RequestBody ValoresJsonVO valoresJsonVO) throws Exception {
		EdicionUtil.printWSEdicion(valoresJsonVO, "/readCita");
		return  citaEmpresaService.citaEmpresaServiceRead(valoresJsonVO.getAction());
	}


	




}
