package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BussinessLogic.Oferente;
import BussinessLogic.Administrador;
import BussinessLogic.Empresa;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("         ");
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
 Administrador administrador = (Administrador) session.getAttribute("administrador");
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
 if (administrador!=null){
      out.write("\r\n");
      out.write("                         <li><a href=\"#\">");
      out.print(administrador.getAdministradorUserName());
      out.write("<img class=\"inline\" style=\"width: 15px; height: auto;\" src=\"images/da.png\" alt=\"\"></a>\r\n");
      out.write("                         <ul class=\"menuitem\" > <li> <a href=\"AdminLogout\">Logout</a></li> </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                     ");
 }
      out.write("\r\n");
      out.write("                     ");
 if (empresa==null && oferente== null && administrador == null){
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
      out.write("        <h1>Pagina principal </h1>\r\n");
      out.write("    </body>\r\n");
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
