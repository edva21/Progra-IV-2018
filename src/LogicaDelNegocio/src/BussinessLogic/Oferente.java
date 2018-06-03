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
public class Oferente {    
    private String oferenteEmail;    
    private String oferenteCedula;    
    private String oferenteNombre;        
    private String oferenteApellido;   
    private String oferenteTelefono;
    private String oferenteResidencia;    
    private byte[] oferenteCurriculum;
    private String oferenteEstadoDeCuenta;    
    private String oferenteUserName;    
    private String oferenteClave;    
    private String oferenteNacionalidad;    

    public Oferente() {
    }

    public Oferente(String oferenteEmail, String oferenteCedula, String oferenteNombre, String oferenteApellido, String oferenteTelefono, String oferenteResidencia, byte[] oferenteCurriculum, String oferenteEstadoDeCuenta, String oferenteUserName, String oferenteClave) {
        this.oferenteEmail = oferenteEmail;
        this.oferenteCedula = oferenteCedula;
        this.oferenteNombre = oferenteNombre;
        this.oferenteApellido = oferenteApellido;
        this.oferenteTelefono = oferenteTelefono;
        this.oferenteResidencia = oferenteResidencia;
        this.oferenteCurriculum = oferenteCurriculum;
        this.oferenteEstadoDeCuenta = oferenteEstadoDeCuenta;
        this.oferenteUserName = oferenteUserName;
        this.oferenteClave = oferenteClave;
    }
    
    /**
     * @return the oferenteNacionalidad
     */
    public String getOferenteNacionalidad() {
        return oferenteNacionalidad;
    }

    /**
     * @param oferenteNacionalidad the oferenteNacionalidad to set
     */
    public void setOferenteNacionalidad(String oferenteNacionalidad) {
        this.oferenteNacionalidad = oferenteNacionalidad;
    }
    
    /**
     * @return the oferenteEmail
     */
    public String getOferenteEmail() {
        return oferenteEmail;
    }

    /**
     * @param oferenteEmail the oferenteEmail to set
     */
    public void setOferenteEmail(String oferenteEmail) {
        this.oferenteEmail = oferenteEmail;
    }

    /**
     * @return the oferenteCedula
     */
    public String getOferenteCedula() {
        return oferenteCedula;
    }

    /**
     * @param oferenteCedula the oferenteCedula to set
     */
    public void setOferenteCedula(String oferenteCedula) {
        this.oferenteCedula = oferenteCedula;
    }

    /**
     * @return the oferenteNombre
     */
    public String getOferenteNombre() {
        return oferenteNombre;
    }

    /**
     * @param oferenteNombre the oferenteNombre to set
     */
    public void setOferenteNombre(String oferenteNombre) {
        this.oferenteNombre = oferenteNombre;
    }

    /**
     * @return the oferenteApellido
     */
    public String getOferenteApellido() {
        return oferenteApellido;
    }

    /**
     * @param oferenteApellido the oferenteApellido to set
     */
    public void setOferenteApellido(String oferenteApellido) {
        this.oferenteApellido = oferenteApellido;
    }

    /**
     * @return the oferenteTelefono
     */
    public String getOferenteTelefono() {
        return oferenteTelefono;
    }

    /**
     * @param oferenteTelefono the oferenteTelefono to set
     */
    public void setOferenteTelefono(String oferenteTelefono) {
        this.oferenteTelefono = oferenteTelefono;
    }

    /**
     * @return the oferenteResidencia
     */
    public String getOferenteResidencia() {
        return oferenteResidencia;
    }

    /**
     * @param oferenteResidencia the oferenteResidencia to set
     */
    public void setOferenteResidencia(String oferenteResidencia) {
        this.oferenteResidencia = oferenteResidencia;
    }

    /**
     * @return the oferenteCurriculum
     */
    public byte[] getOferenteCurriculum() {
        return oferenteCurriculum;
    }

    /**
     * @param oferenteCurriculum the oferenteCurriculum to set
     */
    public void setOferenteCurriculum(byte[] oferenteCurriculum) {
        this.oferenteCurriculum = oferenteCurriculum;
    }

    /**
     * @return the oferenteEstadoDeCuenta
     */
    public String getOferenteEstadoDeCuenta() {
        return oferenteEstadoDeCuenta;
    }

    /**
     * @param oferenteEstadoDeCuenta the oferenteEstadoDeCuenta to set
     */
    public void setOferenteEstadoDeCuenta(String oferenteEstadoDeCuenta) {
        this.oferenteEstadoDeCuenta = oferenteEstadoDeCuenta;
    }

    /**
     * @return the oferenteUserName
     */
    public String getOferenteUserName() {
        return oferenteUserName;
    }

    /**
     * @param oferenteUserName the oferenteUserName to set
     */
    public void setOferenteUserName(String oferenteUserName) {
        this.oferenteUserName = oferenteUserName;
    }

    /**
     * @return the oferenteClave
     */
    public String getOferenteClave() {
        return oferenteClave;
    }

    /**
     * @param oferenteClave the oferenteClave to set
     */
    public void setOferenteClave(String oferenteClave) {
        this.oferenteClave = oferenteClave;
    }
    
}
