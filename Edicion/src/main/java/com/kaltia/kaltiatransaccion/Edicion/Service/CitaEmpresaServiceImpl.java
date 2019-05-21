package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.CitaEmpresaDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.CitaEmpresaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

@Service("citaEmpresaServiceImpl")
public class CitaEmpresaServiceImpl implements CitaEmpresaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5929607333811329034L;
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ResultVO resultVO;	
	@Autowired
	@Qualifier("citaEmpresaDAO")
	private CitaEmpresaDAO citaEmpresaDAO;
	
	
	private static Calendar fecha = Calendar.getInstance();

	public CitaEmpresaServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ResultVO citaEmpresaServiceCreate(String action, String horario) throws Exception {
		CitaEmpresaEntity  citaEntity = new CitaEmpresaEntity();
		citaEntity.setIdAction(action);
		citaEntity.setCondiciones(horario);
		citaEntity.setCitaEnero("{}");
		citaEntity.setCitaFebrero("{}");
		citaEntity.setCitaMarzo("{}");
		citaEntity.setCitaAbril("{}");
		citaEntity.setCitaMayo("{}");
		citaEntity.setCitaJunio("{}");
		citaEntity.setCitaJulio("{}");
		citaEntity.setCitaAgosto("{}");
		citaEntity.setCitaSeptiembre("{}");
		citaEntity.setCitaOctubre("{}");
		citaEntity.setCitaNoviembre("{}");
		citaEntity.setCitaDiciembre("{}");
		citaEmpresaDAO.save(citaEntity);
		
		return null;
	}
	
	@Override
	public ResultVO citaEmpresaServiceRead(String action) {
		
		//CitaEntity citaEntity = new CitaEntity();
		String mesActual;
		String mesMas;
		ArrayList<String> meses = new ArrayList<String>();
		
		try {
			CitaEmpresaEntity citaEntity = citaEmpresaEntityRead(action); 
			mesActual= numMes(fecha.get(Calendar.MONTH), citaEntity);
			
			if(fecha.get(Calendar.MONTH)+1 == 12) {
				mesMas = numMes(0, citaEntity);
			}else {
				mesMas = numMes(fecha.get(Calendar.MONTH)+1, citaEntity);
			}
			meses.add(citaEntity.getCondiciones());
			meses.add(mesActual);
			meses.add(mesMas);
			resultVO.setCodigo(0);
			resultVO.setMensajeArray(meses);
			
		}catch(Exception e){
			e.printStackTrace() ;
			resultVO.setCodigo(99);
			ArrayList<String> exceptionE= new ArrayList<String>();
			exceptionE.add(e.toString());
			resultVO.setMensaje("Error de lectura Citas idEmpresa:"+action);
		}
		
		logger.info(resultVO.getMensajeArray());
		return resultVO;
	}

	@Override
	public ResultVO citaEmpresaServiceUpdate(ValoresJsonVO valoresJsonVO){
		/*
		 * Nuevo Diseño JSON Cita
		 *  action: "bronea", idEmpresa: "broneauser", valoresFinales: "18/04/2019|1230"
		 */
		String action = valoresJsonVO.getAction();
		String userEmpresa = valoresJsonVO.getIdEmpresa();
		
		try {

			String[] fecha = valoresJsonVO.getValoresFinales().split("\\/");  	//"20/05/2019|1100|DescripcionCita"
			String diaCita = fecha[0];
			String horaCita = fecha[2].substring(fecha[2].indexOf('|')+1, fecha[2].lastIndexOf('|'));//.length());
			String descripcionCita= fecha[2].substring(fecha[2].lastIndexOf('|')+1,fecha[2].length());
			logger.info("citaEmpresaServiceCreateFecha[0]:"+fecha[0]);
				
			JSONObject elementoA = new JSONObject();
			elementoA.put("userEmpresa", userEmpresa);
			elementoA.put("descripcionCita",descripcionCita);

			JSONObject mesCitaEmpresa = new JSONObject();
			JSONObject mesCitaEmpresaActualizado = mesCitaEmpresa;
			JSONObject diaCitaEmpresa = new JSONObject();
			
			CitaEmpresaEntity citaEmpresaEntity = citaEmpresaEntityRead(valoresJsonVO.getAction());
			 mesCitaEmpresa = (JSONObject) JSONValue.parse(numMes(Integer.valueOf(fecha[1])-1, citaEmpresaEntity));
			 logger.info(mesCitaEmpresa);
			 
			if(mesCitaEmpresa.containsKey(diaCita)) { //dia con citas
	//			logger.info("dia con citas:"+mesCitaEmpresa.get(diaCita));				
				diaCitaEmpresa = (JSONObject) mesCitaEmpresa.get(diaCita);
					if(diaCitaEmpresa.containsKey(horaCita)) {
						resultVO.setCodigo(99);
						resultVO.setMensaje("Horario de Cita no disponible");
						return resultVO;
					}else {
						diaCitaEmpresa.put(horaCita, elementoA);
					}
			}else { // dia sin citas
//				logger.info("dia SIN citas");
				diaCitaEmpresa.put(horaCita, elementoA);
				mesCitaEmpresa.put(diaCita, diaCitaEmpresa);
			}
				 
//			logger.info(mesCitaEmpresa);
			String mesCitaEmpresaString = mesCitaEmpresa.toString();
			citaEmpresaEntity  = numMesSet(Integer.valueOf(fecha[1])-1, citaEmpresaEntity ,mesCitaEmpresaString );
			citaEmpresaEntityUpdate(citaEmpresaEntity);
			resultVO.setCodigo(0);
			resultVO.setMensaje("Cita pendiente de Aprobacion");

		}catch(Exception e){	
			resultVO.setCodigo(99);
			resultVO.setMensaje("Error Agendar Cita");
			e.printStackTrace();
		}

		return resultVO;
	}

	@Override
	public ResultVO citaEmpresaServiceDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	
	private CitaEmpresaEntity citaEmpresaEntityRead(String action) {
		CitaEmpresaEntity citaEmpresaEntity = new CitaEmpresaEntity();
		try {
		citaEmpresaEntity = citaEmpresaDAO.findOne(action);
		}catch(Exception e) {
			citaEmpresaEntity.setIdAction("Verificar calendario de "+action);
			e.printStackTrace();
		}
		return citaEmpresaEntity;
	}
	
	private void citaEmpresaEntityUpdate(CitaEmpresaEntity citaEmpresaEntity) {
		try {
			citaEmpresaDAO.save(citaEmpresaEntity);
			}catch(Exception e) {
				citaEmpresaEntity.setIdAction("Verificar actualizacion de Citas");
			}
	}
	
	
	private String numMes(int mes, CitaEmpresaEntity citaEmpresaEntity) {
		logger.info("mes:"+(mes+1));
		String columna = "";
//		JSONObject columna = new JSONObject();
		switch (mes) {		
		case 0:
			columna =  citaEmpresaEntity.getCitaEnero();
			break;
		case 1:
			columna =  citaEmpresaEntity.getCitaFebrero();
			break;
		case 2:
			columna =  citaEmpresaEntity.getCitaMarzo();
			break;
		case 3:
			columna =  citaEmpresaEntity.getCitaAbril();
			break;
		case 4:
			columna =  citaEmpresaEntity.getCitaMayo();
			break;
		case 5:
			columna =  citaEmpresaEntity.getCitaJunio();
			break;
		case 6:
			columna =  citaEmpresaEntity.getCitaJulio();
			break;
		case 7:
			columna =  citaEmpresaEntity.getCitaAgosto();
			break;
		case 8:
			columna =  citaEmpresaEntity.getCitaSeptiembre();
			break;
		case 9:
			columna =  citaEmpresaEntity.getCitaOctubre();
			break;
		case 10:
			columna =  citaEmpresaEntity.getCitaNoviembre();
			break;
		case 11:
			columna =  citaEmpresaEntity.getCitaDiciembre();
			break;
		}
		return columna;
	}
	
private CitaEmpresaEntity numMesSet(Integer mes, CitaEmpresaEntity  citaEmpresaEntity ,  String mesCitaEmpresa) {
		
		logger.info("mes:"+(mes+1));
		String columna = "";
		
		switch (mes) {		
		case 0:
			citaEmpresaEntity.setCitaEnero(mesCitaEmpresa);
			break;
		case 1:
			citaEmpresaEntity.setCitaFebrero(mesCitaEmpresa);
			break;
		case 2:
			citaEmpresaEntity.setCitaMarzo(mesCitaEmpresa);
			break;
		case 3:
			citaEmpresaEntity.setCitaAbril(mesCitaEmpresa);
			break;
		case 4:
			citaEmpresaEntity.setCitaMayo(mesCitaEmpresa);
			break;
		case 5:
			citaEmpresaEntity.setCitaJunio(mesCitaEmpresa);
			break;
		case 6:
			citaEmpresaEntity.setCitaJulio(mesCitaEmpresa);
			break;
		case 7:
			citaEmpresaEntity.setCitaAgosto(mesCitaEmpresa);
			break;
		case 8:
			citaEmpresaEntity.setCitaSeptiembre(mesCitaEmpresa);
			break;
		case 9:
			citaEmpresaEntity.setCitaOctubre(mesCitaEmpresa);
			break;
		case 10:
			citaEmpresaEntity.setCitaNoviembre(mesCitaEmpresa);
			break;
		case 11:
			citaEmpresaEntity.setCitaDiciembre(mesCitaEmpresa);
			break;
		}
		
		return citaEmpresaEntity;
	}
	

}
