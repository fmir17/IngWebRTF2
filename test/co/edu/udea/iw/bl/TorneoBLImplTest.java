package co.edu.udea.iw.bl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.ToTorneo;
import co.edu.udea.iw.util.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
/**
 * Prueba de las funcionalidades para los torneos
 * @author Maicol Giraldo
 * 
 */
public class TorneoBLImplTest {
	@Autowired
	TorneoBL torneoBL;
	/**
	 * Prueba para obtener todos los torneos registrados
	 *  en la base de datos
	 */
	@Test
	public void testObtener() {
		try {
			List<ToTorneo> listaTorneos = torneoBL.obtener();
			for (ToTorneo torneo : listaTorneos) {
				System.out.println("id: " + torneo.getToId());
				System.out.println("Torneo: " + torneo.getToNombre());
				System.out
						.println("***************************************************");
			}
			
			Assert.assertTrue(true);
		} catch (IWDaoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Prueba para obtener la informacion de un torneo determinado
	 */
	@Test
	public void testObtenerTorneoPorId() {
		ToTorneo torneo = null;
		int toId = 1;
		try {
			
			torneo = torneoBL.obtenerTorneoPorId(toId);
			System.out.println("La informacion del torneo es:");
			System.out.println("id: " + torneo.getToId());
			System.out.println("Torneo: " + torneo.getToNombre());
			System.out
					.println("***************************************************");

		} catch (IWDaoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
