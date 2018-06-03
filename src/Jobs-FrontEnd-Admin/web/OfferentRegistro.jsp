<%-- 
    Document   : OfferentRegistro
    Created on : 20/05/2018, 12:53:36 AM
    Author     : fabio
--%>

<%@page import="java.util.List"%>
<%@page import="BussinessLogic.Nacionalidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            /*$(document).on("load", function () {
             $.get("GetNac", function (responseJson) {
             var $select = $("<tr><td><select class=\"etiqueta\" id=\"nacionalidad\">").appendTo($("#tbl"));
             $.each(responseJson, function (index, nac) {
             $("<option>").appendTo($select).append($("<td>").text(nac.getNacionalidadNombre()));
             });
             });
             });*/
        </script>
        <title>OferenteRegistro</title>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <div id="body" style="margin: 0 auto; width:85%; ">
            <div id="formularioDiv" style="display: block;vertical-align:top;">
                <form method="POST" name="formulario" id="formulario" action="javascript:registrarOfferente();">
                    <table border=0 cellpadding=3 cellspacing=4 id="tbl">
                        <tr><td colspan="2" class="titulo">Registro Oferentes</td></tr>
                        <tr><td class="etiqueta">Correo</td><td><input type="text" name="correo" id="correo"></td></tr>
                        <tr><td class="etiqueta">Cedula</td><td><input type="text" name="cedula" id="cedula"></td></tr>
                        <tr><td class="etiqueta">Nombre</td><td><input type="text" name="nombre" id="nombre"></td></tr>
                        <tr><td class="etiqueta">Apellido</td><td><input type="text" name="apellido" id="apellido"></td></tr>
                        <tr><td class="etiqueta">Telefono</td><td><input type="text" name="telefono" id="telefono"></td></tr>
                        <tr><td class="etiqueta">Residencia</td><td><input type="text" name="residencia" id="residencia"></td></tr>
                        <tr><td class="etiqueta">UserName</td><td><input type="text" name="username" id="username"></td></tr>
                        <tr><td class="etiqueta">Clave</td><td><input type="password" name="clave" id="clave"></td></tr>
                        <tr><td class="etiqueta">Nacionalidad</td><td><select name="nacionalidad" id="nacionalidad"> </select></td></tr>
                        <tr><td class="titulo" colspan="2"><input class="boton" type="submit" value="Registrar"></td></tr>	   
                    </table>
                </form>
            </div>     
        </div>
        <script>
            function registrarOfferente() {
                oferente = {oferenteEmail: $("#correo").val(), oferenteCedula: $("#cedula").val(), oferenteTelefono: $("#telefono").val(), oferenteResidencia: $("#residencia").val(),
                    oferenteNombre: $("#nombre").val(), oferenteApellido: $("#apellido").val(), oferenteUserName: $("#username").val(), oferenteClave: $("#clave").val(), oferenteNacionalidad: $("#nacionalidad").val(), oferenteEstadoDeCuenta: "ESPERA"};
                
                $.ajax({type: "POST",
                    url: "OferenteRegistro",
                    data: JSON.stringify(oferente),
                    dataType: "json",
                    success:
                            function (obj) {
                                show(obj);
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
            function show(per) {
                location.href = "main.jsp";
            }

            $(window).on("load", getNac());

            function getNac() {
                $.ajax({type: "POST",
                    url: "GetNac",
                    dataType: "json",
                    processData: false,
                    contentType: false,
                    async: true,
                    success:
                            function (nac) {
                                var i;
                                for (i = 0; i < nac.length; i++)
                                    addHabilidad(nac[i]);

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

            function addHabilidad(nac) {
                $("#nacionalidad").append("<option>" + nac.nacionalidadNombre + "</option>");
            }
        </script>
    </body>
</html>
