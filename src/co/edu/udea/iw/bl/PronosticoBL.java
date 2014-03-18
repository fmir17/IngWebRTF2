package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PrPronostico;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;
/**
 * Interfaz de la capa de logica de negocio, correspondiente a 
 * la funcionalidad para el dto PrPronostico
 *
 * @author Maicol Giraldo
 */
public interface PronosticoBL {
	/**
	 * Entrega todos los pronosticos que se encuentran almacenados en la base de datos para 
	 * un usuario.
	 * @return lista de Pronosticos
	 * @param usuario
	 * 			- usuario a quien se le consultara sus pronosticos	
	 * @throws IWDaoException
	 */
	public List<PrPronostico> consultarPronosticosUsuario(String usuario) throws IWDaoException,IWBLException;
	
	/**
	 * Entrega todos los pronosticos que se encuentran almacenados en la base de datos para 
	 * un partido determinado.
	 * @return  Pronostico realizado para dicho id
	 * @param idEquipoVisitante
	 * 			- Objeto del tipo int que contiene el id del equipo visitante
	 * @param idEquipoLocal
	 * 			- Objeto del tipo int que contiene el id del equipo local
	 * @param fechaPartido
	 * 			- Objeto del tipo Date que contiene la fecha del partido pronosticado
	 * 
	 * 
	 * @throws IWDaoException,IWBLException
	 */
	public List<PrPronostico> consultarPronosticosPartido(Date fechaPartido,int idEquipoLocal, int idEquipoVisitante) throws IWDaoException,IWBLException;
	
	/**
	 * Entrega el pronostico solicitado que se encuentra almacenado en la base de datos.
	 * 
	 * @return  Pronostico realizado para dicho id
	 * @param idVisitante
	 * 			- Objeto del tipo int que contiene el id del equipo visitante
	 * @param idLocal
	 * 			- Objeto del tipo int que contiene el id del equipo local
	 * @param PaFecha
	 * 			- Objeto del tipo Date que contiene la fecha del partido pronosticado
	 * @param nomUsuario
	 * 			- Objeto del tipo String que contiene lel nombre dle usuario que 
	 * 			  realizo el pronostico
	 * 
	 * 
	 * @throws IWDaoException,IWBLException
	 */
	public PrPronostico obtenerPronosticoPorId(int idVisitante,int idLocal,Date PaFecha,String nomUsuario) throws IWDaoException,IWBLException;
	
}
