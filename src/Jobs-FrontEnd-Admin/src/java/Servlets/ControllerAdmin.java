/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import FEBussinesLogic.MensajeEstado;
import BussinessLogic.Administrador;
import BussinessLogic.Habilidad;
import BussinessLogic.Nacionalidad;
import BussinessLogic.Puesto;
import FEBussinesLogic.PuestoDto;
import Model.Model;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
 * @author edva5
 */
@MultipartConfig @WebServlet(name = "Administradores", urlPatterns = {"/AdminLogout","/AdminLogin","/sendJobReport","/sendHabilidades","/sendHabilidad","/sonsHabilidad","/addHabilidad","/Administradores","/add","/cambiarEstadoOferente","/cambiarEstadoEmpresa"})
public class ControllerAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{        
      switch(request.getServletPath()){                   
           case "/add":
            doAdd(request,response);
              break;
           case "/cambiarEstadoOferente":
               doUpdateEstadoOferente(request, response);
               break;
            case "/cambiarEstadoEmpresa":
               doUpdateEstadoEmpresa(request, response);
               break;
            case "/addHabilidad":
               doAddHabilidad(request, response);
               break;               
            case "/sendHabilidad":
               doSendHabilidad(request, response);
               break;
            case "/sendHabilidades":
               doSendHabilidades(request, response);
               break;
            case "/sonsHabilidad":
                doSendSons(request, response);
                break;
            case "/sendJobReport":
                doSendJobsReports(request, response);
                break;
            case "/AdminLogin":
                doAdminLogin(request, response);
                break;
            case "/AdminLogout":
                doAdminLogout(request, response);
                break;
          default:
              break;
      }           
    }
    private void doAdd(HttpServletRequest request, HttpServletResponse response){                
       
        try {
        Reader personaReader = new BufferedReader(new InputStreamReader(request.getPart("objeto").getInputStream()));
        Gson gson = new Gson();
        Administrador object = gson.fromJson(personaReader, Administrador.class);
        PrintWriter out;
        out = response.getWriter();
         Model.getInstance().create(object);        
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(object));        
        response.setStatus(200); // ok with content
        } catch (IOException ex) {
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    private void doUpdateEstadoOferente(HttpServletRequest request, HttpServletResponse response){                
        try {
        Reader reader = new BufferedReader(new InputStreamReader(request.getPart("objeto").getInputStream()));
        Gson gson = new Gson();
        MensajeEstado object = gson.fromJson(reader, MensajeEstado.class);
        PrintWriter out;
        out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(object));    
            if (Model.getInstance().updateEstado(object.getOferenteid(), object.getEstado()))
                response.setStatus(200); // ok with content
            else
                response.setStatus(401); 
        } catch (IOException ex) {            
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void doUpdateEstadoEmpresa(HttpServletRequest request, HttpServletResponse response){                
        try {
        Reader reader = new BufferedReader(new InputStreamReader(request.getPart("objeto").getInputStream()));
        Gson gson = new Gson();
        MensajeEstado object = gson.fromJson(reader, MensajeEstado.class);
        PrintWriter out;
        out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(object));    
            if (Model.getInstance().updateEstadoEmpresa(object.getOferenteid(), object.getEstado()))
                response.setStatus(200); // ok with content
            else
                response.setStatus(401); 
        } catch (IOException ex) {            
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
    private void doAddHabilidad(HttpServletRequest request, HttpServletResponse response){                
        Gson gson = new Gson();
        try {
        Reader reader = new BufferedReader(new InputStreamReader(request.getPart("objeto").getInputStream()));        
        Habilidad object = gson.fromJson(reader, Habilidad.class);
        PrintWriter out;
        out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(object));    
            if (Model.getInstance().create(object))
                response.setStatus(200); // ok with content
            else
                response.setStatus(401); 
        } catch (IOException ex) {            
            response.setStatus(401);             
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(JsonSyntaxException ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void doSendSons(HttpServletRequest request, HttpServletResponse response){                        
        try {
        Gson gson = new Gson();
        Reader reader = request.getReader();
        Habilidad object = gson.fromJson(reader, Habilidad.class);
         List<Habilidad> l;
        if(object.getHabilidadNombre().equals("Inicio"))
            l=Model.getInstance().readAllHabilidadRoots();
        else
            l=Model.getInstance().readAllHabilidadHijos(object.getHabilidadNombre()); 
        PrintWriter out;
        String json =gson.toJson(l);
        out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        out.write(json);                
                response.setStatus(200); // ok with content           
        } catch (IOException ex) {            
            response.setStatus(401);             
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(JsonSyntaxException ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void doSendHabilidad(HttpServletRequest request, HttpServletResponse response){                        
        Gson gson = new Gson();
        try {
        Reader reader = request.getReader();
        Habilidad object = gson.fromJson(reader, Habilidad.class);
        PrintWriter out;
        object = Model.getInstance().readHabilidad(object.getHabilidadNombre());        
        out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(object));    
        response.setStatus(200); // ok with content
        } catch (IOException ex) {            
            response.setStatus(401);             
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(JsonSyntaxException ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private void doSendHabilidades(HttpServletRequest request, HttpServletResponse response){                        
        try {
        Gson gson = new Gson();        
        List<Habilidad> l=Model.getInstance().readAllHabilidad();
        PrintWriter out;
        String json =gson.toJson(l);
        out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        out.write(json);                
                response.setStatus(200); // ok with content           
        } 
        catch(JsonSyntaxException ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void doSendJobsReports(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException{                        
        Gson gson = new Gson();
        try {
        Reader reader = request.getReader();
        String object = gson.fromJson(reader, String.class);
        PrintWriter out;
        LocalDate date = LocalDate.parse(object+"-01");
        List<Puesto> l = Model.getInstance().readJobsByMonth(date);
        ArrayList<PuestoDto> p = new ArrayList<PuestoDto>();
        l.stream().forEach(x->p.add(new PuestoDto(x)));
        out = response.getWriter();
        response.setContentType("application/json; charset=UTF-8");
        out.write(gson.toJson(p));    
        response.setStatus(200); // ok with content
        } catch (IOException ex) {            
            response.setStatus(401);             
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(JsonSyntaxException ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception ex){
            response.setStatus(401); 
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void doAdminLogin(HttpServletRequest request, HttpServletResponse response) {
        try{
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
         Administrador admin = gson.fromJson(reader, Administrador.class);          
        PrintWriter out = response.getWriter();
        boolean x = Model.getInstance().login(admin);
        response.setContentType("application/json; charset=UTF-8");
         out.write(gson.toJson(admin)); 
         if(admin!=null){
            HttpSession s =  request.getSession();
            s.setAttribute("administrador", admin);
            response.setStatus(200);
        } // ok with content
        if(x){response.setStatus(200);} // ok with content
        else{response.setStatus(401);} 
        
      }
      catch(Exception e){	
        response.setStatus(401); //Bad request
      }		
    }
    protected void doAdminLogout(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            request.getSession().invalidate();
            request.getRequestDispatcher("main.jsp").forward( request, response);          
    }    
    
}