package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dao.PuntosMesDao;
import co.edu.udea.iw.dto.PmPuntosmes;
import co.edu.udea.iw.dto.PmPuntosmesId;
import co.edu.udea.iw.util.exception.IWDaoException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * DAO correspondiente a la entidad Puntosmes. Permite realizar operaciones para
 * obtener informacion relacionada con dicha entidad.
 * 
 * @author Alan Arboleda
 */

public class PuntosMesDaoHibernate implements PuntosMesDao {

	static Logger log = null;

	static {
		/**
		 * Clase de logging.
		 */
		log = Logger.getLogger(PuntosMesDaoHibernate.class);
		// Da la configuracion a la libreria log4j.
		BasicConfigurator.configure();
	}

	/**
	 * Metodo que permite consultar los puntos obtenidos por un usuario en un
	 * mes y anno determinado
	 * 
	 * @param id
	 *            - Parametro de tipo PmPuntosmesId que contiene el nombre del
	 *            jugador el mes y el anno
	 * @return Objeto del tipo PmPuntosmes que contiene la informacion de los
	 *         puntos que el usuario obtuvo en un mes y anno determinado
	 * 
	 *         Retorna null si el jugador no obtuvo puntos ese mes
	 * @throws IWDaoException
	 */
	@Override
	public PmPuntosmes consultarPuntosMes(PmPuntosmesId id)
			throws IWDaoException {
		Session sesion = null;
		log.debug("obteniendo los puntos del mes del id: " + id);
		PmPuntosmes puntosMes = null;
		try {

			sesion = HibernateSessionFactory.getInstance().getSession();
			puntosMes = (PmPuntosmes) sesion.get(
					"co.edu.udea.iw.dto.PmPuntosmes", id);

		} catch (HibernateException e) {
			log.error("error al obtener los puntos del mes y anno", e);
			throw new IWDaoException(e);
		}
		return puntosMes;

	}

	/**
	 * Metodo que permite consultar los puntos de todos los jugadores de un mes
	 * y año determinado
	 * 
	 * @param mes
	 *            -Parametro de tipo int que hace referencia al mes a consultar
	 * @param anno
	 *            -Parametro de tipo int que hace referencia al anno a consultar
	 * @return Lita de objetos del tipo PmPuntosmes que contiene la informacion de los
	 *         puntos de los jugadores de un mes y anno determinado
	 * 
	 * @throws IWDaoException
	 */
	@Override
	public List<PmPuntosmes> consultarTablaEspecifica(int mes, int anno)
			throws IWDaoException {
		Session sesion = null;
		List<PmPuntosmes> puntosMes = new ArrayList<PmPuntosmes>();
		List<PmPuntosmes> tabla = new ArrayList<PmPuntosmes>();
		try {

			sesion = HibernateSessionFactory.getInstance().getSession();
			puntosMes = sesion.createCriteria(PmPuntosmes.class).list();

			for (PmPuntosmes pm : puntosMes) {
				if (pm.getId().getUsMes() == mes
						&& pm.getId().getUsAnno() == anno) {
					tabla.add(pm);
				}
			}

		} catch (HibernateException e) {
			log.error(
					"error al obtener la tabla de posiciones del mes y anno seleccionados",
					e);
			throw new IWDaoException(e);
		}
		return tabla;

	}
}

