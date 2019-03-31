package com.kaltia.kaltiatransaccion.Edicion.Service;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.UserEmpresaEntity;

	@Service
	public class ClienteRestImpl implements ClienteRest {

		
//		static final String URL_GET_USER_EMPRESA = "http://31.220.60.92:8010/userEmpresaRead";
//		static final String URL_GET_EMPRESA = 		"http://31.220.60.92:8010/empresaRead";
		
		////////////   URL LOCAL /////////////////
		static final String URL_GET_USER_EMPRESA = "http://localhost:8010/userEmpresaRead";
		static final String URL_GET_EMPRESA = 	   "http://localhost:8010/empresaRead";
		static final String NOTIFICARKUENUEVO =    "http://localhost:8012/mail/notificarKUENuevo";
		
		static final String POST = "HttpMethod.POST";
		static final String GET = "HttpMethod.GET";
		static final String PUT = "HttpMethod.PUT";
		
		@Autowired
		private ResultVO resultVO;

		
		
		@SuppressWarnings("unchecked")
		@Override
		public ResultVO notificarKUENuevo(UserEmpresaEntity userEmpresaEntity) {
			
			String tituloMail = "Verificar usuario "+ userEmpresaEntity.getNombreRegistro()+ " "+ userEmpresaEntity.getApellidoRegistro() ;
			
			 JSONObject jsonRequest = new JSONObject();
//				 jsonRequest.put("idUser", userEmpresaEntity.getIdUserEmpresa());
//				 jsonRequest.put("action", userEmpresaEntity.getActionRegistro());
//				 jsonRequest.put("nombre", userEmpresaEntity.getNombreRegistro());
//				 jsonRequest.put("apellido", userEmpresaEntity.getApellidoRegistro());
//				 jsonRequest.put("email", userEmpresaEntity.getEmailRegistro());
				 
				 jsonRequest.put("action", userEmpresaEntity.getActionRegistro());
				 jsonRequest.put("valoresFinales", userEmpresaEntity.getIdUserEmpresa()+"++"
												 + userEmpresaEntity.getNombreRegistro()+"++"
												 + userEmpresaEntity.getApellidoRegistro()+"++"
												 + userEmpresaEntity.getEmailRegistro()+"++"
												 + tituloMail);
				 
				    Map req_content = new HashMap();
			        req_content.put("req_content", jsonRequest);
	 
			resultVO = getTemplate(NOTIFICARKUENUEVO,POST, jsonRequest);
			return resultVO;
		}
		
		
		
		private ResultVO getTemplate(String url, String metodo, JSONObject req_content) {
			   // HttpHeaders
		    HttpHeaders headers = new HttpHeaders();
			    headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
			    // Request to return JSON format
			    headers.setContentType(MediaType.APPLICATION_JSON);
			    
		    // HttpEntity<String>: To get result as String.
		    HttpEntity<?> entity = new HttpEntity<>(req_content);

		    // RestTemplate
		    RestTemplate restTemplate = new RestTemplate();

		    // Send request with POST method, and Headers.
		    ResponseEntity<ResultVO> response = restTemplate.postForEntity(url, entity, ResultVO.class);
		    
		    return  (ResultVO)response.getBody();

		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		public String getUserEmpresa(String userEmpresa) {
//		    String result = getTemplate(URL_GET_USER_EMPRESA+"?idUserEmpresa="+userEmpresa);
//		    return result;
//		}
//		
//		public String getEmpresa(String action) {	
//			String result = getTemplate(URL_GET_EMPRESA+"?idEmpresa="+action);
//		    return result;		
//		}
		
	}
