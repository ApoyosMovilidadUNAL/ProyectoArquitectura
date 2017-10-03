package co.unal.sm.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.unal.sm.dao.HogarDao;
import co.unal.sm.dto.Hogar;
import co.unal.sm.mybatis.MyBatisConnectionFactory;

public class HogarControladorServicio {

	public static boolean crearHogarCliente(Hogar hogar) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
		try {
			Date date = format.parse(hogar.getFecha_json());
			hogar.setFecha_registro(date);
		} catch (Exception e) {
		}
		HogarDao hogarDao = new HogarDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return hogarDao.agregarHogar(hogar);
	}
	
	public static List<Hogar> consultarHogarPorCliente(Integer ht_clente_id){
		HogarDao hogarDao = new HogarDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return hogarDao.consultarHogarPorCliente(ht_clente_id);
	}
	
	public static List<Hogar> consultarHogares(){
		HogarDao hogarDao = new HogarDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return hogarDao.consultarHogares();
	}

}
