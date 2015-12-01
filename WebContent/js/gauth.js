var ProperNameRE = /^[a-zA-Z ]+$/;
var ProperNumberRE = /^[0-9]+$/;
var ProperDoubleRE = /^([0-9]+(\.[0-9]+){0,1})$/;
var ProperEmailRE = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;

$(document).ready(function(){
	$("#new_reg_submit").click(function()
    {
        validateForm();
        if($(".has-error").size() == 0) $("#registration").submit();
    });
});

function markError(field_name)
{
  $("[name='"+field_name+"']").closest(".form-group").addClass("has-error");
}

function unmarkError(field_name)
{
  $("[name='"+field_name+"']").closest(".form-group").removeClass("has-error");
}

function tagField(field_name)
{
  return $("[name='"+field_name+"']");
}

function validateForm()
{
  var field = "name_reg";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "corrAddress_reg";
  var input = tagField(field).val().trim();
  if(input.length == 0) markError(field);
  else unmarkError(field);

  field = "mob_reg";
  var input = tagField(field).val().trim();
  if(!(input.length >= 10 && input.length <= 11) || !ProperNumberRE.test(input)) markError(field);
  else unmarkError(field);

  field = "email_reg";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperEmailRE.test(input)) markError(field);
  else unmarkError(field);
}