/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BussinessLogic.Empresa;
import BussinessLogic.Puesto;
import Model.Model;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gaspa
 */
@WebServlet(name = "ControllerEmpleo", urlPatterns = {"/ControllerEmpleo","/Empleo","/EmpleoAdd"})
public class ControllerEmpleo extends HttpServlet {

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
            case "/Empleo":
                this.doEmpleo(request,response);
                break;
             case "/EmpleoAdd":
                this.doEmpleoAdd(request,response);
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

    private void doEmpleo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.getRequestDispatcher("EmpleoRegistro.jsp").forward(request, response);
    }
     private void doEmpleoAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         try{
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            Puesto puesto = gson.fromJson(reader, Puesto.class);
            HttpSession s =  request.getSession();
            Empresa empresa= (Empresa) s.getAttribute("empresa");
            puesto.setEmpresa(empresa);
            Date input = new Date();
            LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            puesto.setPuestoFecha(date);
            PrintWriter out = response.getWriter();
              if (Model.getInstance().create(puesto)){
                    response.setContentType("application/json; charset=UTF-8");
                     out.write(gson.toJson(puesto));        
                    response.setStatus(200); // ok with content
              }
              else {
                  throw new RuntimeException("error");
              }    
      }
      catch(Exception e){	
        response.setStatus(401); //Bad request
      }		
    }

}
