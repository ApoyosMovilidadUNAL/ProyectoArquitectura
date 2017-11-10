package co.unal.sm.rest;

import javax.servlet.annotation.WebServlet;

import co.unal.sm.dto.Consumos;
import co.unal.sm.net.POST;
import co.unal.sm.net.RestService;
import co.unal.sm.servicios.ConsumoServicio;

@SuppressWarnings("serial")
@WebServlet("/consumo/*")
public class ConsumoRest extends RestService {

	@POST("/consumo/obtenerConsumo")
	public static Consumos obtenerConsumo(String email) {
		if(email == null){
			return null;
		}
		return ConsumoServicio.obtenerConsumo(email);
	}

}
