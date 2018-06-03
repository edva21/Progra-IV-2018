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
public class PuestoPK {
    private int idPuesto;    
    private String empresaEmpresaEmail;

    public PuestoPK() {
    }

    public PuestoPK(int idPuesto, String empresaEmpresaEmail) {
        this.idPuesto = idPuesto;
        this.empresaEmpresaEmail = empresaEmpresaEmail;
    }
    
    /**
     * @return the idPuesto
     */    
    public int getIdPuesto() {
        return idPuesto;
    }

    /**
     * @param idPuesto the idPuesto to set
     */
    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    /**
     * @return the empresaEmpresaEmail
     */
    public String getEmpresaEmpresaEmail() {
        return empresaEmpresaEmail;
    }

    /**
     * @param empresaEmpresaEmail the empresaEmpresaEmail to set
     */
    public void setEmpresaEmpresaEmail(String empresaEmpresaEmail) {
        this.empresaEmpresaEmail = empresaEmpresaEmail;
    }
    
}
