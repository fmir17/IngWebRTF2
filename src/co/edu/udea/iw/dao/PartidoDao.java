package co.edu.udea.iw.dao;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PaPartidoId;
import co.edu.udea.iw.dto.PrPronostico;
import co.edu.udea.iw.util.exception.IWDaoException;

public interface PartidoDao {

	/**
	 * Entrega todos los partidos que se encuentran almacenados en la base de
	 * datos.
	 * 
	 * @return lista de Partidos
	 * @throws IWDaoException
	 */
	public List<PaPartido> obtenerPartidos() throws IWDaoException;

	/**
	 * Consulta un partido en la base de datos.
	 * 
	 * @throws IWDaoException
	 */
	public PaPartido obtenerPartido(PaPartidoId id) throws IWDaoException;

	/**
	 * Consultar la oferta de partidos del mes
	 * 
	 * @throws IWDaoException
	 */
	public List<PaPartido> consultarOferta(int mes) throws IWDaoException;

	/**
	 * Permite registrar el marcador de un partido
	 * 
	 * @throws IWDaoException
	 */
	public void registrarMarcador(PaPartidoId idPartido, int golesLocal,
			int golesVisitante) throws IWDaoException;

	/**
	 * Permite ingresar un nuevo partido
	 * 
	 * @throws IWDaoException
	 */
	public void ingresarPartido(PaPartido partido) throws IWDaoException;

}
