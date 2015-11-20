package ap.adm.phd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import ap.adm.phd.model.Applicant;
import ap.adm.phd.utilities.GlobalVars;

public class Database {
	
	//private static EnrollmentNoGenerator eig = new EnrollmentNoGenerator();
	
	public static void fillUser(Applicant applicant,HashMap<String,String> params)
	{
		applicant.getPersonalInformation().setApplicantName(params.get("name"));
		applicant.getPersonalInformation().setEmail(params.get("email"));
		applicant.getPersonalInformation().setEnrollmentNo(eidGenerator());
		applicant.getPersonalInformation().setCorrespondenceAddress(params.get("corrAddress"));
		applicant.getPersonalInformation().setMobileNo(params.get("mobNumber"));
		applicant.getPersonalInformation().setDateOfBirth(LocalDate.parse(params.get("dobField"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		applicant.getPersonalInformation().setStream(params.get("phdStreamSelector"));
		if(params.get("phdStreamSelector").equals("Electronics and Communication")) applicant.getPersonalInformation().setPreferences(params.get("preferences1"),params.get("preferences2"),params.get("preferences3"),params.get("preferences4"));
		else applicant.getPersonalInformation().setPreferences(params.get("preferences1"),params.get("preferences2"),params.get("preferences3"));
		applicant.getPersonalInformation().setGender(params.get("gender"));
		applicant.getPersonalInformation().setCategory(GlobalVars.casteList[Integer.parseInt(params.get("category"))-1]);
		if(params.get("phyDisabled") != null) applicant.getPersonalInformation().setDisabled(true);
		else applicant.getPersonalInformation().setDisabled(false);
		if(params.get("defence") != null) applicant.getPersonalInformation().setDefence(true);
		else applicant.getPersonalInformation().setDefence(false);
		applicant.getPersonalInformation().setFatherName(params.get("fatherName"));
		applicant.getPersonalInformation().setNationality(params.get("nationality"));
		applicant.getPersonalInformation().setPermanentAddress(params.get("permAddress"));
		applicant.getPersonalInformation().setPincode(params.get("pincode"));

		//Schooling Information
		applicant.getEducationInformation().getSchooling().setTenthBoardName(params.get("xBoard"));
		applicant.getEducationInformation().getSchooling().setTenthBoardResults(Double.parseDouble(params.get("xMarks")));
		applicant.getEducationInformation().getSchooling().setTenthYear(Integer.parseInt(params.get("xYear")));
		applicant.getEducationInformation().getSchooling().setTwelfthBoardName(params.get("xiiBoard"));
		applicant.getEducationInformation().getSchooling().setTwelfthBoardResults(Double.parseDouble(params.get("xiiMarks")));
		applicant.getEducationInformation().getSchooling().setTwelfthYear(Integer.parseInt(params.get("xiiYear")));

		//Graduation Information
		applicant.getEducationInformation().getGraduation().setDegreeName(params.get("gradDegree"));
		applicant.getEducationInformation().getGraduation().setDepartment(params.get("gradDept"));
		applicant.getEducationInformation().getGraduation().setCollegeName(params.get("gradCollege"));
		applicant.getEducationInformation().getGraduation().setUniversityName(params.get("gradUniv"));
		applicant.getEducationInformation().getGraduation().setCity(params.get("gradCity"));
		applicant.getEducationInformation().getGraduation().setState(params.get("gradState"));
		applicant.getEducationInformation().getGraduation().setGraduationYear(Integer.parseInt(params.get("gradYear")));
		if(params.get("gradPerformanceCGPA")!=null) 
		{
			applicant.getEducationInformation().getGraduation().setCgpa(Double.parseDouble(params.get("gradPerformance")));
			applicant.getEducationInformation().getGraduation().setCgpaSelected(true);
			applicant.getEducationInformation().getGraduation().setPercentageSelected(false);
		}
		else
		{
			applicant.getEducationInformation().getGraduation().setPercentage(Double.parseDouble(params.get("gradPerformance")));
			applicant.getEducationInformation().getGraduation().setPercentageSelected(true);
			applicant.getEducationInformation().getGraduation().setCgpaSelected(false);
		} 

		//Post Graduation Information
		if(params.get("pgApplicable")!=null)
		{
			applicant.getEducationInformation().getPostGraduation().setDegreeName(params.get("pgDegree"));
			applicant.getEducationInformation().getPostGraduation().setThesisTitle(params.get("pgThesis"));
			applicant.getEducationInformation().getPostGraduation().setDepartment(params.get("pgDept"));
			applicant.getEducationInformation().getPostGraduation().setCollege(params.get("pgCollege"));
			applicant.getEducationInformation().getPostGraduation().setUniversity(params.get("pgUniv"));
			applicant.getEducationInformation().getPostGraduation().setCity(params.get("pgCity"));
			applicant.getEducationInformation().getPostGraduation().setState(params.get("pgState"));
			applicant.getEducationInformation().getPostGraduation().setYear(Integer.parseInt(params.get("pgYear")));
			if(params.get("pgPerformanceCGPA")!=null) 
			{
				applicant.getEducationInformation().getPostGraduation().setCgpa(Double.parseDouble(params.get("pgPerformance")));
				applicant.getEducationInformation().getPostGraduation().setCgpaSelected(true);
				applicant.getEducationInformation().getPostGraduation().setPercentageSelected(false);
			}
			else  
			{
				applicant.getEducationInformation().getPostGraduation().setPercentage(Double.parseDouble(params.get("pgPerformance")));
				applicant.getEducationInformation().getPostGraduation().setPercentageSelected(true);
				applicant.getEducationInformation().getPostGraduation().setCgpaSelected(false);
			}
		}
		else applicant.getEducationInformation().setPostGraduation(null);

		//Other Academic Degrees
		if(params.get("oAApplicable")!=null)
		{
			applicant.getEducationInformation().getOtherAcademic().getDegree().setDegreeName(params.get("oADegree"));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setSubject(params.get("oASubject"));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setInstitution(params.get("oACollege"));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setYear(Integer.parseInt(params.get("oAYear")));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setScore(Double.parseDouble(params.get("oAPerformance")));
		}
		else applicant.getEducationInformation().getOtherAcademic().setDegree(null);

		//GATE
		if(params.get("gateApplicable")!=null)
		{
			applicant.getEducationInformation().getOtherAcademic().getGate().setArea(params.get("gateArea"));
			applicant.getEducationInformation().getOtherAcademic().getGate().setYear(Integer.parseInt(params.get("gateYear")));
			applicant.getEducationInformation().getOtherAcademic().getGate().setPercentage(Double.parseDouble(params.get("gatePercentage")));
			applicant.getEducationInformation().getOtherAcademic().getGate().setScore(Double.parseDouble(params.get("gateScore")));
			applicant.getEducationInformation().getOtherAcademic().getGate().setRank(Integer.parseInt(params.get("gateRank")));
		}
		else applicant.getEducationInformation().getOtherAcademic().setGate(null);

		//Uploading Documents
		applicant.getEducationInformation().getAchievements().setDescription(params.get("otherAchieve"));
		//applicant.getEducationInformation().getAchievements().setCv(cvUploadPath);
		//applicant.getEducationInformation().getAchievements().setSop(sopUploadPath);


		//Feedback
/*		applicant.getFeedback().setFirstHear(params.get("feedbackQ1"));
		ArrayList<String> q2messages = new ArrayList<>();
		if(feedbackQ2op1.isSelected()) q2messages.add(feedbackQ2op1.getText());
		if(feedbackQ2op2.isSelected()) q2messages.add(feedbackQ2op2.getText());
		if(feedbackQ2op3.isSelected()) q2messages.add(feedbackQ2op3.getText());
		if(feedbackQ2op4.isSelected()) q2messages.add(feedbackQ2op4.getText());
		if(feedbackQ2op5.isSelected()) q2messages.add(feedbackQ2op5.getText());
		if(feedbackQ2op6.isSelected()) q2messages.add(feedbackQ2op6.getText());
		if(feedbackQ2op7.isSelected()) q2messages.add(feedbackQ2op7.getText());
		if(feedbackQ2op8.isSelected()) q2messages.add(feedbackQ2op8.getText());
		if(feedbackQ2op9.isSelected()) q2messages.add(feedbackQ2op9.getText());
		if(feedbackQ2op10.isSelected()) q2messages.add(feedbackQ2op10.getText());
		applicant.getFeedback().setReasonOfInterest(q2messages.toArray(new String[q2messages.size()]));
*/
		//Set Today's Date to Record
		applicant.setApplicationSubmit(LocalDate.now());
		//File outDir = new File("data/DATA" + applicant.getPersonalInformation().getEnrollmentNo());
		//if (!outDir.exists()) outDir.mkdirs();
		//Files.copy(new File(applicant.getEducationInformation().getAchievements().getCv()).toPath(),new File("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantCV.pdf").toPath());
		//Files.copy(new File(applicant.getEducationInformation().getAchievements().getSop()).toPath(),new File("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantSOP.pdf").toPath());				
		applicant.getEducationInformation().getAchievements().setCv("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantCV.pdf");
		applicant.getEducationInformation().getAchievements().setSop("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantSOP.pdf");
	}
	
	private static String eidGenerator()
	{
		return "PHD" + System.currentTimeMillis();
		//return eig.next(); 
	}
}
