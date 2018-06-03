package BussinessLogic;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class Habilidad {    
    private String habilidadNombre;        
    private String habilidadHabilidadNombre;
    private boolean habilidadEsHoja;
    public Habilidad() {
    }

    public Habilidad(String habilidadNombre, Habilidad habilidadHabilidadNombre) {
        this.habilidadNombre = habilidadNombre;        
    }
    
    /**
     * @return the habilidadNombre
     */
    public String getHabilidadNombre() {
        return habilidadNombre;
    }
    /**
     * @return the habilidadEsHoja
     */
    public boolean isHabilidadEsHoja() {
        return habilidadEsHoja;
    }

    /**
     * @param habilidadEsHoja the habilidadEsHoja to set
     */
    public void setHabilidadEsHoja(boolean habilidadEsHoja) {
        this.habilidadEsHoja = habilidadEsHoja;
    }
   

    /**
     * @param habilidadNombre the habilidadNombre to set
     */
    public void setHabilidadNombre(String habilidadNombre) {
        this.habilidadNombre = habilidadNombre;
    }

    /**
     * @return the habilidadHabilidadNombre
     */
    public String getHabilidadHabilidadNombre() {
        return habilidadHabilidadNombre;
    }

    /**
     * @param habilidadHabilidadNombre the habilidadHabilidadNombre to set
     */
    public void setHabilidadHabilidadNombre(String habilidadHabilidadNombre) {
        this.habilidadHabilidadNombre = habilidadHabilidadNombre;
    }    
}
