package co.unal.sm.servicios;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;

import co.unal.sm.dao.PersonaDao;
import co.unal.sm.dao.UsuarioDao;
import co.unal.sm.dto.DatosAuth;
import co.unal.sm.dto.Usuario;
import co.unal.sm.ldap.LdapAuth;
import co.unal.sm.mybatis.MyBatisConnectionFactory;

public class AutenticacionServicio {

	public Boolean AutenticarUsuario(DatosAuth datosAuth) {

		System.out.println("Iniciando Autenticacion");

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
				return false;
			}
			PersonaDao personaDao = new PersonaDao(MyBatisConnectionFactory.getSqlSessionFactory());
			idPersona = personaDao.consultarIdPersona(identificacion);
			UsuarioDao usuarioDao = new UsuarioDao(MyBatisConnectionFactory.getSqlSessionFactory());
			Usuario admin = usuarioDao.consultarUsuarioPorIdPersona(idPersona);
			if (admin != null) {
				return true;
			}
		}
		return false;
	}
}
