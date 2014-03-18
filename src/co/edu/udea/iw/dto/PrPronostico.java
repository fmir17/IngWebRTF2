package co.edu.udea.iw.dto;

import java.util.Date;
/**
 * Clase DTO para el manejo de los datos de los 
 * pronosticos realizados por cada usuario
 * @author Maicol Giraldo
 *
 */
public class PrPronostico {
	/**
	 * Campo que contiene la clave primaria compuesta
	 * de pronostico
	 */
	private PrPronosticoId id;

	/**
	 * Campo  que relaciona al usuario que hizo el pronostico
	 */
	private UsUsuario usUsuario;

	/**
	 * Campo que realaciona al partido para el cual se hizo 
	 * el pronostico
	 */
	private PaPartido paPartido;

	/**
	 * Campo utilizado para almacenar el numero de goles del equipo visitante
	 * que el usuario a pronosticado
	 */
	private int prNroGolVis;

	/**
	 * Campo utilizado para almacenar el numero de goles del equipo local
	 * que el usuario a pronosticado
	 */
	private int prNroGolLoc;

	/**
	 * Campo utilizado para almacenar la fecha en la cual ha sido realizado el pronostico
	 */
	private Date prFechaHoraPro;

	/**
	 * Metodo constructor por defecto
	 */
	public PrPronostico() {
	}

	/**
	 * Mmetodo constructor que recibe como parametros los campos
	 *  del pronostico
	 */
	public PrPronostico(PrPronosticoId id, UsUsuario usUsuario,
			PaPartido paPartido, int prNroGolVis, int prNroGolLoc,
			Date prFechaHoraPro) {
		this.id = id;
		this.usUsuario = usUsuario;
		this.paPartido = paPartido;
		this.prNroGolVis = prNroGolVis;
		this.prNroGolLoc = prNroGolLoc;
		this.prFechaHoraPro = prFechaHoraPro;
	}
	public PrPronosticoId getId() {
		return this.id;
	}

	public void setId(PrPronosticoId id) {
		this.id = id;
	}

	public UsUsuario getUsUsuario() {
		return this.usUsuario;
	}

	public void setUsUsuario(UsUsuario usUsuario) {
		this.usUsuario = usUsuario;
	}

	public PaPartido getPaPartido() {
		return this.paPartido;
	}

	public void setPaPartido(PaPartido paPartido) {
		this.paPartido = paPartido;
	}

	public int getPrNroGolVis() {
		return this.prNroGolVis;
	}

	public void setPrNroGolVis(int prNroGolVis) {
		this.prNroGolVis = prNroGolVis;
	}

	public int getPrNroGolLoc() {
		return this.prNroGolLoc;
	}

	public void setPrNroGolLoc(int prNroGolLoc) {
		this.prNroGolLoc = prNroGolLoc;
	}

	public Date getPrFechaHoraPro() {
		return this.prFechaHoraPro;
	}

	public void setPrFechaHoraPro(Date prFechaHoraPro) {
		this.prFechaHoraPro = prFechaHoraPro;
	}
}
