/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('#datetimepicker').datetimepicker({
    format: 'yyyy-mm-dd hh:ii'
});
            
var counter=0;
function bringpdf(){
    $.ajax({type: "POST", 
        url:"sendJobReport", 
        data:JSON.stringify($('#datepicker').val()),
        datatype:"application/json",
        processData: false, 
        contentType: false,   
        async: true,
        success: 
        function(x){    
          createReport(x);                                                             
        },
        error: function(y){                        
            window.alert("Error al generar Reporte");
            }                    
        });
}
function createReport(jobArr){
    if(jobArr!==null){
        if(jobArr.length>0){
            var doc = new jsPDF();
        doc.text('Reporte de Puestos de Trabajo', 50, 10);        
        for(var i=jobArr.length-1;i>=0;i--){  
            alert(i);
            doc.setFontSize(24);
            //doc.setTextColor(220,55,53);
            doc.setFontStyle("italic");
            doc.text('Nombre:'+jobArr[i].puestoNombre, 10, 10*(counter+2));
            measureLines(doc);
            //doc.setTextColor(0,128,255);
            doc.setFontSize(18);
            doc.text('Empresa:'+jobArr[i].empresa, 10, 10*(counter+2));
            measureLines(doc);
            //doc.setTextColor(51,0,0);
            doc.setFontSize(12);
            doc.setFontStyle("helvetica");
            doc.text('Descripcion:'+jobArr[i].puestoDescripcion, 10, 10*(counter+2));
            measureLines(doc);
            doc.text('Id:'+jobArr[i].idPuesto, 10, 10*(counter+2));
            measureLines(doc);
            doc.text('Salario:'+jobArr[i].puestoSalario, 10, 10*(counter+2));
            measureLines(doc);                        
            doc.text('Fecha:'+jobArr[i].puestoFecha, 10, 10*(counter+2));
            measureLines(doc);
            jobArr.shift();
        }       
        
        doc.save('reporte.pdf');        
        }
        else{
            alert("Ningung Puesto CumpleCon los Filtros Especificados");
        }
    }   
    else{
            alert("Ningung Puesto CumpleCon los Filtros Especificados");
        }
}
function measureLines(doc){
    counter++;        
    if(counter===28){
        doc.addPage();
        counter=0;
    }
}
function createPDF(){    
    var doc = new jsPDF();
    doc.text('Reporte de Puestos de Trabajo', 50, 10);
    
    for(var i=0;i<28;i++){
        doc.setFontStyle("italic");
            doc.setFontSize(i+2);
            doc.text('Hello world!', 10, 10*(i+2));            
        }    
        doc.addPage();
        doc.setFontStyle("helvetica");
        for(var i=0;i<28;i++){
            doc.text('Hello world!', 10, 10*(i+2));
        }    
    doc.save('reporte.pdf');
}

