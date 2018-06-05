<%-- 
    Document   : EmppleoHabilidad
    Created on : 04/06/2018, 05:13:39 PM
    Author     : gaspa
--%>

<%@page import="java.util.List"%>
<%@page import="BussinessLogic.Puesto"%>
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
        <div id="listadoDiv" style="display: block; vertical-align:top;">
        <jsp:useBean id="puestos" scope="request" type="List<Puesto>" />
        <table class="grid">
	  <thead><tr><th>Puesto</th><th>Salario</th><th>Activo</th><th>Habilidades</th></tr></thead>
          <tbody id="listado">
            <% for(Puesto p: puestos){ %>
                 <tr>
                    <td><%=p.getPuestoNombre()%></td>
                    <td><%=p.getPuestoSalario()%></td>
                    <td><%=p.getPuestoActivo()%></td>
                    <td>
                        <table>
                            <tr><td class="etiqueta">Activar<input type="radio" name="tipo" value="1" id="Publico" checked ></td>
				<td id="tdMasc"></td>
                                <td class="etiqueta">Desactivar<input type="radio" name="tipo" value="0" id="Privado"></td>
			        <td id="tdFem"></td></tr>
                        </table>
		     </td>
                    <td><img src='images/edit.png' onclick='ID(<%=p.getPuestoPK().getIdPuesto()%>);'></td>
                 </tr>
           <% } %>              
          </tbody>
	</table>
        </div>	
          <script>
              function ID(id){
                  var x = id;
                    window.alert(x);
              }
          </script>
    </body>
</html>
