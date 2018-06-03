<%-- 
    Document   : adminPuestoReporte
    Created on : 23-May-2018, 23:04:20
    Author     : edva5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 4 DatePicker</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.5/jspdf.debug.js" integrity="sha384-CchuzHs077vGtfhGYl9Qtc7Vx64rXBXdIAZIPbItbNyWIRTdG0oYAqki3Ry13Yzu" crossorigin="anonymous"></script>
    <script src="js/adminPuestoReporte.js"></script>
</head>
<body>
    <%@ include file="Header.jsp"%>
    
    <div id="reporte">
        <input id="monthPicker" width="276" />
    <button type="button" class="btn btn-primary" onclick="javascript:bringpdf()">Generar Reporte</button> 
    </div>
    <script>
        $('#monthPicker').datetimepicker({
        format: 'YYYY-MM'
        })
        $('#monthPicker').text("YYYY-MM");
    </script>
</body>
</html>
