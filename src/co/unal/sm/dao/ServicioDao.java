package co.unal.sm.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.unal.sm.dto.HogarServicio;
import co.unal.sm.dto.Servicio;
import co.unal.sm.dtoFront.Visita;

public class ServicioDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public ServicioDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Servicio consultarServicioPorId(Integer id) {
		Servicio servicio = new Servicio();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			servicio = session.selectOne("Servicio.consultarServicioPorId", id);
		} finally {
			session.close();
		}
		System.out.println("consultarServicioPorId()--->" + servicio);
		return servicio;
	}

	public List<Servicio> consultarServicios() {
		List<Servicio> servicios = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			servicios = session.selectList("Servicio.consultarServicios");
		} finally {
			session.close();
		}
		System.out.println("consultarServicios()--->" + servicios);
		return servicios;
	}

	public boolean agregarServicio(Servicio servicio) {
		SqlSession session = sqlSessionFactory.openSession();
		Integer id_servicio = null;
		try {
			id_servicio = session.insert("Servicio.agregarServicio", servicio);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		System.out.println("agregarServicio()--->" + id_servicio);
		return true;
	}

	public boolean asignarServicioHogar(HogarServicio hogarServicio) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Servicio.asignarServicioHogar", hogarServicio);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		System.out.println("asignarServicioHogar()");
		return true;
	}
	
	public List<String> consultarServiciosHogar(Integer ht_hogar_id){
		List<String> servicios = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			servicios=session.selectList("Servicio.consultarServiciosHogar", ht_hogar_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		System.out.println("consultarServiciosHogar()");
		return servicios;
	}
	
	public boolean actualizarEstadoServicioHogar(Integer ht_hogar_id, Integer ht_servicio_id,String estado_servicio){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("ht_hogar_id", ht_hogar_id);
			map.put("ht_servicio_id", ht_servicio_id);
			map.put("estado_servicio", estado_servicio);
			session.update("Servicio.actualizarEstadoServicioHogar",map);
			session.commit();
			System.out.println("actualizarEstadoServicioHogar()");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}

	public List<HogarServicio> consultarVisitasNuevas() {
		List<HogarServicio> hogarServicios = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 0);
			date = calendar.getTime();
			System.out.println("consultarVisitasNuevas() --- " + date);
			hogarServicios = session.selectList("Servicio.consultarVisitasNuevas",date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return hogarServicios;
	}
	
	public List<HogarServicio> consultarVisitasFinalizadas() {
		List<HogarServicio> hogarServicios = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 0);
			date = calendar.getTime();
			hogarServicios = session.selectList("Servicio.consultarVisitasFinalizadas",date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return hogarServicios;
	}
	
	public List<HogarServicio> consultarVisitasRetiro() {
		List<HogarServicio> hogarServicios = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 0);
			date = calendar.getTime();
			hogarServicios = session.selectList("Servicio.consultarVisitasRetiro",date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return hogarServicios;
	}
	
}
