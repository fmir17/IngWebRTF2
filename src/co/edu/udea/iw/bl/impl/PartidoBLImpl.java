package co.edu.udea.iw.bl.impl;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import co.edu.udea.iw.bl.PartidoBL;
import co.edu.udea.iw.bl.PuntosMesBL;
import co.edu.udea.iw.dao.EquipoDao;
import co.edu.udea.iw.dao.PartidoDao;
import co.edu.udea.iw.dao.PronosticoDao;
import co.edu.udea.iw.dao.PuntosMesDao;
import co.edu.udea.iw.dao.TorneoDao;
import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PaPartidoId;
import co.edu.udea.iw.dto.PmPuntosmes;
import co.edu.udea.iw.dto.PmPuntosmesId;
import co.edu.udea.iw.dto.PrPronostico;
import co.edu.udea.iw.dto.ToTorneo;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Clase que imlementa la interfaz de la capa de logica de negocio,
 * correspondiente a la funcionalidad para los partidos
 * 
 * @author Fredy Miranda
 */
public class PartidoBLImpl implements PartidoBL {
	static Logger log = null;
	PartidoDao partidoDAO;
	EquipoDao equipoDao;
	TorneoDao torneoDao;
	PronosticoDao pronosticoDao;
	PuntosMesDao puntosMesDao;
	PuntosMesBL puntosMesBL;

	int puntosAciertoTotal = 10;
	int puntosAciertoParcial = 5;
	
	public PuntosMesBL getPuntosMesBL() {
		return puntosMesBL;
	}

	public void setPuntosMesBL(PuntosMesBL puntosMesBL) {
		this.puntosMesBL = puntosMesBL;
	}
	

	public PuntosMesDao getPuntosMesDao() {
		return puntosMesDao;
	}

	public void setPuntosMesDao(PuntosMesDao puntosMesDao) {
		this.puntosMesDao = puntosMesDao;
	}

	public PronosticoDao getPronosticoDao() {
		return pronosticoDao;
	}

	public void setPronosticoDao(PronosticoDao pronosticoDao) {
		this.pronosticoDao = pronosticoDao;
	}

	public TorneoDao getTorneoDao() {
		return torneoDao;
	}

	public void setTorneoDao(TorneoDao torneoDao) {
		this.torneoDao = torneoDao;
	}

	public void setPartidoDAO(PartidoDao partidoDAO) {
		this.partidoDAO = partidoDAO;
	}

	public PartidoDao getPartidoDao() {
		return partidoDAO;
	}

	public EquipoDao getEquipoDao() {
		return equipoDao;
	}

	public void setEquipoDao(EquipoDao equipoDao) {
		this.equipoDao = equipoDao;
	}

	static {
		/**
		 * Clase de logging.
		 */
		log = Logger.getLogger(PartidoBLImpl.class);
		// Da la configuracion a la libreria log4j.
		BasicConfigurator.configure();
	}

	/**
	 * @see PartidoBL#obtenerPartidos()
	 * 
	 */
	@Override
	public List<PaPartido> obtenerPartidos() throws IWDaoException,
			IWBLException {

		List<PaPartido> partidos = partidoDAO.obtenerPartidos();
		return partidos;
	}

	/**
	 * @see PartidoBL#obtenerPartido(int, int, Date)
	 * 
	 */
	@Override
	public PaPartido obtenerPartido(int idEquipoLocal, int idEquipoVisitante,
			Date fechaPartido) throws IWDaoException, IWBLException {

		/**
		 * Validamos la entrada de datos
		 */
		if (idEquipoLocal < 0)
			throw new IWBLException("El id debe ser positivo");
		if (idEquipoVisitante < 0)
			throw new IWBLException("El id debe ser positivo");
		if (fechaPartido == null)
			throw new IWBLException("La fecha no puede ser nula");
		EqEquipo equipoLocal = null;
		EqEquipo equipoVisitante = null;
		PaPartido partido = null;
		/**
		 * Obtenemos los Equipos
		 */
		equipoLocal = equipoDao.obtenerEquipoPorId(idEquipoLocal);
		if (equipoLocal == null) {
			throw new IWBLException(
					"El equipo referenciado con idLocal no se encuentra en la base de datos");
		}
		equipoVisitante = equipoDao.obtenerEquipoPorId(idEquipoVisitante);
		if (equipoVisitante == null)
			throw new IWBLException(
					"El equipo referenciado con idVisitante no se encuentra en la base de datos");
		// Formamos el id del partido
		PaPartidoId idPartido = new PaPartidoId();
		idPartido.setPaEqIdLocal(equipoLocal);
		idPartido.setPaEqIdVisitante(equipoVisitante);
		idPartido.setPaFecha(fechaPartido);

		partido = partidoDAO.obtenerPartido(idPartido);
		if (partido == null)
			throw new IWBLException(
					"Partido no se encuentra en la base de datos");
		return partido;

	}

	/**
	 * @see PartidoBL#consultarOferta(int)
	 */
	@Override
	public List<PaPartido> consultarOferta(int mes) throws IWDaoException,
			IWBLException {
		if (mes < 1 || mes > 12)
			throw new IWBLException(
					"El mes debe ser un numero entre 1 y 12, correspondiente al mes del año");
		List<PaPartido> partidos = partidoDAO.consultarOferta(mes);
		return partidos;
	}

	/**
	 * @see PartidoBL#registrarNuevoPartido(int, int, Date, Time, int)
	 */
	@Override
	public void registrarNuevoPartido(int idEquipoLoc, int idEquipoVis,
			Date fechaPartido, Date horaPartido, int idTorneo)
			throws IWDaoException, IWBLException {
		if (idEquipoLoc < 0)
			throw new IWBLException("El id debe ser positivo");
		if (idEquipoVis < 0)
			throw new IWBLException("El id debe ser positivo");
		if (fechaPartido == null)
			throw new IWBLException("La fecha no puede ser nula");
		if (horaPartido == null)
			throw new IWBLException("La hora no puede ser nula");
		if (idTorneo < 0)
			throw new IWBLException("El id debe ser positivo");

		EqEquipo equipoLocal = null;
		EqEquipo equipoVisitante = null;
		PaPartido partido = new PaPartido();
		ToTorneo torneo = null;
		/**
		 * Obtenemos los Equipos, y el torneo
		 */
		equipoLocal = equipoDao.obtenerEquipoPorId(idEquipoLoc);
		if (equipoLocal == null) {
			throw new IWBLException(
					"El equipo referenciado con idLocal no se encuentra en la base de datos");
		}
		equipoVisitante = equipoDao.obtenerEquipoPorId(idEquipoVis);
		if (equipoVisitante == null)
			throw new IWBLException(
					"El equipo referenciado con idVisitante no se encuentra en la base de datos");

		torneo = torneoDao.obtenerTorneoPorId(idTorneo);
		if (torneo == null)
			throw new IWBLException(
					"El torneo referenciado con idTorneo no se encuentra en la base de datos");

		// Se crea el id de paritido
		PaPartidoId idPartido = new PaPartidoId();
		idPartido.setPaEqIdLocal(equipoLocal);
		idPartido.setPaEqIdVisitante(equipoVisitante);
		idPartido.setPaFecha(fechaPartido);

		if (partidoDAO.obtenerPartido(idPartido) != null)
			throw new IWBLException(
					"El partido que se intenta ingresar ya se encuentra en la base de datos");

		partido.setToTorneo(torneo);
		partido.setPaHora(horaPartido);
		partido.setId(idPartido);

		partidoDAO.ingresarPartido(partido);

	}

	/**
	 * @see PartidoBL#registrarMarcador(int, int, Date, int, int)
	 */
	@Override
	public void registrarMarcador(int idEquipoLoc, int idEquipoVis,
			Date fechaPartido, int golesLocal, int golesVisitante)
			throws IWDaoException, IWBLException {
		if (idEquipoLoc < 0)
			throw new IWBLException("El id debe ser positivo");
		if (idEquipoVis < 0)
			throw new IWBLException("El id debe ser positivo");
		if (fechaPartido == null)
			throw new IWBLException("La fecha no puede ser nula");
		if (golesLocal < 0)
			throw new IWBLException(
					"la cantidad de goles debe ser positiva o 0");
		if (idEquipoVis < 0)
			throw new IWBLException(
					"la cantidad de goles debe ser positiva o 0");

		if (obtenerPartido(idEquipoLoc, idEquipoVis, fechaPartido) == null)
			throw new IWBLException("El partido no existe en la base de datos");

		EqEquipo equipoLocal = null;
		EqEquipo equipoVisitante = null;
		equipoLocal = equipoDao.obtenerEquipoPorId(idEquipoLoc);
		equipoVisitante = equipoDao.obtenerEquipoPorId(idEquipoVis);

		PaPartidoId idPartido = new PaPartidoId();
		idPartido.setPaEqIdLocal(equipoLocal);
		idPartido.setPaEqIdVisitante(equipoVisitante);
		idPartido.setPaFecha(fechaPartido);
		partidoDAO.registrarMarcador(idPartido, golesLocal, golesVisitante);

	}

	/**
	 *  @see PartidoBL#actualizarJugadorPuntos(PaPartido, PrPronostico)
	 */
	@Override
	public void actualizarJugadorPuntos(PaPartido partido,
			PrPronostico pronostico) throws IWDaoException, IWBLException {
		
		if (!partido.getId().equals(pronostico.getPaPartido().getId()))
			throw new IWBLException(
					"El partido que se quiere comparar con el pronostico no es el mismo");

		// Validar Acierto Total y enviar puntos
		if (partido.getPaNroGolLoc() == pronostico.getPrNroGolLoc()
				&& partido.getPaNroGolVis() == pronostico.getPrNroGolVis()) {
			puntosMesBL.actualizarPuntosMes(pronostico.getId().getPrUsNombre(),partido.getId().getPaFecha(),
					puntosAciertoTotal);
		}

		else {
			// Validar Ganador para Acierto Parcial
			if (partido.getPaNroGolLoc() > partido.getPaNroGolVis()
					&& pronostico.getPrNroGolLoc() > pronostico
							.getPrNroGolVis()) {
				puntosMesBL.actualizarPuntosMes(pronostico.getId().getPrUsNombre(),partido.getId().getPaFecha(),
						puntosAciertoParcial);
			}

		}
	}
}
