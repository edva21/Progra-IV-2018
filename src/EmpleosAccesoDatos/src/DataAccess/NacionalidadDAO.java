/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BussinessLogic.Nacionalidad;
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
public class NacionalidadDAO extends DAO{
private static NacionalidadDAO INSTANCE;
    private NacionalidadDAO() {
   
    }
    public static NacionalidadDAO getInstance(){
        if (INSTANCE == null){
            INSTANCE = new NacionalidadDAO();
        }
        return INSTANCE;
    }
     private Nacionalidad nacionalidad (ResultSet rs){
        try {
            Nacionalidad nacionalidad= new Nacionalidad();
            nacionalidad.setNacionalidadNombre(rs.getString("NacionalidadNombre"));
            
            return nacionalidad;
        } catch (SQLException ex) {
            Logger.getLogger(NacionalidadDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
        
}
    public Nacionalidad NacionalidadNombreGet(String NacionalidadNombre)throws Exception{
         getConnection();
        String sql="select * from Nacionalidad where NacionalidadNombre='%s'";
        sql = String.format(sql,NacionalidadNombre);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
            Nacionalidad a= nacionalidad(rs);
            desconectar();
            return a;     
        }
        else{
            throw new Exception ("Nacionalidad no Existe");
        }
    }
   
    public List<Nacionalidad> nacionalidadListar(){
         getConnection();
        List<Nacionalidad> resultado=new ArrayList<>();
        try {
            String sql="select * from Nacionalidad";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(nacionalidad(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(NacionalidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public Nacionalidad nacionalidadGet(String Nacionalidad){
         getConnection();
        Nacionalidad resultado=new Nacionalidad();
        try {
            String sql="select * from Nacionalidad where NacionalidadNombre like '%%%s%%'";
            sql=String.format(sql,Nacionalidad);
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado=nacionalidad(rs);
            }        
        } catch (SQLException ex) {
            Logger.getLogger(NacionalidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public void nacionalidadIngresar(Nacionalidad a) throws Exception{
       getConnection();
        String sql="INSERT INTO Nacionalidad (NacionalidadNombre) VALUES('%s')";
        sql=String.format(sql,a.getNacionalidadNombre());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Nacionalidad no se pudo ingresar");
        }
        desconectar();
    }
    public void nacionalidadBorrar(Nacionalidad a) throws Exception{
         getConnection();
        String sql="delete from Nacionalidad where NacionalidadNombre='%s'";
        sql = String.format(sql,a.getNacionalidadNombre());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Nacionalidad no existe");
        }
         desconectar();
    }
    
}
