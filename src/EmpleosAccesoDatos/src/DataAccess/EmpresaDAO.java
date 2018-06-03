/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BussinessLogic.Empresa;
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
public class EmpresaDAO extends DAO{
private static EmpresaDAO INSTANCE;
    private EmpresaDAO() {
   
    }
    public static EmpresaDAO getInstance(){
        if (INSTANCE == null){
            INSTANCE = new EmpresaDAO();
        }
        return INSTANCE;
    }
   private Empresa empresa(ResultSet rs){
        try {
            Empresa a = new Empresa();
            a.setEmpresaClave(rs.getString("EmpresaClave"));
            a.setEmpresaDescripcion(rs.getString("EmpresaDescripcion"));
            a.setEmpresaEmail(rs.getString("EmpresaEmail"));
            a.setEmpresaEstadoDeCuenta(rs.getString("EmpresaEstadoDeCuenta"));
            a.setEmpresaLocalizacion(rs.getString("EmpresaLocalizacion"));
            a.setEmpresaLatitud(rs.getDouble("EmpresaLongitud"));
            a.setEmpresaLongitud(rs.getDouble("EmpresaLatitud"));
            a.setEmpresaNombre(rs.getString("EmpresaNombre"));
            a.setEmpresaTelefono(rs.getString("EmpresaTelefono"));
            a.setEmpresaUsername(rs.getString("EmpresaUsername"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }  
    }
    public Empresa empresaGet(String EmpresaEmail)throws Exception{
         getConnection();
        String sql="select * from Empresa where EmpresaEmail='%s'";
        sql = String.format(sql,EmpresaEmail);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
            Empresa a= empresa(rs);
            desconectar();
            return a;     
        }
        else{
            throw new Exception ("Empresa no Existe");
        }
    }
    public List<Empresa> empresaBuscarNombre(Empresa filtro){
         getConnection();
        List<Empresa> resultado = new ArrayList<>();
        try {
            String sql="select * from Empresa  where EmpresaNombre like '%%%s%%'";
            sql=String.format(sql,filtro.getEmpresaNombre());
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(empresa(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
    public List<Empresa> empresaListar(){
         getConnection();
        List<Empresa> resultado=new ArrayList<>();
        try {
            String sql="select * from Empresa";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(empresa(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }

    public void empresaIngresar(Empresa a) throws Exception{
       getConnection();
        String sql="INSERT INTO Empresa (EmpresaEmail,EmpresaNombre,EmpresaLocalizacion,EmpresaTelefono,EmpresaDescripcion,"
                + "EmpresaClave,EmpresaEstadoDeCuenta,EmpresaUsername,EmpresaLongitud,EmpresaLatitud) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%f','%f')";
        sql=String.format(sql,a.getEmpresaEmail(),a.getEmpresaNombre(),a.getEmpresaLocalizacion(),a.getEmpresaTelefono(),a.getEmpresaDescripcion(),
        a.getEmpresaClave(),a.getEmpresaEstadoDeCuenta(),a.getEmpresaUsername(),a.getEmpresaLongitud(),a.getEmpresaLatitud());
        System.out.println("empleosaccesodatos.EmpresaDAO.empresaIngresar()"+sql);
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Empresa no se pudo ingresar");
        }
        desconectar();
    }
    public void empresaBorrar(Empresa a) throws Exception{
         getConnection();
        String sql="delete from Empresa where EmpresaEmail='%s'";
        sql = String.format(sql,a.getEmpresaEmail());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Empresa no existe");
        }
         desconectar();
    }
    public List<Empresa> empresaEnEsperaListar(){
         getConnection();
        List<Empresa> resultado=new ArrayList<>();
        try {
            String sql="select * from Empresa WHERE empresaEstadoDeCuenta='ESPERA'";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(empresa(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public boolean empresaUpdateEstado(String id,String Estado) throws Exception{
       getConnection();
        String sql="UPDATE Empresa SET EmpresaEstadoDeCuenta='%s' WHERE EmpresaEmail='%s' AND EmpresaEstadoDeCuenta='%s';";
        sql=String.format(sql,Estado,id,"ESPERA");
        int count=executeUpdate(sql);
        if (count==0){
            return false;
        }        
        desconectar();
        return true;
    }
   
}
