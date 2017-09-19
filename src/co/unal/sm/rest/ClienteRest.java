package co.unal.sm.rest;

import javax.servlet.annotation.WebServlet;

import co.unal.sm.dto.Persona;
import co.unal.sm.net.POST;
import co.unal.sm.net.RestService;
import co.unal.sm.servicios.ClienteServicio;

@SuppressWarnings("serial")
@WebServlet("/cliente/*")
public class ClienteRest extends RestService {

	@POST("/cliente/consultarCliente")
	public static Persona consultarCliente(Integer id) {
		return ClienteServicio.consultarCliente(id);
	}
	
	@POST("/cliente/crearCliente")
	public static Boolean crearCliente(Persona persona) {
		return ClienteServicio.crearCliente(persona);
	}

}
