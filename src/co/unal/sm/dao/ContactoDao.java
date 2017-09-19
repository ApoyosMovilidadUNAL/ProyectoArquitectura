package co.unal.sm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.unal.sm.dto.Contacto;

public class ContactoDao {
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	public ContactoDao(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public List<Contacto> consultarContactos(){
		List<Contacto> contactos = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			contactos = session.selectList("Contacto.consultarContactos");
		} finally {
			session.close();
		}
		System.out.println("consultarContactos()--->" + contactos);
		return contactos;
	}

}
