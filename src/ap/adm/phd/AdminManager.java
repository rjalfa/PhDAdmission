package ap.adm.phd;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ap.adm.phd.model.Applicant;

public class AdminManager {
	private static ArrayList<Applicant> applicants;
	private static ArrayList<Applicant> filteredApplicants;
	public static HashSet<String> temp1;
	public static HashSet<String> temp2;
	public static HashSet<String> temp3;
	public static HashSet<String> temp4;
	public static HashSet<String> temp5;
	public static HashSet<String> temp6;
	public static HashSet<String> temp7;
	public static HashSet<String> temp8;
	public static void readRecord() throws IOException, ClassNotFoundException{
		Applicant applicant = null;
		temp1 = new HashSet<String>();
		temp2 = new HashSet<String>();
		temp3 = new HashSet<String>();
		temp4 = new HashSet<String>();
		temp5 = new HashSet<String>();
		temp6 = new HashSet<String>();
		temp7 = new HashSet<String>();
		temp8 = new HashSet<String>();
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
					temp1.add(applicant.getEducationInformation().getSchooling().getTenthBoardName());
					temp2.add(applicant.getEducationInformation().getSchooling().getTwelfthBoardName());
					temp3.add(applicant.getEducationInformation().getGraduation().getDegreeName());
					temp4.add(applicant.getEducationInformation().getGraduation().getDepartment());
					temp7.add(applicant.getEducationInformation().getGraduation().getState());
					if(applicant.getEducationInformation().getPostGraduation() != null)
					{
						temp5.add(applicant.getEducationInformation().getPostGraduation().getDegreeName());
						temp6.add(applicant.getEducationInformation().getPostGraduation().getDepartment());
						temp8.add(applicant.getEducationInformation().getPostGraduation().getState());
					}
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
		if(params.get("enrollField").trim().length() > 0 && A.getPersonalInformation().getEnrollmentNo().equals(params.get("enrollField")) == false) return false;
		/*
		if(!params.get("category").equals("") && A.getPersonalInformation().getCategory().equals(params.get("category")) == false) return false;
		if(A.getPersonalInformation().getGender().equals(params.get("genderField")) == false) return false;
		if(A.getPersonalInformation().getDisabled() == params.get("phyDisField").equals("Yes")) return false; 
		switch(params.get("dateOfBirthConditionField"))
		{
			case "Before":if(A.getPersonalInformation().getDateOfBirth().isBefore(LocalDate.parse(params.get("dateOfBirthField"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))) == false) return false;break;
			case "On":if(A.getPersonalInformation().getDateOfBirth().isEqual(LocalDate.parse(params.get("dateOfBirthField"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))) == false) return false;break;
			case "After":if(A.getPersonalInformation().getDateOfBirth().isAfter(LocalDate.parse(params.get("dateOfBirthField"), DateTimeFormatter.ofPattern("yyyy-MM-dd"))) == false) return false;break;
		}
		
		//Educational Information
		*/
		if(!params.get("phdStreamField").equals("") && !A.getPersonalInformation().getPreferences()[0].equals(params.get("phdStreamField")) && !A.getPersonalInformation().getPreferences()[1].equals(params.get("phdStreamField")) && !A.getPersonalInformation().getPreferences()[2].equals(params.get("phdStreamField"))) return false;
		if(!params.get("graduationDegreeField").equals("") && A.getEducationInformation().getGraduation().getDegreeName().equals(params.get("graduationDegreeField")) == false) return false;
		if(!params.get("pgDegreeField").equals("") && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getDegreeName().equals(params.get("pgDegreeField")) == false))) return false;
		if(!params.get("xBoardField").equals("") && A.getEducationInformation().getSchooling().getTenthBoardName().equals(params.get("xBoardField")) == false) return false;
		if(!params.get("xiiBoardField").equals("") && A.getEducationInformation().getSchooling().getTwelfthBoardName().equals(params.get("xiiBoardField")) == false) return false;
		if(!params.get("gradDeptField").equals("") && A.getEducationInformation().getGraduation().getDepartment().equals(params.get("gradDeptField")) == false) return false;
		if(!params.get("pgDeptField").equals("") && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getDepartment().equals(params.get("pgDeptField")) == false))) return false;
		if(params.get("gradUnivField").trim().length() > 0 && A.getEducationInformation().getGraduation().getUniversityName().equals(params.get("gradUnivField")) == false) return false;
		if(params.get("pgUnivField").trim().length() > 0 && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getUniversity().equals(params.get("pgUnivField")) == false))) return false;
		if(!params.get("gradStateField").equals("") && A.getEducationInformation().getGraduation().getState().equals(params.get("gradStateField")) == false) return false;
		if(!params.get("pgStateField").equals("") && (A.getEducationInformation().getPostGraduation() == null || (A.getEducationInformation().getPostGraduation() != null && A.getEducationInformation().getPostGraduation().getState().equals(params.get("pgStateField")) == false))) return false;
		/*
		if(params.get("xMarksField").trim().length() > 0)
		{
			boolean t = false;
			if(params.containsKey("xMarksFieldGreater") && A.getEducationInformation().getSchooling().getTenthBoardResults() > Double.parseDouble(params.get("xMarksField"))) t = true;
			if(params.containsKey("xMarksFieldEqual") && A.getEducationInformation().getSchooling().getTenthBoardResults() == Double.parseDouble(params.get("xMarksField"))) t = true;
			if(params.containsKey("xMarksFieldLesser") && A.getEducationInformation().getSchooling().getTenthBoardResults() < Double.parseDouble(params.get("xMarksField"))) t = true;
			if(t == false) return false;
		}
		if(params.get("xiiMarksField").trim().length() > 0)
		{
			boolean t = false;
			if(params.containsKey("xiiMarksFieldGreater") && A.getEducationInformation().getSchooling().getTwelfthBoardResults() > Double.parseDouble(params.get("xiiMarksField"))) t = true;
			if(params.containsKey("xiiMarksFieldEqual") && A.getEducationInformation().getSchooling().getTwelfthBoardResults() == Double.parseDouble(params.get("xiiMarksField"))) t = true;
			if(params.containsKey("xiiMarksFieldLesser") && A.getEducationInformation().getSchooling().getTwelfthBoardResults() < Double.parseDouble(params.get("xiiMarksField"))) t = true;
			if(t == false) return false;
		}
		if(params.get("gradMarksField").trim().length() > 0)
		{
			boolean t = false;
			if(params.containsKey("gradMarksFieldGreater") && ((A.getEducationInformation().getGraduation().getCgpaSelected() == true && A.getEducationInformation().getGraduation().getCgpa()*10 > Double.parseDouble(params.get("gradMarksField"))) || (A.getEducationInformation().getGraduation().getPercentageSelected() == true && A.getEducationInformation().getGraduation().getPercentage() > Double.parseDouble(params.get("gradMarksField"))))) t = true;
			if(params.containsKey("gradMarksFieldEqual") && ((A.getEducationInformation().getGraduation().getCgpaSelected() == true && A.getEducationInformation().getGraduation().getCgpa()*10 == Double.parseDouble(params.get("gradMarksField"))) || (A.getEducationInformation().getGraduation().getPercentageSelected() == true && A.getEducationInformation().getGraduation().getPercentage() == Double.parseDouble(params.get("gradMarksField"))))) t = true;
			if(params.containsKey("gradMarksFieldLesser") && ((A.getEducationInformation().getGraduation().getCgpaSelected() == true && A.getEducationInformation().getGraduation().getCgpa()*10 < Double.parseDouble(params.get("gradMarksField"))) || (A.getEducationInformation().getGraduation().getPercentageSelected() == true && A.getEducationInformation().getGraduation().getPercentage() < Double.parseDouble(params.get("gradMarksField"))))) t = true;
			if(t == false) return false;
		}
		if(params.get("pgMarksField").trim().length() > 0)
		{
			if(A.getEducationInformation().getPostGraduation() == null) return false;
			boolean t = false;
			if(params.containsKey("pgMarksFieldGreater") && ((A.getEducationInformation().getPostGraduation().getCgpaSelected() == true && A.getEducationInformation().getPostGraduation().getCgpa()*10 > Double.parseDouble(params.get("pgMarksField"))) || (A.getEducationInformation().getPostGraduation().getPercentageSelected() == true && A.getEducationInformation().getPostGraduation().getPercentage() > Double.parseDouble(params.get("pgMarksField"))))) t = true;
			if(params.containsKey("pgMarksFieldEqual") && ((A.getEducationInformation().getPostGraduation().getCgpaSelected() == true && A.getEducationInformation().getPostGraduation().getCgpa()*10 == Double.parseDouble(params.get("pgMarksField"))) || (A.getEducationInformation().getPostGraduation().getPercentageSelected() == true && A.getEducationInformation().getPostGraduation().getPercentage() == Double.parseDouble(params.get("pgMarksField"))))) t = true;
			if(params.containsKey("pgMarksFieldLesser") && ((A.getEducationInformation().getPostGraduation().getCgpaSelected() == true && A.getEducationInformation().getPostGraduation().getCgpa()*10 < Double.parseDouble(params.get("pgMarksField"))) || (A.getEducationInformation().getPostGraduation().getPercentageSelected() == true && A.getEducationInformation().getPostGraduation().getPercentage() < Double.parseDouble(params.get("pgMarksField"))))) t = true;
			if(t == false) return false;
		}
		if(params.get("gateMarksField").trim().length() > 0)
		{
			if(A.getEducationInformation().getOtherAcademic().getGate() == null) return false; 
			boolean t = false;
			if(params.containsKey("gateMarksFieldGreater") && A.getEducationInformation().getOtherAcademic().getGate().getPercentage() > Double.parseDouble(params.get("gateMarksField"))) t = true;
			if(params.containsKey("gateMarksFieldEqual") && A.getEducationInformation().getOtherAcademic().getGate().getPercentage() == Double.parseDouble(params.get("gateMarksField"))) t = true;
			if(params.containsKey("gateMarksFieldLesser") && A.getEducationInformation().getOtherAcademic().getGate().getPercentage() < Double.parseDouble(params.get("gateMarksField"))) t = true;
			if(t == false) return false;
		}
		*/
		if(!(params.get("adfField").trim().length() > 0 || (A.getApplicationSubmit().isAfter(LocalDate.parse(params.get("adfField"), DateTimeFormatter.ofPattern("yyyy-MM-dd")).minusDays(1))))) return false;
		if(!(params.get("adtField").trim().length() > 0 || (A.getApplicationSubmit().isBefore(LocalDate.parse(params.get("adtField"), DateTimeFormatter.ofPattern("yyyy-MM-dd")).plusDays(1))))) return false;
		return true;
	}
}
