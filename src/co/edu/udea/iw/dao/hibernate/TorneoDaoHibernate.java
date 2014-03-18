package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dao.TorneoDao;
import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.dto.ToTorneo;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * DAO correspondiente a la entidad ToTorneo. Permite realizar operaciones para
 * obtener informacion relacionada con dicha entidad.
 * 
 * @author Maicol Giraldo
 */
public class TorneoDaoHibernate implements TorneoDao{
	@Override
	public List<ToTorneo> obtenerTorneos() throws IWDaoException {
		
		List<ToTorneo> torneos = new ArrayList<ToTorneo>();
		Session sesion = null;
		try{
			sesion = HibernateSessionFactory.getInstance().getSession();
			torneos= sesion.createCriteria(ToTorneo.class).list();
		}catch (HibernateException e) {
			throw new IWDaoException(e);
			
			}
			finally {

				if(sesion != null){				
					sesion.close();
			}
		}
		
		return torneos;
	}
}
