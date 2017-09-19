package co.unal.sm.test;

import java.util.ArrayList;
import java.util.List;

import co.unal.sm.dto.Contacto;
import co.unal.sm.servicios.ContactoServicio;

public class TestContacto {

	public static void main(String[] args) {
		List<Contacto> contactos = new ArrayList<>();
		contactos = ContactoServicio.consultarContactos();
		for (Contacto contacto : contactos) {
			System.out.println(contacto.getNombre());
		}
	}

}
