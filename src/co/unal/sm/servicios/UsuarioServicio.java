package co.unal.sm.servicios;

import co.unal.sm.dao.ClienteDao;
import co.unal.sm.dao.PersonaDao;
import co.unal.sm.dto.Persona;
import co.unal.sm.mybatis.MyBatisConnectionFactory;

public class UsuarioServicio {
	
	public static boolean crearUsuario(Persona persona){
		System.out.println("persona" + persona.getCorreo());
		Boolean creado = false;
		PersonaDao personaDao = new PersonaDao(MyBatisConnectionFactory.getSqlSessionFactory());
		ClienteDao clienteDao =new ClienteDao(MyBatisConnectionFactory.getSqlSessionFactory());
		Boolean p = personaDao.agregarPersona(persona);
		if (p) {
			Integer personaId = personaDao.consultarIdPersona(persona.getIdentificacion());
			creado = clienteDao.agregarCliente(personaId);
		}
		return creado;
	}

}
