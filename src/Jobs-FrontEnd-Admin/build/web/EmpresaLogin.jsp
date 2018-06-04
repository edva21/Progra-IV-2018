<%-- 
    Document   : EmpresaLogin
    Created on : 17/05/2018, 05:04:14 PM
    Author     : gaspa
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
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <hr>
        <div id="body" style="margin: 0 auto; width:85%; ">
            <div id="formularioDiv" style="display: block;vertical-align:top;">
                <form method="POST" name="formulario" id="formulario" action="javascript:login();">
                <table border=0 cellpadding=3 cellspacing=4 >
		   <tr><td colspan="2" class="titulo">Cuenta Empresarial</td></tr>
		   <tr><td class="etiqueta">Correo</td><td><input type="text" name="correo" id="correo"></td></tr>
		   <tr><td class="etiqueta">Clave</td><td><input type="password" name="clave" id="clave"></td></tr>
                    <tr><td class="titulo" colspan="2"><input class="boton" type="submit" value="Login"></td></tr>	   
                    </table>
                </form>
            </div>
            <div>
                <H1>No tienes cuenta? </H1>
                <div class="regresar">
                    <form method="POST" action ="Registrar">
                        <input class="button-registrar"  type="submit" value="Registrar">
                    </form>
                </div>        
            </div>    
        </div>
        <script>
            function login(){
                empresa = {empresaEmail:$("#correo").val(), empresaClave:$("#clave").val()};     
                 $.ajax({type: "POST", 
                  url:"EmpresaLogin", 
                  data: JSON.stringify(empresa), 
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
