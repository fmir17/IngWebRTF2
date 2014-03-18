package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;
import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PrPronostico;
/**
 * Interfaz de la capa de logica de negocio, correspondiente a la funcionalidad para los
 * partidos
 * @author Fredy Miranda
 */
public interface PartidoBL {
	/**
	 * Metodo que permite Listar todos los partidos
	 * 
	 * @return Lista de objetos de tipo PaPartido que contiene la informacion de
	 *         los partidos
	 * 
	 * @throws IWDaoException
	 * @throws IWBLException
	 */
	public List<PaPartido> obtenerPartidos() throws IWDaoException,
			IWBLException;


	/**
	 * Metodo que permite buscar un partido por su id.
	 * 
	 * @param idEquipoLocal
	 *            - Nro entero que identifica al equipo local
	 * @param idEquipoVisitante
	 *            - Nro entero que identifica al equipo visitante
	 * @param fechaPartido
	 *            - Fecha en que los equipos juegan el partido
	 * @return Retorna el partido de los equipos ingresados en la fecha
	 *         ingresada
	 * 
	 * @throws IWDaoException
	 * @throws IWBLException
	 */
	public PaPartido obtenerPartido(int idEquipoLocal, int idEquipoVisitante,
			Date fechaPartido) throws IWDaoException, IWBLException;
	
	/**
	 * Consultar la oferta de partidos del mes
	 * @param 
	 * 		-mes Campo mes necesario para saber los partidos de un determinado mes
	 * 
	 * @return Lista de objetos de tipo PaPartido que contiene la informacion de
	 *         los partidos y que cumplen con el parametro mes.
	 *         
	 * @throws IWDaoException
	 * @throws IWBLException
	 */
	public List<PaPartido> consultarOferta(int mes) throws IWDaoException, IWBLException;
	
	/**
	 * Metodo que permite registrar un nuevo partido a disputar
	
 	 * @param idEquipoLoc
	 * 			-Parametro que indica el id del equipo local que juega el partido
	 * @param idEquipoVis
	 * 			-Parametro que indica el id del equipo visitante que juega el partido
	 * @param fechaPartido
	 * 			-Parametro que indica la fecha en la que se disputará el partido
	 * @param horaPartido
	 * 			-Parametro que indica la hora que se disputara el partido
	 * @param idTorneo
	 * 			-Parametro que indica a cual torneo corresponde el partido
	 * 
	 * @throws IWDaoException
	 * @throws IWBLException
	 */
	public void registrarNuevoPartido(int idEquipoLoc,int idEquipoVis, Date fechaPartido, Date horaPartido, int idTorneo) 
			throws IWDaoException, IWBLException;
	
	
	/**
	 * Metodo que permite registrar el marcador de un partido disputado
 	 * @param idEquipoLoc
	 * 			-Parametro que indica el id del equipo local que juega el partido
	 * @param idEquipoVis
	 * 			-Parametro que indica el id del equipo visitante que juega el partido
	 * @param fechaPartido
	 * 			-Parametro que indica la fecha en la que se disputará el partido
	 * @param golesLocal
	 * 			-Parametro que indica la cantidad de goles del equipo local
	 * @param golesVisitante
	 * 			-Parametro que indica la cantidad de goles del equipo visitante
	 * 
	 * @throws IWDaoException
	 * @throws IWBLException
	 */
	public void registrarMarcador(int idEquipoLoc, int idEquipoVis,
			Date fechaPartido,int golesLocal,int golesVisitante)	throws IWDaoException, IWBLException;
	
	/**
	 * Establece puntos a un jugador que realizó un determinado pronostico
	 *  @param partido
	 *  		- Partido con un resultado final
	 *  @param pronostico
	 *  		- Pronostico de un usuario
	 *  @throws IWDaoException
	 *  @throws IWBLException
	 */
	public void actualizarJugadorPuntos(PaPartido partido,
			PrPronostico pronostico)throws IWDaoException, IWBLException;
}

