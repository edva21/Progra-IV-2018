/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FEBussinesLogic;

import BussinessLogic.OferenteHasHabilidad;

/**
 *
 * @author edva5
 */
public class OferenteHabilidadDto {

    public OferenteHabilidadDto() {
    }
    public OferenteHabilidadDto(OferenteHasHabilidad h) {
        nombre=h.getHabilidad().getHabilidadNombre();
        porcentaje = h.getPuestoHabilidadPorcentaje();
    }
    public OferenteHabilidadDto(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }
    
    /**
     * @return the nombre
     */
    public String getnombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the porcentaje
     */
    public int getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    private String nombre;
    private int porcentaje;
}
