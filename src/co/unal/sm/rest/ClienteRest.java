package co.unal.sm.rest;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import co.unal.sm.dto.Persona;
import co.unal.sm.dto.Cliente;
import co.unal.sm.net.POST;
import co.unal.sm.net.GET;
import co.unal.sm.net.RestService;
import co.unal.sm.servicios.ClienteServicio;

@SuppressWarnings("serial")
@WebServlet("/cliente/*")
public class ClienteRest extends RestService {

	@POST("/cliente/consultarClientePorId")
	public static Persona consultarClientePorId(Integer id) {
		return ClienteServicio.consultarClientePorId(id);
	}
	
	@POST("/cliente/crearCliente")
	public static Boolean crearCliente(Persona persona) {
		return ClienteServicio.crearCliente(persona);
	}
	
	@GET("/cliente/consultarClientes")
	public static List<Persona> consultarClientes(){
		return ClienteServicio.consultarClientes();
	}

}
