package co.unal.sm.servicios;

import co.unal.sm.dao.PersonaDao;
import co.unal.sm.dto.Persona;
import co.unal.sm.mybatis.MyBatisConnectionFactory;

public class PersonaServicio {
	
	public static Persona consultarContactos(Integer id){
		PersonaDao dao = new PersonaDao(MyBatisConnectionFactory.getSqlSessionFactory());
		Persona persona = new Persona();
		persona = dao.consultarPersonaPorId(id);
		return persona;
	}

}
