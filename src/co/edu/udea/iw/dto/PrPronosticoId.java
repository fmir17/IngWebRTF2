package co.edu.udea.iw.dto;
import java.io.Serializable;
import java.util.Date;
/**
 * Clase DTO para el id compuesto de los pronosticos 
 * realizados por cada usuario
 * @author Maicol Giraldo
 *
 */
public class PrPronosticoId implements Serializable  {
	
	/**
	 * Campo utilizado para almacenar el nombre del 
	 * usuario que realizo el pronostico
	 */
	private String prUsNombre;

	/**
	 * Campo utilizado para almacenar el id que identifica
	 * al equipo visitante
	 */
	private int prPaEqIdVisitante;
	
	/**
	 * Campo utilizado para almacenar el id que identifica
	 * al equipo local
	 */
	private int prPaEqIdLocal;
	
	/**
	 * Campo utilizado para almacenar la fecha del partido
	 */
	private Date prPaFecha;
	
	/**
	 * Campo utilizado para hacer referencia al usuario 
	 * que realizo el pronostico
	 */
	private UsUsuario usUsuario;
	
	/**
	 * Campo utilizado para hacer referencia al partido 
	 * al cual se le hace pronostico
	 */
	private PaPartido paPartido;
	

	public PaPartido getPaPartido() {
		return paPartido;
	}

	public void setPaPartido(PaPartido paPartido) {
		this.paPartido = paPartido;
	}

	public UsUsuario getUsUsuario() {
		return usUsuario;
	}

	public void setUsUsuario(UsUsuario usUsuario) {
		this.usUsuario = usUsuario;
	}

	public PrPronosticoId(){
			
		}
	
	public PrPronosticoId(String prUsNombre, int prPaEqIdVisitante,
		int prPaEqIdLocal, Date prPaFecha) {
		this.prUsNombre = prUsNombre;
		this.prPaEqIdVisitante = prPaEqIdVisitante;
		this.prPaEqIdLocal = prPaEqIdLocal;
		this.prPaFecha = prPaFecha;
	}

	public String getPrUsNombre() {
		return this.prUsNombre;
	}

	public void setPrUsNombre(String prUsNombre) {
		this.prUsNombre = prUsNombre;
	}

	public int getPrPaEqIdVisitante() {
		return this.prPaEqIdVisitante;
	}

	public void setPrPaEqIdVisitante(int prPaEqIdVisitante) {
		this.prPaEqIdVisitante = prPaEqIdVisitante;
	}

	public int getPrPaEqIdLocal() {
		return this.prPaEqIdLocal;
	}

	public void setPrPaEqIdLocal(int prPaEqIdLocal) {
		this.prPaEqIdLocal = prPaEqIdLocal;
	}

	public Date getPrPaFecha() {
		return this.prPaFecha;
	}

	public void setPrPaFecha(Date prPaFecha) {
		this.prPaFecha = prPaFecha;
	}
}
