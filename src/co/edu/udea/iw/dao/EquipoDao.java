package co.edu.udea.iw.dao;

import java.util.List;
/**
 * Define la funcionalidad a implementar en el DAO de Cliente
 * @author Maicol
 *
 */
import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Define la funcionalidad a implementar en el DAO de Equipo
 * 
 * @author Alan Arboleda
 * 
 */
public interface EquipoDao {
	/**
	 * Entrega todos los equipos que se encuentran almacenados en la base de
	 * datos.
	 * 
	 * @return lista de equipos
	 * @throws IWDaoException
	 */
	public List<EqEquipo> obtener() throws IWDaoException;

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
	public EqEquipo obtenerEquipoPorId(int eqId) throws IWDaoException;
}
