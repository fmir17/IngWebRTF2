package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.util.exception.IWDaoException;

import co.edu.udea.iw.dto.PmPuntosmes;
import co.edu.udea.iw.dto.PmPuntosmesId;

/**
 * Interface del DAO correspondiente a la entidad Asegurado. Expresa las
 * operaciones que se implementaran en el DAO para otener informacion
 * relacionada con dicha entidad.
 * 
 * @author Alan Arboleda
 */
public interface PuntosMesDao {
	
	/**
	 * Metodo que permite consultar los puntos obtenidos por un usuario en un
	 * mes y anno determinado
	 * 
	 * @param id
	 *            - Parametro de tipo PmPuntosmesId que contiene el nombre del
	 *            jugador el mes y el anno
	 * @return Objeto del tipo PmPuntosmes que contiene la informacion de los
	 *         puntos que el usuario obtuvo en un mes y anno determinado
	 * 
	 *         Retorna null si el jugador no obtuvo puntos ese mes
	 */
	PmPuntosmes consultarPuntosMes(PmPuntosmesId id) throws IWDaoException;
	
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
	List<PmPuntosmes> consultarTablaEspecifica(int mes, int anno) throws IWDaoException;
	
	/**
	 * Metodo que permite actualizar los puntos del mes de un
	 * jugador especifico
	 * 
	 * @param pm
	 *            -Parametro de tipo PmPuntosmes que contiene la informacion
	 *            de los puntos de un mes y anno especificos obtenidos por un jugador
	 * 
	 * @throws IWDaoException
	 */
	void actualizarPuntosMes(PmPuntosmes pm) throws IWDaoException;
}