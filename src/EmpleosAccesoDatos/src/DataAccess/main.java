/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;


import BussinessLogic.Administrador;
import java.io.IOException;
import java.net.URISyntaxException;
import BussinessLogic.Empresa;

/**
 *
 * @author gaspa
 */
public class main {
    public static void main(String[] args) throws URISyntaxException, IOException, Exception {        
        Administrador x = AdministradorDAO.getInstance().AdministradorGet("a");
        if(x!=null)
            System.err.println("True");
        else
            System.err.println("False");
    
    }
    
    
}
