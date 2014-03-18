package co.edu.udea.iw.bl.impl;

import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import co.edu.udea.iw.bl.TorneoBL;
import co.edu.udea.iw.dao.TorneoDao;
import co.edu.udea.iw.dto.ToTorneo;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Clase que implementa  metodos de la interfaz TorneoBL de la capa de logica de negocio, 
 * correspondiente a la funcionalidad de la entidad ToTorneo
 * @author Maicol Giraldo
 */
public class TorneoBLImpl implements TorneoBL {
	
	TorneoDao torneoDao;
	static Logger log = null;
	static {

		/**
		 * Clase de logging.
		 */
		log = Logger.getLogger(UsuarioBLImpl.class);
		// Da la configuracion a la libreria log4j.
		BasicConfigurator.configure();
	}
	
	/**
	 * @see TorneoBL#obtenerTorneoPorId(int)
	 */
	@Override
	public ToTorneo obtenerTorneoPorId(int toId) throws IWDaoException,
			IWBLException {
		return torneoDao.obtenerTorneoPorId(toId);
	}	
	
	/**
	 * @see TorneoBL#obtener()
	 */
	@Override
	public List<ToTorneo> obtener() throws IWDaoException {
		return torneoDao.obtenerTorneos();
	}
	
	public TorneoDao getEquipoDao(){
		return torneoDao;
	}
	
	public void setTorneoDao(TorneoDao torneoDao){
		this.torneoDao = torneoDao;
	}

}
