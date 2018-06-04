/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Get the input field
// Execute a function when the user releases a key on the keyboard
var stack =[];
var leaf=false;
stack.push("Inicio");
function checkleaf(){
    if(leaf)
        leaf=false;
    else
        leaf=true;
}
function addHabilidad(event){
    if (event.keyCode === 13) {   
        if ($("#newhabilidad").val().length>0)
            add($("#newhabilidad").val());        
  }
}
function addToList(){
    if(leaf)
        $("#habilidadList").append("<li class=\"leafitem\" onclick=\"javascript:navHabilidad(this)\"><font color=\"red\">"+$("#newhabilidad").val()+"</font></li>");
    else
        $("#habilidadList").append("<li class=\"item\" onclick=\"javascript:navHabilidad(this)\">"+$("#newhabilidad").val()+"</li>");
    $("#newhabilidad").val("");
}

function printpath(){
    $("#path").empty();
    for (i = 0; i < stack.length; i++) {
        $("#path").append("<li id="+stack[i]+" onclick=\"goto(this)\" class=\"pathItem\" >>>"+stack[i]+"</li>");
    }     
}
function printHabilidad(habilidad){        
    $("#path").append("<li id=\"item\" onclick=\"goto(this)\" class=\"item\" >"+habilidad.habilidadNombre+"</li>");    
}
function printHabilidadItem(habilidad){ 
    if(habilidad.habilidadEsHoja)
        $("#habilidadList").append("<li class=\"leafitem\" onclick=\"javascript:navHabilidad(this)\"  ><font color=\"red\">"+habilidad.habilidadNombre+"</font></li>");    
    else
        $("#habilidadList").append("<li class=\"item\" onclick=\"javascript:navHabilidad(this)\"  >"+habilidad.habilidadNombre+"</li>");    
}
function printSons(data){
    $("#habilidadList").empty();
    var arr=JSON.parse(data);
    for(var i=0;i<arr.length;i++)                        
        printHabilidad(arr[i]); 
}
function goto(li){    
       for (i = stack.length-1; i >= 0; i--) {
        if(li.id===stack[i])
            i=0;        
        else        
            stack.pop();        
        } 
        $(".item").remove();
        $(".leafitem").remove();
        printpath();                     
        printHabilidadSons(li.id);       
        leaf=false;
}
function add(habilidad){    
    var answer = confirm("Desea agregar la habilidad:"+habilidad);
    if(answer!==false){
                    var parent_hability=null;
                    if(stack.length>1){
                        parent_hability=stack[stack.length-1];
                    }
                    var message = {habilidadNombre:habilidad,habilidadHabilidadNombre:parent_hability,habilidadEsHoja:leaf};
                    var data=new FormData();                    
                    data.append("objeto",JSON.stringify(message));
                    $.ajax({type: "POST", 
                                url:"addHabilidad", 
                                data:data,
                                datatype:"application/json",
                                  processData: false, 
                                  contentType: false,   
                                  async: true,
                                  success: 
                                    function(x){                        
                                      addToList();                                                         
                                    },
                                    error: function(xhr, ajaxOptions, thrownError){                        
                                        alert(thrownError);    
                                    }                    
                            }); 
                }
}
function navHabilidad(li){ //borraLista e Imprime hijos de la habilidad                              
                    var parent_hability=null;
                    if(stack.length>1){
                        parent_hability=stack[stack.length-1];
                    }
                    var message = {"habilidadNombre":li.innerHTML,"habilidadHabilidadNombre":parent_hability,"habilidadEsHoja":false};                                       
                    $.ajax({type: "POST", 
                                url:"sendHabilidad", 
                                data:JSON.stringify(message),
                                datatype:"application/json",
                                  processData: false, 
                                  contentType: false,   
                                  async: true,
                                  success: 
                                    function(x){                                                                
                                     changeScreen(x,li);
                                    },
                                    error: function(xhr, ajaxOptions, thrownError){                        
                                            window.alert("Error al agregar Habilidad: "+xhr.status+" "+ajaxOptions+" "+xhr);                                            
                                    }                    
                            }); 
}
/*function goto(li){ //borraLista e Imprime hijos de la habilidad                              
                    var parent_hability=null;
                    if(stack.length>1){
                        parent_hability=stack[stack.length-1];
                    }
                    var message = {"habilidadNombre":li.innerHTML,"habilidadHabilidadNombre":parent_hability,"habilidadEsHoja":false};                                       
                    $.ajax({type: "POST", 
                                url:"sendHabilidad", 
                                data:JSON.stringify(message),
                                datatype:"application/json",
                                  processData: false, 
                                  contentType: false,   
                                  async: true,
                                  success: 
                                    function(x){                                                                
                                        if (!x.habilidadEsHoja) {
                                         for (i = stack.length-1; i > 0; i--) {
                                            if(li.id===stack[i])
                                                i=0;        
                                            else        
                                                stack.pop();        
                                            } 
                                        }
                                    },
                                    error: function(xhr, ajaxOptions, thrownError){                        
                                            window.alert("Error al agregar Habilidad: "+xhr.status+" "+ajaxOptions);
                                            return {habilidadNombre:habilidad,habilidadHabilidadNombre:parent_hability,habilidadEsHoja:true};                                       
                                    }                    
                            }); 
}*/
function printHabilidadSons(_habilidadNombre){ //borraLista e Imprime hijos de la habilidad                              
                    var parent_hability=null;
                    if(stack.length>1){
                        parent_hability=stack[stack.length-1];
                    }
                    var message = {"habilidadNombre":_habilidadNombre,"habilidadHabilidadNombre":parent_hability,"habilidadEsHoja":false};                                       
                    $.ajax({type: "POST", 
                                url:"sonsHabilidad", 
                                data:JSON.stringify(message),
                                datatype:"application/json",
                                  processData: false, 
                                  contentType: false,   
                                  async: true,
                                  success: 
                                    function(x){                                                                
                                     for(var i=0;i<x.length;i++)
                                        printHabilidadItem(x[i]); 
                                        //$("#comboox").atrr('item').add(x[i]);
                                    },
                                    error: function(xhr, ajaxOptions, thrownError){                        
                                            window.alert("Error al agregar Habilidad: "+xhr.status+" "+ajaxOptions);
                                            return {habilidadNombre:habilidad,habilidadHabilidadNombre:parent_hability,habilidadEsHoja:true};                                       
                                    }                    
                            }); 
}
 function changeScreen(json,li){
     if(!json.habilidadEsHoja){
        stack.push(li.innerHTML);
        $(".item").remove();
        $(".leafitem").remove();
        printpath();             
        printHabilidadSons(li.innerHTML);
        leaf=false;        
     }    
 }

