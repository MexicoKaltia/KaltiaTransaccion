package com.kaltia.kaltiatransaccion.mail.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kaltia.kaltiatransaccion.mail.vo.MailVO;
import com.kaltia.kaltiatransaccion.mail.vo.ResultVO;
import com.kaltia.kaltiatransaccion.mail.vo.ValoresJSONVO;

@Service 
public class MailServiceImpl implements MailService{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	 	
	@Autowired
	private ResultVO resultVO;
	@Autowired
	private ClienteRest clienteRest;
	@Autowired
	private MailVO mailVO;
	
	@Override
	public ResultVO mailServiceNotificarKUENuevo(ValoresJSONVO valoresJSONVO) {
		
//		String userEmpresa = valoresJSONVO.getIdEmpresa().toString();
//		String correoIdUserEmpresa = clienteRest.getUserEmpresa(userEmpresa);
//		String correoEmpresa = clienteRest.getEmpresa(valoresJSONVO.getAction());
//		
//		logger.info("userEmpresa:"+correoIdUserEmpresa); //OK
//		logger.info("empresa:"+correoEmpresa); //OK
		
		String[] valoresFinales = valoresJSONVO.getValoresFinales().split("\\++");
		String body = "Estimado "+valoresFinales[1]+ " "+ valoresFinales[2]+ " por razones de seguridad favor de dar click en el siguiente enlace"
					+ " para verificar autenticidad:\n"
					+ " http://31.220.63.183:8010/registroUser2?userSetup="+valoresFinales[0] ; 
		
		mailVO.setAsunto(valoresFinales [4]);
		mailVO.setBody(body);
		mailVO.setMensaje("/static/layout/notificarKUEActivo.html");
		mailVO.setUserDestino(valoresFinales[3]);
//		mailVO.setUserOrigen();
		
		resultVO = mandarCorreo(mailVO);
		
		
		return resultVO;
		}
	
	@Override
	public ResultVO mailServiceCreate(ValoresJSONVO valoresJSONVO) {return null;}

	@Override
	public ResultVO mailServiceRead(String action) {return null;}

	@Override
	public ResultVO mailServiceUpdate(ValoresJSONVO valoresJsonVO) {return null;}

	@Override
	public ResultVO mailServiceDelete() {return null;}
	
	@Override
	public ResultVO mailServiceNotificaCita1(ValoresJSONVO valoresJSONVO) {
		
		
		
		return resultVO;
	}
	



	 public ResultVO mandarCorreo(MailVO mailVO) {
		 
		 logger.info("Correo Destino: "+mailVO.getUserDestino());
	  // El correo gmail de envío
	  String correoEnvia = "kaltiaservicios@gmail.com";
	  String claveCorreo = "H00W6odR";
	 
	  // La configuración para enviar correo
	  Properties properties = new Properties();
	  properties.put("mail.smtp.host", "smtp.gmail.com");
	  properties.put("mail.smtp.starttls.enable", "true");
	  properties.put("mail.smtp.port", "587");
	  properties.put("mail.smtp.auth", "true");
	  properties.put("mail.user", correoEnvia);
	  properties.put("mail.password", claveCorreo);
	 
	  // Obtener la sesion
	  Session session = Session.getInstance(properties, null);
	  session.setDebug(true);
	 
	  try {
	   // Crear el cuerpo del mensaje
	   MimeMessage mimeMessage = new MimeMessage(session);
	 
	   // Agregar quien envía el correo
	   mimeMessage.setFrom(new InternetAddress(correoEnvia, "Kaltia Servicios"));
	 
	   // Los destinatarios
	   InternetAddress[] internetAddresses = { new InternetAddress(mailVO.getUserDestino()) };
	 
	   // Agregar los destinatarios al mensaje
	   mimeMessage.setRecipients(Message.RecipientType.TO,internetAddresses);
	 
	   // Agregar el asunto al correo
	   mimeMessage.setSubject(mailVO.getAsunto());
	 
	   // Crear el multipart para agregar la parte del mensaje anterior
	   Multipart multipart = new MimeMultipart();
	 
	   // Leer la plantilla
	   InputStream inputStream = getClass().getResourceAsStream(mailVO.getMensaje());
	   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	 
	   // Almacenar el contenido de la plantilla en un StringBuffer
	   String strLine;
	   StringBuffer msjHTML = new StringBuffer();
	   while ((strLine = bufferedReader.readLine()) != null) {
	    msjHTML.append(strLine);
	   }
	   msjHTML.append(mailVO.getBody());
	 
	   // Url del directorio donde estan las imagenes
	   String urlImagenes = "";//"C:\\Kaltia\\KaltiaWorkbench\\KaltiaMail\\src\\images\\";
	   File directorio = new File(urlImagenes);
	    
	   // Obtener los nombres de las imagenes en el directorio
	   String[] imagenesDirectorio = directorio.list();
	 
	   // Creo la parte del mensaje HTML
	   MimeBodyPart mimeBodyPart = new MimeBodyPart();
	   mimeBodyPart.setContent(msjHTML.toString(), "text/html");
	 
	   // Validar que el directorio si tenga las imagenes
	   if (imagenesDirectorio != null) {
	    for (int count = 0; count < imagenesDirectorio.length; count++) {
	 
	     MimeBodyPart imagePart = new MimeBodyPart();
	     imagePart.setHeader("Content-ID", "<"
	       + imagenesDirectorio[count].toString() + ">");
	     imagePart.setDisposition(MimeBodyPart.INLINE);
	     imagePart.attachFile(urlImagenes
	       + imagenesDirectorio[count].toString());
	     multipart.addBodyPart(imagePart);
	     System.out.println("nombre de las imagenes : "+imagenesDirectorio[count].toString());
	    }
	   } else {
	    System.out.println("No hay imagenes en el directorio");
	   }
	 
	   // Agregar la parte del mensaje HTML al multiPart
	   multipart.addBodyPart(mimeBodyPart);
	 
	   // Agregar el multipart al cuerpo del mensaje
	   mimeMessage.setContent(multipart);
	 
	   // Enviar el mensaje
	   Transport transport = session.getTransport("smtp");
	   transport.connect(correoEnvia, claveCorreo);
	   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
	   transport.close();
	 
	   resultVO.setCodigo(0);
	   resultVO.setMensaje("Correo Enviado");
	   logger.info("Correo enviado");
	  } catch (Exception ex) {
		  resultVO.setCodigo(99);
		   resultVO.setMensaje("Correo NO Enviado");
		  ex.printStackTrace();
		  logger.info("Correo NO enviado");
	  }
	  
	  return resultVO;
	  
	 }


			 
 
}