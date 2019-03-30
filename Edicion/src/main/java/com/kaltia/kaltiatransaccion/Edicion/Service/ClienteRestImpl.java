package com.kaltia.kaltiatransaccion.Edicion.Service;


	import java.util.Arrays;

	import org.springframework.http.HttpEntity;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpMethod;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Service;
	import org.springframework.web.client.RestTemplate;

	@Service
	public class ClienteRestImpl implements ClienteRest {

		
//		static final String URL_GET_USER_EMPRESA = "http://31.220.60.92:8010/userEmpresaRead";
//		static final String URL_GET_EMPRESA = 		"http://31.220.60.92:8010/empresaRead";
		
		////////////   URL LOCAL /////////////////
		static final String URL_GET_USER_EMPRESA = "http://localhost:8010/userEmpresaRead";
		static final String URL_GET_EMPRESA = 		"http://localhost:8010/empresaRead";
		
		public String getUserEmpresa(String userEmpresa) {
			
		    String result = getTemplate(URL_GET_USER_EMPRESA+"?idUserEmpresa="+userEmpresa);
		    return result;
			
		}
		
		public String getEmpresa(String action) {
			
			String result = getTemplate(URL_GET_EMPRESA+"?idEmpresa="+action);
		    return result;		
		}
		
		private String getTemplate(String url) {
			   // HttpHeaders
		    HttpHeaders headers = new HttpHeaders();

		    headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		    // Request to return JSON format
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.set("my_other_key", "my_other_value");

		    // HttpEntity<String>: To get result as String.
		    HttpEntity<String> entity = new HttpEntity<String>(headers);

		    // RestTemplate
		    RestTemplate restTemplate = new RestTemplate();

		    // Send request with GET method, and Headers.
		    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		    
		    return  response.getBody();

		}
		
		
		
		
		
	}
