package co.edu.udea.iw.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.PronosticoDao;
import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.dto.PaPartidoId;
import co.edu.udea.iw.dto.PrPronostico;
import co.edu.udea.iw.util.exception.IWDaoException;
/**
 * 
 */

/**
 * @author Maicol Giraldo
 *
 */
public class PronosticoDaoHibernateTest {

/**
 * Prueba para consultar pronostico
 */
	@Test
	public void consultarPronosticoUsuario() {
		try {

			String nomUsuario="Maicol";

			PronosticoDao dao = new PronosticoDaoHibernate();

			List<PrPronostico> lista = dao.consultarPronosticosUsuario(nomUsuario);

			System.out.println("Estos son los pronosticos realizados por " + nomUsuario);
			for(PrPronostico pu : lista){
				System.out.println("PARTIDO: " + pu.getPaPartido().getId().getPaEqIdLocal().getEqNombre()+
						"VS" + pu.getPaPartido().getId().getPaEqIdVisitante().getEqNombre());
				System.out.println("RESULTADO PRONOSTICADO: " + pu.getPrNroGolLoc()+ "---"+pu.getPrNroGolVis());

				System.out.println("*******************************************************************");
			} }catch (IWDaoException e) {

				e.printStackTrace();
			}
	}

	

	
	
}
