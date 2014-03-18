package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.TorneoDao;
import co.edu.udea.iw.dto.ToTorneo;
import co.edu.udea.iw.util.exception.IWDaoException;
/**
 * Prueba de las funcionalidades de Torneo
 * @author Maicol Giraldo
 *
 */
public class TorneoDaoHibernateTest {
	@Test
	public void testObtenerTorneos() {
		try{
			TorneoDao dao = new TorneoDaoHibernate();
			
			List<ToTorneo> listaTorneos= dao.obtenerTorneos();
			System.out.println("DATOS DEL TORNEO \n");
			for(ToTorneo torneo: listaTorneos){
				System.out.println("id: " + torneo.getToId());
				System.out.println("Nombre: " + torneo.getToNombre());
				System.out.println("URL Imagen: " + torneo.getToUriimagen() +"\n");
				
			}
		}catch (IWDaoException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
