<%-- 
    Document   : adminOferente
    Created on : 18-May-2018, 21:15:53
    Author     : edva5
--%>

<%@page import="BussinessLogic.Administrador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <meta name="viewport" content-width="device-width">
 <title>Remove a specific table row using jQuery.</title>
 <link rel="stylesheet" href="css/adminOferente.css">
 
 
 </head>
 <body>
     <%@ include file="Header.jsp"%>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     <script src="js/adminOferente.js">
     <jsp:useBean id="oferentes" scope="request" type="List<BussinessLogic.Oferente>" class="java.util.ArrayList" />   
   </script>
 <table id="mytable">
     <tr id="header">
     <th>Info</th>
  <th>Email</th>
  <th>Nombre</th>
  <th>Apellidos</th>
  <th>Outro1</th>
  <th>Outro2</th>
  </tr>
   <%int x = 0;for(BussinessLogic.Oferente o : oferentes){ %>                            
   <tr id=<%=x%> >
       <td><a href="#<%=x%>modal">+</a></td>
       <td class="email"><%=o.getOferenteEmail()%></td>
       <td class="nombre"><%=o.getOferenteNombre()%></td>
       <td class="apellido"><%=o.getOferenteApellido()%></td>       
       <td> <button type="button"  class="<%=x%>" onclick="aproveOferente(this)">Aceptar</button> </td>
       <td> <button type="button"  class="<%=x%>" onclick="disaproveOferente(this)">Denegar</button> </td>
   </tr>        
            <%x++;};%>
   </table>


<%int y = 0;for(BussinessLogic.Oferente o : oferentes){ %>   
<div id="<%=y%>modal" class="modalDialog">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		<h2><%=o.getOferenteEmail()%></h2>		
                <p>Email:<%=o.getOferenteEmail()%></p>                   
                <p>Cedula:<%=o.getOferenteCedula()%></p>  
                <p>Nombre:<%=o.getOferenteNombre()%></p>                   
                <p>Telefono:<%=o.getOferenteTelefono()%></p>                   
                <p>Residencia:<%=o.getOferenteResidencia()%></p>                   
                <p>Nombre de Usuario:<%=o.getOferenteUserName()%></p>   
                <p>Nacionalidad:<%=o.getOferenteNacionalidad()%></p>     
                <td> <button type="button"  class="<%=y%>" onclick="aproveOferente(this)">Aceptar</button> </td>
                <td> <button type="button"  class="<%=y%>" onclick="disaproveOferente(this)">Denegar</button> </td>
	</div>
    </div>
<%y++;}%>
</body>
</html>
