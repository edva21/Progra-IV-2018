/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;



import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class Empresa {
    private String empresaEmail;        
    private String empresaNombre;    
    private String empresaLocalizacion;    
    private String empresaTelefono;    
    private String empresaDescripcion;    
    private String empresaClave;    
    private String empresaEstadoDeCuenta;    
    private String empresaUsername;    
    private double empresaLongitud;        
    private double empresaLatitud;

    public Empresa() {
    }

    public Empresa(String empresaEmail, String empresaNombre, String empresaLocalizacion, String empresaTelefono, String empresaDescripcion, String empresaClave, String empresaEstadoDeCuenta, String empresaUsername, double empresaLongitud, double empresaLatitud) {
        this.empresaEmail = empresaEmail;
        this.empresaNombre = empresaNombre;
        this.empresaLocalizacion = empresaLocalizacion;
        this.empresaTelefono = empresaTelefono;
        this.empresaDescripcion = empresaDescripcion;
        this.empresaClave = empresaClave;
        this.empresaEstadoDeCuenta = empresaEstadoDeCuenta;
        this.empresaUsername = empresaUsername;
        this.empresaLongitud = empresaLongitud;
        this.empresaLatitud = empresaLatitud;
    }
    
    /**
     * @return the empresaEmail
     */
    public String getEmpresaEmail() {
        return empresaEmail;
    }

    /**
     * @param empresaEmail the empresaEmail to set
     */
    public void setEmpresaEmail(String empresaEmail) {
        this.empresaEmail = empresaEmail;
    }

    /**
     * @return the empresaNombre
     */
    public String getEmpresaNombre() {
        return empresaNombre;
    }

    /**
     * @param empresaNombre the empresaNombre to set
     */
    public void setEmpresaNombre(String empresaNombre) {
        this.empresaNombre = empresaNombre;
    }

    /**
     * @return the empresaLocalizacion
     */
    public String getEmpresaLocalizacion() {
        return empresaLocalizacion;
    }

    /**
     * @param empresaLocalizacion the empresaLocalizacion to set
     */
    public void setEmpresaLocalizacion(String empresaLocalizacion) {
        this.empresaLocalizacion = empresaLocalizacion;
    }

    /**
     * @return the empresaTelefono
     */
    public String getEmpresaTelefono() {
        return empresaTelefono;
    }

    /**
     * @param empresaTelefono the empresaTelefono to set
     */
    public void setEmpresaTelefono(String empresaTelefono) {
        this.empresaTelefono = empresaTelefono;
    }

    /**
     * @return the empresaDescripcion
     */
    public String getEmpresaDescripcion() {
        return empresaDescripcion;
    }

    /**
     * @param empresaDescripcion the empresaDescripcion to set
     */
    public void setEmpresaDescripcion(String empresaDescripcion) {
        this.empresaDescripcion = empresaDescripcion;
    }

    /**
     * @return the empresaClave
     */
    public String getEmpresaClave() {
        return empresaClave;
    }

    /**
     * @param empresaClave the empresaClave to set
     */
    public void setEmpresaClave(String empresaClave) {
        this.empresaClave = empresaClave;
    }

    /**
     * @return the empresaEstadoDeCuenta
     */
    public String getEmpresaEstadoDeCuenta() {
        return empresaEstadoDeCuenta;
    }

    /**
     * @param empresaEstadoDeCuenta the empresaEstadoDeCuenta to set
     */
    public void setEmpresaEstadoDeCuenta(String empresaEstadoDeCuenta) {
        this.empresaEstadoDeCuenta = empresaEstadoDeCuenta;
    }

    /**
     * @return the empresaUsername
     */
    public String getEmpresaUsername() {
        return empresaUsername;
    }

    /**
     * @param empresaUsername the empresaUsername to set
     */
    public void setEmpresaUsername(String empresaUsername) {
        this.empresaUsername = empresaUsername;
    }

    /**
     * @return the empresaLongitud
     */
    public double getEmpresaLongitud() {
        return empresaLongitud;
    }

    /**
     * @param empresaLongitud the empresaLongitud to set
     */
    public void setEmpresaLongitud(double empresaLongitud) {
        this.empresaLongitud = empresaLongitud;
    }

    /**
     * @return the empresaLatitud
     */
    public double getEmpresaLatitud() {
        return empresaLatitud;
    }

    /**
     * @param empresaLatitud the empresaLatitud to set
     */
    public void setEmpresaLatitud(double empresaLatitud) {
        this.empresaLatitud = empresaLatitud;
    }
        
    //private ArrayList<Puesto> puestoCollection;

 
}
