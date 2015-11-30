package ap.adm.phd;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import ap.adm.phd.model.Applicant;

public class AdminManager {
	private static ArrayList<Applicant> applicants;
	private static ArrayList<Applicant> filteredApplicants;
	public static void readRecord() throws IOException, ClassNotFoundException{
		Applicant applicant = null;
		int i;
		ObjectInputStream inStream = null;
		applicants = new ArrayList<>();
		File[] dataFolder = (new File("data")).listFiles();
		for(i=0;i<dataFolder.length;i++)
		{
			inStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("data/"+dataFolder[i].getName()+"/applicantData.adm")));
			try{
				while (true)
				{	
					applicant = (Applicant)inStream.readObject();
					applicants.add(applicant);
				}
			}
			catch(EOFException e){
				inStream.close();
			}
		}
	}
	public static void filter(HashMap<String,String> params){
		filteredApplicants = new ArrayList<>();
		for (Applicant a : applicants){
			if (filterPredicate(a, params)) filteredApplicants.add(a);
		}
		return;
	}
	
	public static ArrayList<Applicant> getFilteredApplicants()
	{
		return filteredApplicants;
	}
	private static boolean filterPredicate(Applicant A, HashMap<String, String> params)
	{
		//Personal Information
		if(params.get("nameField").trim().length() > 0 && A.getPersonalInformation().getApplicantName().equals(params.get("nameField")) == false) return false;
		System.out.println(params.get("emailField"));
		if(params.get("emailField").trim().length() > 0 && A.getPersonalInformation().getEmail().equals(params.get("emailField")) == false) return false;
		//if(params.get("enrollField").trim().length() > 0 && A.getPersonalInformation().getEnrollmentNo().equals(params.get("enrollField")) == false) return false;
		//if(!params.get("category").equals("") && A.getPersonalInformation().getCategory().equals(params.get("category")) == false) return false;
		// if(genderField.getSelectedToggle() != null && A.getPersonalInformation().getGender().equals(((RadioButton)(genderField.getSelectedToggle())).getText()) == false) return false;
		// if(phyDisField.getSelectedToggle() != null && A.getPersonalInformation().getDisabled() == (((RadioButton)(phyDisField.getSelectedToggle())).getText().equals("Yes"))) return false; 
		// if(dateOfBirthConditionField.getSelectedToggle() != null && dateOfBirthField.getValue() != null)
		// {
		// 	switch(((RadioButton)(dateOfBirthConditionField.getSelectedToggle())).getText())
		// 	{
		// 		case "Before":if(A.getPersonalInformation().getDateOfBirth().isBefore(dateOfBirthField.getValue()) == false) return false;break;
		// 		case "On":if(A.getPersonalInformation().getDateOfBirth().isEqual(dateOfBirthField.getValue()) == false) return false;break;
		// 		case "After":if(A.getPersonalInformation().getDateOfBirth().isAfter(dateOfBirthField.getValue()) == false) return false;break;
		// 	}
		// }
		
		//Educational Information
		/*if(!params.get("phdStreamField").equals("") && !A.getPersonalInformation().getPreferences()[0].equals(params.get("phdStreamField")) && !A.getPersonalInformation().getPreferences()[1].equals(params.get("phdStreamField")) && !A.getPersonalInformation().getPreferences()[2].equals(params.get("phdStreamField"))) return false;
		if(!params.get("graduationDegreeField").equals("") && A.getEducationInformation().getGraduation().getDegreeName().equals(params.get("graduationDegreeField")) == false) return false;
		if(!params.get("pgDegreeField").equals("") && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getDegreeName().equals(params.get("pgDegreeField")) == false))) return false;
		if(!params.get("xBoardField").equals("") && A.getEducationInformation().getSchooling().getTenthBoardName().equals(params.get("xBoardField")) == false) return false;
		if(!params.get("xiiBoardField").equals("") && A.getEducationInformation().getSchooling().getTwelfthBoardName().equals(params.get("xiiBoardField")) == false) return false;
		if(!params.get("gradDeptField").equals("") && A.getEducationInformation().getGraduation().getDepartment().equals(params.get("gradDeptField")) == false) return false;
		if(!params.get("pgDeptField").equals("") && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getDepartment().equals(params.get("pgDeptField")) == false))) return false;
		if(params.get("gradUnivField").trim().length() > 0 && A.getEducationInformation().getGraduation().getUniversityName().equals(params.get("gradUnivField")) == false) return false;
		*/// if(params.get("pgUnivField").trim().length() > 0 && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getUniversity().equals(pgUnivField.getText()) == false))) return false;
		// if(!params.get("gradStateField").equals("") && A.getEducationInformation().getGraduation().getState().equals(gradStateField.getValue()) == false) return false;
		// if!(params.get("pgStateField").equals("") && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getState().equals(pgStateField.getValue()) == false))) return false;
		// if(params.get("xMarksField").trim().length() > 0)
		// {
		// 	boolean t = false;
		// 	if(xMarksFieldGreater.isSelected() && A.getEducationInformation().getSchooling().getTenthBoardResults() > Double.parseDouble(xMarksField.getText())) t = true;
		// 	if(xMarksFieldEqual.isSelected() && A.getEducationInformation().getSchooling().getTenthBoardResults() == Double.parseDouble(xMarksField.getText())) t = true;
		// 	if(xMarksFieldLesser.isSelected() && A.getEducationInformation().getSchooling().getTenthBoardResults() < Double.parseDouble(xMarksField.getText())) t = true;
		// 	if(t == false) return false;
		// }
		// if(xiiMarksField.getText().trim().length() > 0)
		// {
		// 	boolean t = false;
		// 	if(xiiMarksFieldGreater.isSelected() && A.getEducationInformation().getSchooling().getTwelfthBoardResults() > Double.parseDouble(xiiMarksField.getText())) t = true;
		// 	if(xiiMarksFieldEqual.isSelected() && A.getEducationInformation().getSchooling().getTwelfthBoardResults() == Double.parseDouble(xiiMarksField.getText())) t = true;
		// 	if(xiiMarksFieldLesser.isSelected() && A.getEducationInformation().getSchooling().getTwelfthBoardResults() < Double.parseDouble(xiiMarksField.getText())) t = true;
		// 	if(t == false) return false;
		// }
		// if(gradMarksField.getText().trim().length() > 0)
		// {
		// 	boolean t = false;
		// 	if(gradMarksFieldGreater.isSelected() && ((A.getEducationInformation().getGraduation().getCgpaSelected() == true && A.getEducationInformation().getGraduation().getCgpa()*10 > Double.parseDouble(gradMarksField.getText())) || (A.getEducationInformation().getGraduation().getPercentageSelected() == true && A.getEducationInformation().getGraduation().getPercentage() > Double.parseDouble(gradMarksField.getText())))) t = true;
		// 	if(gradMarksFieldEqual.isSelected() && ((A.getEducationInformation().getGraduation().getCgpaSelected() == true && A.getEducationInformation().getGraduation().getCgpa()*10 == Double.parseDouble(gradMarksField.getText())) || (A.getEducationInformation().getGraduation().getPercentageSelected() == true && A.getEducationInformation().getGraduation().getPercentage() == Double.parseDouble(gradMarksField.getText())))) t = true;
		// 	if(gradMarksFieldLesser.isSelected() && ((A.getEducationInformation().getGraduation().getCgpaSelected() == true && A.getEducationInformation().getGraduation().getCgpa()*10 < Double.parseDouble(gradMarksField.getText())) || (A.getEducationInformation().getGraduation().getPercentageSelected() == true && A.getEducationInformation().getGraduation().getPercentage() < Double.parseDouble(gradMarksField.getText())))) t = true;
		// 	if(t == false) return false;
		// }
		// if(pgMarksField.getText().trim().length() > 0)
		// {
		// 	if(A.getEducationInformation().getPostGraduation() == null) return false;
		// 	boolean t = false;
		// 	if(pgMarksFieldGreater.isSelected() && ((A.getEducationInformation().getPostGraduation().getCgpaSelected() == true && A.getEducationInformation().getPostGraduation().getCgpa()*10 > Double.parseDouble(pgMarksField.getText())) || (A.getEducationInformation().getPostGraduation().getPercentageSelected() == true && A.getEducationInformation().getPostGraduation().getPercentage() > Double.parseDouble(pgMarksField.getText())))) t = true;
		// 	if(pgMarksFieldEqual.isSelected() && ((A.getEducationInformation().getPostGraduation().getCgpaSelected() == true && A.getEducationInformation().getPostGraduation().getCgpa()*10 == Double.parseDouble(pgMarksField.getText())) || (A.getEducationInformation().getPostGraduation().getPercentageSelected() == true && A.getEducationInformation().getPostGraduation().getPercentage() == Double.parseDouble(pgMarksField.getText())))) t = true;
		// 	if(pgMarksFieldLesser.isSelected() && ((A.getEducationInformation().getPostGraduation().getCgpaSelected() == true && A.getEducationInformation().getPostGraduation().getCgpa()*10 < Double.parseDouble(pgMarksField.getText())) || (A.getEducationInformation().getPostGraduation().getPercentageSelected() == true && A.getEducationInformation().getPostGraduation().getPercentage() < Double.parseDouble(pgMarksField.getText())))) t = true;
		// 	if(t == false) return false;
		// }
		// if(gateMarksField.getText().trim().length() > 0)
		// {
		// 	if(A.getEducationInformation().getOtherAcademic().getGate() == null) return false; 
		// 	boolean t = false;
		// 	if(gateMarksFieldGreater.isSelected() && A.getEducationInformation().getOtherAcademic().getGate().getPercentage() > Double.parseDouble(gateMarksField.getText())) t = true;
		// 	if(gateMarksFieldEqual.isSelected() && A.getEducationInformation().getOtherAcademic().getGate().getPercentage() == Double.parseDouble(gateMarksField.getText())) t = true;
		// 	if(gateMarksFieldLesser.isSelected() && A.getEducationInformation().getOtherAcademic().getGate().getPercentage() < Double.parseDouble(gateMarksField.getText())) t = true;
		// 	if(t == false) return false;
		// }
		// if(!(datedFromField.getValue() == null || (!datedFromField.getValue().equals("") && A.getApplicationSubmit().isAfter(datedFromField.getValue().minusDays(1))))) return false;
		// if(!(datedToField.getValue() == null || (datedToField.getValue() != null && A.getApplicationSubmit().isBefore(datedToField.getValue().plusDays(1))))) return false;
		return true;
	}
}
