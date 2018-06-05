<%-- 
    Document   : EmpleoRegistro
    Created on : 03/06/2018, 03:44:32 PM
    Author     : gaspa
--%>

<%@page import="BussinessLogic.Puesto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/master.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script type="text/javascript" src="https://maps.google.com/maps/api/js?key=AIzaSyDkH_nzn1WAba3fmOgTpVjP5obSMFV9hHM"></script>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
         <%@ include file="Header.jsp" %>
         <hr>
         <div id="area">
            <div id="formularioDiv" style="display: inline-block;vertical-align:top;">
                <form method="POST" name="formulario" id="formularioEmpleo" action="javascript:addEmpleo();">
                    <table border=0 cellpadding=3 cellspacing=4 >
                            <tr><td colspan="2" class="titulo">Puesto</td></tr>
                            <tr><td class="etiqueta">Nombre:</td><td><input type="text" name="puesto" id="puesto"></td></tr>
                            <tr><td class="etiqueta">Descripcion;</td><td><input type="text" name="descripcion" id="descripcion"></td></tr>
                            <tr><td class="etiqueta">Salario:</td><td><input type="text" name="salario" id="salario"></td></tr>
                            <tr><td class="etiqueta">Tipo</td>
			   <td>
				 <table>
                                     <tr><td class="etiqueta">Activar<input type="radio" name="tipo" value="1" id="Publico" checked ></td>
				       <td id="tdMasc"></td>
					   <td class="etiqueta">Desactivar<input type="radio" name="tipo" value="0" id="Privado"></td>
					   <td id="tdFem"></td></tr>
				  </table>
				</td>
			</tr>
                            <tr><td class="titulo" colspan="2"><input class="boton" type="submit" value="Registrar"></td></tr>
                    </table>
                </form>
            </div>
        </div>       
        <script>
        function addEmpleo(){
          
          puesto = {puestoNombre:$("#puesto").val(),
		puestoDescripcion:$("#descripcion").val(),
                puestoSalario:$("#salario").val(),
                puestoActivo: $("input[name='tipo']:checked").val()
		};
       $.ajax({type: "POST",
                url: "EmpleoAdd",
                data: JSON.stringify(puesto),
                dataType: "json",
                  success: 
                  function(obj){
                        show(obj); 
                    },
                  error: function(status){
                         window.alert("Error");
                    }                    
                });      
        }  
         function show(per){
             window.alert("Puesto registrado");
         
        }
      </script> 
     </body>
</html>
