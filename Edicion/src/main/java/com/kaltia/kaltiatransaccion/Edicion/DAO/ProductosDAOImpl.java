package com.kaltia.kaltiatransaccion.Edicion.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kaltia.kaltiatransaccion.Edicion.VO.ChatEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultDAOVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.TarjetaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.VideoEntity;


@Repository
public class ProductosDAOImpl implements IProductosDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
//	private EmpresaEntity empresaEntity;
	@Autowired
	private ResultDAOVO resultDAOVO;
	
    /*
     * Sets the entity manager.
     */
	private EntityManager em = null;
	
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	// end Entity Manager
    
	
	@Override
	@Transactional
	public ResultDAOVO addVideoDAO(VideoEntity videoEntity) {
		logger.info("-----------"+videoEntity.getVideoTitulo());
	     
		try {
		  em.merge(videoEntity);
	      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Video guardado con exito ");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
			e.printStackTrace();
		}finally {
			em.close( );
		}
		return resultDAOVO;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public ResultDAOVO getVideosService(String idEmpresa) {
		
		Query query=null;
		query = em.createNamedQuery("find videos by idEmpresa");
		query.setParameter("id", idEmpresa);
      ArrayList<VideoEntity> videosEntityArray = new ArrayList<VideoEntity>();
      try {
    	  videosEntityArray = (ArrayList<VideoEntity>) query.getResultList();
    	  resultDAOVO.setArrayJson(listToJSONVideos(videosEntityArray));
    	  resultDAOVO.setMessage("Exito en consulta de Videos");
    	  resultDAOVO.setCode("00");
      }catch(Exception e){
    	  resultDAOVO.setMessage("Error en consulta de Videos");
    	  resultDAOVO.setCode("99");
    	  e.printStackTrace();
      }
      return resultDAOVO;
	}
	
	
	/*
	 * Modulo Chat
	 */
	@Override
	@Transactional
	public ResultDAOVO addChatDAO(ChatEntity chatEntity) {
		logger.info("-----------"+chatEntity.getNumeroChat());
	     
		try {
		  em.merge(chatEntity);
	      
	      resultDAOVO.setCode("00");
	      resultDAOVO.setMessage("Chat guardado con exito ");
	      
		}catch(Exception e) {
			resultDAOVO.setCode("99");
			resultDAOVO.setMessage(e.toString());
			e.printStackTrace();
		}finally {
			em.close( );
		}
		return resultDAOVO;
	}
	
	@Override
	public ResultDAOVO getChatDAO(String idEmpresa) {
		
		Query query=null;
		query = em.createNamedQuery("find chat by idEmpresa");
		query.setParameter("id", idEmpresa);
      ChatEntity chatEntity = new ChatEntity ();
      try {
    	  chatEntity=  (ChatEntity) query.getSingleResult();
    	  resultDAOVO.setJson(chatToJSON(chatEntity));
    	  resultDAOVO.setMessage("Exito en consulta de chat");
    	  resultDAOVO.setCode("00");
      }catch(Exception e){
    	  resultDAOVO.setMessage("Error en consulta de chat");
    	  resultDAOVO.setCode("99");
    	  e.printStackTrace();
      }
      return resultDAOVO;
	}
	
	@Override
	public ResultDAOVO getTarjetaProductosDAO(String idEmpresa) {
		
		Query query=null;
		query = em.createNamedQuery("find tarjetaProductos by idEmpresa");
		query.setParameter("id", idEmpresa);
      TarjetaEntity tarjetaEntity = new TarjetaEntity ();
      try {
    	  tarjetaEntity=  (TarjetaEntity) query.getSingleResult();
    	  resultDAOVO.setJson(chatToJSONTarjeta(tarjetaEntity));
    	  resultDAOVO.setMessage("Exito en consulta de chat");
    	  resultDAOVO.setCode("00");
      }catch(Exception e){
    	  resultDAOVO.setMessage("Error en consulta de chat");
    	  resultDAOVO.setCode("99");
    	  e.printStackTrace();
      }
      return resultDAOVO;
	}
	
	
	
	private JSONObject chatToJSONTarjeta(TarjetaEntity tarjetaEntity) {
		
		JSONObject json = new JSONObject();
		json.put("idEmpresa", tarjetaEntity.getIdEmpresa());
		json.put("idAction", tarjetaEntity.getIdAction());
		json.put("tarjetaProductos", stringToJSONParser(tarjetaEntity.getTarjetaProductos()));
		return json;
	}
	
	private JSONObject stringToJSONParser(String tarjetaProductos) {
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(tarjetaProductos);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	
	
	
	private JSONObject chatToJSON(ChatEntity chatEntity) {
		JSONObject json = new JSONObject();
		json.put("idEmpresa", chatEntity.getIdEmpresa());
		json.put("idAction", chatEntity.getIdAction());
		json.put("numeroChat", chatEntity.getNumeroChat());
		return json;
	}
	/*
	 * privates
	 */
	private List<JSONObject> listToJSONVideos(ArrayList<VideoEntity> videosEntityArray) {

		List<JSONObject> arrayJson = new ArrayList<JSONObject>();
		
		for(VideoEntity ve : videosEntityArray) {
			JSONObject json = new JSONObject();
			json.put("idVideo", ve.getIdVideo());
			json.put("videoTitulo", ve.getVideoTitulo());
			json.put("videoURL", ve.getVideoURL());
			json.put("videoContexto", ve.getVideoContexto());
			arrayJson.add(json);
		}
		return arrayJson;
	}


	
}
