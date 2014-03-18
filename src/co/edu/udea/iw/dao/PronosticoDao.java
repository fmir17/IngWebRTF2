package co.edu.udea.iw.dao;
import java.util.List;

import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PaPartidoId;
import co.edu.udea.iw.dto.PrPronostico;
import co.edu.udea.iw.dto.PrPronosticoId;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;
/**
 * Interface del DAO correspondiente a la entidad Pronostico. Expresa las
 * operaciones que se implementaran en el DAO para otener informacion
 * relacionada con dicha entidad.
 * 
 * @author Maicol Giraldo
 */
public interface PronosticoDao {

	/**
	 * Entrega todos los pronosticos que se encuentran almacenados en la base de datos para un usuario.
	 * @return lista de Pronosticos
	 * @param usuario
	 * 			- usuario a quien se le consultara sus pronosticos	
	 * @throws IWDaoException
	 */
	List<PrPronostico> consultarPronosticosUsuario(String usuario) throws IWDaoException;
	
	/**
	 * Registra pronostico en la base de datos
	 * @param id
	 * 			-Id del partido
	 * @param golLocal
	 * 			-Goles del equipo local
	 * @param golVis
	 * 			-Goles del equipo Visitante
	 * @param usuario
	 * 			-campo que identifica al usuario
	 * @throws IWDaoException
	 */
	void registrarPronostico(PaPartidoId id,int golLocal, int golVis,String usuario) throws IWDaoException;

	/**
	 * Entrega todos los pronosticos que se encuentran almacenados en la base de datos para 
	 * un partido determinado.
	 * @return lista de Pronosticos realizados para dicho partido
	 * @param partido
	 * 			- Objeto dle tipo PaPartido que contiene la informacion del partido paar consultar sus pronosticos	
	 * @throws IWDaoException,IWBLException
	 */
	List<PrPronostico> consultarPronosticosPartido(PaPartido partido) throws IWDaoException,IWBLException;
	
	
	/**
	 *  Entrega el pronostico solicitado que se encuentra almacenado en la base de datos.
	 *
	 * @return Pronostico solicitado
	 * @param idPronostico
	 * 			- Objeto dle tipo PrPronosticoId que contiene la informacion del id del
	 * 			  pronostico  a consultar	
	 * @throws IWDaoException,IWBLException
	 */
	PrPronostico consultarPronosticoPorId(PrPronosticoId idPronostico) throws IWDaoException,IWBLException;


}
