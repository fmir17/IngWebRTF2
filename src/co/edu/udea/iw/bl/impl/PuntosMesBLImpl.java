package co.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.udea.iw.bl.PuntosMesBL;
import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.dao.PuntosMesDao;
import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dao.impl.UsuarioDaoImpl;
import co.edu.udea.iw.dto.PmPuntosmes;
import co.edu.udea.iw.dto.PmPuntosmesId;
import co.edu.udea.iw.dto.UsUsuario;
import co.edu.udea.iw.util.exception.IWBLException;
import co.edu.udea.iw.util.exception.IWDaoException;

/**
 * Clase que implementa metodos de la interfaz PuntosMesBL de la capa de logica
 * de negocio, correspondiente a la funcionalidad para PmPuntosmes
 * 
 * @author Alan Arboleda
 */
public class PuntosMesBLImpl implements PuntosMesBL {

	PuntosMesDao puntosMesDao;
	UsuarioDao usuarioDAO;
	
	/**
	 * @see PuntosMesBL#consultarPuntosMes(String, int, int)
	 */
	@Override
	public PmPuntosmes consultarPuntosMes(String nombre, int mes, int anno)
			throws IWDaoException, IWBLException {
		if (nombre == null || "".equals(nombre))
			throw new IWBLException(
					"El nombre del jugador no puede ser un valor nulo o vacio");
		if (mes < 1 || mes > 12)
			throw new IWBLException(
					"El mes tiene que estar entre el 01 y el 12 (enero y diciembre)");
		if (anno < 2000 || anno > 2099)
			throw new IWBLException(
					"El anno tiene que estar entre el 2000 y el 2099");
		
		UsUsuario jugador = usuarioDAO.buscarUsuario(nombre);
		PmPuntosmesId puntosMesId = new PmPuntosmesId();
		puntosMesId.setUsMes(mes);
		puntosMesId.setUsAnno(anno);
		puntosMesId.setUsuario(jugador);
		
		PmPuntosmes puntosMes = puntosMesDao.consultarPuntosMes(puntosMesId);

		return puntosMes;
	}

	/**
	 * @see PuntosMesBL#consultarTablaEspecifica(int, int)
	 */
	@Override
	public List<PmPuntosmes> consultarTablaEspecifica(int mes, int anno)
			throws IWDaoException, IWBLException {
		if (mes < 1 || mes > 12)
			throw new IWBLException(
					"El mes tiene que estar entre el 01 y el 12 (enero y diciembre)");
		if (anno < 2000 || anno > 2099)
			throw new IWBLException(
					"El anno tiene que estar entre el 2000 y el 2099");

		List<PmPuntosmes> puntosMes = new ArrayList<PmPuntosmes>();
		puntosMes = puntosMesDao.consultarTablaEspecifica(mes, anno);
		return puntosMes;
	}
	
	/**
	 * @see PuntosMesBL#actualizarPuntosMes(String, Date, int)
	 */
	@Override
	public void actualizarPuntosMes(String nombre, Date fecha, int puntos)
			throws IWDaoException, IWBLException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		int mes = cal.get(Calendar.MONTH);
		int anno = cal.get(Calendar.YEAR);
		PmPuntosmes puntosMes = null;
		puntosMes = this.consultarPuntosMes(nombre, mes + 1, anno);
		System.out.println("fecha: " + mes + " anno: "+anno );
		if (puntosMes != null) {
			puntosMes.setUsPtos(puntosMes.getUsPtos() + puntos);
			puntosMesDao.actualizarPuntosMes(puntosMes);
		} else {
			puntosMes = new PmPuntosmes();
			PmPuntosmesId id = new PmPuntosmesId();
			id.setUsAnno(anno);
			id.setUsMes(mes + 1);
			id.setUsuario(usuarioDAO.buscarUsuario(nombre));
			puntosMes.setId(id);
			puntosMes.setUsPtos(puntos);
			puntosMesDao.actualizarPuntosMes(puntosMes);
		}
	}

	public void setPuntosMesDao(PuntosMesDao puntosMesDao) {
		this.puntosMesDao = puntosMesDao;
	}

	public PuntosMesDao getPuntosMesDao() {
		return puntosMesDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDAO = usuarioDao;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDAO;
	}

}