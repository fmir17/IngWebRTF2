package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.PuntosMesDao;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.PmPuntosmes;
import co.edu.udea.iw.dto.PmPuntosmesId;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * DAO correspondiente a la entidad Puntosmes. Permite realizar operaciones para
 * obtener informacion relacionada con dicha entidad.
 * 
 * @author Alan Arboleda
 */

public class PuntosMesDaoImpl extends HibernateDaoSupport implements PuntosMesDao {

	PuntosMesDao puntosMesDao;
	UsuarioDao usuarioDao;
	static Logger log = null;
	static {
		/**
		 * Clase de logging.
		 */
		log = Logger.getLogger(PuntosMesDaoImpl.class);
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
		log.debug("obteniendo los puntos del mes del jugador: " + id.getUsuario().getUsNombre());
		PmPuntosmes puntosMes = null;
		try {

			sesion = getSession();
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
		try {

			sesion = getSession();
			
			
			String hql = "FROM PmPuntosmes p WHERE p.id.usMes ="+mes +"and p.id.usAnno="+anno;
			Query query = sesion.createQuery(hql);
			puntosMes = query.list();
			
		} catch (HibernateException e) {
			log.error(
					"error al obtener la tabla de posiciones del mes y anno seleccionados",
					e);
			throw new IWDaoException(e);
		}
		return puntosMes;
	}
	
	/**
	 * @see PuntosMesDao#actualizarPuntosMes(PmPuntosmes)
	 */
	@Override
	public void actualizarPuntosMes(PmPuntosmes pm)
			throws IWDaoException {
		Transaction tx = null;
		try {
		Session sesion = getSession();
		tx = sesion.beginTransaction();
		System.out.println(pm.getId().getUsMes());
		sesion.saveOrUpdate(pm);
		tx.commit();
		} catch (HibernateException e) {
		log.error("error al actualizar los puntos del mes", e);
		throw new IWDaoException(e);
		}			
	}
}
