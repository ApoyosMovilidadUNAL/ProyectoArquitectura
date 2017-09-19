package co.unal.sm.servicios;

import java.util.List;

import co.unal.sm.dao.HogarDao;
import co.unal.sm.dao.ServicioDao;
import co.unal.sm.dto.Hogar;
import co.unal.sm.dto.HogarServicio;
import co.unal.sm.dto.Servicio;
import co.unal.sm.mybatis.MyBatisConnectionFactory;

public class ServicioControladorServicio {

	public static boolean agregarServicio(Servicio servicio) {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.agregarServicio(servicio);
	}

	public static Hogar consultarServicioPorId(Integer ht_clente_id) {
		HogarDao hogarDao = new HogarDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return hogarDao.consultarHogarPorCliente(ht_clente_id);
	}

	public static List<String> consultarServiciosHogar(Integer ht_hogar_id) {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.consultarServiciosHogar(ht_hogar_id);
	}
	
	public static boolean actualizarEstadoServicioHogar(Integer ht_hogar_id, Integer ht_servicio_id, String estado_servicio) {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.actualizarEstadoServicioHogar(ht_hogar_id, ht_servicio_id, estado_servicio);
	}
	
	public static List<Servicio> consultarServicios(){
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.consultarServicios();
	}
	
	public static boolean asignarServicioHogar(HogarServicio hogarServicio){
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.asignarServicioHogar(hogarServicio);
	}

}
