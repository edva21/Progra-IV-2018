/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo
 */
public  class DAO {

    /**
     *
     */
    
    public static final String PROPERTIES_FILE_NAME="e.properties"; 
    Connection conexion=null;

    public DAO() {
        
    }
    
    protected void getConnection()  {
        try {
            Properties prop = new Properties();
            prop.load(this.getClass().getResourceAsStream(PROPERTIES_FILE_NAME));
            String driver = prop.getProperty("database_driver");
            String server = prop.getProperty("database_server");
            String port = prop.getProperty("database_port");
            String user = prop.getProperty("database_user");
            String database = prop.getProperty("database_name"); 
            String password = prop.getProperty("database_password");      
            String URL_conexion="jdbc:mysql://"+ server+":"+port+"/"+
                    database+"?user="+user+"&password="+password;
            Class.forName(driver).newInstance();
            conexion= DriverManager.getConnection(URL_conexion);
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void desconectar(){
        try {
            if(!conexion.isClosed())
            {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected int executeUpdate(String statement) {
        try {
            Statement stm = conexion.createStatement();
            stm.executeUpdate(statement);
            return stm.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }
    protected ResultSet executeQuery(String statement){
        try {
            Statement stm = conexion.createStatement();        
            return stm.executeQuery(statement);
        } catch (SQLException ex) {
        }
        return null;
    }
}
