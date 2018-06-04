<%-- 
    Document   : Header
    Created on : 17/05/2018, 11:12:54 AM
    Author     : gaspa
--%>

<%@page import="BussinessLogic.Oferente"%>
<%@page import="BussinessLogic.Administrador"%>
<%@page import="BussinessLogic.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
         <% Empresa empresa= (Empresa) session.getAttribute("empresa");%>
        <% Administrador admin = (Administrador) session.getAttribute("administrador");%>
        <% Oferente oferente = (Oferente) session.getAttribute("oferente");%>
    </head>
    <body>
        <div class="header" >
            <div id="banner"
                 background-image:<img src="images/imag1.jpg" alt=""> 
             </div>
            <div class="banner" id="b"><a href="main " style="color:#ffffff"><H1></H1>
                <H1>Tico </H1>
                <H1>Empleos</H1></a>
             </div>
            <div class="menus">
                <ul class="menu">
                     <% if (empresa!=null){%>
                         <li><a href="#"><%=empresa. getEmpresaEmail()%>-<%=empresa.getEmpresaNombre()%><img class="inline" style="width: 15px; height: auto;" src="images/da.png" alt=""></a>
                         <ul class="menuitem" > <li> <a href="main.jsp" onclick="javascript:logOutEmp();">Logout</a></li> </ul>
                        </li>
                     <% }%>
                     <% if (oferente!=null){%>
                         <li><a href="#"><%=oferente.getOferenteEmail()%>-<%=oferente.getOferenteNombre()%><img class="inline" style="width: 15px; height: auto;" src="images/da.png" alt=""></a>
                             <ul class="menuitem" > <li> <a href="main.jsp" onclick="javascript:logOutOff();">Logout</a></li> </ul>
                         <ul class="menuitem" > <li> <a href="OferenteSubidaPDF.jsp">Subir Currículum PDF</a></li> </ul>
                         <ul class="menuitem" > <li> <a href="EdiciónDatosOferente.jsp">Editar Datos Personales</a></li> </ul>
                        </li>
                     <% }%>
                     <% if (admin!=null){%>
                         <li><a href="#"><%=admin.getAdministradorUserName()%><img class="inline" style="width: 15px; height: auto;" src="images/da.png" alt=""></a>
                         <ul class="menuitem" > <li> <a href="main.jsp" onclick="javascript:logOutAdm();">Logout</a></li> </ul>
                        </li>
                        <div>
                            <ul>
                                <li><a href="adminOferente">Aprovar Oferente</a></li>
                                <li><a href="adminEmpresa">Aprovar Empresas</a></li>
                                <li><a href="adminHabilidad">Agregar Habilidades</a></li>
                                <li><a href="adminReporte">Generar Reportes</a></li>
                            </ul>
                        </div>
                     <% }%>
                     <% if (empresa==null && oferente== null && admin== null){%>
                        <li><a href="OfferentLogin.jsp">ACCESO OFERENTE </a></li>
                        <li><a href="EmpresaLogin.jsp">ACCESO EMPRESA </a></li>
                        <li><a href="AdminLogin.jsp">ACCESO ALMINISTRADOR </a></li>
                    <% }%>         
                </ul>      
            </div>
            
        </div>
        
        <script>     
            function logOutOff() {
                
                $.ajax({type: "POST",
                    url: "LogOutOferente",
                    success:
                            function (obj) {
                                
                            },
                    error: function (jqXHR, textStatus, errorThrown) {
                        if (jqXHR.status === 0) {

                            window.alert('Not connect: Verify Network.');

                        } else if (jqXHR.status == 404) {

                            window.alert('Requested page not found [404]');

                        } else if (jqXHR.status == 500) {

                            window.alert('Internal Server Error [500].');

                        } else if (textStatus === 'parsererror') {

                            window.alert('Requested JSON parse failed.');

                        } else if (textStatus === 'timeout') {

                            window.alert('Time out error.');

                        } else if (textStatus === 'abort') {

                            window.alert('Ajax request aborted.');

                        } else {

                            window.alert('Uncaught Error: ' + jqXHR.responseText);

                        }


                    }
                });

            }
            
            function logOutEmp() {
                
                $.ajax({type: "POST",
                    url: "LogOutEmpresa",
                    success:
                            function (obj) {
                            },
                    error: function (jqXHR, textStatus, errorThrown) {
                        if (jqXHR.status === 0) {

                            window.alert('Not connect: Verify Network.');

                        } else if (jqXHR.status == 404) {

                            window.alert('Requested page not found [404]');

                        } else if (jqXHR.status == 500) {

                            window.alert('Internal Server Error [500].');

                        } else if (textStatus === 'parsererror') {

                            window.alert('Requested JSON parse failed.');

                        } else if (textStatus === 'timeout') {

                            window.alert('Time out error.');

                        } else if (textStatus === 'abort') {

                            window.alert('Ajax request aborted.');

                        } else {

                            window.alert('Uncaught Error: ' + jqXHR.responseText);

                        }


                    }
                });

            }
            
            function logOutAdm() {
                
                $.ajax({type: "POST",
                    url: "LogOutAdministrador",
                    success:
                            function (obj) {
                            },
                    error: function (jqXHR, textStatus, errorThrown) {
                        if (jqXHR.status === 0) {

                            window.alert('Not connect: Verify Network.');

                        } else if (jqXHR.status == 404) {

                            window.alert('Requested page not found [404]');

                        } else if (jqXHR.status == 500) {

                            window.alert('Internal Server Error [500].');

                        } else if (textStatus === 'parsererror') {

                            window.alert('Requested JSON parse failed.');

                        } else if (textStatus === 'timeout') {

                            window.alert('Time out error.');

                        } else if (textStatus === 'abort') {

                            window.alert('Ajax request aborted.');

                        } else {

                            window.alert('Uncaught Error: ' + jqXHR.responseText);

                        }


                    }
                });

            }
        </script> 

    </body>
</html>

