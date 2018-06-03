/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FEBussinesLogic;

import BussinessLogic.Puesto;

/**
 *
 * @author edva5
 */
public class PuestoDto {
    private int idPuesto;        
    private String puestoNombre;
    private String puestoDescripcion;    
    private double puestoSalario;
    private Boolean puestoActivo;    
    private String empresa;
    private String puestoFecha;

    public PuestoDto(Puesto p) {
        idPuesto=p.getPuestoPK().getIdPuesto();
        puestoNombre=p.getPuestoNombre();
        puestoDescripcion=p.getPuestoDescripcion();
        puestoSalario=p.getPuestoSalario();
        puestoActivo=p.getPuestoActivo();
        empresa=p.getEmpresa().getEmpresaNombre();
        puestoFecha=p.getPuestoFecha().toString();
    }

    public PuestoDto(int idPuesto, String puestoNombre, String puestoDescripcion, double puestoSalario, Boolean puestoActivo, String empresa, String puestoFecha) {
        this.idPuesto = idPuesto;
        this.puestoNombre = puestoNombre;
        this.puestoDescripcion = puestoDescripcion;
        this.puestoSalario = puestoSalario;
        this.puestoActivo = puestoActivo;
        this.empresa = empresa;
        this.puestoFecha = puestoFecha;
    }
    
}
