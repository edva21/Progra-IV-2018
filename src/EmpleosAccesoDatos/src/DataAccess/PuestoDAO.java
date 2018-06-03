/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

//import Entities.Puesto;
//import Entities.PuestoPK;
import BussinessLogic.Puesto;
import BussinessLogic.PuestoPK;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaspa
 */
public class PuestoDAO extends DAO{
    private static PuestoDAO INSTANCE;
    private String attributes;
    private PuestoDAO() {
        attributes="Puesto.idPuesto,Puesto.Empresa_EmpresaEmail,Puesto.PuestoNombre,Puesto.Empresa_EmpresaEmail,Puesto.PuestoActivo,Puesto.PuestoDescripcion,Puesto.PuestoSalario,Puesto.PuestoFecha";
    }
    public static PuestoDAO getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PuestoDAO();
        }
        return INSTANCE;
    }
    private Puesto puesto(ResultSet rs) throws Exception{
        try {
            Puesto a = new Puesto();
            PuestoPK puestoPK = new PuestoPK(rs.getInt("idPuesto"),rs.getString("Empresa_EmpresaEmail"));
            a.setPuestoPK(puestoPK);
            a.setPuestoNombre(rs.getString("PuestoNombre"));
            a.setEmpresa(EmpresaDAO.getInstance().empresaGet(rs.getString("Empresa_EmpresaEmail")));
            a.setPuestoActivo(rs.getBoolean("PuestoActivo"));//
            a.setPuestoDescripcion(rs.getString("PuestoDescripcion"));
            a.setPuestoSalario(rs.getDouble("PuestoSalario"));
            if(rs.getDate("PuestoFecha")!=null)
                a.setPuestoFecha(rs.getDate("PuestoFecha").toLocalDate());
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
        
}
    public Puesto puestoGet(int idPuesto,String Empresa_EmpresaEmail)throws Exception{
         getConnection();
        String sql="select * from Puesto where idPuesto='%n',Empresa_EmpresaEmail='%s'";
        sql = String.format(sql,idPuesto,Empresa_EmpresaEmail);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
            Puesto a= puesto(rs);
            desconectar();
            return a;     
        }
        else{
            throw new Exception ("Puesto no Existe");
        }
    }
     public List<Puesto> PuestoBuscarNombre(Puesto filtro) throws Exception{
         getConnection();
        List<Puesto> resultado = new ArrayList<>();
        try {
            String sql="select * from Puesto  where PuestoNombre like '%%%s%%'";
            sql=String.format(sql,filtro.getPuestoNombre());
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(puesto(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
     
     public List<Puesto> PuestoCincoMayores() throws Exception{
         getConnection();
        List<Puesto> resultado = new ArrayList<>();
        try {
            String sql="select * from Puesto  order by idPuesto desc LIMIT 5";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(puesto(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
     
    public List<Puesto> puestoListar() {
         getConnection();
        List<Puesto> resultado=new ArrayList<>();
        try {
            String sql="select * from Puesto";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                try {
                    resultado.add(puesto(rs));
                } catch (Exception ex) {
                    Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }        
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public List<Puesto> puestoListar(LocalDate d) throws Exception{
         getConnection();
        List<Puesto> resultado=new ArrayList<>();
        try {
            String sql="select * from Puesto WHERE MONTH(PuestoFecha) LIKE MONTH("+java.sql.Date.valueOf(d)+")"
                    +"AND YEAR(PuestoFecha) LIKE YEAR("+java.sql.Date.valueOf(d)+")";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(puesto(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
   
    public void puestoIngresar(Puesto a) throws Exception{
       getConnection();
        String sql="INSERT INTO Puesto (PuestoNombre,PuestoDescripcion,PuestoSalario,PuestoActivo,Empresa_EmpresaEmail,PuestoFecha) VALUES('%s','%s','%d','%b','%s',"+java.sql.Date.valueOf(a.getPuestoFecha())+")";
        sql=String.format(sql,a.getPuestoNombre(),a.getPuestoDescripcion(),a.getPuestoSalario(),a.getPuestoActivo(),a.getEmpresa().getEmpresaEmail());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("puesto no se pudo ingresar");
        }
        desconectar();
    }
    public void puestoBorrar(Puesto a) throws Exception{
         getConnection();
        String sql="delete from Puesto where idPuesto='%d' and Empresa_EmpresaEmail ='%s'" ;
        sql = String.format(sql,a.getPuestoPK().getIdPuesto(),a.getPuestoPK().getEmpresaEmpresaEmail());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("Puesto no existe");
        }
         desconectar();
    }
    public List<Puesto> puestoListar(String whereSQL) throws Exception{
         getConnection();
        List<Puesto> resultado=new ArrayList<>();
        try {
            String sql=whereSQL;
            ResultSet rs =  executeQuery(sql);
            while (rs.next())
                resultado.add(puesto(rs));            
        } catch (SQLException ex) {
            Logger.getLogger(PuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    public Puesto puestoGet(int idPuesto)throws Exception{
         getConnection();
        String sql="select * from Puesto where idPuesto="+idPuesto;        
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
            Puesto a= puesto(rs);
            desconectar();
            return a;     
        }
        else
            throw new Exception ("Puesto no Existe");        
    }
    
}
