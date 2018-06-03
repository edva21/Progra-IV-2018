<%-- 
    Document   : AdminLogin
    Created on : 17/05/2018, 12:06:00 PM
    Author     : edva590112
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>    
        <title>EmpresaLogin</title>   
        <% Administrador administrador = (Administrador) session.getAttribute("administrador");%>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <hr>
        <div id="body" style="margin: 0 auto; width:85%; ">
            <div id="formularioDiv" style="display: block;vertical-align:top;">
                <form method="POST" name="formulario" id="formulario" action="javascript:login();">
                <table border=0 cellpadding=3 cellspacing=4 >
		   <tr><td colspan="2" class="titulo">Administrador</td></tr>
		   <tr><td class="etiqueta">Nombre de Usuario</td><td><input type="text" name="correo" id="correo"></td></tr>
		   <tr><td class="etiqueta">Clave</td><td><input type="password" name="clave" id="clave"></td></tr>
                    <tr><td class="titulo" colspan="2"><input class="boton" type="submit" value="Login"></td></tr>	   
                    </table>
                </form>
            </div>                    
        </div>
        <script>
            function login(){
                administrador = {administradorUserName:$("#correo").val(), administradorClave:$("#clave").val()};     
                 $.ajax({type: "POST", 
                  url:"AdminLogin", 
                  data: JSON.stringify(administrador), 
                  dataType:"json",
                  success: 
                    function(obj){
                        show(obj); 
                    },
                  error: function(status){
                         window.alert("no");
                    }                    
                });   
                 
            }
        function show(per){
            location.href="main";
        }
       
        </script>
    </body>
</html>