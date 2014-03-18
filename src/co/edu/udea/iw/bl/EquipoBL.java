package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Interfaz de la capa de logica de negocio, correspondiente a la funcionalidad para el dto Equipo
 * 
 * @author Alan Arboleda
 */
public interface EquipoBL {

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
	public EqEquipo obtenerEquipoPorId(int eqId) throws IWDaoException,IWBLException;
	
	/**
	 * Entrega todos los equipos que se encuentran almacenados en la base de
	 * datos.
	 * 
	 * @return lista de equipos
	 * @throws IWDaoException
	 */
	public List<EqEquipo> obtener() throws IWDaoException;
}
