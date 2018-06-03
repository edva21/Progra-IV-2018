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
public class PuestoHabilidadPK {
    private int puestoidPuesto;    
    private String puestoEmpresaEmpresaEmail;    
    private String habilidadHabilidadNombre;

    public PuestoHabilidadPK() {
    }

    public PuestoHabilidadPK(int puestoidPuesto, String puestoEmpresaEmpresaEmail, String habilidadHabilidadNombre) {
        this.puestoidPuesto = puestoidPuesto;
        this.puestoEmpresaEmpresaEmail = puestoEmpresaEmpresaEmail;
        this.habilidadHabilidadNombre = habilidadHabilidadNombre;
    }
    
    /**
     * @return the puestoidPuesto
     */
    public int getPuestoidPuesto() {
        return puestoidPuesto;
    }

    /**
     * @param puestoidPuesto the puestoidPuesto to set
     */
    public void setPuestoidPuesto(int puestoidPuesto) {
        this.puestoidPuesto = puestoidPuesto;
    }

    /**
     * @return the puestoEmpresaEmpresaEmail
     */
    public String getPuestoEmpresaEmpresaEmail() {
        return puestoEmpresaEmpresaEmail;
    }

    /**
     * @param puestoEmpresaEmpresaEmail the puestoEmpresaEmpresaEmail to set
     */
    public void setPuestoEmpresaEmpresaEmail(String puestoEmpresaEmpresaEmail) {
        this.puestoEmpresaEmpresaEmail = puestoEmpresaEmpresaEmail;
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
