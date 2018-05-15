/*
Validating Dialog Fields in Classic UI
*/
var  learningValidation = learningValidation || (function($) {
    // $ sign here is a parameter, which is set to jQuery 
 
    // this can be use to initialize the variables
    function initialize() {
         
    };
 
    // validate fields
    function validate(dialog) {


        var res = true;
        var name = $("input[name='./name']").val();
        var phone = $("input[name='./phone']").val();
        var msg = "";
        if($.trim(name) == ""){
            	res = false;
            	msg += "Name can not be empty" + "\n"
        }

         if($.trim(phone) == ""){
            	res = false;
            	msg += "Phone can not be empty";
        }

        if(!res){
            alert(msg);
        }

        return res;
    };
 
    return {
        beforeSubmit: validate,        
        init: initialize
    }
})(jQuery);
 
 
window.onload(learningValidation.init());