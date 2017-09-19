package co.unal.sm.rest;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import co.unal.sm.dto.Hogar;
import co.unal.sm.net.GET;
import co.unal.sm.net.POST;
import co.unal.sm.net.RestService;
import co.unal.sm.servicios.HogarControladorServicio;

@SuppressWarnings("serial")
@WebServlet("/hogar/*")
public class HogarRest extends RestService {

	@POST("/hogar/consultarHogarPorCliente")
	public static Hogar consultarHogarPorCliente(Integer id) {
		return HogarControladorServicio.consultarHogarPorCliente(id);
	}

	@POST("/hogar/crearHogarCliente")
	public static Boolean crearHogarCliente(Hogar hogar) {
		return HogarControladorServicio.crearHogarCliente(hogar);
	}

	@GET("/hogar/consultarHogares")
	public static List<Hogar> consultarHogares() {
		return HogarControladorServicio.consultarHogares();
	}

}
