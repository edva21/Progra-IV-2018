/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BussinessLogic.Empresa;
import Model.Model;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gaspa
 */
@WebServlet(name = "ControllerEmpresa", urlPatterns = {"/ControllerEmpresa","/EmpresaLogin","/EmpresaLogout","/EmpresaRegistrar","/RegistrarE"})
@MultipartConfig
public class ControllerEmpresa extends HttpServlet {

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
            case "/EmpresaLogin":
                this.doEmpresaLogin(request,response);
                break;
            case "/EmpresaLogout":
                this.doEmpresaLogout(request,response);
                break;
             case "/RegistrarE":
                this.doRegistrar(request,response);
                break;
             case "/EmpresaRegistrar":
                this.doEmpresaRegistrar(request,response);
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

    private void doEmpresaLogin(HttpServletRequest request, HttpServletResponse response) {
        try{
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
         Empresa empresa = gson.fromJson(reader, Empresa.class);
          
        PrintWriter out = response.getWriter();
        empresa = Model.getInstance().login(empresa);
        response.setContentType("application/json; charset=UTF-8");
         out.write(gson.toJson(empresa)); 
        if(empresa!=null){
            HttpSession s =  request.getSession();
            s.setAttribute("empresa", empresa);
            response.setStatus(200);
        } // ok with content
        else{response.setStatus(401);} 
      }
      catch(Exception e){	
        response.setStatus(401); //Bad request
      }		
    }
     protected void doEmpresaLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("main.jsp").forward( request, response);          
    }    

    private void doRegistrar(HttpServletRequest request, HttpServletResponse response) {
        try {   
            request.getRequestDispatcher("EmpresaRegistro.jsp").forward( request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ControllerEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      private void doEmpresaRegistrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         try{
            Reader empreasaReader = new BufferedReader(new InputStreamReader(request.getPart("empresa").getInputStream()));
            Gson gson = new Gson();
            Empresa empresa = gson.fromJson(empreasaReader, Empresa.class);
            empresa.setEmpresaEstadoDeCuenta("ESPERA");
            PrintWriter out = response.getWriter();
              if (Model.getInstance().create(empresa)){
             try (OutputStream fotoFile = new FileOutputStream(new File(getServletContext().getRealPath("/")+"imagenes/"+empresa.getEmpresaEmail()))) {
                 InputStream fotoReader = request.getPart("foto").getInputStream();
                 int read = 0;
                 final byte[] bytes = new byte[1024];
                 while ((read = fotoReader.read(bytes)) != -1) {
                     fotoFile.write(bytes, 0, read);
                 }} 
            response.setContentType("application/json; charset=UTF-8");
            out.write(gson.toJson(empresa));        
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

