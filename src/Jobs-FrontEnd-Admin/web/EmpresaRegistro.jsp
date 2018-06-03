<%-- 
    Document   : EmpresaRegistro
    Created on : 02/06/2018, 03:07:19 PM
    Author     : gaspa
--%>

<%@page import="BussinessLogic.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="css/master.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script type="text/javascript" src="https://maps.google.com/maps/api/js?key=AIzaSyDkH_nzn1WAba3fmOgTpVjP5obSMFV9hHM"></script>
        <title>FormularioEmpresa</title>
        <% Empresa empresas= (Empresa) session.getAttribute("empresa");%>
    </head>
   <body onload="initMap()">
    <%@ include file="Header.jsp" %>
    <div id="area">
     <hr>
    <div id="formularioDiv" style="display: inline-block;vertical-align:top;">
        <form method="POST" name="formulario" id="formulario" action="javascript:addEmpresa();">
            <table border=0 cellpadding=3 cellspacing=4 >
                    <tr><td colspan="2" class="titulo">Perfil</td></tr>
                    <tr><td class="etiqueta">Empresa:</td><td><input type="text" name="nombre" id="nombre"></td></tr>
                    <tr><td class="etiqueta">Email;</td><td><input type="text" name="email" id="email"></td></tr>
                    <tr><td class="etiqueta">Clave:</td><td><input type="password" name="clave" id="clave"></td></tr>
                    <tr><td class="etiqueta">Telefono:</td><td><input type="text" name="telefono" id="telefono"></td></tr>
                    <tr><td class="etiqueta">Descripcion:</td><td><input type="text" name="descripcion" id="descripcion"></td></tr>
                    <tr><td class="etiqueta ">Localizacion:</td><td><input  type="text" name="localizacion" id="localizacion"size="50" ></td></tr>
                    <tr><td class="etiqueta">foto</td><td><input type="file" name="foto" id="foto" class="hde">
                        <input type="button" value="Examinar..." id="fotoExaminar"><img id="fotoView"></td></tr>
                    <tr><td class="titulo" colspan="2"><input class="boton" type="submit" value="Registrar"></td></tr>
                    </form>
                     <form method="POST" name="formulario" id="formulario" action="javascript:addEmpresa();">
                        <tr><td class="hide" colspan="2"><input class="boton" type="submit" value="Registrar"></td></tr>
                    <tr><td class="hide ">Longitud:</td><td><input class="hide" type="text" name="longitud" id="longitud"></td></tr>
                    <tr><td class="hide ">Latitud:</td><td><input class="hide" type="text" name="latitud" id="latitud" ></td></tr>    
                         
            </table>
        </form>
       </div>
     
        <div id="mapArea" style="display: inline-block;">
            <h3 >Click en el mapa para cambiar localizacion </h3>
            
            <div id="map" style="display: inline-block; vertical-align:top; height: 350px; width: 450px;">
                 mapa pendiente...
            </div>
        </div>
    </div>
    <script>
        function addEmpresa(){
          
          empresa = {empresaNombre:$("#nombre").val(),
		empresaEmail:$("#email").val(),
                empresaLocalizacion:$("#localizacion").val(),
                empresaTelefono:$("#telefono").val(),
                empresaDescripcion:$("#descripcion").val(),
                empresaClave:$("#clave").val(),
                empresaUsername:$("#nombre").val(),
                empresaLongitud:$("#longitud").val(),
                empresaLatitud :$("#latitud").val()
		};
        data=new FormData();
        data.append("empresa",JSON.stringify(empresa));
        data.append("foto",$("#foto")[0].files[0]);
            $.ajax({type: "POST", 
                  url:"EmpresaRegistrar", 
                  data: data,
                  processData: false,
                  contentType: false,                  
                  success: 
                  function(obj){
                        show(obj); 
                    },
                  error: function(status){
                         window.alert("Error");
                    }                    
                });      
        }  
         function show(per){
          location.href="main";
        }
        
      
      function createMap(loc) {
      			var map = new google.maps.Map(
      			            document.getElementById('map'), 
      					    {center: {lat: loc.lat, lng: loc.lng}, zoom: 16}
      					  );
      			/* click en el mapa traduce (lat,lng)-->texto */
      			var gc = new google.maps.Geocoder();
      			var dr = document.getElementById('localizacion');
                              var long = document.getElementById("longitud");
                              var lat = document.getElementById("latitud");
      			var iw = new google.maps.InfoWindow({map: map});
                              long.value = loc.lng;
                              lat.value = loc.lat;
      			google.maps.event.addListener(map, 'click',	
      			  function(e){pickAddress(gc,map,e.latLng,dr,iw,long,lat);}
      			 );
      			pickAddress(gc,map,loc,dr,iw,long,lat);	
             }
	   
	    function pickAddress(gc,map,loc,dr,iw,long,lat){
  		  gc.geocode({'latLng': loc }, // (lat,lng)-->texto
  		    function(results, status) { // callback
  			  if (status == google.maps.GeocoderStatus.OK) {
  			    if (results[0]) {
  				  dr.value=results[0].formatted_address;
                                    long.value = loc.lng();
                                    lat.value = loc.lat();
  				  iw.setPosition(loc);
  				  iw.setContent("Empresa");
  				  iw.open(map);
  			    }
                           
  			  }
  		    }
  		 );
     }   
      function initMap() {
        if (navigator.geolocation) {
		  /* obtine localizacion actual y crea el mapa con ella */
          navigator.geolocation.getCurrentPosition(
		    function(loc){createMap({lat: loc.coords.latitude,lng: loc.coords.longitude});},
			function(loc){createMap({lat: 0,lng: 0});});
        } else {
          // Browser no soporta Geolocation
		  createMap({lat: 0,lng: 0});
        }
      }
        </script>
      <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8O7F5hqPv2wbSnaZkO5yTp3sISiiyR4A">
    </script>
    </body>
</html

