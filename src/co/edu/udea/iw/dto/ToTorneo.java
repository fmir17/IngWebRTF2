package co.edu.udea.iw.dto;



/**
 * Clase DTO para transportar la informaci�n de los torneos
 * 
 * @author Maicol Giraldo
 * 
 */

public class ToTorneo {
	/**
	 * Codigo que identifica el torneo
	 */
	private int toId;
	/**
	 * Nombre asignado al torneo
	 */
	private String toNombre;
	/**
	 * URL de la imagen que contiene el logo del torneo
	 */
	private String toUriimagen;

	public int getToId() {
		return this.toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public String getToNombre() {
		return this.toNombre;
	}

	public void setToNombre(String toNombre) {
		this.toNombre = toNombre;
	}

	public String getToUriimagen() {
		return this.toUriimagen;
	}

	public void setToUriimagen(String toUriimagen) {
		this.toUriimagen = toUriimagen;
	}

}
