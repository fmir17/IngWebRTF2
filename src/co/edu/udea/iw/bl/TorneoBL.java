package co.edu.udea.iw.bl;

import java.util.List;

import co.edu.udea.iw.dto.ToTorneo;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Interfaz de la capa de logica de negocio, correspondiente 
 * a la funcionalidad para el dto Torneo
 * 
 * @author Maicol Giraldo
 */
public interface TorneoBL {
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
	
	/**
	 * Entrega todos los torneos que se encuentran almacenados en la base de
	 * datos.
	 * 
	 * @return Objeto del tipo List que contiene objetos del tipo ToTorneo
	 * 		   con la lista de los torneos que han sido almacenados en la base de datos
	 * @throws IWDaoException
	 */
	public List<ToTorneo> obtener() throws IWDaoException;
}
