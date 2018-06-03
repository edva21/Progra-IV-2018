/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

//import Entities.PuestoHabilidad;
//import Entities.PuestoHabilidadPK;
import BussinessLogic.PuestoHabilidad;
import BussinessLogic.PuestoHabilidadPK;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaspa
 */
public class PuestoHabilidadDAO extends DAO{
    private static PuestoHabilidadDAO INSTANCE;
    private PuestoHabilidadDAO() {
   
    }
    public static PuestoHabilidadDAO getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PuestoHabilidadDAO();
        }
        return INSTANCE;
    }
    private PuestoHabilidad puestoHabilidad(ResultSet rs) throws Exception{
        try {
           PuestoHabilidad a = new PuestoHabilidad();
           PuestoHabilidadPK puestoHabilidadPK = new PuestoHabilidadPK(rs.getInt("Puesto_idPuesto" ),
                   rs.getString(rs.getString("Puesto_Empresa_EmpresaEmail")), rs.getString(rs.getString("Habilidad_HabilidadNombre")));
            a.setPuestoHabilidadPK(puestoHabilidadPK);
            a.setHabilidad(HabilidadDAO.getInstance().habilidadGet(rs.getString("Habilidad_HabilidadNombre")));
            a.setPuesto(PuestoDAO.getInstance().puestoGet(rs.getInt("Puesto_idPuesto"),rs.getString("Puesto_Empresa_EmpresaEmail")));
            a.setPuestoHabilidadPorcentaje(rs.getInt("Puesto_HabilidadPorcentaje"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(PuestoHabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
        
}
    public PuestoHabilidad puestoHabilidadGet(String Puesto_Empresa_EmpresaEmail,
            int Puesto_idPuesto,String Habilidad_HabilidadNombre)throws Exception{
         getConnection();
        String sql="select * from PuestoHabilidad where Puesto_Empresa_EmpresaEmail='%s',Habilidad_HabilidadNombre='%s',Puesto_idPuesto='%d'";
        sql = String.format(sql,Puesto_Empresa_EmpresaEmail,Habilidad_HabilidadNombre,Puesto_idPuesto);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
            PuestoHabilidad a= puestoHabilidad(rs);
            desconectar();
            return a;     
        }
        else{
            throw new Exception ("PuestoHabilidad no Existe");
        }
    }
    
    public List<PuestoHabilidad> puestoHabilidadBuscarPuesto(PuestoHabilidad filtro) throws Exception{
         getConnection();
        List<PuestoHabilidad> resultado = new ArrayList<>();
        try {
            String sql="select * from PuestoHabilidad  where PuestoHabilidad like '%%%s%%'";
            sql=String.format(sql,filtro.getPuesto().getPuestoNombre());
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(puestoHabilidad(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuestoHabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
    
    public List<PuestoHabilidad> puestoHabilidadBuscarPuestoNom(String filtro1, int filtro2) throws Exception{
         getConnection();
        List<PuestoHabilidad> resultado = new ArrayList<>();
        try {
            String sql="select * from PuestoHabilidad  where Habilidad_HabilidadNombre = '%s'and Puesto_HabilidadPorcentaje = '%d'";
            sql=String.format(sql,filtro1, filtro2);
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(puestoHabilidad(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuestoHabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
    
    public List<PuestoHabilidad> puestoHabilidadListar() throws Exception{
         getConnection();
        List<PuestoHabilidad> resultado=new ArrayList<>();
        try {
            String sql="select * from Puesto_Habilidad";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(puestoHabilidad(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(PuestoHabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    
    public void administradorIngresar(PuestoHabilidad a) throws Exception{
       getConnection();
        String sql="INSERT INTO Puesto_Habilidad (Puesto_Empresa_EmpresaEmail,Habilidad_HabilidadNombre,Puesto_HabilidadPorcentaje) VALUES('%s','%s','%d')";
        sql=String.format(sql,a.getPuesto().getEmpresa().getEmpresaEmail(),
                a.getHabilidad().getHabilidadNombre(),a.getPuestoHabilidadPorcentaje());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Puesto Habilidad no se pudo ingresar");
        }
        desconectar();
    }
    public void administradorBorrar(PuestoHabilidad a) throws Exception{
         getConnection();
        String sql="delete from Puesto_Habilidad where Habilidad_HabilidadNombre='%s',Puesto_idPuesto='%d'";
        sql = String.format(sql,a.getHabilidad().getHabilidadNombre(),a.getPuesto().getPuestoPK().getIdPuesto());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("administradorBorrar no existe");
        }
         desconectar();
    }
}
