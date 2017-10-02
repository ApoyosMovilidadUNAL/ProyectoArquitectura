package co.unal.sm.servicios;

import java.util.List;

import co.unal.sm.dao.ClienteDao;
import co.unal.sm.dao.PersonaDao;
import co.unal.sm.dto.Cliente;
import co.unal.sm.dto.Persona;
import co.unal.sm.mybatis.MyBatisConnectionFactory;

public class ClienteServicio {

	public static Persona consultarClientePorId(Integer id) {

		ClienteDao clienteDao = new ClienteDao(MyBatisConnectionFactory.getSqlSessionFactory());
		Cliente cliente = new Cliente();
		cliente = clienteDao.consultarClientePorId(id);

		if (cliente != null) {
			PersonaDao dao = new PersonaDao(MyBatisConnectionFactory.getSqlSessionFactory());
			Persona persona = new Persona();
			persona = dao.consultarPersonaPorId(cliente.getHt_persona_id());
			return persona;
		}
		return null;
	}
	
	public static boolean crearCliente(Persona persona){
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
	
	public static List<Persona> consultarClientes(){
		
		ClienteDao clienteDao =new ClienteDao(MyBatisConnectionFactory.getSqlSessionFactory());
		List<Persona> clientes = clienteDao.consultarClientes();
		
		return clientes;
	}
	
}
