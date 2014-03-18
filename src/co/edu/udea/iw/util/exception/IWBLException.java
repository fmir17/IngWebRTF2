package co.edu.udea.iw.util.exception;

import org.apache.log4j.Logger;

public class IWBLException extends Exception {

	Logger log = Logger.getLogger(getClass());

	public IWBLException() {
		log.error("Ocurrio un error en el sistema");
	}

	public IWBLException(String arg0) {
		super(arg0);
		log.error(arg0);
	}

	public IWBLException(Throwable arg0) {
		super(arg0);
		log.error("Ocurrio un error en el sistema", arg0);
	}

	public IWBLException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		log.error(arg0, arg1);
	}

	public IWBLException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		log.error(arg0, arg1);
	}

}
