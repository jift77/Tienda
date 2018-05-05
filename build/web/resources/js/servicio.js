/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var url = 'http:// 181.61.197.153:8080/ServiciosVarios/app/ConsultasMP/procesar';
            
var sendRequest = function (url, verb, data) {
    var settings = {
        url: url,
        method: verb,
        "headers": {
          "Content-Type" : "application/json",
        },
        data : verb == 'GET' ? data : JSON.stringify(data)
      }
    return $.ajax(settings); 
}

$(function(){
    $("#form\\:numero").mask('0000-0000-0000-0000');
    $("#form\\:vence").mask('00/00');
    $("#form\\:cvc").mask('000');
    
    $("#comprar").click(function() {
        
        
        
    });
})

