package co.unal.sm.servicios;

import java.util.ArrayList;
import java.util.List;

import co.unal.sm.dao.ServicioDao;
import co.unal.sm.dto.Hogar;
import co.unal.sm.dto.HogarServicio;
import co.unal.sm.dto.Persona;
import co.unal.sm.dto.Servicio;
import co.unal.sm.dtoFront.Visita;
import co.unal.sm.mybatis.MyBatisConnectionFactory;

public class ServicioControladorServicio {

	public static boolean agregarServicio(Servicio servicio) {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.agregarServicio(servicio);
	}

	public static Servicio consultarServicioPorId(Integer ht_servicio_id) {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.consultarServicioPorId(ht_servicio_id);
	}

	public static List<String> consultarServiciosHogar(Integer ht_hogar_id) {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.consultarServiciosHogar(ht_hogar_id);
	}

	public static boolean actualizarEstadoServicioHogar(Integer ht_hogar_id, Integer ht_servicio_id,
			String estado_servicio) {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.actualizarEstadoServicioHogar(ht_hogar_id, ht_servicio_id, estado_servicio);
	}

	public static List<Servicio> consultarServicios() {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.consultarServicios();
	}

	public static boolean asignarServicioHogar(HogarServicio hogarServicio) {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return servicioDao.asignarServicioHogar(hogarServicio);
	}

	public static List<Visita> consultarVisitasNuevas() {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		List<HogarServicio> listaHogarServicio = servicioDao.consultarVisitasNuevas();
		List<Visita> listaVisitas = new ArrayList<>();
		for (HogarServicio hogarServicio : listaHogarServicio) {
			Visita visita = new Visita();
			visita.setEstado_servicio(hogarServicio.getEstado_servicio());
			visita.setFecha_visita(hogarServicio.getFecha_visita());
			Servicio servicio = consultarServicioPorId(hogarServicio.getHt_servicio_id());
			visita.setNombreServicio(servicio.getNombre_servicio());
			Hogar hogar = HogarControladorServicio.consultarHogarPorId(hogarServicio.getHt_hogar_id());
			visita.setDireccion(hogar.getDireccion());
			Persona persona = PersonaServicio.consultarPersonaPorIdCliente(hogar.getHt_clente_id());
			visita.setNombreCliente(persona.getNombre() + " " + persona.getApellido());
			visita.setId_cliente(hogar.getHt_clente_id());
			visita.setId_hogar(hogarServicio.getHt_hogar_id());
			visita.setId_servicio(hogarServicio.getHt_servicio_id());
			listaVisitas.add(visita);
		}
		
		return listaVisitas;
	}
	
	public static List<Visita> consultarVisitasFinalizadas() {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		List<HogarServicio> listaHogarServicio = servicioDao.consultarVisitasFinalizadas();
		List<Visita> listaVisitas = new ArrayList<>();
		for (HogarServicio hogarServicio : listaHogarServicio) {
			Visita visita = new Visita();
			visita.setEstado_servicio(hogarServicio.getEstado_servicio());
			visita.setFecha_visita(hogarServicio.getFecha_visita());
			Servicio servicio = consultarServicioPorId(hogarServicio.getHt_servicio_id());
			visita.setNombreServicio(servicio.getNombre_servicio());
			Hogar hogar = HogarControladorServicio.consultarHogarPorId(hogarServicio.getHt_hogar_id());
			visita.setDireccion(hogar.getDireccion());
			Persona persona = PersonaServicio.consultarPersonaPorIdCliente(hogar.getHt_clente_id());
			visita.setNombreCliente(persona.getNombre() + " " + persona.getApellido());
			visita.setId_cliente(hogar.getHt_clente_id());
			visita.setId_hogar(hogarServicio.getHt_hogar_id());
			visita.setId_servicio(hogarServicio.getHt_servicio_id());
			listaVisitas.add(visita);
		}
		
		return listaVisitas;
	}
	
	public static List<Visita> consultarVisitasRetiro() {
		ServicioDao servicioDao = new ServicioDao(MyBatisConnectionFactory.getSqlSessionFactory());
		List<HogarServicio> listaHogarServicio = servicioDao.consultarVisitasRetiro();
		List<Visita> listaVisitas = new ArrayList<>();
		for (HogarServicio hogarServicio : listaHogarServicio) {
			Visita visita = new Visita();
			visita.setEstado_servicio(hogarServicio.getEstado_servicio());
			visita.setFecha_visita(hogarServicio.getFecha_retiro());
			Servicio servicio = consultarServicioPorId(hogarServicio.getHt_servicio_id());
			visita.setNombreServicio(servicio.getNombre_servicio());
			Hogar hogar = HogarControladorServicio.consultarHogarPorId(hogarServicio.getHt_hogar_id());
			visita.setDireccion(hogar.getDireccion());
			Persona persona = PersonaServicio.consultarPersonaPorIdCliente(hogar.getHt_clente_id());
			visita.setNombreCliente(persona.getNombre() + " " + persona.getApellido());
			visita.setId_cliente(hogar.getHt_clente_id());
			visita.setId_hogar(hogarServicio.getHt_hogar_id());
			visita.setId_servicio(hogarServicio.getHt_servicio_id());
			listaVisitas.add(visita);
		}
		
		return listaVisitas;
	}

}
