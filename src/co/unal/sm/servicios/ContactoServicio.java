package co.unal.sm.servicios;

import java.util.ArrayList;
import java.util.List;

import co.unal.sm.dao.ContactoDao;
import co.unal.sm.dto.Contacto;
import co.unal.sm.mybatis.MyBatisConnectionFactory;

public class ContactoServicio {
	
	public static List<Contacto> consultarContactos(){
		ContactoDao dao = new ContactoDao(MyBatisConnectionFactory.getSqlSessionFactory());
		List<Contacto> contactos = new ArrayList<>();
		contactos = dao.consultarContactos();
		return contactos;
	}
}
