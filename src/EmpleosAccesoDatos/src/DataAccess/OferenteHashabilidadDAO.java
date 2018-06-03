/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BussinessLogic.OferenteHasHabilidadPK;
import BussinessLogic.OferenteHasHabilidad;
///import BussinessLogic.OferenteHasHabilidadPK;
//import BussinessLogic.PuestoHabilidadPK;
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
public class OferenteHashabilidadDAO extends DAO{
     private static OferenteHashabilidadDAO INSTANCE;
    private OferenteHashabilidadDAO() {
   
    }
    public static OferenteHashabilidadDAO getInstance(){
        if (INSTANCE == null){
            INSTANCE = new OferenteHashabilidadDAO();
        }
        return INSTANCE;
    }
    private OferenteHasHabilidad oferenteHasHabilidad(ResultSet rs) throws Exception{
        try {
            OferenteHasHabilidad a = new OferenteHasHabilidad();
            OferenteHasHabilidadPK oferenteHasHabilidadPK = new OferenteHasHabilidadPK(rs.getString("Oferente_OferenteEmail"),rs.getString("Habilidad_HabilidadNombre"));
            a.setOferenteHasHabilidadPK(oferenteHasHabilidadPK);
            a.setHabilidad(HabilidadDAO.getInstance().habilidadGet(rs.getString("Habilidad_HabilidadNombre")));
            a.setOferente(OferenteDAO.getInstance().oferenteGet(rs.getString("Oferente_OferenteEmail")));
            a.setPuestoHabilidadPorcentaje(rs.getInt("Puesto_HabilidadPorcentaje"));
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(OferenteHashabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
        }
        
}
    public OferenteHasHabilidad OferenteHasHabilidadGet(String Oferente_OferenteEmail,
            String Habilidad_HabilidadNombre)throws Exception{
         getConnection();
        String sql="select * from Oferente_has_Habilidad where Oferente_OferenteEmail='%s',Habilidad_HabilidadNombre='%s'";
        sql = String.format(sql,Oferente_OferenteEmail,Habilidad_HabilidadNombre);
        ResultSet rs =  executeQuery(sql);
        if (rs.next()) { 
          OferenteHasHabilidad a= oferenteHasHabilidad(rs);
            desconectar();
            return a;     
        }
        else{
            throw new Exception ("OferenteHasHabilidad no Existe");
        }
    }
    
    public List<OferenteHasHabilidad> oferenteHasHabilidadBuscarOferente(OferenteHasHabilidad filtro) throws Exception{
         getConnection();
        List<OferenteHasHabilidad> resultado = new ArrayList<>();
        try {
            String sql="select * from Oferente_has_Habilidad  where Oferente_OferenteEmail like '%%%s%%'";
            sql=String.format(sql,filtro.getOferente().getOferenteEmail());
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(oferenteHasHabilidad(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OferenteHashabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return resultado;
    }
    public List<OferenteHasHabilidad> oferenteHasHabilidadListar() throws Exception{
         getConnection();
        List<OferenteHasHabilidad> resultado=new ArrayList<>();
        try {
            String sql="select * from Oferente_has_Habilidad";
            ResultSet rs =  executeQuery(sql);
            while (rs.next()) {
                resultado.add(oferenteHasHabilidad(rs));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(OferenteHashabilidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         desconectar();
        return  resultado;
    }
    
    public void oferenteHasHabilidadIngresar(OferenteHasHabilidad a) throws Exception{
       getConnection();
        String sql="INSERT INTOOferente_has_Habilidad (Oferente_OferenteEmail,Habilidad_HabilidadNombre,Puesto_HabilidadPorcentaje) VALUES('%s','%s','%d')";
        sql=String.format(sql,a.getOferente().getOferenteEmail(),
                a.getHabilidad().getHabilidadNombre(),a.getPuestoHabilidadPorcentaje());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception(" oferenteHasHabilidad no se pudo ingresar");
        }
        desconectar();
    }
    public void oferenteHasHabilidadBorrar( OferenteHasHabilidad a) throws Exception{
         getConnection();
        String sql="delete from Oferente_has_Habilidad where Habilidad_HabilidadNombre='%s',Oferente_OferenteEmail='%s'";
        sql = String.format(sql,a.getHabilidad().getHabilidadNombre(),a.getOferente().getOferenteEmail());
        int count=executeUpdate(sql);
        if (count==0){
            throw new Exception("oferenteHasHabilidad no existe");
        }
         desconectar();
    }
}
