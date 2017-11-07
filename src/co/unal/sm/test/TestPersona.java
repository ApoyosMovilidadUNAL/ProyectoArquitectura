package co.unal.sm.test;

import co.unal.sm.servicios.ConsumoServicio;

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
		
//		@SuppressWarnings("unused")
//		PruebaServicio pruebaServicio = new PruebaServicio();
//		
//		PruebaServicio.prueba();
		
		
		@SuppressWarnings("unused")
		ConsumoServicio consumoServicio = new ConsumoServicio();
		
		ConsumoServicio.obtenerConsumo("jmhurtadoc@unal.edu.co");
	}

}
