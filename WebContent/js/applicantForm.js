var CSEChoice = ["","Artificial Intelligence and Robotics","Compilers","Computer Architecture and Systems Design","Computer Graphics","Computer Vision","Image Analysis and Biometrics","Information Management and Data Engineering","Machine Learning","Massively Parallel Systems","Mobile Computing and Networking Applications","Program Analysis","Security and Privacy","Signal and Image Processing","Software Engineering","Theoretical Computer Science","Wireless Networks"];
var ECEChoice = ["","Wireless Communication","Wireless Networks","RF and mixed signal electronics","OFDM based Optical Access Networks","Optical Wireless Communication Systems","Signal and Image Processing","Machine Learning","Controls and Robotics","Digital and Analog VLSI Systems Design","Electromagnetics","Embedded and VLSI systems design","Embedded Systems","Fiber-Wireless Architectures","Computer Architecture and Systems Design"];
var CBChoice = ["","Structural Biology","Systems Biology","Biophysics"];
var countries = ["Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","China","Colombia","Comoros","Congo","Congo","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Ivory Coast","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati","Korea North","Korea South","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mozambique","Myanmar, {Burma}","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Romania","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia","Saint Vincent & the Grenadines","Samoa","San Marino","Sao Tome & Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe"]
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
      $("[name='name']").val(readCookie('guser_name').replace(/\"/g, ""));
      $("[name='email']").val(readCookie('guser_email').replace(/\"/g, ""));
      $("[name='corrAddress']").val(readCookie('guser_corrAddress').replace(/\"/g, ""));
      $("[name='mobNumber']").val(readCookie('guser_mobNumber').replace(/\"/g, ""));
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
}