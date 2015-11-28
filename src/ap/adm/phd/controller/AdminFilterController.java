package ap.adm.phd.controller;

import static ap.adm.phd.utilities.GlobalVars.Choices;
import static ap.adm.phd.utilities.GlobalVars.IndianStates;
import static ap.adm.phd.utilities.GlobalVars.casteList;

import java.util.HashSet;

import ap.adm.phd.MainApp;
import ap.adm.phd.model.Applicant;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */

public class AdminFilterController
{
	@FXML private TextField nameField;
	@FXML private TextField emailField;
	@FXML private TextField enrollField;
	@FXML private ChoiceBox<String> categoryField;
	@FXML private ToggleGroup genderField;
	@FXML private ToggleGroup phyDisField;
	@FXML private ToggleGroup dateOfBirthConditionField;
	@FXML private DatePicker dateOfBirthField;
	@FXML private ChoiceBox<String> phdStreamField;
	@FXML private ChoiceBox<String> graduationDegreeField;
	@FXML private ChoiceBox<String> pgDegreeField;
	@FXML private ChoiceBox<String> xBoardField;
	@FXML private ChoiceBox<String> xiiBoardField;
	@FXML private ChoiceBox<String> gradDeptField;
	@FXML private ChoiceBox<String> pgDeptField;
	@FXML private TextField gradUnivField;
	@FXML private TextField pgUnivField;
	@FXML private ChoiceBox<String> gradStateField;
	@FXML private ChoiceBox<String> pgStateField;
	@FXML private CheckBox xMarksFieldGreater;
	@FXML private CheckBox xMarksFieldEqual;
	@FXML private CheckBox xMarksFieldLesser;
	@FXML private TextField xMarksField;
	@FXML private CheckBox xiiMarksFieldGreater;
	@FXML private CheckBox xiiMarksFieldEqual;
	@FXML private CheckBox xiiMarksFieldLesser;
	@FXML private TextField xiiMarksField;
	@FXML private CheckBox gradMarksFieldGreater;
	@FXML private CheckBox gradMarksFieldEqual;
	@FXML private CheckBox gradMarksFieldLesser;
	@FXML private TextField gradMarksField;
	@FXML private CheckBox pgMarksFieldGreater;
	@FXML private CheckBox pgMarksFieldEqual;
	@FXML private CheckBox pgMarksFieldLesser;
	@FXML private TextField pgMarksField;
	@FXML private CheckBox gateMarksFieldGreater;
	@FXML private CheckBox gateMarksFieldEqual;
	@FXML private CheckBox gateMarksFieldLesser;
	@FXML private TextField gateMarksField;
	@FXML private DatePicker datedFromField;
	@FXML private DatePicker datedToField;
	@FXML private Button submitButton;
	
	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}
	private boolean filterPredicate(Applicant A)
	{
		//Personal Information
		if(nameField.getText().trim().length() > 0 && A.getPersonalInformation().getApplicantName().equals(nameField.getText()) == false) return false;
		if(emailField.getText().trim().length() > 0 && A.getPersonalInformation().getEmail().equals(emailField.getText()) == false) return false;
		if(enrollField.getText().trim().length() > 0 && A.getPersonalInformation().getEnrollmentNo().equals(enrollField.getText()) == false) return false;
		if(categoryField.getValue() != null && A.getPersonalInformation().getCategory().equals(categoryField.getValue()) == false) return false;
		if(genderField.getSelectedToggle() != null && A.getPersonalInformation().getGender().equals(((RadioButton)(genderField.getSelectedToggle())).getText()) == false) return false;
		if(phyDisField.getSelectedToggle() != null && A.getPersonalInformation().getDisabled() == (((RadioButton)(phyDisField.getSelectedToggle())).getText().equals("Yes"))) return false; 
		if(dateOfBirthConditionField.getSelectedToggle() != null && dateOfBirthField.getValue() != null)
		{
			switch(((RadioButton)(dateOfBirthConditionField.getSelectedToggle())).getText())
			{
				case "Before":if(A.getPersonalInformation().getDateOfBirth().isBefore(dateOfBirthField.getValue()) == false) return false;break;
				case "On":if(A.getPersonalInformation().getDateOfBirth().isEqual(dateOfBirthField.getValue()) == false) return false;break;
				case "After":if(A.getPersonalInformation().getDateOfBirth().isAfter(dateOfBirthField.getValue()) == false) return false;break;
			}
		}
		
		//Educational Information
		if(phdStreamField.getValue() != null && !A.getPersonalInformation().getPreferences()[0].equals(phdStreamField.getValue()) && !A.getPersonalInformation().getPreferences()[1].equals(phdStreamField.getValue()) && !A.getPersonalInformation().getPreferences()[2].equals(phdStreamField.getValue())) return false;
		if(graduationDegreeField.getValue() != null && A.getEducationInformation().getGraduation().getDegreeName().equals(graduationDegreeField.getValue()) == false) return false;
		if(pgDegreeField.getValue() != null && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getDegreeName().equals(pgDegreeField.getValue()) == false))) return false;
		if(xBoardField.getValue() != null && A.getEducationInformation().getSchooling().getTenthBoardName().equals(xBoardField.getValue()) == false) return false;
		if(xiiBoardField.getValue() != null && A.getEducationInformation().getSchooling().getTwelfthBoardName().equals(xiiBoardField.getValue()) == false) return false;
		if(gradDeptField.getValue() != null && A.getEducationInformation().getGraduation().getDepartment().equals(gradDeptField.getValue()) == false) return false;
		if(pgDeptField.getValue() != null && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getDepartment().equals(pgDeptField.getValue()) == false))) return false;
		if(gradUnivField.getText().trim().length() > 0 && A.getEducationInformation().getGraduation().getUniversityName().equals(gradUnivField.getText()) == false) return false;
		if(pgUnivField.getText().trim().length() > 0 && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getUniversity().equals(pgUnivField.getText()) == false))) return false;
		if(gradStateField.getValue() != null && A.getEducationInformation().getGraduation().getState().equals(gradStateField.getValue()) == false) return false;
		if(pgStateField.getValue() != null && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getState().equals(pgStateField.getValue()) == false))) return false;
		if(xMarksField.getText().trim().length() > 0)
		{
			boolean t = false;
			if(xMarksFieldGreater.isSelected() && A.getEducationInformation().getSchooling().getTenthBoardResults() > Double.parseDouble(xMarksField.getText())) t = true;
			if(xMarksFieldEqual.isSelected() && A.getEducationInformation().getSchooling().getTenthBoardResults() == Double.parseDouble(xMarksField.getText())) t = true;
			if(xMarksFieldLesser.isSelected() && A.getEducationInformation().getSchooling().getTenthBoardResults() < Double.parseDouble(xMarksField.getText())) t = true;
			if(t == false) return false;
		}
		if(xiiMarksField.getText().trim().length() > 0)
		{
			boolean t = false;
			if(xiiMarksFieldGreater.isSelected() && A.getEducationInformation().getSchooling().getTwelfthBoardResults() > Double.parseDouble(xiiMarksField.getText())) t = true;
			if(xiiMarksFieldEqual.isSelected() && A.getEducationInformation().getSchooling().getTwelfthBoardResults() == Double.parseDouble(xiiMarksField.getText())) t = true;
			if(xiiMarksFieldLesser.isSelected() && A.getEducationInformation().getSchooling().getTwelfthBoardResults() < Double.parseDouble(xiiMarksField.getText())) t = true;
			if(t == false) return false;
		}
		if(gradMarksField.getText().trim().length() > 0)
		{
			boolean t = false;
			if(gradMarksFieldGreater.isSelected() && ((A.getEducationInformation().getGraduation().getCgpaSelected() == true && A.getEducationInformation().getGraduation().getCgpa()*10 > Double.parseDouble(gradMarksField.getText())) || (A.getEducationInformation().getGraduation().getPercentageSelected() == true && A.getEducationInformation().getGraduation().getPercentage() > Double.parseDouble(gradMarksField.getText())))) t = true;
			if(gradMarksFieldEqual.isSelected() && ((A.getEducationInformation().getGraduation().getCgpaSelected() == true && A.getEducationInformation().getGraduation().getCgpa()*10 == Double.parseDouble(gradMarksField.getText())) || (A.getEducationInformation().getGraduation().getPercentageSelected() == true && A.getEducationInformation().getGraduation().getPercentage() == Double.parseDouble(gradMarksField.getText())))) t = true;
			if(gradMarksFieldLesser.isSelected() && ((A.getEducationInformation().getGraduation().getCgpaSelected() == true && A.getEducationInformation().getGraduation().getCgpa()*10 < Double.parseDouble(gradMarksField.getText())) || (A.getEducationInformation().getGraduation().getPercentageSelected() == true && A.getEducationInformation().getGraduation().getPercentage() < Double.parseDouble(gradMarksField.getText())))) t = true;
			if(t == false) return false;
		}
		if(pgMarksField.getText().trim().length() > 0)
		{
			if(A.getEducationInformation().getPostGraduation() == null) return false;
			boolean t = false;
			if(pgMarksFieldGreater.isSelected() && ((A.getEducationInformation().getPostGraduation().getCgpaSelected() == true && A.getEducationInformation().getPostGraduation().getCgpa()*10 > Double.parseDouble(pgMarksField.getText())) || (A.getEducationInformation().getPostGraduation().getPercentageSelected() == true && A.getEducationInformation().getPostGraduation().getPercentage() > Double.parseDouble(pgMarksField.getText())))) t = true;
			if(pgMarksFieldEqual.isSelected() && ((A.getEducationInformation().getPostGraduation().getCgpaSelected() == true && A.getEducationInformation().getPostGraduation().getCgpa()*10 == Double.parseDouble(pgMarksField.getText())) || (A.getEducationInformation().getPostGraduation().getPercentageSelected() == true && A.getEducationInformation().getPostGraduation().getPercentage() == Double.parseDouble(pgMarksField.getText())))) t = true;
			if(pgMarksFieldLesser.isSelected() && ((A.getEducationInformation().getPostGraduation().getCgpaSelected() == true && A.getEducationInformation().getPostGraduation().getCgpa()*10 < Double.parseDouble(pgMarksField.getText())) || (A.getEducationInformation().getPostGraduation().getPercentageSelected() == true && A.getEducationInformation().getPostGraduation().getPercentage() < Double.parseDouble(pgMarksField.getText())))) t = true;
			if(t == false) return false;
		}
		if(gateMarksField.getText().trim().length() > 0)
		{
			if(A.getEducationInformation().getOtherAcademic().getGate() == null) return false; 
			boolean t = false;
			if(gateMarksFieldGreater.isSelected() && A.getEducationInformation().getOtherAcademic().getGate().getPercentage() > Double.parseDouble(gateMarksField.getText())) t = true;
			if(gateMarksFieldEqual.isSelected() && A.getEducationInformation().getOtherAcademic().getGate().getPercentage() == Double.parseDouble(gateMarksField.getText())) t = true;
			if(gateMarksFieldLesser.isSelected() && A.getEducationInformation().getOtherAcademic().getGate().getPercentage() < Double.parseDouble(gateMarksField.getText())) t = true;
			if(t == false) return false;
		}
		if(!(datedFromField.getValue() == null || (datedFromField.getValue() != null && A.getApplicationSubmit().isAfter(datedFromField.getValue().minusDays(1))))) return false;
		if(!(datedToField.getValue() == null || (datedToField.getValue() != null && A.getApplicationSubmit().isBefore(datedToField.getValue().plusDays(1))))) return false;
		return true;
	}
	
	@FXML private void onSubmitAction(){
		if(validateFields())
		{
			setValid(submitButton);
			mainApp.filteredApplicants.clear();
			for (Applicant a : mainApp.getApplicants()){
				if (filterPredicate(a)) mainApp.filteredApplicants.add(a);
			}
			mainApp.openAdminFilterResults();
		}
		else setInvalid(submitButton);
	}

	//Numeric Text Fields (Floating Point Values) Constraint Event
	private void makeNumericF(TextField text){
		text.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>(){
			public void handle( KeyEvent t ){
				char ar[] = t.getCharacter().toCharArray();
				char ch = ar[t.getCharacter().toCharArray().length - 1];
				if (!(ch >= '0' && ch <= '9' || ch == '.')) t.consume();
			}
		});
	}

	public void init() {
		try{
			mainApp.readRecord();
		} catch(Exception e){
			e.printStackTrace();
		}
		HashSet<String> temp1 = new HashSet<String>();
		HashSet<String> temp2 = new HashSet<String>();
		HashSet<String> temp3 = new HashSet<String>();
		HashSet<String> temp4 = new HashSet<String>();
		HashSet<String> temp5 = new HashSet<String>();
		HashSet<String> temp6 = new HashSet<String>();
		for(Applicant A : mainApp.getApplicants())
		{
			temp3.add(A.getEducationInformation().getSchooling().getTenthBoardName());
			temp4.add(A.getEducationInformation().getSchooling().getTwelfthBoardName());
			temp1.add(A.getEducationInformation().getGraduation().getDegreeName());
			temp5.add(A.getEducationInformation().getGraduation().getDepartment());
			if(A.getEducationInformation().getPostGraduation() != null)
			{
				temp2.add(A.getEducationInformation().getPostGraduation().getDegreeName());
				temp6.add(A.getEducationInformation().getPostGraduation().getDepartment());
			}
			
		}
		//System.out.println(filteredResult);
		categoryField.setItems(casteList);
		phdStreamField.setItems(Choices);
		gradStateField.setItems(IndianStates);
		pgStateField.setItems(IndianStates);
		graduationDegreeField.setItems(FXCollections.observableArrayList(temp1));
		pgDegreeField.setItems(FXCollections.observableAqrrayList(temp2));
		xBoardField.setItems(FXCollections.observableArrayList(temp3));
		xiiBoardField.setItems(FXCollections.observableArrayList(temp4));
		gradDeptField.setItems(FXCollections.observableArrayList(temp5));
		pgDeptField.setItems(FXCollections.observableArrayList(temp6));
		makeNumericF(xMarksField);
		makeNumericF(xiiMarksField);
		makeNumericF(gradMarksField);
		makeNumericF(pgMarksField);
		makeNumericF(gateMarksField);
		makeNumericF(enrollField);
	}
	
	private boolean validateFields()
	{
		boolean flag = true;
		if(emailField.getText().trim().length() > 0 && !emailField.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {setInvalid(emailField);flag=false;}
		else setValid(emailField);
		if(enrollField.getText().trim().length() > 0 && emailField.getText().length() != 8) {setInvalid(enrollField);flag=false;}
		else setValid(enrollField);
		if(xMarksField.getText().trim().length() > 0 && !checkDouble(xMarksField.getText())) {setInvalid(xMarksField);flag=false;}
		else setValid(xMarksField);
		if(xiiMarksField.getText().trim().length() > 0 && !checkDouble(xiiMarksField.getText())) {setInvalid(xiiMarksField);flag=false;}
		else setValid(xiiMarksField);
		if(gradMarksField.getText().trim().length() > 0 && !checkDouble(gradMarksField.getText())) {setInvalid(gradMarksField);flag=false;}
		else setValid(gradMarksField);
		if(pgMarksField.getText().trim().length() > 0 && !checkDouble(pgMarksField.getText())) {setInvalid(pgMarksField);flag=false;}
		else setValid(pgMarksField);
		if(gateMarksField.getText().trim().length() > 0 && !checkDouble(gateMarksField.getText())) {setInvalid(gateMarksField);flag=false;}
		else setValid(gateMarksField);
		if(datedFromField.getValue() != null && datedToField.getValue() != null && !datedFromField.getValue().isBefore(datedToField.getValue())) {setInvalid(datedFromField);setInvalid(datedToField);flag=false;}
		else {setValid(datedFromField);setValid(datedToField);}
		return flag;
	}
	
	private boolean checkDouble(String s)
	{
		if(s.matches("[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*"))
		{
			return (Double.parseDouble(s) >= 0 && Double.parseDouble(s) <= 100);
		}
		return false;
	}
	private void setValid(Control control) {control.setStyle("-fx-border-color: none;");}
	private void setInvalid(Control control) {control.setStyle("-fx-border-color: red;");}
}
