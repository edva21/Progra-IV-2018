package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import BussinessLogic.Puesto;
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("          <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/main.js\"></script> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>        \r\n");
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
      out.write('\r');
      out.write('\n');
      List<Puesto> puestos = null;
      synchronized (request) {
        puestos = (List<Puesto>) _jspx_page_context.getAttribute("puestos", PageContext.REQUEST_SCOPE);
        if (puestos == null){
          puestos = new java.util.ArrayList();
          _jspx_page_context.setAttribute("puestos", puestos, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("                        \r\n");
      List<BussinessLogic.Habilidad> habilidades = null;
      synchronized (request) {
        habilidades = (List<BussinessLogic.Habilidad>) _jspx_page_context.getAttribute("habilidades", PageContext.REQUEST_SCOPE);
        if (habilidades == null){
          habilidades = new java.util.ArrayList();
          _jspx_page_context.setAttribute("habilidades", habilidades, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("   \r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <h2>Top 5 Puestos</h2>  \r\n");
      out.write("  <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("    <!-- Indicators -->\r\n");
      out.write("     <ol class=\"carousel-indicators\">\r\n");
      out.write("         <c:forEach var = \"i\" begin =\"0\" end=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${puestos.size()-1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("             <c:choose>\r\n");
      out.write("                 <c:when test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i == 0}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                    <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("                 </c:when>\r\n");
      out.write("                 <c:otherwise>\r\n");
      out.write("                    <li data-target=\"#myCarousel\" data-slide-to=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></li>\r\n");
      out.write("                 </c:otherwise>\r\n");
      out.write("             </c:choose>\r\n");
      out.write("        </c:forEach>\r\n");
      out.write("    </ol>\r\n");
      out.write("    <!-- Wrapper for slides -->\r\n");
      out.write("    <div class=\"carousel-inner\">\r\n");
      out.write("        \r\n");
      out.write("        ");
int x = 0; for(Puesto p : puestos){ 
      out.write("\r\n");
      out.write("            ");
if(x == 1){
      out.write("\r\n");
      out.write("                <div id=\"");
      out.print(p.getPuestoPK().getIdPuesto());
      out.write("\" onclick=\"javascript:popUpCarrousel(this)\" class=\"item\">\r\n");
      out.write("                        <h1> &nbsp ");
      out.print(p.getPuestoNombre());
      out.write("</h1> \r\n");
      out.write("                        <h1>&nbsp ");
      out.print(p.getPuestoDescripcion());
      out.write("</h1>\r\n");
      out.write("                        <h1>&nbsp ");
      out.print(p.getPuestoSalario());
      out.write("</h1>\r\n");
      out.write("                        <h1>&nbsp ");
      out.print(p.getPuestoActivo());
      out.write("</h1> \r\n");
      out.write("                </div>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("            ");
if(x == 0){ x = 1;
      out.write("\r\n");
      out.write("                    <div id=\"");
      out.print(p.getPuestoPK().getIdPuesto());
      out.write("\" onclick=\"javascript:popUpCarrousel(this)\" class=\"item active\">\r\n");
      out.write("                        <h1> &nbsp ");
      out.print(p.getPuestoNombre());
      out.write("</h1> \r\n");
      out.write("                        <h1>&nbsp ");
      out.print(p.getPuestoDescripcion());
      out.write("</h1>\r\n");
      out.write("                        <h1>&nbsp ");
      out.print(p.getPuestoSalario());
      out.write("</h1>\r\n");
      out.write("                        <h1>&nbsp ");
      out.print(p.getPuestoActivo());
      out.write("</h1> \r\n");
      out.write("                    </div>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Left and right controls -->\r\n");
      out.write("    <a class=\"left carousel-control\" href=\"#myCarousel\" data-slide=\"prev\">\r\n");
      out.write("      <span class=\"glyphicon glyphicon-chevron-left\"></span>\r\n");
      out.write("      <span class=\"sr-only\">Previous</span>\r\n");
      out.write("    </a>\r\n");
      out.write("    <a class=\"right carousel-control\" href=\"#myCarousel\" data-slide=\"next\">\r\n");
      out.write("      <span class=\"glyphicon glyphicon-chevron-right\"></span>\r\n");
      out.write("      <span class=\"sr-only\">Next</span>\r\n");
      out.write("    </a>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("    <div id=\"busquedaCar\">\r\n");
      out.write("    <div id=\"jobSearch\">\r\n");
      out.write("        <h2>Busqueda De Trabajos</h2> \r\n");
      out.write("        <button type=\"button\" class=\"btn btn-info\" onclick=\"javascript:searchJobs()\">Buscar Puestos</button>\r\n");
      out.write("                <ul id=\"path\"></ul>\r\n");
      out.write("        <ul id=\"habilidadList\">            \r\n");
      out.write("            ");
int y = 0;for(BussinessLogic.Habilidad h : habilidades){ 
      out.write(" \r\n");
      out.write("            ");
if(!h.isHabilidadEsHoja()){
      out.write("\r\n");
      out.write("            <li  class=\"itemSearch\" onclick=\"javascript:navHabilidad(this)\">");
      out.print(h.getHabilidadNombre());
      out.write("</li>\r\n");
      out.write("            ");
}else{
      out.write("\r\n");
      out.write("            <li  class=\"leafitem\" onclick=\"javascript:navHabilidad(this)\"><font color=\"red\">");
      out.print(h.getHabilidadNombre());
      out.write("</font><input id=\"");
      out.print(h.getHabilidadNombre());
      out.write("\" onclick=\"javascrip:checkleaf(this)\" type=\"checkbox\"><input id=\"");
      out.print(h.getHabilidadNombre());
      out.write("nmbr\" type=\"number\" onchange=\"changedNumber(this)\" min=\"1\" max=\"100\" style=\"display:none\"></li>\r\n");
      out.write("            ");
}}
      out.write("                        \r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("        <div id=\"carrito\">\r\n");
      out.write("            <h3>Carrito</h3> \r\n");
      out.write("             <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>Habilidad</th>\r\n");
      out.write("                    <th>Porcentaje</th>                    \r\n");
      out.write("                </tr>\r\n");
      out.write("            </table> \r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
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
