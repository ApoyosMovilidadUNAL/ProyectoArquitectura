package co.unal.sm.servicios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.unal.sm.dao.HogarDao;
import co.unal.sm.dto.Hogar;
import co.unal.sm.dto.Persona;
import co.unal.sm.dtoFront.HogarFront;
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

	public static List<Hogar> consultarHogarPorCliente(Integer ht_clente_id) {
		HogarDao hogarDao = new HogarDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return hogarDao.consultarHogarPorCliente(ht_clente_id);
	}

	public static List<Hogar> consultarHogares() {
		HogarDao hogarDao = new HogarDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return hogarDao.consultarHogares();
	}

	public static Hogar consultarHogarPorId(Integer ht_hogar_id) {
		HogarDao hogarDao = new HogarDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return hogarDao.consultarHogarPorId(ht_hogar_id);
	}

	public static List<HogarFront> consultarHogaresInformacion() {
		List<Hogar> listaHogares = new ArrayList<>();
		listaHogares = consultarHogares();

		List<HogarFront> listaHogaresFront = new ArrayList<>();

		for (Hogar hogar : listaHogares) {
			HogarFront hogarFront = new HogarFront();
			Persona persona = ClienteServicio.consultarClientePorId(hogar.getHt_clente_id());
			hogarFront.setIdCliente(hogar.getHt_clente_id());
			hogarFront.setNombreCliente(persona.getNombre() + " " + persona.getApellido());
			hogarFront.setIdHogar(hogar.getId());
			hogarFront.setDireccion(hogar.getDireccion());
			hogarFront.setFecha_registro(hogar.getFecha_registro());
			hogarFront.setServicios(ServicioControladorServicio.consultarServiciosHogar(hogar.getId()));
			listaHogaresFront.add(hogarFront);
		}
		return listaHogaresFront;
	}

}
