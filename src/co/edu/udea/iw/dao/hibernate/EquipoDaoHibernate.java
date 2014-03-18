package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import co.edu.udea.iw.dao.EquipoDao;

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;


import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * DAO correspondiente a la entidad EqEquipo. Permite realizar operaciones para
 * obtener informacion relacionada con dicha entidad.
 * 
 * @author Alan Arboleda
 */
public class EquipoDaoHibernate   implements  EquipoDao{
	
	/**
	 * Metodo que permite consultar todos los equipos
	 * 
	 * @return Lista de objetos de tipo EqEquipo que contiene la informacion de los
	 *         equipos
	 * 
	 * @throws IWDaoException
	 */
	@Override
	public List<EqEquipo> obtener() throws IWDaoException {
		
		List<EqEquipo> equipos = new ArrayList<EqEquipo>();
		Session sesion = null;
		try{
			sesion = HibernateSessionFactory.getInstance().getSession();
			equipos= sesion.createCriteria(EqEquipo.class).list();
		}catch (HibernateException e) {
			throw new IWDaoException(e);
			
			}
			finally {

				if(sesion != null){				
					sesion.close();
			}
		}	
		return equipos;
	}
	
	/**
	 * Entrega la informacion del equipo asociado la id ingresada
	 * 
	 * @param eqId
	 *            -Parametro de tipo int que contiene el id del equipo a buscar
	 *            
	 * @return Objeto de tipo EqEquipo con la informacion del equipo
	 *         correspondiente al eqId
	 * @throws IWDaoException
	 */
	@Override
	public EqEquipo obtenerEquipoPorId(int eqId) throws IWDaoException {
		
		EqEquipo equipo = null;
		try{
			Session sesion = HibernateSessionFactory.getInstance().getSession();
			
			equipo = (EqEquipo)sesion.createCriteria(EqEquipo.class)
							 .add(Restrictions.eq("eqId", eqId))
							 .uniqueResult();
		}catch (HibernateException e) {
			throw new IWDaoException(e);
		}
		
		return equipo;
	}
}
