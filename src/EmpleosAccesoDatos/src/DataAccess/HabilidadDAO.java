/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;




import BussinessLogic.Habilidad;
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
public class HabilidadDAO extends DAO{
private static HabilidadDAO INSTANCE;
    private HabilidadDAO() {
   
    }
    public static HabilidadDAO getInstance(){
        if (INSTANCE == null){
            INSTANCE = new HabilidadDAO();
        }
        return INSTANCE;
    }
    private Habilidad habilidad(ResultSet rs) throws Exception{
        try {
            Habilidad a = new Habilidad();
            a.setHabilidadNombre(rs.getString("HabilidadNombre"));
            a.setHabilidadEsHoja(rs.getBoolean("HabilidadEsHoja"));
            if(rs.getString("Habilidad_HabilidadNombre")!=null){
                 a.setHabilidadHabilidadNombre(rs.getString("Habilidad_HabilidadNombre"));
            }else {a.setHabilidadHabilidadNombre(null);}
             
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(HabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
    }
    public List<Habilidad> habilidadBuscaHabilidad_HabilidadNombre(String hablilidadNombre) throws Exception{
        List<Habilidad> resultado = new ArrayList<>();
        try {
            String sql="select * from Habilidad  where Habilidad_HabilidadNombre like '%%%s%%'";
            sql=String.format(sql,hablilidadNombre);
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {    
                resultado.add(habilidad(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return resultado;
    }
    public Habilidad habilidadGet(String habilidadNombre)throws Exception{ 
        if(conexion==null || conexion.isClosed()){getConnection();};
        String sql="select * from Habilidad where HabilidadNombre='%s'";
        sql = String.format(sql,habilidadNombre);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) {
            Habilidad x =habilidad(rs);
           
            return x;
        }
        else{
           
            return null;
        }
    }
    public List<Habilidad> habilidadBuscarNombre(Habilidad filtro) throws Exception{
         getConnection();
        List<Habilidad> resultado = new ArrayList<>();
        try {
            String sql="select * from Habilidad  where HabilidadNombre like '%%%s%%'";
            sql=String.format(sql,filtro.getHabilidadNombre());
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(habilidad(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
    public List<Habilidad> HabilidadListar() throws Exception{
         getConnection();
        List<Habilidad> resultado=new ArrayList<>();
        try {
            String sql="select * from Habilidad";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(habilidad(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(HabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public List<Habilidad> HabilidadRoots() throws Exception{
         getConnection();
        List<Habilidad> resultado=new ArrayList<>();
        try {
            String sql="select * from Habilidad where Habilidad_HabilidadNombre IS NULL";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(habilidad(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(HabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public List<Habilidad> HabilidadHijos(String padre) throws Exception{
         getConnection();
        List<Habilidad> resultado=new ArrayList<>();
        try {
            String sql="select * from Habilidad where Habilidad_HabilidadNombre =\""+padre+"\"";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(habilidad(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(HabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public void habilidadIngresar(Habilidad a) throws Exception{
        Habilidad padre= new Habilidad();
        if(a.getHabilidadHabilidadNombre()!=null){
            padre=habilidadGet(a.getHabilidadHabilidadNombre());
        }
       getConnection();
        String sql="";        
       if(a.getHabilidadHabilidadNombre()==null){
             sql="INSERT INTO Habilidad (HabilidadNombre,HabilidadEsHoja) VALUES('%s',"+a.isHabilidadEsHoja()+")";
            sql=String.format(sql,a.getHabilidadNombre());
       
       }
       else{
           if(!padre.isHabilidadEsHoja()){
        sql="INSERT INTO Habilidad (HabilidadNombre,Habilidad_HabilidadNombre,HabilidadEsHoja) VALUES('%s','%s',"+a.isHabilidadEsHoja()+')';
        sql=String.format(sql,a.getHabilidadNombre(),a.getHabilidadHabilidadNombre());
        
        
           }        
       }
       int count=executeUpdate(sql);
       if (count==0){
            throw new Exception("Habilidad no se pudo ingresar");
        }
        desconectar(); 
    }
    public void habilidadBorrar(Habilidad a) throws Exception{
         getConnection();
        String sql="delete from Habilidad where HabilidadNombre='%s'";
        sql = String.format(sql,a.getHabilidadNombre());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Habilidad no existe");
        }
         desconectar();
    } 
    
}
