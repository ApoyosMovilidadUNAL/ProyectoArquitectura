package co.unal.sm.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.unal.sm.dto.Hogar;

public class HogarDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public HogarDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<Hogar> consultarHogarPorCliente(Integer ht_clente_id) {
		Hogar hogar = new Hogar();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			System.out.println("consultarHogarPorCliente()--->" + hogar);
			return session.selectList("Hogar.consultarHogarPorCliente", ht_clente_id);
		} finally {
			session.close();
		}
	}
	
	public List<Hogar> consultarHogares() {
		List<Hogar> hogares = new ArrayList<>();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			hogares = session.selectList("Hogar.consultarHogares");
		} finally {
			session.close();
		}
		System.out.println("consultarHogares()--->" + hogares);
		return hogares;
	}

	public boolean agregarHogar(Hogar hogar) {
		SqlSession session = sqlSessionFactory.openSession();
		Integer id_hogar = null;
		try {
			id_hogar = session.insert("Hogar.agregarHogar", hogar);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		System.out.println("agregarHogar()--->" + id_hogar);
		return true;
	}

	public Hogar consultarHogarPorId(Integer ht_hogar_id) {
		Hogar hogar = new Hogar();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			hogar = session.selectOne("Hogar.consultarHogarPorId", ht_hogar_id);
		} finally {
			session.close();
		}
		System.out.println("consultarHogarPorId()--->" + hogar);
		return hogar;
	}
}
