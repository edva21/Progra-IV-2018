<%-- 
    Document   : adminMngmnt
    Created on : 03-May-2018, 14:57:01
    Author     : edva5
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
    <meta charset="utf-8">
    <title>Administradores</title>
    <link rel="stylesheet" href="css/master.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>   
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
        </head>
      <body>
          <jsp:useBean id="administradores" scope="request" type="List<BussinessLogic.Administrador>" class="java.util.ArrayList" />
          <div class="jumbotron text-center">
         <h1>Administración de Administradores</h1>
        <p>Agregue, Elimine o Edite Administradores</p>
        </div>
    <div class="row">      
    <div class="col-sm-4">
      <form name="formulario" id="formulario" action="javascript:add()" method="post">
        <table cellpadding="3" cellspacing="4">
          <tr>
            <td class="titulo" colspan="2">Agregar Adminisrador</td>
          </tr>
          <tr>
            <td class="etiqueta">Nombre de Usuario:</td>
            <td><input class="form-control"type="text" name="username" id="username"></td>
            <td class="error" id="username_error"></td>
          </tr>
          <tr>
            <td class="etiqueta">Contrasenha</td>
            <td><input class="form-control" type="password" name="password" id="password"></td>
            <td class="error" id="password_error"></td>
          </tr>
          <tr>
            <td class="titulo" colspan="2">
              <input type="submit" name="" value="Registrar">
            </td>
          </tr>
        </table>
      </form>
    </div>
    <hr>
    <div class="col-sm-4">
        <table class="table-bordered">
        <thead>
          <tr>
            <th>Nombre de Usuario</th>
            <th>Contrasena</th>
          </tr>
        </thead>
        <tbody id="list">
            <%int x = 0; for(BussinessLogic.Administrador a : administradores){ %>            
                <div class="item">
                    <tr>
                        <td>
                            <%=a.getAdministradorUserName()%>
                        </td>
                        <td>
                            <%=a.getAdministradorClave()%>
                        </td>
                    </tr>
                </div>
            <%}%>
        </tbody>
      </table>
    </div>
    </div>
  </body>
</html>
