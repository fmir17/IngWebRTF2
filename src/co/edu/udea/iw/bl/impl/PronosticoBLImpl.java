package co.edu.udea.iw.bl.impl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.bl.PronosticoBL;
import co.edu.udea.iw.dao.EquipoDao;
import co.edu.udea.iw.dao.PartidoDao;
import co.edu.udea.iw.dao.PronosticoDao;
import co.edu.udea.iw.dto.EqEquipo;
import co.edu.udea.iw.dto.PaPartido;
import co.edu.udea.iw.dto.PaPartidoId;
import co.edu.udea.iw.dto.PrPronostico;
import co.edu.udea.iw.dto.PrPronosticoId;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Clase que implementa metodos de la interfaz PronosticoBL de la capa de logica
 * de negocio, correspondiente a la funcionalidad para PrPronostico
 * 
 * @author Maicol Giraldo
 */
public class PronosticoBLImpl implements PronosticoBL {

	PronosticoDao pronosticoDao;
	PartidoDao partidoDAO;
	EquipoDao equipoDao;
	
	public EquipoDao getEquipoDao() {
		return equipoDao;
	}

	public void setEquipoDao(EquipoDao equipoDao) {
		this.equipoDao = equipoDao;
	}

	public PartidoDao getPartidoDao() {
		return partidoDAO;
	}

	public void setPartidoDao(PartidoDao partidoDAO) {
		this.partidoDAO = partidoDAO;
	}

	/**
	 * 
	 */
	@Override
	public List<PrPronostico> consultarPronosticosUsuario(String usuario)
			throws IWDaoException, IWBLException {
		if (usuario == null || "".equals(usuario))
			throw new IWBLException(
					"El nombre del jugador no puede ser un valor nulo o vacio");

		return pronosticoDao.consultarPronosticosUsuario(usuario);

	}

	@Override
	public List<PrPronostico> consultarPronosticosPartido(Date fechaPartido,
			int idEquipoLocal, int idEquipoVisitante) throws IWDaoException,
			IWBLException {
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

		PaPartidoId idPartido = new PaPartidoId();
		idPartido.setPaEqIdLocal(equipoLocal);
		idPartido.setPaEqIdVisitante(equipoVisitante);
		idPartido.setPaFecha(fechaPartido);

		partido = partidoDAO.obtenerPartido(idPartido);
		return pronosticoDao.consultarPronosticosPartido(partido);

	}

	public PronosticoDao getPronosticoDao() {
		return pronosticoDao;
	}

	public void setPronosticoDao(PronosticoDao pronosticoDao) {
		this.pronosticoDao = pronosticoDao;
	}

	@Override
	public PrPronostico obtenerPronosticoPorId(
			int idVisitante, int idLocal, Date fechaPartido, String nomUsuario)
			throws IWDaoException, IWBLException {
		
		if (idLocal < 0)
			throw new IWBLException("El id debe ser positivo");
		if (idVisitante < 0)
			throw new IWBLException("El id debe ser positivo");
		if (fechaPartido == null)
			throw new IWBLException("La fecha no puede ser nula");
		EqEquipo equipoLocal = null;
		EqEquipo equipoVisitante = null;
		PaPartido partido = null;

		/**
		 * Obtenemos los Equipos
		 */
		equipoLocal = equipoDao.obtenerEquipoPorId(idLocal);
		if (equipoLocal == null) {
			throw new IWBLException(
					"El equipo referenciado con idLocal no se encuentra en la base de datos");
		}
		equipoVisitante = equipoDao.obtenerEquipoPorId(idVisitante);
		if (equipoVisitante == null)
			throw new IWBLException(
					"El equipo referenciado con idVisitante no se encuentra en la base de datos");

		PaPartidoId idPartido = new PaPartidoId();
		idPartido.setPaEqIdLocal(equipoLocal);
		idPartido.setPaEqIdVisitante(equipoVisitante);
		idPartido.setPaFecha(fechaPartido);
		PrPronosticoId pr= new PrPronosticoId(); 
		partido = partidoDAO.obtenerPartido(idPartido);
		pr.setPaPartido(partido);
		pr.setPrPaEqIdLocal(idLocal);
		pr.setPrPaEqIdVisitante(idVisitante);
		pr.setPrPaFecha(fechaPartido);
		pr.setPrUsNombre(nomUsuario);
	
		return pronosticoDao.consultarPronosticoPorId(pr);

		
		
	
	}

}
