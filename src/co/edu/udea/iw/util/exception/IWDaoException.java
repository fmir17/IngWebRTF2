package co.edu.udea.iw.util.exception;

import org.apache.log4j.Logger;

/**
 * Excepcion creada para manejar las excepciones en la capa de acceso a datos
 * @author Alan Arboleda
 *
 */
public class IWDaoException extends Exception {

	Logger log = Logger.getLogger(IWDaoException.class);
	
	public IWDaoException() {
		super();
		log.error(this.getMessage(), this);
	}

	public IWDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		log.error(arg0, arg1);
	}

	public IWDaoException(String arg0) {
		super(arg0);
		log.error(arg0, this);
	}

	public IWDaoException(Throwable arg0) {
		super(arg0);
		log.error(arg0.getMessage(), arg0);
	}
	
	

}
