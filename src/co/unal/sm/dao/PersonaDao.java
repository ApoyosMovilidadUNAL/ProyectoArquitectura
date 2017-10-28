package co.unal.sm.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.unal.sm.dto.Persona;

public class PersonaDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public PersonaDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Persona consultarPersonaPorId(Integer id) {
		Persona persona = new Persona();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			persona = session.selectOne("Persona.consultarPersonaPorId", id);
		} finally {
			session.close();
		}
		System.out.println("consultarPersona()--->" + persona);
		return persona;
	}
	
	public boolean agregarPersona(Persona persona) {
		SqlSession session = sqlSessionFactory.openSession();
		Integer id_persona = null;
		try {
			id_persona = session.insert("Persona.agregarPersona", persona);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		System.out.println("agregarPersona()--->" + id_persona);
		return true;
	}
	
	public Integer consultarIdPersonaCorreo(String correo){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne("Persona.consultarIdPersona", correo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();	
		}
	}
	
	public Integer consultarIdPersona(String identificacion){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectOne("Persona.consultarIdPersona", identificacion);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();	
		}
	}
	
	public Persona consultarPersonaPorIdCliente(Integer id) {
		Persona persona = new Persona();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			persona = session.selectOne("Persona.consultarPersonaPorIdCliente", id);
		} finally {
			session.close();
		}
		System.out.println("consultarPersona()--->" + persona);
		return persona;
	}

}
