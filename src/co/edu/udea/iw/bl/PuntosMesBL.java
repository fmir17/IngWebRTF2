package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.PmPuntosmes;
import co.edu.udea.iw.dto.PmPuntosmesId;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Interfaz de la capa de logica de negocio, correspondiente a la funcionalidad para el dto PmPuntosmes
 *
 * @author Alan Arboleda
 */
public interface PuntosMesBL {
	/**
	 * Metodo que permite consultar los puntos obtenidos por un usuario en un
	 * mes y anno determinado
	 * 
	 * @param nombre
	 *            - Parametro de tipo String correspondiente al nombre del jugador
	 * @param mes
	 *            - Parametro de tipo int correspondiente al mes
	 * @param anno
	 *            - Parametro de tipo int correspondiente al anno
	 * @return Objeto del tipo PmPuntosmes que contiene la informacion de los
	 *         puntos que el usuario obtuvo en un mes y anno determinado
	 * 
	 *         Retorna null si el jugador no obtuvo puntos ese mes
	 */
	PmPuntosmes consultarPuntosMes(String nombre, int mes, int anno) throws IWDaoException, IWBLException;
	
	/**
	 * Metodo que permite consultar los puntos de todos los jugadores de un mes
	 * y anno determinado
	 * 
	 * @param mes
	 *            -Parametro de tipo int que hace referencia al mes a consultar
	 * @param anno
	 *            -Parametro de tipo int que hace referencia al anno a consultar
	 * @return Lita de objetos del tipo PmPuntosmes que contiene la informacion de los
	 *         puntos de los jugadores de un mes y anno determinado
	 * 
	 * @throws IWDaoException
	 */
	List<PmPuntosmes> consultarTablaEspecifica(int mes, int anno) throws IWDaoException, IWBLException;

	/**
	 * Metodo que permite actualizar los puntos del mes de un
	 * jugador especifico
	 * 
	 * @param nombre
	 *            -Parametro de tipo String que indica el nombre del jugador
	 *            al cual se le actualizara los puntos
	 * @param fecha
	 *            -Parametro de tipo date que hace referencia al
	 *            mes y al anno en los cuales actualizar los puntos
	 * @param puntos
	 * 			  -Parametro de tipo int que indica los puntos a añadir
	 * @return Lita de objetos del tipo PmPuntosmes que contiene la informacion de los
	 *         puntos de los jugadores de un mes y anno determinado
	 * 
	 * @throws IWDaoException, link IWBLException
	 */
	void actualizarPuntosMes(String nombre, Date fecha, int puntos) throws IWDaoException, IWBLException;
}