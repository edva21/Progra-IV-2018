/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;


import BussinessLogic.Administrador;
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
public class AdministradorDAO extends DAO{    
private static AdministradorDAO INSTANCE;
    private AdministradorDAO() {
   
    }
    public static AdministradorDAO getInstance(){
        if (INSTANCE == null){
            INSTANCE = new AdministradorDAO();
        }
        return INSTANCE;
    }
    private Administrador administrador(ResultSet rs){
        try {
            Administrador a = new Administrador();
            a.setAdministradorUserName(rs.getString("AdministradorUserName"));
            a.setAdministradorClave(rs.getString("AdministradorClave"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
        
}
    public Administrador administradorGet(String administradorUserName)throws Exception{
         getConnection();
        String sql="select * from Administrador where AdministradorUserName='%s'";
        sql = String.format(sql,administradorUserName);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
            Administrador a= administrador(rs);
            desconectar();
            return a;     
        }
        else{
            throw new Exception ("Administrador no Existe");
        }
    }
    public List<Administrador> administradorBuscarNombre(Administrador filtro){
         getConnection();
        List<Administrador> resultado = new ArrayList<>();
        try {
            String sql="select * from Administrador  where AdministradorUserName like '%%%s%%'";
            sql=String.format(sql,filtro.getAdministradorUserName());
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(administrador(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
    public List<Administrador> administradorListar(){
         getConnection();
        List<Administrador> resultado=new ArrayList<>();
        try {
            String sql="select * from Administrador";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(administrador(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public Administrador AdministradorGet(String AdministradorUserName)throws Exception{
         getConnection();
        String sql="select * from Administrador where AdministradorUserName='%s'";
        sql = String.format(sql,AdministradorUserName);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
            Administrador a=administrador(rs);
            super.desconectar();
            return a;            
        }
        else{
            throw new Exception ("Administrador no Existe");
        }
    }
    public void administradorIngresar(Administrador a) throws Exception{
        getConnection();
        String sql="INSERT INTO Administrador (AdministradorUserName,AdministradorClave) VALUES('%s','%s')";
        sql=String.format(sql,a.getAdministradorUserName(),a.getAdministradorClave());
        int count=executeUpdate(sql);
         desconectar();    
    }
    public void administradorBorrar(Administrador a) throws Exception{
         getConnection();
        String sql="delete from Administrador where AdministradorUserName='%s'";
        sql = String.format(sql,a.getAdministradorUserName());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Administrador no existe");
        }
         desconectar();
    }
    
}
