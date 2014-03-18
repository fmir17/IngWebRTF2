package co.edu.udea.iw.bl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.UsUsuario;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
/**
 * Prueba de las funcionalidades para partido
 * @author Fredy Miranda
 * 
 */
public class UsuarioBLImplTest {
	@Autowired
	UsuarioBL usuarioBL;

	/**
	 * Prueba para la funcionalidad guardar usuario
	 * @author Fredy Miranda
	 * 
	 */
	@Test
	public void testGuardar() {
		try {
			usuarioBL.crearNuevoUsuario("Frefre5", "ingweb",
					"fre.fre@gmail.com", "Jug");
			assertTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Prueba para la funcionalidad autenticar Usuario
	 * @author Fredy Miranda
	 * 
	 */
	@Test
	public void testAutenticarUsuario(){
		
		try {
			usuarioBL.verificarUsuario("Frefre3", "ingweb");
			assertTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Prueba para la funcionalidad buscar Uusario
	 * @author Alan Arboleda
	 * 
	 */
	@Test
	public void testbuscar(){
		String nombre = "Alan";
		UsUsuario alan;
		try {
			alan = usuarioBL.buscarUsuario(nombre);
			System.out.println("correo " + alan.getUsEmail());
			assertTrue(true);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
