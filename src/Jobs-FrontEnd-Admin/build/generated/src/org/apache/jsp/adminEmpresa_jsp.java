package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class adminEmpresa_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write(" <meta charset=\"utf-8\">\r\n");
      out.write(" <meta name=\"viewport\" content-width=\"device-width\">\r\n");
      out.write(" <title>Remove a specific table row using jQuery.</title>\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"css/adminOferente.css\">\r\n");
      out.write(" </head>\r\n");
      out.write(" <body>\r\n");
      out.write("     <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("     <script src=\"js/adminEmpresa.js\">\r\n");
      out.write("     ");
      List<BussinessLogic.Empresa> empresas = null;
      synchronized (request) {
        empresas = (List<BussinessLogic.Empresa>) _jspx_page_context.getAttribute("empresas", PageContext.REQUEST_SCOPE);
        if (empresas == null){
          empresas = new java.util.ArrayList();
          _jspx_page_context.setAttribute("empresas", empresas, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("   \r\n");
      out.write("   </script>\r\n");
      out.write(" <table id=\"mytable\">\r\n");
      out.write("     <tr id=\"header\">\r\n");
      out.write("     <th>Info</th>\r\n");
      out.write("  <th>Email</th>\r\n");
      out.write("  <th>Nombre</th>\r\n");
      out.write("  <th>Telefono</th>\r\n");
      out.write("  <th>Outro1</th>\r\n");
      out.write("  <th>Outro2</th>\r\n");
      out.write("  </tr>\r\n");
      out.write("   ");
int x = 0;for(BussinessLogic.Empresa o : empresas){ 
      out.write("                            \r\n");
      out.write("   <tr id=");
      out.print(x);
      out.write(" >\r\n");
      out.write("       <td><a href=\"#");
      out.print(x);
      out.write("modal\">+</a></td>\r\n");
      out.write("       <td class=\"email\">");
      out.print(o.getEmpresaEmail());
      out.write("</td>\r\n");
      out.write("       <td class=\"nombre\">");
      out.print(o.getEmpresaNombre());
      out.write("</td>\r\n");
      out.write("       <td class=\"telefono\">");
      out.print(o.getEmpresaTelefono());
      out.write("</td>       \r\n");
      out.write("       <td> <button type=\"button\"  class=\"");
      out.print(x);
      out.write("\" onclick=\"aproveEmpresa(this)\">Aceptar</button> </td>\r\n");
      out.write("       <td> <button type=\"button\"  class=\"");
      out.print(x);
      out.write("\" onclick=\"disaproveEmpresa(this)\">Denegar</button> </td>\r\n");
      out.write("   </tr>        \r\n");
      out.write("            ");
x++;};
      out.write("\r\n");
      out.write("   </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
int y = 0;for(BussinessLogic.Empresa o : empresas){ 
      out.write("   \r\n");
      out.write("<div id=\"");
      out.print(y);
      out.write("modal\" class=\"modalDialog\">\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<a href=\"#close\" title=\"Close\" class=\"close\">X</a>\r\n");
      out.write("\t\t<h2>");
      out.print(o.getEmpresaEmail());
      out.write("</h2>\t\t\r\n");
      out.write("                <p>Email:");
      out.print(o.getEmpresaEmail());
      out.write("</p>                   \r\n");
      out.write("                <p>Nombre:");
      out.print(o.getEmpresaNombre());
      out.write("</p>  \r\n");
      out.write("                <p>Localizacion:");
      out.print(o.getEmpresaLocalizacion());
      out.write("</p>                   \r\n");
      out.write("                <p>Telefono:");
      out.print(o.getEmpresaTelefono());
      out.write("</p>                   \r\n");
      out.write("                <p>Descripcion:");
      out.print(o.getEmpresaDescripcion());
      out.write("</p>                   \r\n");
      out.write("                <p>Nombre de Usuario:");
      out.print(o.getEmpresaUsername());
      out.write("</p>                   \r\n");
      out.write("                <td> <button type=\"button\"  class=\"");
      out.print(y);
      out.write("\" onclick=\"aproveEmpresa(this)\">Aceptar</button> </td>\r\n");
      out.write("                <td> <button type=\"button\"  class=\"");
      out.print(y);
      out.write("\" onclick=\"disaproveEmpresa(this)\">Denegar</button> </td>\r\n");
      out.write("\t</div>\r\n");
      out.write("    </div>\r\n");
y++;}
      out.write("\r\n");
      out.write("</body>\r\n");
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
