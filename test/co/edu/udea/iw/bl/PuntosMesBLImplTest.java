package co.edu.udea.iw.bl;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import co.edu.udea.iw.dto.PmPuntosmes;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracionSpring.xml")
/**
 * Prueba de las funcionalidades para los puntos de los meses
 * @author Alan Arboleda
 * 
 */
public class PuntosMesBLImplTest {
	@Autowired
	PuntosMesBL puntosMesBL;

	@Test
	public void testConsultarPuntosMes() throws IWBLException {
		try {
			String nombre = "Alan";
			int mes = 1;
			int anno = 2013;
			PmPuntosmes puntosMes = puntosMesBL.consultarPuntosMes(nombre, mes,
					anno);
			System.out.println("Sennor " + nombre + " sus puntos en el mes " + mes
					+ " de " + anno + " son: " + puntosMes.getUsPtos());
			if (50 == puntosMes.getUsPtos()) {
				Assert.assertTrue(true);
			} else
				Assert.assertTrue(false);

		} catch (IWDaoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConsultarTablaEspecifica() throws IWBLException {
		try {
			int mes = 1;
			int anno = 2013;
			List<PmPuntosmes> lista = puntosMesBL.consultarTablaEspecifica(mes,
					anno);
			System.out.println("Esta es la tabla de posiciones del mes " + mes
					+ " del anno " + anno);
			for (PmPuntosmes pm : lista) {
				System.out.println("Nombre: "
						+ pm.getId().getUsuario().getUsNombre());
				System.out.println("puntos: " + pm.getUsPtos());

				System.out
						.println("*******************************************************************");
			}
		} catch (IWDaoException e) {
			e.printStackTrace();
		}
	}

}
