<%-- 
    Document   : main
    Created on : 17/05/2018, 10:33:29 AM
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
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/main.js"></script> 
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>        
         <%@ include file="Header.jsp" %>
<jsp:useBean id="puestos" scope="request" type="List<Puesto>" class="java.util.ArrayList" />                        
<jsp:useBean id="habilidades" scope="request" type="List<BussinessLogic.Habilidad>" class="java.util.ArrayList" />   
<div class="container">
  <h2>Top 5 Puestos</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
     <ol class="carousel-indicators">
         <c:forEach var = "i" begin ="0" end="${puestos.size()-1}">
             <c:choose>
                 <c:when test="${i == 0}">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                 </c:when>
                 <c:otherwise>
                    <li data-target="#myCarousel" data-slide-to="${i}"></li>
                 </c:otherwise>
             </c:choose>
        </c:forEach>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        
        <%int x = 0; for(Puesto p : puestos){ %>
            <%if(x == 1){%>
                <div id="<%=p.getPuestoPK().getIdPuesto()%>" onclick="javascript:popUpCarrousel(this)" class="item">
                        <h1> &nbsp <%=p.getPuestoNombre()%></h1> 
                        <h1>&nbsp <%=p.getPuestoDescripcion()%></h1>
                        <h1>&nbsp <%=p.getPuestoSalario()%></h1>
                        <h1>&nbsp <%=p.getPuestoActivo()%></h1> 
                </div>
            <%}%>
            <%if(x == 0){ x = 1;%>
                    <div id="<%=p.getPuestoPK().getIdPuesto()%>" onclick="javascript:popUpCarrousel(this)" class="item active">
                        <h1> &nbsp <%=p.getPuestoNombre()%></h1> 
                        <h1>&nbsp <%=p.getPuestoDescripcion()%></h1>
                        <h1>&nbsp <%=p.getPuestoSalario()%></h1>
                        <h1>&nbsp <%=p.getPuestoActivo()%></h1> 
                    </div>
            <% } %>
        <% } %>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
    <div id="busquedaCar">
    <div id="jobSearch">
        <h2>Busqueda De Trabajos</h2> 
        <button type="button" class="btn btn-info" onclick="javascript:searchJobs()">Buscar Puestos</button>
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
            </table> 
        </div>
        </div>
    </body>
</html>
