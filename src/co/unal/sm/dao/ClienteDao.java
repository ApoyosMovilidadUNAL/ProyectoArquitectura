package co.unal.sm.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.unal.sm.dto.Cliente;

public class ClienteDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public ClienteDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Cliente consultarClientePorId(Integer id) {
		Cliente cliente = new Cliente();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			cliente = session.selectOne("Cliente.consultarClientePorId", id);
		} finally {
			session.close();
		}
		System.out.println("consultarClientePorId()--->" + cliente);
		return cliente;
	}

	public boolean agregarCliente(Integer ht_persona_id) {
		SqlSession session = sqlSessionFactory.openSession();
		Integer id_cliente = null;
		try {
			id_cliente = session.insert("Cliente.agregarCliente", ht_persona_id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		System.out.println("agregarCliente()--->" + id_cliente);
		return true;
	}
}
