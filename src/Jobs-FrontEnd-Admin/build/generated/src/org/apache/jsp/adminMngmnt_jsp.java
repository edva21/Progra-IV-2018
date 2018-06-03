package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class adminMngmnt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("      <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>Administradores</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/master.css\">\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>   \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">    \r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"js/script.js\"></script>\r\n");
      out.write("        </head>\r\n");
      out.write("      <body>\r\n");
      out.write("          ");
      List<BussinessLogic.Administrador> administradores = null;
      synchronized (request) {
        administradores = (List<BussinessLogic.Administrador>) _jspx_page_context.getAttribute("administradores", PageContext.REQUEST_SCOPE);
        if (administradores == null){
          administradores = new java.util.ArrayList();
          _jspx_page_context.setAttribute("administradores", administradores, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("          <div class=\"jumbotron text-center\">\r\n");
      out.write("         <h1>Administración de Administradores</h1>\r\n");
      out.write("        <p>Agregue, Elimine o Edite Administradores</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    <div class=\"row\">      \r\n");
      out.write("    <div class=\"col-sm-4\">\r\n");
      out.write("      <form name=\"formulario\" id=\"formulario\" action=\"javascript:add()\" method=\"post\">\r\n");
      out.write("        <table cellpadding=\"3\" cellspacing=\"4\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td class=\"titulo\" colspan=\"2\">Agregar Adminisrador</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td class=\"etiqueta\">Nombre de Usuario:</td>\r\n");
      out.write("            <td><input class=\"form-control\"type=\"text\" name=\"username\" id=\"username\"></td>\r\n");
      out.write("            <td class=\"error\" id=\"username_error\"></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td class=\"etiqueta\">Contrasenha</td>\r\n");
      out.write("            <td><input class=\"form-control\" type=\"password\" name=\"password\" id=\"password\"></td>\r\n");
      out.write("            <td class=\"error\" id=\"password_error\"></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td class=\"titulo\" colspan=\"2\">\r\n");
      out.write("              <input type=\"submit\" name=\"\" value=\"Registrar\">\r\n");
      out.write("            </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <hr>\r\n");
      out.write("    <div class=\"col-sm-4\">\r\n");
      out.write("        <table class=\"table-bordered\">\r\n");
      out.write("        <thead>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <th>Nombre de Usuario</th>\r\n");
      out.write("            <th>Contrasena</th>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody id=\"list\">\r\n");
      out.write("            ");
int x = 0; for(BussinessLogic.Administrador a : administradores){ 
      out.write("            \r\n");
      out.write("                <div class=\"item\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(a.getAdministradorUserName());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(a.getAdministradorClave());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </div>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("      </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
