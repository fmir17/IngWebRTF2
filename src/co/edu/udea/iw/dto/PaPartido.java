
package co.edu.udea.iw.dto;
import java.util.Calendar;
/**
 * Clase DTO para obtener la informacion de los partidos 
 * @author Fredy Miranda
 *
 */
import java.util.Date;

public class PaPartido {
	/**
	 * Campo que contiene la clave de partido
	 */
	private PaPartidoId id;
	
	/**
	 * Campo que relaciona al torneo del partido
	 */

	private ToTorneo toTorneo;
	
	/**
	 * Campo para determinar la hora del partido
	 */
	private Date paHora;
	
	/**
	 * Campo para extraer el mes de la fecha.
	 */
	private int paMes; 
	

	/**
	 * Campo que indica el numero de goles del visitante
	 */
	private int paNroGolVis;
	/**
	 * Campo que indica el numero de goles del local
	 */
	private int paNroGolLoc;
	public PaPartidoId getId() {
		return id;
	}
	public void setId(PaPartidoId id) {
		this.id = id;
	}
	
	public ToTorneo getToTorneo() {
		return toTorneo;
	}
	public void setToTorneo(ToTorneo toTorneo) {
		this.toTorneo = toTorneo;
	}
	public Date getPaHora() {
		return paHora;
	}
	public void setPaHora(Date paHora) {
		this.paHora = paHora;
	}
	public int getPaNroGolVis() {
		return paNroGolVis;
	}
	public void setPaNroGolVis(int paNroGolVis) {
		this.paNroGolVis = paNroGolVis;
	}
	public int getPaNroGolLoc() {
		return paNroGolLoc;
	}
	public void setPaNroGolLoc(int paNroGolLoc) {
		this.paNroGolLoc = paNroGolLoc;
	}
	
	public int getPaMes() {
				
		Date fecha = id.getPaFecha();

		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);

		//comienza en 0
		int mes = cal.get(Calendar.MONTH) + 1;
		return mes;
	}
	


}
