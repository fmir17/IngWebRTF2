package co.edu.udea.iw.util.properties;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Va a tomar la informaci�n de configuraci�n desde el archivo de propiedades del DAO
 * @author Elver Suarez Alzate
 *
 */
public class LeerPropiedades {
	
	ResourceBundle bundle = null;
	
	private final static String PROPIEDADES_NOMBRE = "co.edu.udea.iw.util.properties.configuracion";
	public final static String PROPIEDADES_URL = "conexion.url";
	public final static String PROPIEDADES_NOMBRE_USUARIO = "conexion.usuario";
	public final static String PROPIEDADES_PASSWORD = "conexion.pws";
	
	public LeerPropiedades() throws IWDaoException{
		try{
			bundle = ResourceBundle.getBundle(PROPIEDADES_NOMBRE);
		}catch (MissingResourceException e) {
			throw new IWDaoException("El archivo " + PROPIEDADES_NOMBRE + " no existe");
		}
	}
	
	/**
	 * Entrega el valor de la url de la base de datos a la que nos conectaremos
	 * @return
	 * @throws IWDaoException
	 */
	public String getDato(String clave) throws IWDaoException{
		try{
			return bundle.getString(clave);
		}catch (MissingResourceException e) {
			throw new IWDaoException("La clave " + clave + " no existe en el archivo");
		}
	}

}
