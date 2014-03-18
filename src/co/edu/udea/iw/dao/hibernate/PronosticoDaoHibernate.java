package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dao.PronosticoDao;
import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PaPartidoId;
import co.edu.udea.iw.dto.PmPuntosmes;
import co.edu.udea.iw.dto.PrPronostico;
import co.edu.udea.iw.dto.PrPronosticoId;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.util.exception.IWDaoException;


/**
 * DAO correspondiente a la entidad Pronostico. Este DAO permite realizar 
 * operaciones para obtener informacion relacionada con dicha entidad.
 * 
 * @author Maicol Giraldo
 */
public class PronosticoDaoHibernate implements PronosticoDao{
	static Logger log = null;

	static {
		/**
		 * Clase de logging.
		 */
		log = Logger.getLogger(PronosticoDaoHibernate.class);
		// Da la configuracion a la libreria log4j.
		BasicConfigurator.configure();
	}
	
	/**
	 * Metodo que permite consultar la lista de los pronosticos realizados por un usuario
	 * @param usuario
	 *            - Parametro de tipo Strting que contiene el nombre del
	 *            jugador para el cual se quiere conocer la lista de los  partidos que ha pronosticado
	 * @return Objeto del tipo List<PrPronotico> que contiene la informacion de los
	 *        pronosticos que realizo el  jugador.
	 * 
	 *         Retorna null si el jugador no ha realizado ningun pronostico
	 *         	 * @throws IWDaoException excepcion capturada por el metodo
	 */	
		
	@Override
	public List<PrPronostico> consultarPronosticosUsuario(String usuario)
			throws IWDaoException {
		Session sesion = null;
		List<PrPronostico> pronosticos = new ArrayList<PrPronostico>();
		List<PrPronostico> prUsuario = new ArrayList<PrPronostico>();
		try {

			sesion = HibernateSessionFactory.getInstance().getSession();
			pronosticos = sesion.createCriteria(PrPronostico.class).list();

			for (PrPronostico pm : pronosticos) {
				String unNom =pm.getId().getPrUsNombre();
				if (unNom.equals(usuario)) {
					prUsuario.add(pm);
				}
			}

		} catch (HibernateException e) {
			log.error(
					"error al obtener los pronosticos realizados por"+usuario ,
					e);
			throw new IWDaoException(e);
		}
		return prUsuario;

	}
	
	
	/**
	 * Registra pronostico en la base de datos
	 * @param id
	 * 			-Id del partido
	 * @param golLocal
	 * 			-Goles del equipo local
	 * @param golVis
	 * 			-Goles del equipo Visitante
	 * @param usuario
	 * 			-campo que identifica al usuario
	 * @throws IWDaoException
	 */
	@Override
	public void registrarPronostico(PaPartidoId id,int golLocal, int golVis,String usuario) throws IWDaoException{
		Session sesion = null;
		Transaction tx = null;
		PrPronostico pronostico = new PrPronostico();
		PrPronosticoId pronosticoId = new PrPronosticoId();
		try{			
			sesion = HibernateSessionFactory.getInstance().getSession();
			tx = sesion.beginTransaction();
			pronosticoId.setPrPaEqIdLocal(id.getPaEqIdLocal().getEqId());
			pronosticoId.setPrPaEqIdVisitante(id.getPaEqIdVisitante().getEqId());
			pronosticoId.setPrPaFecha(id.getPaFecha());
			pronostico.setId(pronosticoId);
			pronostico.setPrNroGolLoc(golLocal);
			pronostico.setPrNroGolVis(golVis);			
			sesion.update(pronostico);
			tx.commit();
	
		}
		catch(HibernateException e){
			throw new IWDaoException(e);
		}
		finally{
			if(sesion !=null){
				sesion.close();
			}
		}
	}

}
