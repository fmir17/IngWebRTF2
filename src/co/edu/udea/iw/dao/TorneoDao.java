package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.ToTorneo;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;
/**
 * Define la funcionalidad a implementar en el DAO de Torneo
 * @author Alan Arboleda
 *
 */
public interface TorneoDao {
	/**
	 * Entrega todos los torneos que se encuentran almacenados en la base de datos.
	 * @return lista de torneos
	 * @throws IWDaoException
	 * @Maicol
	 */
	public List<ToTorneo> obtenerTorneos() throws IWDaoException;
	
	/**
	 * Entrega la informacion del torneo asociado la id ingresada
	 * 
	 * @param toId
	 *            -Parametro de tipo int que contiene el id del torneo a buscar
	 *            
	 * @return Objeto de tipo ToTorneo con la informacion del torneo
	 *         correspondiente al toId
	 * @throws IWDaoException , IWBLException
	 */
	public ToTorneo obtenerTorneoPorId(int toId) throws IWDaoException,IWBLException;
}
