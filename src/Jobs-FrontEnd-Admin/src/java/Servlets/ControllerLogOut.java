/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
@WebServlet(name = "ControllerLogOut", urlPatterns = {"/ControllerLogOut", "/LogOutOferente", "/LogOutEmpresa", "/LogOutAdministrador"})
public class ControllerLogOut extends HttpServlet {

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
            case "/LogOutOferente":
                this.doLogOutOff(request, response);
                break;
            case "/LogOutEmpresa":
                this.doLogOutEmp(request, response);
                break;
            case "/LogOutAdministrador":
                this.doLogOutAdm(request, response);
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

    private void doLogOutOff(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().setAttribute("oferente", null);

        try {
            PrintWriter out = response.getWriter();
            response.setStatus(200);
        } catch (IOException ex) {
            response.setStatus(401);
        }

    }

    private void doLogOutEmp(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("empresa", null);

        try {
            PrintWriter out = response.getWriter();
            response.setStatus(200);
        } catch (IOException ex) {
            response.setStatus(401);
        }
    }

    private void doLogOutAdm(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("administrador", null);

        try {
            PrintWriter out = response.getWriter();
            response.setStatus(200);
        } catch (IOException ex) {
            response.setStatus(401);
        }
    }

}
