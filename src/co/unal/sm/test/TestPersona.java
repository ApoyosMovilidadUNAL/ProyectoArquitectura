package co.unal.sm.test;

import co.unal.sm.dto.Cliente;
import co.unal.sm.dto.Persona;
import co.unal.sm.servicios.ClienteServicio;
import co.unal.sm.servicios.PersonaServicio;

public class TestPersona {

	public static void main(String[] args) {
//		Persona persona = new Persona();
//		
//		persona.setNombre("Jhader");
//		persona.setApellido("Hurtado");
//		persona.setCorreo("jmhurtadoc@unal.edu.co");
//		persona.setIdentificacion("1016054188");
//		
//		Boolean creacion = ClienteServicio.crearCliente(persona);
//		System.out.println(creacion);
		
		@SuppressWarnings("unused")
		Persona cliente = new Persona();
		
		cliente  = ClienteServicio.consultarClientePorId(2);
	}

}
