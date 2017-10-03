package co.unal.sm.servicios;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;

import co.unal.sm.dao.PersonaDao;
import co.unal.sm.dao.SesionDao;
import co.unal.sm.dao.UsuarioDao;
import co.unal.sm.dto.DatosAuth;
import co.unal.sm.dto.Sesion;
import co.unal.sm.dto.Usuario;
import co.unal.sm.ldap.LdapAuth;
import co.unal.sm.mybatis.MyBatisConnectionFactory;
import encriptar.md5.md5;

public class AutenticacionServicio {

	public static Sesion autenticarUsuario(DatosAuth datosAuth) {

		System.out.println("Iniciando Autenticacion");
		
		System.out.println(datosAuth.getClave());
		System.out.println(datosAuth.getUsuario());

		String server = "ldap://ldaprbog.unal.edu.co:389"; // servidor de LDAP
		String usuario = datosAuth.getUsuario(); // Usuario de Autenticacion
		String dn = "uid=" + usuario + ",ou=people,o=bogota,o=unal.edu.co"; // Ruta
		String tipoAth = "simple";// tipo de autentuicacion simple o por SSL
		String clave = datosAuth.getClave();
		String identificacion;
		Integer idPersona;
		LdapAuth ldapAuth=new LdapAuth(server,dn,tipoAth,usuario,clave);
		
		if(ldapAuth.isAutenticado()){
			
			Attribute atr = ldapAuth.cargarPropiedadConexion("employeeNumber");
			try {
				identificacion = atr.get().toString();
			} catch (NamingException e) {
				e.printStackTrace();
				return null;
			}
			PersonaDao personaDao = new PersonaDao(MyBatisConnectionFactory.getSqlSessionFactory());
			idPersona = personaDao.consultarIdPersona(identificacion);
			UsuarioDao usuarioDao = new UsuarioDao(MyBatisConnectionFactory.getSqlSessionFactory());
			Usuario admin = usuarioDao.consultarUsuarioPorIdPersona(idPersona);
			
			SesionDao sesionDao = new SesionDao(MyBatisConnectionFactory.getSqlSessionFactory());
			
			Sesion sesion = new Sesion();
			sesion.setId(idPersona);
			System.out.println("identificacion==="+identificacion);
			Double randonDouble = Math.random()*1000000000;
			Integer randonInteger= randonDouble.intValue();
			
			sesion.setToken(md5.MD5(randonInteger.toString()+identificacion));
			if (admin != null) {
				sesionDao.actualizarToken(sesion);
//				return sesion.getToken();
				return sesion;
			}
		}
		return null;
	}

	public static Boolean logout(Sesion sesion) {
		
		try{
			SesionDao sesionDao = new SesionDao(MyBatisConnectionFactory.getSqlSessionFactory());
			System.out.println(sesion.getToken());
			System.out.println(sesion.getId());
			sesion.setToken("");
			sesionDao.actualizarToken(sesion);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
