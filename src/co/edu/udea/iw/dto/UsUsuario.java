
package co.edu.udea.iw.dto;

import java.util.Set;
/**
 * Clase DTO para transportar la informaci�n de los Usuarios
 * @author Alan Arboleda
 *
 */

public class UsUsuario implements java.io.Serializable {
	/**
	 * Nombre que identifica al usuario
	 */
	private String usNombre;
	/**
	 * Email personal del usuario
	 */
	private String usEmail;
	/**
	 * Contrase�a con la cual ingresa al sistema el usuario
	 */
	private String usPassword;
	/**
	 * Tipo de usuario: administrador o jugador
	 */
	private String usTipo;
	
	private  Set<PmPuntosmes> puntosMes;

	public UsUsuario() {
	}
	
	
	public UsUsuario(String Nombre, String Email, String Password,
			String Tipo) {
		super();
		this.usNombre = Nombre;
		this.usEmail = Email;
		this.usPassword = Password;
		this.usTipo = Tipo;

	}


	public String getUsNombre() {
		return this.usNombre;
	}

	public void setUsNombre(String usNombre) {
		this.usNombre = usNombre;
	}

	public String getUsEmail() {
		return this.usEmail;
	}

	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}

	public String getUsPassword() {
		return this.usPassword;
	}

	public void setUsPassword(String usPassword) {
		this.usPassword = usPassword;
	}

	public String getUsTipo() {
		return this.usTipo;
	}

	public void setUsTipo(String usTipo) {
		this.usTipo = usTipo;
	}

	public Set<PmPuntosmes> getPuntosMes() {
		return puntosMes;
	}

	public void setPuntosMes(Set<PmPuntosmes> puntosMes) {
		this.puntosMes = puntosMes;
	}

}
