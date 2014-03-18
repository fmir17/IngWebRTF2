package co.edu.udea.iw.bl;

import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Interfaz de la capa de logica de negocio, correspondiente ala funcionalidad para Usuario
 * 
 * @author Fredy Miranda
 */
public interface UsuarioBL {
	/**
	 * Metodo que permite verificar un usuario a traves de un nombre y usuario.
	 * 
	 * @return Retorna usuario correspondiente al nombre y password ingresado
	 * 
	 * @param nombre
	 * 			-Parametro que indica el nombre del usuario
	 * @param password
	 * 			-Parametro que indica la contraseña del usuario
	 * @throws IWDaoException
	 */
	public UsUsuario verificarUsuario(String nombre, String password) 
			throws IWDaoException, IWBLException;
	
	/**
	 * Metodo que permite crear un nuevo usuario
	
 	 * @param nombre
	 * 			-Parametro que indica el nombre del usuario
	 * @param password
	 * 			-Parametro que indica la contraseña del usuario
	 * @param correo
	 * 			-Parametro que indica el correo del usuario
	 * @param tipo Usuario
	 * 			-Parametro que indica el tipo de usuario
	 * @throws IWDaoException
	 */
	
	public void crearNuevoUsuario(String nombre,String password, String correo, String tipo) 
			throws IWDaoException, IWBLException ;
	
	/**
	 * Metodo para buscar un usuario por su clave primaria (nombre)
	 * 
	 * @param nombre
	 *            -Nombre del usuario a buscar
	 * @return UsUsuario -Retorna un objeto tipo UsUsuario que contiene la
	 *         informacion del jugador
	 * @throws IWDaoException
	 */
	public UsUsuario buscarUsuario(String nombre) throws IWDaoException, IWBLException;
}
