package co.edu.udea.iw.dto;

/**
 * Clase DTO para obtener la informaci�n de los puntajes 
 * mensuales de cada usuario
 * @author Maicol Steeven Giraldo Tobon
 *
 */
public class PmPuntosmes  {

	/*
	 * Clave primaria compuesta de la tabla de puntaje mensual
	 */
	private PmPuntosmesId id;
	/*
	 * Cantidad de puntos acumulados por el usuario
	 */
	private int usPtos;


	public PmPuntosmes() {
	}
	
	public PmPuntosmes(PmPuntosmesId id,  int usPtos) {
		this.id = id;
		this.usPtos = usPtos;
	}

	public PmPuntosmesId getId() {
		return this.id;
	}

	public void setId(PmPuntosmesId id) {
		this.id = id;
	}

	

	public int getUsPtos() {
		return this.usPtos;
	}

	public void setUsPtos(int usPtos) {
		this.usPtos = usPtos;
	}

}
