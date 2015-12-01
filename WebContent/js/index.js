var StreamChoice = ["","Artificial Intelligence and Robotics","Compilers","Computer Architecture and Systems Design","Computer Graphics","Computer Vision","Image Analysis and Biometrics","Information Management and Data Engineering","Machine Learning","Massively Parallel Systems","Mobile Computing and Networking Applications","Program Analysis","Security and Privacy","Signal and Image Processing","Software Engineering","Theoretical Computer Science","Wireless Networks","Wireless Communication","Wireless Networks","RF and mixed signal electronics","OFDM based Optical Access Networks","Optical Wireless Communication Systems","Signal and Image Processing","Machine Learning","Controls and Robotics","Digital and Analog VLSI Systems Design","Electromagnetics","Embedded and VLSI systems design","Embedded Systems","Fiber-Wireless Architectures","Computer Architecture and Systems Design","Structural Biology","Systems Biology","Biophysics"];
var ProperNameRE = /^[a-zA-Z ]+$/;
var ProperEmailRE = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
var ProperDoubleRE = /^([0-9]+(\.[0-9]+){0,1})$/;
var ProperNumberRE = /^[0-9]+$/;

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

$(document).ready(function(){
	$.material.init();
	var vdate = new Date();
    vdate.setFullYear(vdate.getFullYear() - 15);
    $("#dateOfBirthField").bootstrapMaterialDatePicker({ weekStart : 0, time: false ,maxDate: vdate});
    $("#adfField").bootstrapMaterialDatePicker({ weekStart : 0, time: false,  maxDate: new Date()});
    $("#adtField").bootstrapMaterialDatePicker({ weekStart : 0, time: false , maxDate: new Date()});

    var ddata = JSON.parse(JSON.parse(readCookie("dropdowndata")));
	StreamChoice.forEach(function(element,index,array){
	    $('[name="phdStreamField"]').append("<option>"+element+"</option>");
	});

	['xBoardField','xiiBoardField','graduationDegreeField','gradDeptField','pgDegreeField','pgDeptField','pgStateField','gradStateField'].forEach(function(ele,ind,arr)
	{
        $('[name="'+ele+'"]').append("<option></option>");
		((ddata[ele]).slice(1,ddata[ele].length-1).split(",")).forEach(function(element,index,array){
    		$('[name="'+ele+'"]').append("<option>"+element+"</option>");
		});
	});

    $("#submit-btn").click(function()
    {
        validateForm();
        if($(".has-error").size() == 0) $("#adminForm").submit();
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
    var field = "emailField";
    var input = tagField(field).val().trim();
    if(input.length != 0 && !ProperEmailRE.test(input)) markError(field);
    else unmarkError(field);

    var field = "nameField";
    var input = tagField(field).val().trim();
    if(input.length != 0 && !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "gradUnivField";
    var input = tagField(field).val().trim();
    if(input.length != 0 && !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "pgUnivField";
    var input = tagField(field).val().trim();
    if(input.length != 0 && !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "xMarksField";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=100.0)) markError(field);
    else unmarkError(field);

    field = "xiiMarksField";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=100.0)) markError(field);
    else unmarkError(field);

    field = "gradMarksField";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=100.0)) markError(field);
    else unmarkError(field);

    field = "pgMarksField";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=100.0)) markError(field);
    else unmarkError(field);

    field = "gateMarksField";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=1000.0)) markError(field);
    else unmarkError(field);
}