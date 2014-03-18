package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.TorneoDao;
import co.edu.udea.iw.dto.ToTorneo;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * DAO correspondiente a la entidad ToTorneo. Permite realizar operaciones para
 * obtener informacion relacionada con dicha entidad.
 * 
 * @author Maicol Giraldo
 */
public class TorneoDaoImpl extends HibernateDaoSupport implements TorneoDao {
	@Override
	public List<ToTorneo> obtenerTorneos() throws IWDaoException {

		List<ToTorneo> torneos = new ArrayList<ToTorneo>();
		Session sesion = null;
		try {
			sesion = getSession();
			torneos = sesion.createCriteria(ToTorneo.class).list();
		} catch (HibernateException e) {
			throw new IWDaoException(e);

		}

		return torneos;
	}

	/**
	 * Entrega la informacion del torneo asociado la id ingresada
	 * 
	 * @param toId
	 *            -Parametro de tipo int que contiene el id del torneo a buscar
	 * 
	 * @return Objeto de tipo ToTorneo con la informacion del torneo
	 *         correspondiente al toId
	 * @throws IWDaoException
	 *             , IWBLException
	 */
	@Override
	public ToTorneo obtenerTorneoPorId(int toId) throws IWDaoException {

		ToTorneo torneo = null;
		try {
			Session sesion = getSession();

			torneo = (ToTorneo) sesion.createCriteria(ToTorneo.class)
					.add(Restrictions.eq("toId", toId)).uniqueResult();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return torneo;
	}

}
