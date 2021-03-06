package co.unal.sm.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import co.unal.sm.dto.HogarServicio;
import co.unal.sm.dto.Servicio;
import co.unal.sm.dtoFront.Visita;
import co.unal.sm.net.GET;
import co.unal.sm.net.POST;
import co.unal.sm.net.RestService;
import co.unal.sm.servicios.ServicioControladorServicio;

@SuppressWarnings("serial")
@WebServlet("/servicio/*")
public class ServicioRest extends RestService {

	@POST("/servicio/agregarServicio")
	public static Boolean agregarServicio(Servicio servicio) {
		return ServicioControladorServicio.agregarServicio(servicio);
	}

	@POST("/servicio/consultarServiciosHogar")
	public static List<String> consultarServiciosHogar(Integer id_hogar) {
		return ServicioControladorServicio.consultarServiciosHogar(id_hogar);
	}

	@POST("/servicio/actualizarEstadoServicioHogar")
	public static boolean actualizarEstadoServicioHogar(HogarServicio hogarServicio) {
		return ServicioControladorServicio.actualizarEstadoServicioHogar(hogarServicio.getHt_hogar_id(),
				hogarServicio.getHt_servicio_id(), hogarServicio.getEstado_servicio());
	}

	@GET("/servicio/consultarServicios")
	public static List<Servicio> consultarServicios() {
		return ServicioControladorServicio.consultarServicios();
	}

	@POST("/servicio/asignarServicioHogar")
	public static boolean asignarServicioHogar(HogarServicio hogarServicio) {
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
		try {
			date = targetFormat.parse(hogarServicio.getFecha_visita_entrada());
			hogarServicio.setFecha_visita(date);
			return ServicioControladorServicio.asignarServicioHogar(hogarServicio);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	@GET("/servicio/consultarVisitasNuevas")
	public static List<Visita> consultarVisitasNuevas() {
		return ServicioControladorServicio.consultarVisitasNuevas();
	}

	@GET("/servicio/consultarVisitasFinalizadas")
	public static List<Visita> consultarVisitasFinalizadas() {
		return ServicioControladorServicio.consultarVisitasFinalizadas();
	}

	@GET("/servicio/consultarVisitasRetiro")
	public static List<Visita> consultarVisitasRetiro() {
		return ServicioControladorServicio.consultarVisitasRetiro();
	}

}
