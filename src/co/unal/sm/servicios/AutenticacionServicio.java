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
		
		Sesion sesion = new Sesion();
		sesion.setToken("");
		
		System.out.println("Iniciando Autenticacion");
		
		System.out.println(datosAuth.getClave());
		System.out.println(datosAuth.getUsuario());
//		String endpoint = App.getProperty("ldap.endpoint");
//		String server = "ldap://" + endpoint; // servidor de LDAP
		String server = "ldap://192.168.99.102:389"; // servidor de LDAP
		String usuario = datosAuth.getUsuario(); // Usuario de Autenticacion
		String dn = "cn=" + usuario + "@unal.edu.co,ou=AdminHogares,dc=arqsoft,dc=unal,dc=edu,dc=co"; // Ruta
		
		
		String tipoAth = "simple";// tipo de autentuicacion simple o por SSL
		String clave = datosAuth.getClave();
		String correo;
		Integer idPersona;
		LdapAuth ldapAuth=new LdapAuth(server,dn,tipoAth,usuario,clave);
		
		if(ldapAuth.isAutenticado()){
			
			Attribute atr = ldapAuth.cargarPropiedadConexion("cn");
			System.out.println(atr);
			try {
				correo = atr.get().toString();
			} catch (NamingException e) {
				e.printStackTrace();
				return sesion;
			}
			PersonaDao personaDao = new PersonaDao(MyBatisConnectionFactory.getSqlSessionFactory());
			idPersona = personaDao.consultarIdPersonaCorreo(correo);
			UsuarioDao usuarioDao = new UsuarioDao(MyBatisConnectionFactory.getSqlSessionFactory());
			Usuario admin = usuarioDao.consultarUsuarioPorIdPersona(idPersona);
			
			SesionDao sesionDao = new SesionDao(MyBatisConnectionFactory.getSqlSessionFactory());
			
			
			sesion.setId(idPersona);
			System.out.println("correo==="+correo);
			Double randonDouble = Math.random()*1000000000;
			Integer randonInteger= randonDouble.intValue();
			
			sesion.setToken(md5.MD5(randonInteger.toString()+correo));
			if (admin != null) {
				sesionDao.actualizarToken(sesion);
//				return sesion.getToken();
				return sesion;
			}
		}
		return sesion;
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
