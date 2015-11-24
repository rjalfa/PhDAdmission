$(document).ready(function(){
	$.material.init();
	var vdate = new Date();
    vdate.setFullYear(vdate.getFullYear() - 15);
    $("#dateOfBirthField").bootstrapMaterialDatePicker({ weekStart : 0, time: false ,maxDate: vdate});
    $("#adfField").bootstrapMaterialDatePicker({ weekStart : 0, time: false});
    $("#adtField").bootstrapMaterialDatePicker({ weekStart : 0, time: false});
});