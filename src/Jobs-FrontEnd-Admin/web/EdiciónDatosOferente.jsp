<%-- 
    Document   : EdiciónDatosOferente
    Created on : 04/06/2018, 11:18:48 AM
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <div id="body" style="margin: 0 auto; width:85%; ">
            <div id="formularioDiv" style="display: block;vertical-align:top;">
                <form method="POST" name="formulario" id="formulario" action="javascript:editarOfferente();">
                    <table border=0 cellpadding=3 cellspacing=4 id="tbl">
                        <tr><td colspan="2" class="titulo">Edición de Datos de Oferentes</td></tr>
                        <tr><td class="etiqueta">Cedula</td><td><input type="text" name="cedula" id="cedula" value="&nbsp <%=oferente.getOferenteCedula()%>"></td></tr>
                        <tr><td class="etiqueta">Nombre</td><td><input type="text" name="nombre" id="nombre" value="&nbsp <%=oferente.getOferenteNombre()%>"></td></tr>
                        <tr><td class="etiqueta">Apellido</td><td><input type="text" name="apellido" id="apellido" value="&nbsp <%=oferente.getOferenteApellido()%>"></td></tr>
                        <tr><td class="etiqueta">Telefono</td><td><input type="text" name="telefono" id="telefono" value="&nbsp <%=oferente.getOferenteTelefono()%>"></td></tr>
                        <tr><td class="etiqueta">Residencia</td><td><input type="text" name="residencia" id="residencia" value="&nbsp <%=oferente.getOferenteResidencia()%>"></td></tr>
                        <tr><td class="etiqueta">UserName</td><td><input type="text" name="username" id="username" value="&nbsp <%=oferente.getOferenteUserName()%>"></td></tr>
                        <tr><td class="etiqueta">Clave</td><td><input type="password" name="clave" id="clave" value="&nbsp <%=oferente.getOferenteClave()%>"></td></tr>
                        <tr><td class="titulo" colspan="2"><input class="boton" type="submit" value="Registrar"></td></tr>	   
                    </table>
                </form>
            </div>     
        </div>
        <script>
            function editarOfferente() {
                oferente = {oferenteCedula: $("#cedula").val(), oferenteTelefono: $("#telefono").val(), oferenteResidencia: $("#residencia").val(),
                    oferenteNombre: $("#nombre").val(), oferenteApellido: $("#apellido").val(), oferenteUserName: $("#username").val(), oferenteClave: $("#clave").val()};
                
                $.ajax({type: "POST",
                    url: "OferenteEdicion",
                    data: JSON.stringify(oferente),
                    dataType: "json",
                    success:
                            function (obj) {
                                location.href = "main.jsp";
                            },
                    error: function (jqXHR, textStatus, errorThrown) {
                        if (jqXHR.status === 0) {

                            window.alert('Not connect: Verify Network.');

                        } else if (jqXHR.status == 404) {

                            window.alert('Requested page not found [404]');

                        } else if (jqXHR.status == 500) {

                            window.alert('Internal Server Error [500].');

                        } else if (textStatus === 'parsererror') {

                            window.alert('Requested JSON parse failed.');

                        } else if (textStatus === 'timeout') {

                            window.alert('Time out error.');

                        } else if (textStatus === 'abort') {

                            window.alert('Ajax request aborted.');

                        } else {

                            window.alert('Uncaught Error: ' + jqXHR.responseText);

                        }


                    }
                });

            }
        </script>
    </body>
</html>
