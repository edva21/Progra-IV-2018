/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;



import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class PuestoHabilidad {
        private PuestoHabilidadPK puestoHabilidadPK;
        private int puestoHabilidadPorcentaje;    
        private Habilidad habilidad;           
        private Puesto puesto;  

    public PuestoHabilidad() {
    }

    public PuestoHabilidad(int puestoHabilidadPorcentaje, Habilidad habilidad, Puesto puesto) {
        this.puestoHabilidadPorcentaje = puestoHabilidadPorcentaje;
        this.habilidad = habilidad;
        this.puesto = puesto;
    }
    /**
     * @return the puestoHabilidadPK
     */
    public PuestoHabilidadPK getPuestoHabilidadPK() {
        return puestoHabilidadPK;
    }

    /**
     * @param puestoHabilidadPK the puestoHabilidadPK to set
     */
    public void setPuestoHabilidadPK(PuestoHabilidadPK puestoHabilidadPK) {
        this.puestoHabilidadPK = puestoHabilidadPK;
    }
 
        
    /**
     * @return the puestoHabilidadPorcentaje
     */
    public int getPuestoHabilidadPorcentaje() {
        return puestoHabilidadPorcentaje;
    }

    /**
     * @param puestoHabilidadPorcentaje the puestoHabilidadPorcentaje to set
     */
    public void setPuestoHabilidadPorcentaje(int puestoHabilidadPorcentaje) {
        this.puestoHabilidadPorcentaje = puestoHabilidadPorcentaje;
    }

    /**
     * @return the habilidad
     */
    public Habilidad getHabilidad() {
        return habilidad;
    }

    /**
     * @param habilidad the habilidad to set
     */
    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    /**
     * @return the puesto
     */
    public Puesto getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
        
}
