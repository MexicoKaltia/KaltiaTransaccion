package com.kaltia.kaltiatransaccion.Edicion.Service;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kaltia.kaltiatransaccion.Edicion.DAO.CitaDAO;
import com.kaltia.kaltiatransaccion.Edicion.VO.CitaEntity;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultArrayVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ResultVO;
import com.kaltia.kaltiatransaccion.Edicion.VO.ValoresJsonVO;

@Service("citaServiceImpl")
public class CitaServiceImpl implements CitaService {
	
	private static final long serialVersionUID = -2559787777079230762L;

		protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ResultArrayVO resultArrayVO;
	
	@Autowired
	@Qualifier("citaDAO")
	private CitaDAO citaDAO;
	
	private static Calendar fecha = Calendar.getInstance();
	
	@Override
	public ResultVO citaServiceCreate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultArrayVO citaServiceRead(String action) {
		
		CitaEntity citaEntity = new CitaEntity();
		String mesActual;
		String mesMas;
		ArrayList<String> meses = new ArrayList<String>();
		
		try {
			citaEntity = citaDAO.findOne(action);
			mesActual= numMes(fecha.get(Calendar.MONTH), citaEntity);
			
			if(fecha.get(Calendar.MONTH)+1 == 12) {
				mesMas = numMes(0, citaEntity);
			}else {
				mesMas = numMes(fecha.get(Calendar.MONTH)+1, citaEntity);
			}
			meses.add(citaEntity.getCondicionesCita());
			meses.add(mesActual);
			meses.add(mesMas);
			resultArrayVO.setCodigo(0);
			resultArrayVO.setMensaje(meses);
			
		}catch(Exception e){
			e.printStackTrace() ;
			resultArrayVO.setCodigo(99);
			ArrayList<String> exceptionE= new ArrayList<String>();
			exceptionE.add(e.toString());
			resultArrayVO.setMensaje(exceptionE);
		}
		
		
		return resultArrayVO;
	}

	

	@Override
	public ResultVO citaServiceUpdate(ValoresJsonVO valoresJsonVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultVO citaServiceDelete() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private String numMes(Integer mes, CitaEntity citaEntity) {
		logger.info("mes:"+mes);
		String columna = "";
		
		switch (mes) {		
		case 0:
			columna =  citaEntity.getEneroCita();
			break;
		case 1:
			columna =  citaEntity.getFebreroCita();
			break;
		case 2:
			columna =  citaEntity.getMarzoCita();
			break;
		case 3:
			columna =  citaEntity.getAbrilCita();
			break;
		case 4:
			columna =  citaEntity.getMayoCita();
			break;
		case 5:
			columna =  citaEntity.getJunioCita();
			break;
		case 6:
			columna =  citaEntity.getJulioCita();
			break;
		case 7:
			columna =  citaEntity.getAgostoCita();
			break;
		case 8:
			columna =  citaEntity.getSeptiembreCita();
			break;
		case 9:
			columna =  citaEntity.getOctubreCita();
			break;
		case 10:
			columna =  citaEntity.getNoviembreCita();
			break;
		case 11:
			columna =  citaEntity.getDiciembreCita();
			break;
		}
	
		
		return columna;
	}

}
