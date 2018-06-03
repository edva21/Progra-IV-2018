package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BussinessLogic.Oferente;
import BussinessLogic.Administrador;
import BussinessLogic.Empresa;

public final class AdminLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Header.jsp");
  }

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/master.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>    \r\n");
      out.write("        <title>EmpresaLogin</title>   \r\n");
      out.write("        ");
 Administrador administrador = (Administrador) session.getAttribute("administrador");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/master.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">  \r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("         ");
 Empresa empresa= (Empresa) session.getAttribute("empresa");
      out.write("\r\n");
      out.write("        ");
 Administrador admin = (Administrador) session.getAttribute("administrador");
      out.write("\r\n");
      out.write("        ");
 Oferente oferente = (Oferente) session.getAttribute("oferente");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"header\" >\r\n");
      out.write("            <div id=\"banner\"\r\n");
      out.write("                 background-image:<img src=\"images/imag1.jpg\" alt=\"\"> \r\n");
      out.write("             </div>\r\n");
      out.write("            <div class=\"banner\" id=\"b\"><a href=\"main \" style=\"color:#ffffff\"><H1></H1>\r\n");
      out.write("                <H1>Tico </H1>\r\n");
      out.write("                <H1>Empleos</H1></a>\r\n");
      out.write("             </div>\r\n");
      out.write("            <div class=\"menus\">\r\n");
      out.write("                <ul class=\"menu\">\r\n");
      out.write("                     ");
 if (empresa!=null){
      out.write("\r\n");
      out.write("                         <li><a href=\"#\">");
      out.print(empresa. getEmpresaEmail());
      out.write('-');
      out.print(empresa.getEmpresaNombre());
      out.write("<img class=\"inline\" style=\"width: 15px; height: auto;\" src=\"images/da.png\" alt=\"\"></a>\r\n");
      out.write("                         <ul class=\"menuitem\" > <li> <a href=\"EmpresaLogout\">Logout</a></li> </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                     ");
 }
      out.write("\r\n");
      out.write("                     ");
 if (admin!=null){
      out.write("\r\n");
      out.write("                         <li><a href=\"#\">");
      out.print(admin.getAdministradorUserName());
      out.write("<img class=\"inline\" style=\"width: 15px; height: auto;\" src=\"images/da.png\" alt=\"\"></a>\r\n");
      out.write("                         <ul class=\"menuitem\" > <li> <a href=\"AdminLogout\">Logout</a></li> </ul>                         \r\n");
      out.write("                        </li>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <ul>\r\n");
      out.write("                                <li><a href=\"adminOferente\">Aprovar Oferente</a></li>\r\n");
      out.write("                                <li><a href=\"adminEmpresa\">Aprovar Empresas</a></li>\r\n");
      out.write("                                <li><a href=\"adminHabilidad\">Agregar Habilidades</a></li>\r\n");
      out.write("                                <li><a href=\"adminReporte\">Generar Reportes</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     ");
 }
      out.write("\r\n");
      out.write("                     ");
 if (empresa==null && oferente== null && admin== null){
      out.write("\r\n");
      out.write("                        <li><a href=\"OfferentLogin.jsp\">ACCESO OFERENTE </a></li>\r\n");
      out.write("                        <li><a href=\"EmpresaLogin.jsp\">ACCESO EMPRESA </a></li>\r\n");
      out.write("                        <li><a href=\"AdminLogin.jsp\">ACCESO ALMINISTRADOR </a></li>\r\n");
      out.write("                    ");
 }
      out.write("         \r\n");
      out.write("                </ul>      \r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <script>     \r\n");
      out.write("        </script> \r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <hr>\r\n");
      out.write("        <div id=\"body\" style=\"margin: 0 auto; width:85%; \">\r\n");
      out.write("            <div id=\"formularioDiv\" style=\"display: block;vertical-align:top;\">\r\n");
      out.write("                <form method=\"POST\" name=\"formulario\" id=\"formulario\" action=\"javascript:login();\">\r\n");
      out.write("                <table border=0 cellpadding=3 cellspacing=4 >\r\n");
      out.write("\t\t   <tr><td colspan=\"2\" class=\"titulo\">Administrador</td></tr>\r\n");
      out.write("\t\t   <tr><td class=\"etiqueta\">Nombre de Usuario</td><td><input type=\"text\" name=\"correo\" id=\"correo\"></td></tr>\r\n");
      out.write("\t\t   <tr><td class=\"etiqueta\">Clave</td><td><input type=\"password\" name=\"clave\" id=\"clave\"></td></tr>\r\n");
      out.write("                    <tr><td class=\"titulo\" colspan=\"2\"><input class=\"boton\" type=\"submit\" value=\"Login\"></td></tr>\t   \r\n");
      out.write("                    </table>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>                    \r\n");
      out.write("        </div>\r\n");
      out.write("        <script>\r\n");
      out.write("            function login(){\r\n");
      out.write("                administrador = {administradorUserName:$(\"#correo\").val(), administradorClave:$(\"#clave\").val()};     \r\n");
      out.write("                 $.ajax({type: \"POST\", \r\n");
      out.write("                  url:\"AdminLogin\", \r\n");
      out.write("                  data: JSON.stringify(administrador), \r\n");
      out.write("                  dataType:\"json\",\r\n");
      out.write("                  success: \r\n");
      out.write("                    function(obj){\r\n");
      out.write("                        show(obj); \r\n");
      out.write("                    },\r\n");
      out.write("                  error: function(status){\r\n");
      out.write("                         window.alert(\"no\");\r\n");
      out.write("                    }                    \r\n");
      out.write("                });   \r\n");
      out.write("                 \r\n");
      out.write("            }\r\n");
      out.write("        function show(per){\r\n");
      out.write("            location.href=\"main\";\r\n");
      out.write("        }\r\n");
      out.write("       \r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
