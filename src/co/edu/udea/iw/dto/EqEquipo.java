package co.edu.udea.iw.dto;
/**
 * Dto en el que se recibiran los datos de la tabla EqEquipo
 * @author Fredy Miranda
 *
 */
public class EqEquipo {
	/**
	 * Codigo que identifica al equipo
	 */
	private int eqId;
	/**
	 * Nombre del equipo
	 */
	private String eqNombre;


	public int getEqId() {
		return eqId;
	}
	public void setEqId(int eqId) {
		this.eqId = eqId;
	}
	public String getEqNombre() {
		return eqNombre;
	}
	public void setEqNombre(String eqNombre) {
		this.eqNombre = eqNombre;
	}
	
	
}
