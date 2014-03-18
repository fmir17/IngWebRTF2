package co.edu.udea.iw.bl.impl;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import co.edu.udea.iw.bl.EquipoBL;
import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.dao.EquipoDao;
import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Clase que implementa  metodos de la interfaz EquipoBL de la capa de logica de negocio, 
 * correspondiente a la funcionalidad para EqEquipo
 * @author Alan Arboleda
 */
public class EquipoBLImpl implements EquipoBL{
	
	EquipoDao equipoDao;
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
	 * @see EquipoBL#obtenerEquipoPorId(int)
	 */
	@Override
	public EqEquipo obtenerEquipoPorId(int eqId) throws IWDaoException,
			IWBLException {
		return equipoDao.obtenerEquipoPorId(eqId);
	}

	/**
	 * @see EquipoBL#obtener()
	 */
	@Override
	public List<EqEquipo> obtener() throws IWDaoException {
		return equipoDao.obtener();
	}
	
	public EquipoDao getEquipoDao(){
		return equipoDao;
	}
	
	public void setEquipoDao(EquipoDao equipoDao){
		this.equipoDao = equipoDao;
	}
}
