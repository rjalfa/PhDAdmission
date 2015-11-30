var StreamChoice = ["","Artificial Intelligence and Robotics","Compilers","Computer Architecture and Systems Design","Computer Graphics","Computer Vision","Image Analysis and Biometrics","Information Management and Data Engineering","Machine Learning","Massively Parallel Systems","Mobile Computing and Networking Applications","Program Analysis","Security and Privacy","Signal and Image Processing","Software Engineering","Theoretical Computer Science","Wireless Networks","Wireless Communication","Wireless Networks","RF and mixed signal electronics","OFDM based Optical Access Networks","Optical Wireless Communication Systems","Signal and Image Processing","Machine Learning","Controls and Robotics","Digital and Analog VLSI Systems Design","Electromagnetics","Embedded and VLSI systems design","Embedded Systems","Fiber-Wireless Architectures","Computer Architecture and Systems Design","Structural Biology","Systems Biology","Biophysics"];

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
    $("#adfField").bootstrapMaterialDatePicker({ weekStart : 0, time: false});
    $("#adtField").bootstrapMaterialDatePicker({ weekStart : 0, time: false});

    var ddata = JSON.parse(JSON.parse(readCookie("dropdowndata")));
	
	StreamChoice.forEach(function(element,index,array){
	    $('[name="phdStreamField"]').append("<option>"+element+"</option>");
	});

	['xBoardField','xiiBoardField','graduationDegreeField','gradDeptField','pgDegreeField','pgDeptField'].forEach(function(ele,ind,arr)
	{
		ddata[ele].forEach(function(element,index,array){
    		$('[name="'+ele+'"]').append("<option>"+element+"</option>");
		});
	});
});