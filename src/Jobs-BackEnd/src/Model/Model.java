/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BussinessLogic.Administrador;
import BussinessLogic.Empresa;
import BussinessLogic.Habilidad;
import BussinessLogic.Habilidad_Porcentaje;
import BussinessLogic.Nacionalidad;
import BussinessLogic.Oferente;
import BussinessLogic.OferenteHasHabilidad;
import BussinessLogic.Puesto;
import BussinessLogic.PuestoHabilidad;
import DataAccess.AdministradorDAO;
import DataAccess.HabilidadDAO;
import DataAccess.PuestoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edva5
 */
public class Model {
    private static Model INSTANCE;    
    private Model() {
        
    }
    public static Model getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Model();
        }
        return INSTANCE;
    }
    public boolean create(Administrador obj){
        try {
            DataAccess.AdministradorDAO.getInstance().administradorIngresar(obj);            
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Empresa obj){
        try {
            DataAccess.EmpresaDAO.getInstance().empresaIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Habilidad obj){
        try {            
                DataAccess.HabilidadDAO.getInstance().habilidadIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Nacionalidad obj){
        try {
            DataAccess.NacionalidadDAO.getInstance().nacionalidadIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Oferente obj){
        try {
            DataAccess.OferenteDAO.getInstance().oferenteIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(OferenteHasHabilidad obj){
        try {
            DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidadIngresar(
                    obj.getOferente().getOferenteEmail(),
                    obj.getHabilidad().getHabilidadNombre(),
                    obj.getPuestoHabilidadPorcentaje());
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(Puesto obj){
        try {
            DataAccess.PuestoDAO.getInstance().puestoIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean create(PuestoHabilidad obj){
        try {
            DataAccess.PuestoHabilidadDAO.getInstance().administradorIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public Administrador readAdministrador(String userName){
        try {
            return DataAccess.AdministradorDAO.getInstance().AdministradorGet(userName);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Empresa readEmpresa(String email){
        try {
            return DataAccess.EmpresaDAO.getInstance().empresaGet(email);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Habilidad readHabilidad(String nombre){
        try {
            return DataAccess.HabilidadDAO.getInstance().habilidadGet(nombre);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Nacionalidad readNacionalidad(String nacionalidad){
        try {
            return DataAccess.NacionalidadDAO.getInstance().nacionalidadGet(nacionalidad);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Oferente readOferente(String email){
        try {
            return DataAccess.OferenteDAO.getInstance().oferenteGet(email);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /*public OferenteHasHabilidad readOferenteHasHabilidad(OferenteHasHabilidad obj){
        try {
            DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidad(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }*/
    public Puesto readPuesto(int idPuesto,String empresaEmail){
        try {
            return DataAccess.PuestoDAO.getInstance().puestoGet(idPuesto,empresaEmail);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /*public PuestoHabilidad readPuestoHabilidad(PuestoHabilidad obj){
        try {
            DataAccess.PuestoHabilidadDAO.getInstance().administradorIngresar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }*/
    public List<Administrador> readAllAdministrador(){
        try {
            return DataAccess.AdministradorDAO.getInstance().administradorListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Empresa> readAllEmpresa(){
        try {
            return DataAccess.EmpresaDAO.getInstance().empresaListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Empresa> readAllEmpresaEnEspera(){
        try {
            return DataAccess.EmpresaDAO.getInstance().empresaEnEsperaListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Habilidad> readAllHabilidad(){
        try {
            return DataAccess.HabilidadDAO.getInstance().HabilidadListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Habilidad> readAllHabilidadRoots(){
        try {
            return DataAccess.HabilidadDAO.getInstance().HabilidadRoots();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Habilidad> readAllHabilidadHijos(String padre){
        try {
            return DataAccess.HabilidadDAO.getInstance().HabilidadHijos(padre);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Nacionalidad> readAllNacionalidad(){
        try {
            return DataAccess.NacionalidadDAO.getInstance().nacionalidadListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Oferente> readAllOferente(){
        try {
            return DataAccess.OferenteDAO.getInstance().oferenteListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Oferente> readAllOferenteEnEspera(){
        try {
            return DataAccess.OferenteDAO.getInstance().oferenteEsperaListar();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<OferenteHasHabilidad> readAllOferenteHasHabilidad(){
        try {
            return DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidadListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    public List<Puesto> readAllPuesto(){
        try {
            return DataAccess.PuestoDAO.getInstance().puestoListar();            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }
    /*public List<PuestoHabilidad> readAllPuestoHabilidad(){
        try {
            DataAccess.PuestoHabilidadDAO.getInstance().administrador();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }*/
    public boolean delete(Administrador obj){
        try {
            DataAccess.AdministradorDAO.getInstance().administradorBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Empresa obj){
        try {
            DataAccess.EmpresaDAO.getInstance().empresaBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Habilidad obj){
        try {
            DataAccess.HabilidadDAO.getInstance().habilidadBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Nacionalidad obj){
        try {
            DataAccess.NacionalidadDAO.getInstance().nacionalidadBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Oferente obj){
        try {
            DataAccess.OferenteDAO.getInstance().oferenteBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(OferenteHasHabilidad obj){
        try {
            DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidadBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(Puesto obj){
        try {
            DataAccess.PuestoDAO.getInstance().puestoBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean delete(PuestoHabilidad obj){
        try {
            DataAccess.PuestoHabilidadDAO.getInstance().administradorBorrar(obj);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }    
    public Empresa login(Empresa obj){
        try{
             Empresa empresa = DataAccess.EmpresaDAO.getInstance().empresaGet(obj.getEmpresaEmail()); 
            if( empresa!= null && obj.getEmpresaClave().equals(empresa.getEmpresaClave()) && obj.getEmpresaEstadoDeCuenta().equals("APROVADO")){
                return empresa;
            }
            else return null;
        }
        catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;}         
    }
    public boolean login(Administrador obj){
        try{
             Administrador admin = DataAccess.AdministradorDAO.getInstance().AdministradorGet(obj.getAdministradorUserName());
            return obj.getAdministradorClave().equals(admin.getAdministradorClave());
        }
        catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;}         
    }
    public boolean update(Oferente o){
        try{
            DataAccess.OferenteDAO.getInstance().oferenteUpdate(o);
            return true;
        }
        catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;       
        }
    }
    public boolean updateEstado(String oferenteEmail,String Estado){
        try{            
            return DataAccess.OferenteDAO.getInstance().oferenteUpdateEstado(oferenteEmail, Estado);            
        }
        catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;       
        }
    }
    public boolean updateEstadoEmpresa(String oferenteEmail,String Estado){
        try{            
            return DataAccess.EmpresaDAO.getInstance().empresaUpdateEstado(oferenteEmail, Estado);
        }
        catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;       
        }
    }
    public List<Puesto> readJobsByMonth(LocalDate d){
        try{            
            return DataAccess.PuestoDAO.getInstance().puestoListar(d);
        }
        catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<Puesto>();       
        }
    }
    public List<Puesto> readJobsLastFive(){
        try{            
            return DataAccess.PuestoDAO.getInstance().PuestoCincoMayores();
        }
        catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<Puesto>();       
        }
    }
    public Oferente login(Oferente obj){
          try{
             Oferente oferente = DataAccess.OferenteDAO.getInstance().oferenteGet(obj.getOferenteEmail());
            if( oferente!= null && obj.getOferenteClave().equals(oferente.getOferenteClave())){
                return oferente;
            }
            else return null;
        }
        catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;}         
          
    }
    public List<Puesto> readPuestos(ArrayList<Habilidad_Porcentaje> habilidades){
        String attributes="idPuesto,PuestoNombre,Empresa_EmpresaEmail,PuestoActivo,PuestoDescripcion,PuestoSalario,PuestoFecha";
        if(habilidades!=null){                    
                try {
                    return DataAccess.PuestoDAO.getInstance().puestoListar(buildQuery(habilidades, 0, attributes)+';');
                } catch (Exception ex) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                    return new ArrayList<>();
                }
            }
            else            
                return PuestoDAO.getInstance().puestoListar();            
        }       
    
    
    private String buildQuery(ArrayList<Habilidad_Porcentaje> habilidades,int i,String puestoAttributes){
        
        if(i<habilidades.size()-1){
             return "SELECT DISTINCT "+puestoAttributes+" FROM ("+buildQuery(habilidades, i+1, puestoAttributes)+") AS T,Puesto_Habilidad,Habilidad "
                    + "WHERE T.idPuesto=Puesto_Habilidad.Puesto_idPuesto "
                    + "AND Puesto_Habilidad.Habilidad_HabilidadNombre='"+habilidades.get(i).getNombre()+"' "
                    + "AND Puesto_HabilidadPorcentaje<="+habilidades.get(i).getPorcentaje();}                   
        else if (i==habilidades.size()-1){
             return "SELECT DISTINCT "+puestoAttributes+" FROM Puesto,Puesto_Habilidad,Habilidad "
                    + "WHERE Puesto.idPuesto=Puesto_Habilidad.Puesto_idPuesto "
                    + "AND Puesto.PuestoActivo="+true+" "
                    + "AND Puesto_Habilidad.Habilidad_HabilidadNombre=Habilidad.habilidadNombre "
                    + "AND Habilidad.HabilidadNombre='"+habilidades.get(i).getNombre()+"' "
                    + "AND Puesto_HabilidadPorcentaje<="+habilidades.get(i).getPorcentaje();}
        else 
              return  "SELECT * FROM Puesto";             
    }
    public Puesto readPuesto(int idPuesto){
        try {
            return DataAccess.PuestoDAO.getInstance().puestoGet(idPuesto);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void cleanOferenteHasHabilidad(String OferenteEmail){
        DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidadClean(OferenteEmail);
    }
    
    public List<OferenteHasHabilidad> OferenteHasHabilidadbyOferente(String oferenteEmail){
        try {
            return DataAccess.OferenteHashabilidadDAO.getInstance().oferenteHasHabilidadBuscarOferente(oferenteEmail);            
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<OferenteHasHabilidad>();
        }
    }    
}
