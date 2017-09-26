package co.unal.sm.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.unal.sm.dto.Usuario;

public class UsuarioDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public UsuarioDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Usuario consultarUsuarioPorId(Integer id) {
		Usuario usuario = new Usuario();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			usuario = session.selectOne("Usuario.consultarUsuarioPorId", id);
		} finally {
			session.close();
		}
		System.out.println("consultarUsuarioPorId()--->" + usuario);
		return usuario;
	}

	public boolean agregarUsuario(Usuario usuario) {
		SqlSession session = sqlSessionFactory.openSession();
		Integer id_usuario = null;
		try {
			id_usuario = session.insert("Usuario.agregarUsuario", usuario);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		System.out.println("agregarUsuario()--->" + id_usuario);
		return true;
	}

	public Usuario consultarUsuarioPorIdPersona(Integer idPersona) {
		Usuario usuario = new Usuario();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			usuario = session.selectOne("Usuario.consultarUsuarioPorIdPersona", idPersona);
		} finally {
			session.close();
		}
		System.out.println("consultarUsuarioPorIdPersona()--->" + usuario);
		return usuario;
	}
}
