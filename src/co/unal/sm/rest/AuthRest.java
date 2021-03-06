package co.unal.sm.rest;

import javax.servlet.annotation.WebServlet;

import co.unal.sm.dto.DatosAuth;
import co.unal.sm.dto.Persona;
import co.unal.sm.dto.Sesion;
import co.unal.sm.net.POST;
import co.unal.sm.net.RestService;
import co.unal.sm.servicios.AutenticacionServicio;
import co.unal.sm.servicios.ClienteServicio;

@SuppressWarnings("serial")
@WebServlet("/*")
public class AuthRest extends RestService {

	@POST("/login")
	public static Sesion autenticarUsuario(DatosAuth datosAuth) {
		return AutenticacionServicio.autenticarUsuario(datosAuth);
	}
	
	@POST("/logout")
	public static Boolean logout(Sesion sesion) {
		return AutenticacionServicio.logout(sesion);
	}

}
