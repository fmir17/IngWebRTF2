package co.edu.udea.iw.bl;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.util.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
/**
 * Prueba de las funcionalidades para los equipos
 * @author Alan Arboleda
 * 
 */
public class EquipoBLImplTest {
	@Autowired
	EquipoBL equipoBL;

	/**
	 * Prueba para obtener todos los equipos existentes
	 */
	@Test
	public void testObtener() {
		try {
			List<EqEquipo> listaEquipos = equipoBL.obtener();
			for (EqEquipo equipo : listaEquipos) {
				System.out.println("id: " + equipo.getEqId());
				System.out.println("Nombre Equipo: " + equipo.getEqNombre());
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
	 * Prueba para obtener la informacion de un equipo determinado
	 */
	@Test
	public void testObtenerEquipoPorId() {
		EqEquipo equipo = null;
		int eqId = 1;
		try {
			equipo = equipoBL.obtenerEquipoPorId(eqId);
			System.out.println("La informacion del equipo es:");
			System.out.println("id: " + equipo.getEqId());
			System.out.println("Nombre Equipo: " + equipo.getEqNombre());
			System.out
					.println("***************************************************");

		} catch (IWDaoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
