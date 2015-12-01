var CSEChoice = ["","Artificial Intelligence and Robotics","Compilers","Computer Architecture and Systems Design","Computer Graphics","Computer Vision","Image Analysis and Biometrics","Information Management and Data Engineering","Machine Learning","Massively Parallel Systems","Mobile Computing and Networking Applications","Program Analysis","Security and Privacy","Signal and Image Processing","Software Engineering","Theoretical Computer Science","Wireless Networks"];
var ECEChoice = ["","Wireless Communication","Wireless Networks","RF and mixed signal electronics","OFDM based Optical Access Networks","Optical Wireless Communication Systems","Signal and Image Processing","Machine Learning","Controls and Robotics","Digital and Analog VLSI Systems Design","Electromagnetics","Embedded and VLSI systems design","Embedded Systems","Fiber-Wireless Architectures","Computer Architecture and Systems Design"];
var CBChoice = ["","Structural Biology","Systems Biology","Biophysics"];
var countries = ["Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","China","Colombia","Comoros","Congo","Congo","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Ivory Coast","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Korea North","Korea South","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar, {Burma}","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Romania","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia","Saint Vincent & the Grenadines","Samoa","San Marino","Sao Tome & Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe"]

var ProperNameRE = /^[a-zA-Z ]+$/;
var ProperNumberRE = /^[0-9]+$/;
var ProperDoubleRE = /^([0-9]+(\.[0-9]+){0,1})$/;
var ProperEmailRE = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
$(document).ready(main());

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

function main()
{
	$.material.init();
      if(readCookie('guser_name')!=null)
      $("[name='name']").val(readCookie('guser_name').replace(/\"/g, ""));
      if(readCookie('guser_email')!=null)
      $("[name='email']").val(readCookie('guser_email').replace(/\"/g, ""));
      if(readCookie('guser_corrAddress')!=null)
      $("[name='corrAddress']").val(readCookie('guser_corrAddress').replace(/\"/g, ""));
      if(readCookie('guser_mobNumber')!=null)
      $("[name='mobNumber']").val(readCookie('guser_mobNumber').replace(/\"/g, ""));
      if(readCookie('enrollmentNumber')!=null)
      $("[name='enrollmentNumber']").val(readCookie('enrollmentNumber').replace(/\"/g, ""));
      var vdate = new Date();
      vdate.setFullYear(vdate.getFullYear() - 15);
      $("#dobField").bootstrapMaterialDatePicker({ weekStart : 0, time: false ,maxDate: vdate});

      CSEChoice.forEach(function(element,index,array){
      					$("[name='preferences1']").append("<option>"+element+"</option>");
      					$("[name='preferences2']").append("<option>"+element+"</option>");
      					$("[name='preferences3']").append("<option>"+element+"</option>");
      				});
      ECEChoice.forEach(function(element,index,array){
			$("[name='preferences4']").append("<option>"+element+"</option>");
      });
      countries.forEach(function(element,index,array){
			$("[name='nationality']").append("<option>"+element+"</option>");
      });
      $("#preferences4div").hide();
      $("#streamSelector > .radio > label > input").click(function(){
      		$("[name='preferences1']").empty();
      		$("[name='preferences2']").empty();
      		$("[name='preferences3']").empty();
      		switch($(this).val())
      		{
      			case "Computer Science":
      				$("#preferences4div").slideUp();
      				CSEChoice.forEach(function(element,index,array){
      					$("[name='preferences1']").append("<option>"+element+"</option>");
      					$("[name='preferences2']").append("<option>"+element+"</option>");
      					$("[name='preferences3']").append("<option>"+element+"</option>");
      				});break;
      			case "Electronics and Communication":
      				$("#preferences4div").slideDown();
      				ECEChoice.forEach(function(element,index,array){
      					$("[name='preferences1']").append("<option>"+element+"</option>");
      					$("[name='preferences2']").append("<option>"+element+"</option>");
      					$("[name='preferences3']").append("<option>"+element+"</option>");
      				});break;
      			case "Computational Biology":
      				$("#preferences4div").slideUp();
      				CBChoice.forEach(function(element,index,array){
      					$("[name='preferences1']").append("<option>"+element+"</option>");
      					$("[name='preferences2']").append("<option>"+element+"</option>");
      					$("[name='preferences3']").append("<option>"+element+"</option>");
      				});break;
      		}
      });
      $("#pgDIV").hide();
      $("[name='pgApplicable']").click(function(){
            if($(this).prop('checked')) $("#pgDIV").slideDown();
            else $("#pgDIV").slideUp();
      });
      $("#oaDIV").hide();
      $("[name='oaApplicable']").click(function(){
            if($(this).prop('checked')) $("#oaDIV").slideDown();
            else $("#oaDIV").slideUp();
      });
      $("#gateDIV").hide();
      $("[name='gateApplicable']").click(function(){
            if($(this).prop('checked')) $("#gateDIV").slideDown();
            else $("#gateDIV").slideUp();
      });
      $("[name='gradPerformanceCGPA']").click(function(){
            if($(this).prop('checked')) $("[for='gradPerformance']").text("Performance (in CGPA)");
            else $("[for='gradPerformance']").text("Performance (in %age)");
      });
      $("[name='pgPerformanceCGPA']").click(function(){
            if($(this).prop('checked')) $("[for='pgPerformance']").text("Performance (in CGPA)");
            else $("[for='pgPerformance']").text("Performance (in %age)");
      });

      $("#submit-btn").click(function()
      {
        validateForm();
        if($(".has-error").size() == 0) 
        {
          $("#infoDivSubmit").text("[STATUS] The application has been submitted successfully.").css("color","#006400");
          $("#applicantForm").submit();
        }
        else $("#infoDivSubmit").text("[STATUS] Some errors were found in the application. Please correct them. All error fields have been marked.").css("color","#DC143C");
      });
}

function feedbackQ2()
{
  var ans = "";
  $(".feedbackQ2opt").forEach(function(){
    if($(this).prop("checked")) ans = ans+$(this).text()+";";
  });
  return ans;
}

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

function validateEmail(email) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(email);
}

function validateForm()
{
  //..Validations go here
  
  //Personal Information
  var field = "name";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "fatherName";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "corrAddress";
  var input = tagField(field).val().trim();
  if(input.length == 0) markError(field);
  else unmarkError(field);

  field = "dobField";
  var input = tagField(field).val().trim();
  if(input.length == 0) markError(field);
  else unmarkError(field);

  field = "mobNumber";
  var input = tagField(field).val().trim();
  if(!(input.length >= 10 && input.length <= 11) || !ProperNumberRE.test(input)) markError(field);
  else unmarkError(field);

  field = "fatherName";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "email";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperEmailRE.test(input)) markError(field);
  else unmarkError(field);

  field = "permAddress";
  var input = tagField(field).val().trim();
  if(input.length == 0) markError(field);
  else unmarkError(field);

  field = "pincode";
  var input = tagField(field).val().trim();
  if(!(input.length == 6) || !ProperNumberRE.test(input)) markError(field);
  else unmarkError(field);


  //Education Information
  field = "xBoard";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "xMarks";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=100.0)) markError(field);
  else unmarkError(field);

  field = "xYear";
  var input = tagField(field).val().trim();
  if(input.length != 4 || !ProperNumberRE.test(input) || !(parseInt(input)>=1970 && parseInt(input)<=(new Date()).getFullYear())) markError(field);
  else unmarkError(field);

  field = "xiiBoard";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "xiiMarks";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=100.0)) markError(field);
  else unmarkError(field);

  field = "xiiYear";
  var input = tagField(field).val().trim();
  if(input.length != 4 || !ProperNumberRE.test(input) || !(parseInt(input)>=2+parseInt(tagField("xYear").val().trim()) && parseInt(input)<=(new Date()).getFullYear())) markError(field);
  else unmarkError(field);

  field = "gradDegree";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "gradDept";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "gradCollege";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "gradUniv";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "gradCity";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "gradState";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
  else unmarkError(field);

  field = "gradYear";
  var input = tagField(field).val().trim();
  if(input.length != 4 || !ProperNumberRE.test(input) || !(parseInt(input)>=3+parseInt(tagField("xiiYear").val().trim()) && parseInt(input)<=(new Date()).getFullYear())) markError(field);
  else unmarkError(field);

  field = "gradPerformance";
  var input = tagField(field).val().trim();
  if(input.length == 0 || !ProperDoubleRE.test(input)) 
  {
    if($("[name='gradPerformanceCGPA']").prop("checked") && !(parseFloat(input)<=10.0)) markError(field);
    else if(!$("[name='gradPerformanceCGPA']").prop("checked") && !(parseFloat(input)<=100.0)) markError(field);
    else unmarkError(field);
  }
  else unmarkError(field);

  if($("[name='pgApplicable']").prop('checked'))
  {
    field = "pgDegree";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "pgDept";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "pgCollege";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "pgUniv";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "pgCity";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "pgState";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "pgYear";
    var input = tagField(field).val().trim();
    if(input.length != 4 || !ProperNumberRE.test(input) || !(parseInt(input)>=1+parseInt(tagField("gradYear").val().trim()) && parseInt(input)<=(new Date()).getFullYear())) markError(field);
    else unmarkError(field);

    field = "pgPerformance";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperDoubleRE.test(input)) 
    {
      if($("[name='pgPerformanceCGPA']").prop("checked") && !(parseFloat(input)<=10.0)) markError(field);
      else if(!$("[name='pgPerformanceCGPA']").prop("checked") && !(parseFloat(input)<=100.0)) markError(field);
      else unmarkError(field);
    }
    else unmarkError(field);
  }
  else
  {
    unmarkError("pgDegree");
    unmarkError("pgDept");
    unmarkError("pgCollege");
    unmarkError("pgUniv");
    unmarkError("pgCity");
    unmarkError("pgState");
    unmarkError("pgYear");
    unmarkError("pgPerformance");
  }

  if($("[name='oaApplicable']").prop('checked'))
  {
    field = "oADegree";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "oASubject";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "oACollege";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "oAYear";
    var input = tagField(field).val().trim();
    if(input.length != 4 || !ProperNumberRE.test(input) || !(parseInt(input)>=1970 && parseInt(input)<=(new Date()).getFullYear())) markError(field);
    else unmarkError(field);

    field = "oAPerformance";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=100.0)) markError(field);
    else unmarkError(field);
  }
  else
  {
    unmarkError("oADegree");
    unmarkError("oASubject");
    unmarkError("oACollege");
    unmarkError("oAYear");
    unmarkError("oAPerformance");
  }

  if($("[name='gateApplicable']").prop('checked'))
  {
    field = "gateArea";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNameRE.test(input)) markError(field);
    else unmarkError(field);

    field = "gateYear";
    var input = tagField(field).val().trim();
    if(input.length != 4 || !ProperNumberRE.test(input) || !(parseInt(input)>=parseInt(tagField("gradYear").val().trim()) && parseInt(input)<=(new Date()).getFullYear())) markError(field);
    else unmarkError(field);

    field = "gatePercentage";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=100.0)) markError(field);
    else unmarkError(field);
    
    field = "gateScore";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperDoubleRE.test(input) || !(parseFloat(input)<=1000.0)) markError(field);
    else unmarkError(field);

    field = "gateRank";
    var input = tagField(field).val().trim();
    if(input.length == 0 || !ProperNumberRE.test(input) || parseInt(input)==0) markError(field);
    else unmarkError(field);
  }
  else
  {
    unmarkError("gateArea");
    unmarkError("gateYear");
    unmarkError("gatePercentage");
    unmarkError("gateScore");
    unmarkError("gateRank");
  }

  /*field = "cvUploadPath";
  var input = tagField(field);
  if(!(input.prop('files')[0]) || input.files[0].size > 4194304) markError(field);
  else unmarkError(field); 

  field = "sopUploadPath";
  var input = tagField(field);
  if(!(input.prop('files')[0]) || input.files[0].size > 4194304) markError(field);
  else unmarkError(field);
*/
  // field = "feedbackQ2";
  // if(feedbackQ2().length == 0) markError(field);
  // else
  // {
  //   unmarkError(field);
  //   $("[name='feedbackQ2string']").val(feedbackQ2());
  // }
}