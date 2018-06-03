/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

/**
 *
 * @author edva5
 */
public class OferenteHasHabilidadPK {
    private String oferenteOferenteEmail;    
    private String habilidadHabilidadNombre;
    
    public OferenteHasHabilidadPK() {
    }

    public OferenteHasHabilidadPK(String oferenteOferenteEmail, String habilidadHabilidadNombre) {
        this.oferenteOferenteEmail = oferenteOferenteEmail;
        this.habilidadHabilidadNombre = habilidadHabilidadNombre;
    }
    
    /**
     * @return the oferenteOferenteEmail
     */
    public String getOferenteOferenteEmail() {
        return oferenteOferenteEmail;
    }

    /**
     * @param oferenteOferenteEmail the oferenteOferenteEmail to set
     */
    public void setOferenteOferenteEmail(String oferenteOferenteEmail) {
        this.oferenteOferenteEmail = oferenteOferenteEmail;
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
