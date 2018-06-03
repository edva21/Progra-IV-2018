/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class Puesto {
    private PuestoPK puestoPK;
    private String puestoNombre;
    private String puestoDescripcion;    
    private double puestoSalario;
    private Boolean puestoActivo;    
    private Empresa empresa;
    private LocalDate puestoFecha;
    public Puesto() {
    }

    public Puesto(String puestoNombre, String puestoDescripcion, double puestoSalario, Boolean puestoActivo, Empresa empresa) {
        this.puestoNombre = puestoNombre;
        this.puestoDescripcion = puestoDescripcion;
        this.puestoSalario = puestoSalario;
        this.puestoActivo = puestoActivo;
        this.empresa = empresa;
    }
    /**
     * @return the puestoFecha
     */
    public LocalDate getPuestoFecha() {
        return puestoFecha;
    }

    /**
     * @param puestoFecha the puestoFecha to set
     */
    public void setPuestoFecha(LocalDate puestoFecha) {
        this.puestoFecha = puestoFecha;
    }
    

    
    /**
     * @return the puestoPK
     */
    public PuestoPK getPuestoPK() {
        return puestoPK;
    }

    /**
     * @param puestoPK the puestoPK to set
     */
    public void setPuestoPK(PuestoPK puestoPK) {
        this.puestoPK = puestoPK;
    }    
    
    /**
     * @return the puestoNombre
     */
    public String getPuestoNombre() {
        return puestoNombre;
    }

    /**
     * @param puestoNombre the puestoNombre to set
     */
    public void setPuestoNombre(String puestoNombre) {
        this.puestoNombre = puestoNombre;
    }

    /**
     * @return the puestoDescripcion
     */
    public String getPuestoDescripcion() {
        return puestoDescripcion;
    }

    /**
     * @param puestoDescripcion the puestoDescripcion to set
     */
    public void setPuestoDescripcion(String puestoDescripcion) {
        this.puestoDescripcion = puestoDescripcion;
    }

    /**
     * @return the puestoSalario
     */
    public double getPuestoSalario() {
        return puestoSalario;
    }

    /**
     * @param puestoSalario the puestoSalario to set
     */
    public void setPuestoSalario(double puestoSalario) {
        this.puestoSalario = puestoSalario;
    }

    /**
     * @return the puestoActivo
     */
    public Boolean getPuestoActivo() {
        return puestoActivo;
    }

    /**
     * @param puestoActivo the puestoActivo to set
     */
    public void setPuestoActivo(Boolean puestoActivo) {
        this.puestoActivo = puestoActivo;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
  //protected PuestoPK puestoPK;    

    //private ArrayList<PuestoHabilidad> puestoHabilidadCollection;
}

