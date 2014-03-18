package co.edu.udea.iw.dto;

import java.util.Date;
/**
 * Clase DTO para el id compuesto de partido 
 * mensuales de cada usuario
 * @author Fredy Miranda
 *
 */
public class PaPartidoId implements java.io.Serializable{
	/**
	 * Campo para el equipo Visitante
	 */
	private EqEquipo paEqIdVisitante;
	/**
	 * Campo para el equipo Visitante
	 */
	private EqEquipo paEqIdLocal;
	/**
	 * Campo para la fecha
	 */
	private Date paFecha;
	
	
	public EqEquipo getPaEqIdVisitante() {
		return paEqIdVisitante;
	}
	public void setPaEqIdVisitante(EqEquipo paEqIdVisitante) {
		this.paEqIdVisitante = paEqIdVisitante;
	}
	public EqEquipo getPaEqIdLocal() {
		return paEqIdLocal;
	}
	public void setPaEqIdLocal(EqEquipo paEqIdLocal) {
		this.paEqIdLocal = paEqIdLocal;
	}
	public Date getPaFecha() {
		return paFecha;
	}
	public void setPaFecha(Date paFecha) {
		this.paFecha = paFecha;
	}
	
	
	
	
}
