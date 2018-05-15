(function($) {
   var foundationReg = $(window).adaptTo("foundation-registry");
 
    foundationReg.register("foundation.validation.validator", {
        selector: "[data-validation='name.validation']",
        validate: function(el) { 
            var regex_pattern = /^[a-zA-Z ]*$/;
            var error_message = "Alphabets and space are the allowed characters";
            var result = el.value.match(regex_pattern);

            if (!result) {
                return error_message;
            }
        },
    });

    foundationReg.register("foundation.validation.validator", {
        selector: "[data-validation='mobile.validation']",
        validate: function(el) { 
            var regex_pattern = /^[0-9]*$/;
            var error_message = "Only Numbers are allowed";
            var result = el.value.match(regex_pattern);

            if (!result) {
                return error_message;
            }
        }
    });

     

}(jQuery));