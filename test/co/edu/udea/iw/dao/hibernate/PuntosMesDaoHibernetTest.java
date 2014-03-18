/**
 * 
 */
package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import co.edu.udea.iw.dao.PuntosMesDao;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.PmPuntosmes;
import co.edu.udea.iw.dto.PmPuntosmesId;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * @author Alan Arboleda
 *
 */
public class PuntosMesDaoHibernetTest {

	@Test
	public void consultarPuntosMes() {
		try {
			PmPuntosmesId id = new PmPuntosmesId();
			UsUsuario test = new UsUsuario();
			test.setUsNombre("Alan");
			id.setUsAnno(2013);
			id.setUsMes(1);
			id.setUsuario(test);
			
			PuntosMesDao dao = new PuntosMesDaoHibernate();
			PmPuntosmes puntosMes = dao.consultarPuntosMes(id);
			System.out.println("Señor usuario sus puntos son: "+ puntosMes.getUsPtos());
			if(50==puntosMes.getUsPtos()){
			Assert.assertTrue(true);
			}else Assert.assertTrue(false);

		} catch (IWDaoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void consultarTablaMes() {
		try {
			
			PuntosMesDao dao = new PuntosMesDaoHibernate();
			int mes = 1;
			int anno = 2013;
			List<PmPuntosmes> lista = dao.consultarTablaEspecifica(mes, anno);
				System.out.println("Esta es la tabla de posiciones del mes " + mes + " del anno " + anno);
			for(PmPuntosmes pm : lista){
				System.out.println("Nombre: " + pm.getId().getUsuario().getUsNombre());
				System.out.println("puntos: " + pm.getUsPtos());
				
				System.out.println("*******************************************************************");
			}
		} catch (IWDaoException e) {
			e.printStackTrace();
		}
	}
}
