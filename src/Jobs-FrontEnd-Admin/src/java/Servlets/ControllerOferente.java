package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BussinessLogic.Nacionalidad;
import BussinessLogic.Oferente;
import Model.Model;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author fabio
 */
@WebServlet(name = "ControllerOferente", urlPatterns = {"/ControllerOferente", "/OfferentLogin", "/OferenteRegistro", "/OferenteForm", "/GetNac","/toOferenteRegistro", "/UploadPDF"})
public class ControllerOferente extends HttpServlet {

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
        switch (request.getServletPath()) {
            case "/OfferentLogin":
                this.doOferenteLogin(request, response);
                break;
            case "/OferenteRegistro":
                this.doOferenteRegistro(request, response);
                break;
            case "/GetNac":
                this.doGetNacionalidad(request, response);
                break; 
            case "/toOferenteRegistro":
                request.getRequestDispatcher("OfferentRegistro.jsp").forward(request, response);
                break;
            case "/UploadPDF":
                this.doUploadPDF(request, response);
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

    private void doOferenteLogin(HttpServletRequest request, HttpServletResponse response) {
        try {
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            Oferente oferente = gson.fromJson(reader, Oferente.class);

            PrintWriter out = response.getWriter();
            oferente = Model.getInstance().login(oferente);
            response.setContentType("application/json; charset=UTF-8");
            out.write(gson.toJson(oferente));
            if (oferente != null) {
                HttpSession s = request.getSession();
                s.setAttribute("oferente", oferente);
                response.setStatus(200);
            } // ok with content
            else {
                response.setStatus(401);
            }
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            response.setStatus(401); //Bad request
        }
    }

    private void doOferenteRegistro(HttpServletRequest request, HttpServletResponse response) {
        try {
            BufferedReader reader = request.getReader();
            Gson gson = new Gson();
            Oferente oferente = gson.fromJson(reader, Oferente.class);
            oferente.setOferenteCurriculum(null);

            PrintWriter out = response.getWriter();
            boolean x = Model.getInstance().create(oferente);
            if (x) {
                response.setContentType("application/json; charset=UTF-8");
                out.write(gson.toJson(oferente));
                response.setStatus(200);
            } // ok with content
            else {
                response.setStatus(401);
            }
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            response.setStatus(401); //Bad request
        }
    }

    private void doGetNacionalidad(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Nacionalidad> nac = Model.getInstance().readAllNacionalidad();
            List<String> l = new ArrayList<>();
            for (int i = 0; i < nac.size(); i++) {
                l.add(nac.get(i).getNacionalidadNombre());
            }
            String json = new Gson().toJson(nac);

            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(json);       // Write response body.
            if (!nac.isEmpty()) {
                response.setStatus(200);
            } else {
                response.setStatus(401);
            }
        } catch (IOException ex) {
            response.setStatus(401);
        }
    }

    private void doUploadPDF(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            InputStream fileReader = request.getInputStream();
            final byte[] bitesFile = new byte[1024];
            fileReader.read(bitesFile);
            
            Oferente o = Model.getInstance().readOferente("fabio@email.com");
            o.setOferenteCurriculum(bitesFile);
            boolean b = Model.getInstance().update(o);
            if (b) {
                response.setStatus(200);
            } else {
                response.setStatus(401);
            }
        } catch (FileNotFoundException ex ) {
            Logger.getLogger(ControllerOferente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerOferente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
