package co.edu.udea.iw.dao;

import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Define la funcionalidad a implementar en el DAO de Usuario
 * 
 * @author Fredy Miranda
 * 
 */
public interface UsuarioDao {
	/**
	 * Valida a un usuario con su contraseña y password
	 * 
	 * @see UsuarioBL#verificarUsuario(String,String)
	 * 
	 */
	public UsUsuario verificarUsuario(String nombre, String password)
			throws IWDaoException;

	/**
	 * Metodo para crear un nuevo usuario
	 * 
	 * @param usuario
	 * @throws IWDaoException
	 */
	public void crearNuevoUsuario(UsUsuario usuario) throws IWDaoException;

	/**
	 * Metodo para buscar un usuario por su clave primaria (nombre)
	 * 
	 * @param nombre
	 *            -Nombre del usuario a buscar
	 * @return UsUsuario -Retorna un objeto tipo UsUsuario que contiene la
	 *         informacion del jugador
	 * @throws IWDaoException
	 */
	public UsUsuario buscarUsuario(String nombre) throws IWDaoException;
}
