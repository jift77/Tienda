/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var url = 'http://181.61.197.153:8080/ServiciosVarios/app/ConsultasMP/';
            
var sendRequest = function (url, verb, data) {
    var settings = {
        url: url,
        method: verb,
        "headers": {
          "Content-Type" : "application/json"
        },
        data : verb === 'GET' ? data : JSON.stringify(data)
      };
    return $.ajax(settings); 
};

ko.extenders.required = function(target, overrideMessage) {
    target.hasError = ko.observable();
    target.validationMessage = ko.observable();
    function validate(newValue) {
       target.hasError(newValue ? false : true);
       target.validationMessage(newValue ? "" : overrideMessage || "Este campo es requerido");
    }
    validate(target());
    target.subscribe(validate);
    return target;
};

var model = {
    nombre: ko.observable(""),
    numeroTarjeta: ko.observable("").extend({ required: "*"}),
    vence: ko.observable("").extend({ required: "*" }),
    cvc: ko.observable("").extend({ required: "*" }),
    compra: ko.observable("")
};

var comprar = function(){
            
    $('#form\\:hdnCodigo').val(100);
    $('#form\\:btnFacturar').click();
                
    /*data = {
        numero: model.numeroTarjeta().replace(/-/g,''),
        mesVencimiento: model.vence().split('/')[0],
        anioVencimiento: model.vence().split('/')[1],
        numValidacion: model.cvc(),
        compra: model.compra()
    }
    console.log(JSON.stringify(data));
    sendRequest(url + 'procesar', 'POST', data)
        .done(function(d){
            if(d.codigo === '100')
            {
                alert(d.descipcion);
                $('#form\\:hdnCodigo').val(d.codigo);
                $('#form\\:btnFacturar').click();
            }   
            else
                alert(d.descipcion);
        })
        .fail(function(e){
            console.log(`Error: ${e.status}, ${e.statusText}`);
        });*/
};

$(function(){
    $("#form\\:numero").mask('0000-0000-0000-0000');
    $("#form\\:vence").mask('00/00');
    $("#form\\:cvc").mask('000');
    
    model.compra($("#form\\:hdnTotal").val());
    ko.applyBindings();
    
    sendRequest(url + 'status', 'GET')
        .done(function(d){
            console.log(d);
        })
        .fail(function(e){
            console.log(`Error: ${e.status}, ${e.statusText}`);
        });
});

