package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import BussinessLogic.Puesto;

public final class EmppleoHabilidad_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"listadoDiv\" style=\"display: block; vertical-align:top;\">\n");
      out.write("        ");
      List<Puesto> puestos = null;
      puestos = (List<Puesto>) _jspx_page_context.getAttribute("puestos", PageContext.REQUEST_SCOPE);
      if (puestos == null){
        throw new java.lang.InstantiationException("bean puestos not found within scope");
      }
      out.write("\n");
      out.write("\t<table class=\"grid\">\n");
      out.write("\t  <thead><tr><th>Nombre</th><th>Salario</th><th>Activo</th><th>...</th></tr></thead>\n");
      out.write("          <tbody id=\"listado\">\n");
      out.write("            ");
 for(Puesto p: puestos){ 
      out.write("\n");
      out.write("                 <tr>\n");
      out.write("                    <td>");
      out.print(p.getPuestoNombre());
      out.write("\n");
      out.write("                    </td><td>");
      out.print(p.getPuestoNombre());
      out.write("</td>\n");
      out.write("                    </td><td>");
      out.print(p.getPuestoSalario());
      out.write("</td>\n");
      out.write("                    </td><td>");
      out.print(p.getPuestoActivo());
      out.write(" onclick='edit();'</td>\n");
      out.write("                 </tr>\n");
      out.write("           ");
 } 
      out.write("              \n");
      out.write("          </tbody>\n");
      out.write("\t</table>\n");
      out.write("</div>\t\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
