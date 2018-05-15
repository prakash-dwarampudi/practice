(function($) {

    var REGEX_SELECTOR = "validation.mobile",

    foundationReg = $(window).adaptTo("foundation-registry");

    foundationReg.register("foundation.validation.validator", {
        selector: "[data-validation='" + REGEX_SELECTOR + "']",
        validate: function(el) {

            var regex_pattern = "^[0-9]+$";
            var error_message = "Only numbers are allowed in this field";
            var result = el.value.match(regex_pattern);

            if (result === null) {
                return error_message;
            }
        }
    });

}(jQuery));
