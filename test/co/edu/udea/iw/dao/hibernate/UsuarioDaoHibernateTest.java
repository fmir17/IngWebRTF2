package co.edu.udea.iw.dao.hibernate;

import junit.framework.Assert;

import org.junit.Test;

import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Prueba de las funcionalidades de Usuario
 * @author Fredy Miranda
 * 
 */
public class UsuarioDaoHibernateTest {

	/**
	 * Prueba para verificar la existencia de un usuario a traves de su nombre y contraseña
	 */
	@Test
	public void testVerificarUsuario() {
		try {

			UsuarioDao dao = new UsuarioDaoHibernate();

			UsUsuario usuario = dao.verificarUsuario("Fredy", "9113207c1da37b6891004653f0d01da5");

			if (usuario != null) {
				System.out.println("DATOS DE USUARIO \n Nombre : " + usuario.getUsNombre()
						+ "\n Tipo: " + usuario.getUsTipo()
						+ "\n Email: " + usuario.getUsEmail());
				
				Assert.assertTrue(true);
			}
			else Assert.assertTrue(false);
		} catch (IWDaoException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prueba para ingresar un nuevo usuarios
	 */
	@Test
	public void registrarUsuario(){
		//Iniciamos valores a ingresar
		UsUsuario usuario= new UsUsuario();
		usuario.setUsEmail("MiEmail.com");
		usuario.setUsNombre("Prueba1");
		usuario.setUsPassword("12345");
		usuario.setUsTipo("Jug");
		
		//Creamos Dao para usar el metodo de guardar
		UsuarioDao dao = new UsuarioDaoHibernate();
		
		try {
			dao.crearNuevoUsuario(usuario);
			System.out.println("EL USUARIO HA SIDO CREADO SATISFACTORIAMENTE. " );
			
		} catch (IWDaoException e) {
			e.printStackTrace();
		}
		
		
	}
}
