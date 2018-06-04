<%-- 
    Document   : adminEmpresa
    Created on : 21-May-2018, 02:42:58
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
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     <script src="js/adminEmpresa.js"></script>     
 </head>
 <body>              
     <%@ include file="Header.jsp"%>
     <jsp:useBean id="empresas" scope="request" type="List<BussinessLogic.Empresa>" class="java.util.ArrayList" />   
   </script>
 <table id="mytable">
     <tr id="header">
     <th>Info</th>
  <th>Email</th>
  <th>Nombre</th>
  <th>Telefono</th>
  <th>Outro1</th>
  <th>Outro2</th>
  </tr>
   <%int x = 0;for(BussinessLogic.Empresa o : empresas){ %>                            
   <tr id=<%=x%> >
       <td><a href="#<%=x%>modal">+</a></td>
       <td class="email"><%=o.getEmpresaEmail()%></td>
       <td class="nombre"><%=o.getEmpresaNombre()%></td>
       <td class="telefono"><%=o.getEmpresaTelefono()%></td>       
       <td> <button type="button"  class="<%=x%>" onclick="aproveEmpresa(this)">Aceptar</button> </td>
       <td> <button type="button"  class="<%=x%>" onclick="disaproveEmpresa(this)">Denegar</button> </td>
   </tr>        
            <%x++;};%>
   </table>


<%int y = 0;for(BussinessLogic.Empresa o : empresas){ %>   
<div id="<%=y%>modal" class="modalDialog">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		<h2><%=o.getEmpresaEmail()%></h2>		
                <p>Email:<%=o.getEmpresaEmail()%></p>                   
                <p>Nombre:<%=o.getEmpresaNombre()%></p>  
                <p>Localizacion:<%=o.getEmpresaLocalizacion()%></p>                   
                <p>Telefono:<%=o.getEmpresaTelefono()%></p>                   
                <p>Descripcion:<%=o.getEmpresaDescripcion()%></p>                   
                <p>Nombre de Usuario:<%=o.getEmpresaUsername()%></p>                   
                <td> <button type="button"  class="<%=y%>" onclick="aproveEmpresa(this)">Aceptar</button> </td>
                <td> <button type="button"  class="<%=y%>" onclick="disaproveEmpresa(this)">Denegar</button> </td>
	</div>
    </div>
<%y++;}%>
</body>
</html>
