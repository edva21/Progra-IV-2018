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
public class OferenteHasHabilidad {
        private OferenteHasHabilidadPK oferenteHasHabilidadPK;
    private int puestoHabilidadPorcentaje;    
     private Habilidad habilidad;    
     private Oferente oferente;  

    public OferenteHasHabilidad() {
    }

    public OferenteHasHabilidad(int puestoHabilidadPorcentaje, Habilidad habilidad, Oferente oferente) {
        this.puestoHabilidadPorcentaje = puestoHabilidadPorcentaje;
        this.habilidad = habilidad;
        this.oferente = oferente;
    }
    /**
     * @return the oferenteHasHabilidadPK
     */
    public OferenteHasHabilidadPK getOferenteHasHabilidadPK() {
        return oferenteHasHabilidadPK;
    }

    /**
     * @param oferenteHasHabilidadPK the oferenteHasHabilidadPK to set
     */
    public void setOferenteHasHabilidadPK(OferenteHasHabilidadPK oferenteHasHabilidadPK) {
        this.oferenteHasHabilidadPK = oferenteHasHabilidadPK;
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
     * @return the oferente
     */
    public Oferente getOferente() {
        return oferente;
    }

    /**
     * @param oferente the oferente to set
     */
    public void setOferente(Oferente oferente) {
        this.oferente = oferente;
    }
     
}
