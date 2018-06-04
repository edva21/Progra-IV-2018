/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BussinessLogic.Administrador;
import BussinessLogic.Habilidad_Porcentaje;
import BussinessLogic.Puesto;
import FEBussinesLogic.PuestoDto;
import Model.Model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edva5
 */
@WebServlet(name = "ControllerPuesto", urlPatterns = {"/ControllerPuesto","/searchJobs","/searchJob"})
public class ControllerPuesto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        switch(request.getServletPath()){    
            case "/searchJobs":
                doSearchJobs(request, response);
                break;
            case "/searchJob":
                doSearchJob(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    private void doSearchJobs(HttpServletRequest request, HttpServletResponse response) {        
        //BufferedReader reader = request.getReader();
        ArrayList<Habilidad_Porcentaje> list = new ArrayList<>();
        ArrayList<PuestoDto> listPuestoDto = new ArrayList<>();
        List<Puesto> listPuesto = new ArrayList<>();
        Gson gson = new GsonBuilder().create();                        
        
        try (Reader reader = request.getReader()) {
            
            Habilidad_Porcentaje[] users = gson.fromJson(reader, Habilidad_Porcentaje[].class);
            
            Arrays.stream(users).forEach( e -> {
                list.add(e);
            });
        PrintWriter out = response.getWriter();
        listPuesto=Model.getInstance().readPuestos(list);
        for(Puesto p:listPuesto)
            listPuestoDto.add(new PuestoDto(p));
        response.setContentType("application/json; charset=UTF-8");
         out.write(gson.toJson(listPuestoDto));                          
         response.setStatus(200); //Good request
      }
      catch(Exception e){	
        response.setStatus(401); //Bad request
      }		
    }
    private void doSearchJob(HttpServletRequest request, HttpServletResponse response) {        
        //BufferedReader reader = request.getReader();        
        Gson gson = new GsonBuilder().create(); 
        Reader reader;
        try {
            reader = request.getReader();
            int id=gson.fromJson(reader, int.class);
            PrintWriter out = response.getWriter();        
             response.setContentType("application/json; charset=UTF-8");
             Puesto p =Model.getInstance().readPuesto(id);
              out.write(gson.toJson(new PuestoDto(p)));                          
              response.setStatus(200); //Good request
        } catch (IOException ex) {
            Logger.getLogger(ControllerPuesto.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }   
        
      
}
