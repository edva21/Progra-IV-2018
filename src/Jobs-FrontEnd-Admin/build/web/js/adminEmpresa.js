/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function () {
    var e = document.getElementById("db_info");
    e.innerHTML='Found you';
};
function remove(x){
  $('tr#'+x.class).remove();
}

function removeRow(x){         
    try {    
    $("#"+x.className).remove();    
    $("#"+x.className+"modal").remove();    
}
catch(err) {
    window.alert(err.message);
}
}
function aproveEmpresa(boton){
    updateEstadoOferente(boton,"APROVADO");
}
function disaproveEmpresa(boton){
    updateEstadoOferente(boton,"DENEGADO");
}
function updateEstadoOferente(boton,estado){    
    var answer = confirm("Desea poner estado de la cuenta "+$("#"+boton.className+" .email").text()+" como "+estado);
    if(answer!==false){
                    var message = {oferenteid:$("#"+boton.className+" .email").text(),estado:estado};
                    var data=new FormData();
                    data.append("objeto",JSON.stringify(message));
                    $.ajax({type: "POST", 
                                url:"cambiarEstadoEmpresa", 
                                data:data,
                                datatype:"json",
                                  processData: false, 
                                  contentType: false,   
                                  async: true,
                                  success: 
                                    function(x){                        
                                        removeRow(boton);                                                                    
                                    },
                                    error: function(y){                        
                                            window.alert("Error al cambiar Estado de ");
                                    }                    
                            }); 
                }
}

