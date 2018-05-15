(function (document, $) {
  "use strict";

  // listen for dialog injection
  $(document).on("foundation-contentloaded", function (e) {
    $(".showhide").each(function () {
        if($(this).is(":checked")){
            showHide($(this));
        }
    });
  });

  // listen for toggle change
  $(document).on("change", ".showhide", function (e) {
    showHide($(this));
  });

  // show/hide our target depending on toggle state
  function showHide(el) {
    var value = $(el).val();


    var phonefl = $("input[name='./phone']").closest(".coral-Form-fieldwrapper");
    var emailfl = $("input[name='./email']").closest(".coral-Form-fieldwrapper");

      if(value === "phone"){
          	$(phonefl).show();
            $(emailfl).hide();
      }else{
          $(phonefl).hide();
          $(emailfl).show();
      }
  }

})(document, Granite.$);