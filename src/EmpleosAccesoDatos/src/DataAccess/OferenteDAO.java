/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BussinessLogic.Oferente;
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
public class OferenteDAO extends DAO{
private static OferenteDAO INSTANCE;
    private OferenteDAO() {
   
    }
    public static OferenteDAO getInstance(){
        if (INSTANCE == null){
            INSTANCE = new OferenteDAO();
        }
        return INSTANCE;
    }
     private Oferente oferente(ResultSet rs){
        try {
            Oferente a = new Oferente();
            a.setOferenteApellido(rs.getString("OferenteApellido"));
            a.setOferenteCedula(rs.getString("OferenteCedula"));
            a.setOferenteClave(rs.getString("OferenteClave"));
            a.setOferenteCurriculum(rs.getBytes("OferenteCurriculum"));
            a.setOferenteEmail(rs.getString("OferenteEmail"));
            a.setOferenteEstadoDeCuenta(rs.getString("OferenteEstadoDeCuenta"));
            a.setOferenteNombre(rs.getString("OferenteNombre"));
            a.setOferenteResidencia(rs.getString("OferenteResidencia"));
            a.setOferenteTelefono(rs.getString("OferenteTelefono"));
            a.setOferenteUserName(rs.getString("OferenteUserName"));
            a.setOferenteNacionalidad(rs.getString("Nacionalidad"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(OferenteDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
        
}
    public Oferente oferenteGet(String OferenteEmail)throws Exception{
         getConnection();
        String sql="select * from Oferente where OferenteEmail='%s'";
        sql = String.format(sql,OferenteEmail);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
            Oferente a= oferente(rs);
            desconectar();
            return a;     
        }
        else{
            throw new Exception ("Oferente no Existe");
        }
    }
    public List<Oferente> OferenteBuscarNombre(Oferente filtro){
         getConnection();
        List<Oferente> resultado = new ArrayList<>();
        try {
            String sql="select * from Oferente  where OferenteNombre like '%%%s%%'";
            sql=String.format(sql,filtro.getOferenteNombre());
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(oferente(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OferenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
    public List<Oferente> oferenteListar(){
         getConnection();
        List<Oferente> resultado=new ArrayList<>();
        try {
            String sql="select * from Oferente";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(oferente(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(OferenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    
    public void oferenteIngresar(Oferente a) throws Exception{
       getConnection();
        String sql="INSERT INTO Oferente (OferenteEmail,OferenteCedula,OferenteNombre,OferenteApellido,OferenteTelefono,"
                + "OferenteResidencia,OferenteCurriculum,OferenteEstadoDeCuenta,OferenteUserName,OferenteClave,OferenteNacionalidad) VALUES('%s','%s','%s','%s','%s','%s','%x','%s','%s','%s','%s')";
        sql=String.format(sql,a.getOferenteEmail(),a.getOferenteCedula(),a.getOferenteNombre(),a.getOferenteApellido(),
        a.getOferenteTelefono(),a.getOferenteResidencia(),a.getOferenteCurriculum(),a.getOferenteEstadoDeCuenta(),a.getOferenteUserName(),
        a.getOferenteClave(),a.getOferenteNacionalidad());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Oferente no se pudo ingresar");
        }        
        desconectar();
    }
    public void oferenteBorrar(Oferente a) throws Exception{
         getConnection();
        String sql="delete from Oferente where OferenteEmail='%s'";
        sql = String.format(sql,a.getOferenteEmail());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Oferente no existe");
        }
         desconectar();
    }
    
    public List<Oferente> oferenteEsperaListar(){
         getConnection();
        List<Oferente> resultado=new ArrayList<>();
        try {
            String sql="select * from Oferente where OferenteEstadoDeCuenta='ESPERA'";            
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(oferente(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(OferenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public boolean oferenteUpdate(Oferente a) throws Exception{
       getConnection();
        String sql="UPDATE Oferente SET OferenteCedula='%s',OferenteNombre='%s',OferenteApellido='%s',OferenteTelefono='%s',"
                + "OferenteResidencia='%s',OferenteCurriculum='%x',OferenteEstadoDeCuenta='%s',OferenteUserName='%s',OferenteClave='%s',OferenteNacionalidad='%s' WHERE OferenteEmail='%s';";
        sql=String.format(sql,a.getOferenteCedula(),a.getOferenteNombre(),a.getOferenteApellido(),
        a.getOferenteTelefono(),a.getOferenteResidencia(),a.getOferenteCurriculum(),a.getOferenteEstadoDeCuenta(),a.getOferenteUserName(),
        a.getOferenteClave(),a.getOferenteNacionalidad(),a.getOferenteEmail());
        int count=executeUpdate(sql);
        if (count==0){
            return false;
        }        
        desconectar();
        return true;
    }
    public boolean oferenteUpdateEstado(String id,String Estado) throws Exception{
       getConnection();
        String sql="UPDATE Oferente SET OferenteEstadoDeCuenta='%s' WHERE OferenteEmail='%s' AND OferenteEstadoDeCuenta='%s';";
        sql=String.format(sql,Estado,id,"ESPERA");
        int count=executeUpdate(sql);
        if (count==0){
            return false;
        }        
        desconectar();
        return true;
    }
}
