package co.edu.udea.iw.dto;
import java.io.Serializable;


/**
 * Clase que hace las veces de la clave primaria de la tabla 
 * PmPuntosMes
 * @author Fredy Miranda
 *
 */
public class PmPuntosmesId  implements Serializable {

	/**
	 * Usuario al que corresponde puntaje, este campo compone el id
	 */
	private UsUsuario usuario;


	/**
 	 * Numero del mes al cual pertenece el puntaje
 	 */
     private int usMes;
     /**
 	 * A�o al cual pertenece el puntaje
 	 */
     private int usAnno;

  
     public UsUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(UsUsuario usuario) {
		this.usuario = usuario;
	}
   
    public int getUsMes() {
        return this.usMes;
    }
    
    public void setUsMes(int usMes) {
        this.usMes = usMes;
    }
    public int getUsAnno() {
        return this.usAnno;
    }
    
    public void setUsAnno(int usAnno) {
        this.usAnno = usAnno;
    }



}


