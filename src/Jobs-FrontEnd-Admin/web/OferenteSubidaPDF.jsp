<%-- 
    Document   : OferenteSubidaPDF
    Created on : 03/06/2018, 04:20:33 PM
    Author     : fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">  
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>

        <%@ include file="Header.jsp" %>

        <div id="body" style="margin: 0 auto; width:85%; ">
            <div id="formularioDiv" style="display: block;vertical-align:top;">
                <form method="POST" name="formulario" id="formulario" action="javascript:cargarPDF();">
                    <table border=0 cellpadding=3 cellspacing=4 id="tbl">
                        <tr><td colspan="2" class="titulo">Subir Currículum De Oferente</td></tr>
                        <tr><td class="etiqueta">Currículum PDF</td><td><input type="file" name="file" id="file" accept=".pdf" /></td></tr> 
                        <tr><td class="titulo" colspan="2"><input class="boton" type="submit" value="Cargar"></td></tr>
                    </table>
                </form>
            </div>
        </div>
        <script>
            

            function cargarPDF() {
                var fd = new FormData(),
                        myFile = document.getElementById("file").files[0];

                fd.append('file', myFile);
                $.ajax({type: "POST",
                    url: "UploadPDF",
                    data: fd,
                    processData: false,
                    contentType: false,
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
