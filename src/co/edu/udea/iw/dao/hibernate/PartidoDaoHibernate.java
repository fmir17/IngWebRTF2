package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dao.PartidoDao;
import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PaPartidoId;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * DAO correspondiente a la entidad PaPartido. Permite realizar operaciones para
 * obtener informacion relacionada con dicha entidad.
 * 
 * @author Fredy Miranda
 */
public class PartidoDaoHibernate implements PartidoDao {
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
	 * Metodo que permite Listar todos los partidos
	 * 
	 * @return Lista de objetos de tipo PaPartido que contiene la informacion de
	 *         los partidos
	 * 
	 * @throws IWDaoException
	 */
	@Override
	public List<PaPartido> obtenerPartidos() throws IWDaoException {

		List<PaPartido> partidos = new ArrayList<PaPartido>();
		Session sesion = null;
		try {
			sesion = HibernateSessionFactory.getInstance().getSession();
			partidos = sesion.createCriteria(PaPartido.class).list();
		} catch (HibernateException e) {
			log.error("error al obtener los partidos", e);
			throw new IWDaoException(e);

		} 
		return partidos;
	}

	/**
	 * Metodo que permite registrar el marcador de un partido
	 * 
	 * @param id
	 * 			- Parametro para identificar un partido
	 * @param golLocal
	 * 			- Parametro que indica la cantidad de goles del equipo local
	 * @param golVis
	 * 			- Parametro que indica la cantidad de goles del equipo Visitante
	 * 
	 * @throws IWDaoException
	 */

	@Override
	public void registrarMarcador(PaPartidoId id, int golLocal, int golVis)
			throws IWDaoException {
		Session sesion = null;
		Transaction tx = null;
		PaPartido partido;
		try {

			sesion = HibernateSessionFactory.getInstance().getSession();
			tx = sesion.beginTransaction();
			partido = obtenerPartido(id);
			partido.setPaNroGolLoc(golLocal);
			partido.setPaNroGolVis(golVis);
			sesion.update(partido);
			tx.commit();

		} catch (HibernateException e) {
			log.error("error al registrar el marcador", e);
			throw new IWDaoException(e);
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

	/**
	 * Metodo que permite buscar un partido por su id.
	 * 
	 * @param 
	 * 		-id campo para obtener un partido inequivocamente 
	 * @return Retorna el partido con el id ingresado
	 * 
	 * @throws IWDaoException
	 */
	@Override
	public PaPartido obtenerPartido(PaPartidoId id) throws IWDaoException {
		Session sesion = null;
		PaPartido partido = null;
		try {

			sesion = HibernateSessionFactory.getInstance().getSession();
			partido = (PaPartido) sesion
					.get("co.edu.udea.iw.dto.PaPartido", id);
		} catch (HibernateException e) {
			log.error("error al obtener partido", e);
			throw new IWDaoException(e);
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return partido;
	}

	/**
	 * Consultar la oferta de partidos del mes
	 * @param 
	 * 		-mes Campo mes necesario para saber los partidos de un determinado mes
	 * 
	 * @return Lista de objetos de tipo PaPartido que contiene la informacion de
	 *         los partidos y que cumplen con el parametro mes.
	 *         
	 * @throws IWDaoException
	 * 
	 */
	public List<PaPartido> consultarOferta(int mes) throws IWDaoException {
		List<PaPartido> partidos = new ArrayList<PaPartido>();

		partidos = obtenerPartidos();
		/*
		 * Filtrar partidos para entregar los de determinado mes
		 */
		Iterator i = partidos.iterator();
		List<PaPartido> partidosMes = new ArrayList<PaPartido>();
		while (i.hasNext()) {
			PaPartido partido = (PaPartido) i.next();
			int mesPartido = partido.getPaMes();
			if (mesPartido == mes) {
				partidosMes.add(partido);
			}

		}
		return partidosMes;
	}

}
