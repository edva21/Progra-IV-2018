<%-- 
    Document   : OfferentHabilidad
    Created on : 03-Jun-2018, 15:59:15
    Author     : edva5
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/main.css">
        <script src="js/OfferentHabilidad.js"></script>    
    </head>
    <body onload="javascript:getHabilidadesOferente()">
        <%@ include file="Header.jsp" %>
        <jsp:useBean id="habilidades" scope="request" type="List<BussinessLogic.Habilidad>" class="java.util.ArrayList" />   
        <jsp:useBean id="habilidades_oferente" scope="request" type="List<BussinessLogic.OferenteHasHabilidad>" class="java.util.ArrayList" />   
   <div id="busquedaCar">
    <div id="jobSearch">
        <h2>Actualizar Habilidades</h2> 
        <button type="button" class="btn btn-info" onclick="javascript:guardarCambios()">Guardar Cambios</button>
                <ul id="path"></ul>
        <ul id="habilidadList">            
            <%int y = 0;for(BussinessLogic.Habilidad h : habilidades){ %> 
            <%if(!h.isHabilidadEsHoja()){%>
            <li  class="itemSearch" onclick="javascript:navHabilidad(this)"><%=h.getHabilidadNombre()%></li>
            <%}else{%>
            <li  class="leafitem" onclick="javascript:navHabilidad(this)"><font color="red"><%=h.getHabilidadNombre()%></font><input id="<%=h.getHabilidadNombre()%>" onclick="javascrip:checkleaf(this)" type="checkbox"><input id="<%=h.getHabilidadNombre()%>nmbr" type="number" onchange="changedNumber(this)" min="1" max="100" style="display:none"></li>
            <%}}%>                        
        </ul>
    </div>
        <div id="carrito">
            <h3>Carrito</h3> 
             <table>
                <tr>
                    <th>Habilidad</th>
                    <th>Porcentaje</th>                    
                </tr>
                <%int z = 0;for(BussinessLogic.OferenteHasHabilidad h : habilidades_oferente){ %> 
                <tr id="<%=h.getHabilidad().getHabilidadNombre()%>msi" class="carritoItem">
                    <td class="nombre"><%=h.getHabilidad().getHabilidadNombre()%></td>
                    <td class="porcentaje"><%=h.getPuestoHabilidadPorcentaje()%></td>
                </tr>                
            <%}%>   
            </table> 
        </div>
        </div>
    </body>
</html>
