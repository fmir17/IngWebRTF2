package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.bl.impl.PartidoBLImpl;
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
public class PartidoDaoImpl extends HibernateDaoSupport implements PartidoDao {
	static Logger log = null;
	Session sesion = null;
	static {
		/**
		 * Clase de logging.
		 */
		log = Logger.getLogger(PartidoBLImpl.class);
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
		try {
			sesion = getSession();
			partidos = sesion.createCriteria(PaPartido.class).list();
		} catch (HibernateException e) {
			log.error("error al obtener los partidos", e);
			throw new IWDaoException(e);

		}
		return partidos;
	}

	@Override
	public PaPartido obtenerPartido(PaPartidoId id) throws IWDaoException {
		Session sesion = null;
		PaPartido partido = null;
		try {

			sesion = getSession();
			partido = (PaPartido) sesion
					.get("co.edu.udea.iw.dto.PaPartido", id);
		} catch (HibernateException e) {
			log.error("error al obtener partido", e);
			throw new IWDaoException(e);
		}
		return partido;
	}

	/**
	 * Consultar la oferta de partidos del mes
	 * 
	 * @param -mes Campo mes necesario para saber los partidos de un determinado
	 *        mes
	 * 
	 * @return Lista de objetos de tipo PaPartido que contiene la informacion de
	 *         los partidos y que cumplen con el parametro mes.
	 * 
	 * @throws IWDaoException
	 * 
	 */
	@Override
	public List<PaPartido> consultarOferta(int mes) throws IWDaoException {

		
		List<PaPartido> partidosMes = new ArrayList<PaPartido>();
		
		try {
			sesion = getSession();
			String hql = "FROM PaPartido p WHERE MONTH(p.id.paFecha)="+mes ;
			Query query = sesion.createQuery(hql);
			partidosMes = query.list();
			
			} catch (HibernateException e) {
			log.error("error al obtener los partidos", e);
			throw new IWDaoException(e);
		}
		return partidosMes;
	}

	/**
	 * Metodo que permite registrar el marcador de un partido jugado
	 * 
	 * @param idPartido
	 *            -Id del partido a registrarle el marcador
	 * @param golesLocal
	 *            -Goles del equipo local
	 * @param golesVisitante
	 *            -Goles del equipo visitante
	 * @throws IWDaoException
	 * 
	 */
	@Override
	public void registrarMarcador(PaPartidoId idPartido, int golesLocal,
			int golesVisitante) throws IWDaoException {
		Session sesion = null;
		Transaction tx = null;
		PaPartido partido = new PaPartido();
		try {
			sesion = getSession();

			tx = sesion.beginTransaction();
			partido = obtenerPartido(idPartido);
			System.out.println(partido.getPaNroGolLoc());
			System.out.println(partido.getPaNroGolVis());
			partido.setPaNroGolLoc(golesLocal);
			partido.setPaNroGolVis(golesVisitante);
			sesion.update(partido);
			tx.commit();

		} catch (HibernateException e) {
			log.error("error al registrar el marcador", e);
			throw new IWDaoException(e);
		}
	}

	/**
	 * Metodo que permite registrar un nuevo partido
	 * 
	 * @param PaPartido
	 *            -Partido a guardar en la base de datos
	 * @throws IWDaoException
	 */
	@Override
	public void ingresarPartido(PaPartido partido) throws IWDaoException {
		Transaction tx = null;
		try {
			Session sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(partido);
			tx.commit();
		} catch (HibernateException e) {
			log.error("error al crear el partido", e);
			throw new IWDaoException(e);
		}
	}

}
