//<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FEBussinesLogic;

/**
 *
 * @author edva5
 */
public class MensajeEstado {
    private String oferenteid,estado;

    public MensajeEstado() {
    }

    public MensajeEstado(String oferenteid, String estado) {
        this.oferenteid = oferenteid;
        this.estado = estado;
    }
    
    /**
     * @return the oferenteid
     */
    public String getOferenteid() {
        return oferenteid;
    }

    /**
     * @param oferenteid the oferenteid to set
     */
    public void setOferenteid(String oferenteid) {
        this.oferenteid = oferenteid;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
//=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author edva5
 */
