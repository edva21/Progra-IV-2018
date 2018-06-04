<%-- 
    Document   : adminHabilidad
    Created on : 21-May-2018, 05:24:38
    Author     : edva5
--%>

<%@page import="BussinessLogic.Administrador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/adminHabilidad.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="js/adminHabilidad.js"></script>        
    </head>
    <body>        
        <jsp:useBean id="habilidades" scope="request" type="List<BussinessLogic.Habilidad>" class="java.util.ArrayList" />   
        <%@ include file="Header.jsp"%>
        <ul id="path"></ul>
        <ul id="habilidadList">
            <li><input id="newhabilidad" onkeydown="javascript:addHabilidad(event)" type="text" name="habilidad" value="" >Es Hoja:<input id="mycheckBox" onclick="javascrip:checkleaf()" type="checkbox"></li>            
            <%int x = 0;for(BussinessLogic.Habilidad h : habilidades){ %> 
            <%if(!h.isHabilidadEsHoja()){%>
            <li id="<%=h.getHabilidadNombre()%>" class="item" onclick="javascript:navHabilidad(this)"><%=h.getHabilidadNombre()%></li>
            <%}else{%>
            <li id="<%=h.getHabilidadNombre()%>" class="item" onclick="javascript:navHabilidad(this)"><font color="red"><%=h.getHabilidadNombre()%></font></li>
            <%}}%>                        
        </ul>  
    </body>
</html>
