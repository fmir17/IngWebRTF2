	package co.edu.udea.iw.dao.impl;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.util.exception.IWDaoException;
/**
 * DAO correspondiente a la entidad UsUsuario. Permite realizar operaciones para
 * obtener informacion relacionada con dicha entidad.
 * 
 * @author Fredy Miranda
 */
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao {
	static Logger log = null;

	static {
		/**
		 * Clase de logging.
		 */
		log = Logger.getLogger(UsuarioDaoImpl.class);
		// Da la configuracion a la libreria log4j.
		BasicConfigurator.configure();
	}

	/**
	 * Metodo que permite verificar un usuario a traves de un nombre y usuario.
	 * 
	 * @return Retorna usuario correspondiente al nombre y password ingresado
	 * 
	 * @param nombre
	 *            -Parametro que indica el nombre del usuario
	 * @param password
	 *            -Parametro que indica la contraseña del usuario
	 * @throws IWDaoException
	 */
	@Override
	public UsUsuario verificarUsuario(String nombre, String password)
			throws IWDaoException {

		UsUsuario usuario = null;
		try {
			Session sesion = getSession();

			usuario = (UsUsuario) sesion.createCriteria(UsUsuario.class)
					.add(Restrictions.eq("usNombre", nombre))
					.add(Restrictions.eq("usPassword", password))
					.uniqueResult();
		} catch (HibernateException e) {
			log.error("error al verificar el usuario", e);
			throw new IWDaoException(e);
		}

		return usuario;
	}

	/**
	 * Metodo que permite crear un nuevo usuario
	 * 
	 * @param UsUsuario
	 *            -Parametro del Usuario a crear.
	 * @throws IWDaoException
	 */
	@Override
	public void crearNuevoUsuario(UsUsuario usuario) throws IWDaoException {
		Transaction tx = null;
		try {
			Session sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(usuario);
			tx.commit();
		} catch (HibernateException e) {
			log.error("error al crear el usuario", e);
			throw new IWDaoException(e);
		}

	}

	/**
	 * @see UsuarioDao#buscarUsuario(String)
	 */
	@Override
	public UsUsuario buscarUsuario(String nombre) throws IWDaoException {
		UsUsuario usuario = null;
		Session sesion = null;
		try {
			 sesion = getSession();

			usuario = (UsUsuario) sesion.createCriteria(UsUsuario.class)
					.add(Restrictions.eq("usNombre", nombre))
					.uniqueResult();
		} catch (HibernateException e) {
			log.error("error al validar el usuario", e);
			throw new IWDaoException(e);
		}

		return usuario;
	}

}
