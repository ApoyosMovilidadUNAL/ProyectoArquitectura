package co.unal.sm.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.unal.sm.dto.Sesion;
import co.unal.sm.dto.Usuario;

public class SesionDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public SesionDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Boolean actualizarToken(Sesion sesion) {
		Usuario usuario = new Usuario();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			usuario = session.selectOne("Usuario.actualizarToken", sesion);
		} finally {
			session.close();
		}
		System.out.println("actualizarToken()--->" + usuario);
		return true;
	}

}
