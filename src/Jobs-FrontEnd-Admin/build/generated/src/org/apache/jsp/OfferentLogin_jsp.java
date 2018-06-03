package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import BussinessLogic.Oferente;
import BussinessLogic.Administrador;
import BussinessLogic.Empresa;

public final class OfferentLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <style>\r\n");
      out.write("            body {font-family: Arial, Helvetica, sans-serif;}\r\n");
      out.write("\r\n");
      out.write("            /* Full-width input fields */\r\n");
      out.write("            input[type=text], input[type=password] {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                padding: 12px 20px;\r\n");
      out.write("                margin: 8px 0;\r\n");
      out.write("                display: inline-block;\r\n");
      out.write("                border: 1px solid #ccc;\r\n");
      out.write("                box-sizing: border-box;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Set a style for all buttons */\r\n");
      out.write("            button {\r\n");
      out.write("                background-color: #4CAF50;\r\n");
      out.write("                color: white;\r\n");
      out.write("                padding: 14px 20px;\r\n");
      out.write("                margin: 8px 0;\r\n");
      out.write("                border: none;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("                width: 100%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            button:hover {\r\n");
      out.write("                opacity: 0.8;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Extra styles for the cancel button */\r\n");
      out.write("            .cancelbtn {\r\n");
      out.write("                width: auto;\r\n");
      out.write("                padding: 10px 18px;\r\n");
      out.write("                background-color: #f44336;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Center the image and position the close button */\r\n");
      out.write("            .imgcontainer {\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                margin: 24px 0 12px 0;\r\n");
      out.write("                position: relative;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            img.avatar {\r\n");
      out.write("                width: 40%;\r\n");
      out.write("                border-radius: 50%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .container {\r\n");
      out.write("                padding: 16px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            span.psw {\r\n");
      out.write("                float: right;\r\n");
      out.write("                padding-top: 16px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* The Modal (background) */\r\n");
      out.write("            .modal {\r\n");
      out.write("                display: none; /* Hidden by default */\r\n");
      out.write("                position: fixed; /* Stay in place */\r\n");
      out.write("                z-index: 1; /* Sit on top */\r\n");
      out.write("                left: 0;\r\n");
      out.write("                top: 0;\r\n");
      out.write("                width: 100%; /* Full width */\r\n");
      out.write("                height: 100%; /* Full height */\r\n");
      out.write("                overflow: auto; /* Enable scroll if needed */\r\n");
      out.write("                background-color: rgb(0,0,0); /* Fallback color */\r\n");
      out.write("                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\r\n");
      out.write("                padding-top: 60px;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Modal Content/Box */\r\n");
      out.write("            .modal-content {\r\n");
      out.write("                background-color: #fefefe;\r\n");
      out.write("                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */\r\n");
      out.write("                border: 1px solid #888;\r\n");
      out.write("                width: 80%; /* Could be more or less, depending on screen size */\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* The Close Button (x) */\r\n");
      out.write("            .close {\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                right: 25px;\r\n");
      out.write("                top: 0;\r\n");
      out.write("                color: #000;\r\n");
      out.write("                font-size: 35px;\r\n");
      out.write("                font-weight: bold;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .close:hover,\r\n");
      out.write("            .close:focus {\r\n");
      out.write("                color: red;\r\n");
      out.write("                cursor: pointer;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Add Zoom Animation */\r\n");
      out.write("            .animate {\r\n");
      out.write("                -webkit-animation: animatezoom 0.6s;\r\n");
      out.write("                animation: animatezoom 0.6s\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            @-webkit-keyframes animatezoom {\r\n");
      out.write("                from {-webkit-transform: scale(0)} \r\n");
      out.write("                to {-webkit-transform: scale(1)}\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            @keyframes animatezoom {\r\n");
      out.write("                from {transform: scale(0)} \r\n");
      out.write("                to {transform: scale(1)}\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            /* Change styles for span and cancel button on extra small screens */\r\n");
      out.write("            @media screen and (max-width: 300px) {\r\n");
      out.write("                span.psw {\r\n");
      out.write("                    display: block;\r\n");
      out.write("                    float: none;\r\n");
      out.write("                }\r\n");
      out.write("                .cancelbtn {\r\n");
      out.write("                    width: 100%;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
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
      out.write("        <button onclick=\"document.getElementById('id01').style.display = 'block'\" style=\"width:auto;\">Login</button>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"id01\" class=\"modal\">\r\n");
      out.write("\r\n");
      out.write("            <form class=\"modal-content animate\" action=\"/action_page.php\">\r\n");
      out.write("                <div class=\"imgcontainer\">\r\n");
      out.write("                    <span onclick=\"document.getElementById('id01').style.display = 'none'\" class=\"close\" title=\"Close Modal\">&times;</span>\r\n");
      out.write("                    <img src=\"img_avatar2.png\" alt=\"Avatar\" class=\"avatar\">\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <label for=\"uname\"><b>Username</b></label>\r\n");
      out.write("                    <input type=\"text\" placeholder=\"Enter Username\" name=\"uname\" required>\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"psw\"><b>Password</b></label>\r\n");
      out.write("                    <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required>\r\n");
      out.write("\r\n");
      out.write("                    <button type=\"submit\">Login</button>\r\n");
      out.write("                    <label>\r\n");
      out.write("                        <input type=\"checkbox\" checked=\"checked\" name=\"remember\"> Remember me\r\n");
      out.write("                    </label>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            // Get the modal\r\n");
      out.write("            var modal = document.getElementById('id01');\r\n");
      out.write("\r\n");
      out.write("            // When the user clicks anywhere outside of the modal, close it\r\n");
      out.write("            window.onclick = function (event) {\r\n");
      out.write("                if (event.target == modal) {\r\n");
      out.write("                    modal.style.display = \"none\";\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
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
