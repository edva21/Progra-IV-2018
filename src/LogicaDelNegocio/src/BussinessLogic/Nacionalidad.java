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
public class Nacionalidad {
    private String nacionalidadNombre;

    public Nacionalidad() {
    }

    public Nacionalidad(String nacionalidadNombre) {
        this.nacionalidadNombre = nacionalidadNombre;
    }
    
    /**
     * @return the nacionalidadNombre
     */
    public String getNacionalidadNombre() {
        return nacionalidadNombre;
    }

    /**
     * @param nacionalidadNombre the nacionalidadNombre to set
     */
    public void setNacionalidadNombre(String nacionalidadNombre) {
        this.nacionalidadNombre = nacionalidadNombre;
    }
}
