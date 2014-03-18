package co.edu.udea.iw.bl.impl;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Clase que implementa metodos de la interfaz UsuarioBL de la capa de logica de
 * negocio, correspondiente ala funcionalidad para Usuario
 * 
 * @author Fredy Miranda
 */
public class UsuarioBLImpl implements UsuarioBL {
	static Logger log = null;
	UsuarioDao usuarioDAO;

	public UsuarioDao getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDao usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	static {

		/**
		 * Clase de logging.
		 */
		log = Logger.getLogger(UsuarioBLImpl.class);
		// Da la configuracion a la libreria log4j.
		BasicConfigurator.configure();
	}

	/**
	 * @see UsuarioBL#verificarUsuario(String, String)
	 */
	@Override
	public UsUsuario verificarUsuario(String nombre, String password)
			throws IWDaoException, IWBLException {
		if (nombre == null || "".equals(nombre))
			throw new IWBLException(
					"El nombre del cliente no puede ser un valor nulo o vacio");
		if (password == null || "".equals(password))
			throw new IWBLException(
					"El password del cliente no puede ser un valor nulo o vacio");
		UsUsuario usuario = usuarioDAO.verificarUsuario(nombre, password);

		return usuario;
	}

	/**
	 * @see UsuarioBL#crearNuevoUsuario(UsUsuario)
	 */
	@Override
	public void crearNuevoUsuario(String nombre, String password,
			String correo, String tipo) throws IWDaoException, IWBLException {

		if (nombre == null || "".equals(nombre))
			throw new IWBLException(
					"El nombre del cliente no puede ser un valor nulo o vacio");
		if (password == null || "".equals(password))
			throw new IWBLException(
					"El password del cliente no puede ser un valor nulo o vacio");
		//if (usuarioDAO.buscarUsuario(nombre)==true)
		if (usuarioDAO.buscarUsuario(nombre)!=null)
			throw new IWBLException("El usuario con nombre: '"+nombre+"' ya existe en la base de datos");
		if (correo == null || "".equals(correo))
			throw new IWBLException(
					"El correo del cliente no puede ser un valor nulo o vacio");
		if (tipo == null || "".equals(tipo))
			throw new IWBLException(
					"El tipo del cliente no puede ser un valor nulo o vacio");
		if (!("Jug".equals(tipo) || "Admo".equals(tipo)))
			throw new IWBLException(
					"El tipo de Usuario deber ser 'Jug' o Admo'");

		UsUsuario usuario = new UsUsuario(nombre, correo, password, tipo);

		usuarioDAO.crearNuevoUsuario(usuario);

	}
	
	/**
	 * @throws IWBLException 
	 * @see UsuarioBL#buscarUsuario(String)
	 */
	@Override
	public UsUsuario buscarUsuario(String nombre) throws IWDaoException, IWBLException{
		if (nombre == null || "".equals(nombre))
			throw new IWBLException(
					"El nombre del jugador no puede ser un valor nulo o vacio");
		return usuarioDAO.buscarUsuario(nombre);
	}

}
