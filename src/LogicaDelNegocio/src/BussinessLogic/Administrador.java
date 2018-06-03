package BussinessLogic;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class Administrador {
    private String administradorUserName,administradorClave;  
    
    public Administrador() {
    }

    public Administrador(String administradorUserName, String administradorClave) {
        this.administradorUserName = administradorUserName;
        this.administradorClave = administradorClave;
    }   
    /**
     * @return the administradorUserName
     */
    public String getAdministradorUserName() {
        return administradorUserName;
    }

    /**
     * @param administradorUserName the administradorUserName to set
     */
    public void setAdministradorUserName(String administradorUserName) {
        this.administradorUserName = administradorUserName;
    }

    /**
     * @return the administradorClave
     */
    public String getAdministradorClave() {
        return administradorClave;
    }

    /**
     * @param administradorClave the administradorClave to set
     */
    public void setAdministradorClave(String administradorClave) {
        this.administradorClave = administradorClave;
    }        
    public Administrador toEntity(){
        return new Administrador(administradorUserName, administradorClave);
    }
}
