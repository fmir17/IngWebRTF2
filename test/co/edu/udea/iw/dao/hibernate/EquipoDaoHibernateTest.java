package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.junit.Test;
import co.edu.udea.iw.util.exception.IWDaoException;
import co.edu.udea.iw.dao.EquipoDao;
import co.edu.udea.iw.dto.EqEquipo;

/**
 * Prueba de las funcionalidades de Equipo
 * 
 * @author Alan Arboleda
 * 
 */
public class EquipoDaoHibernateTest {

	/**
	 * Prueba para obtener todos los equipos existentes
	 */
	@Test
	public void testObtenerEquipos() {
		try {
			EquipoDao dao = new EquipoDaoHibernate();

			List<EqEquipo> listaEquipos = dao.obtener();
			for (EqEquipo equipo : listaEquipos) {
				System.out.println("id: " + equipo.getEqId());
				System.out.println("Nombre Equipo: " + equipo.getEqNombre());
				System.out
						.println("***************************************************");
			}
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
		EquipoDao dao = new EquipoDaoHibernate();
		EqEquipo equipo = null;
		int eqId = 1;
		try {
			equipo = dao.obtenerEquipoPorId(eqId);
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
