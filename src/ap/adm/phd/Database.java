package ap.adm.phd;

import java.util.HashMap;

import ap.adm.phd.model.Applicant;

public class Database {
	public static void fillUser(Applicant applicant,HashMap<String,String> params)
	{
//		mainApp.createText(applicant);
		/*applicant.getPersonalInformation().setApplicantName(name.getText());
		applicant.getPersonalInformation().setEmail(email.getText());
		applicant.getPersonalInformation().setEnrollmentNo(enrollmentNumber.getText());
		applicant.getPersonalInformation().setCorrespondenceAddress(corrAddress.getText());
		applicant.getPersonalInformation().setMobileNo(mobNumber.getText());
		applicant.getPersonalInformation().setDateOfBirth(dobField.getValue());
		applicant.getPersonalInformation().setStream(((RadioButton)(phdStreamSelector.getSelectedToggle())).getText());
		applicant.getPersonalInformation().setPreferences(preferences1.getValue(),preferences2.getValue(),preferences3.getValue(),preferences4.getValue());
		applicant.getPersonalInformation().setGender(gender.getValue());
		applicant.getPersonalInformation().setCategory(category.getValue());
		applicant.getPersonalInformation().setDisabled(((RadioButton)(phyDisabled.getSelectedToggle())).getText().equals("Yes"));
		applicant.getPersonalInformation().setDefence(((RadioButton)(defence.getSelectedToggle())).getText().equals("Yes"));	
		applicant.getPersonalInformation().setFatherName(fatherName.getText());
		applicant.getPersonalInformation().setNationality(nationality.getValue());
		applicant.getPersonalInformation().setPermanentAddress(permAddress.getText());
		applicant.getPersonalInformation().setPincode(pincode.getText());

		//Schooling Information
		applicant.getEducationInformation().getSchooling().setTenthBoardName(xBoard.getText());
		applicant.getEducationInformation().getSchooling().setTenthBoardResults(Double.parseDouble(xMarks.getText()));
		applicant.getEducationInformation().getSchooling().setTenthYear(Integer.parseInt(xYear.getText()));
		applicant.getEducationInformation().getSchooling().setTwelfthBoardName(xiiBoard.getText());
		applicant.getEducationInformation().getSchooling().setTwelfthBoardResults(Double.parseDouble(xiiMarks.getText()));
		applicant.getEducationInformation().getSchooling().setTwelfthYear(Integer.parseInt(xiiYear.getText()));

		//Graduation Information
		applicant.getEducationInformation().getGraduation().setDegreeName(gradDegree.getText());
		applicant.getEducationInformation().getGraduation().setDepartment(gradDept.getText());
		applicant.getEducationInformation().getGraduation().setCollegeName(gradCollege.getText());
		applicant.getEducationInformation().getGraduation().setUniversityName(gradUniv.getText());
		applicant.getEducationInformation().getGraduation().setCity(gradCity.getText());
		applicant.getEducationInformation().getGraduation().setState(gradState.getValue());
		applicant.getEducationInformation().getGraduation().setGraduationYear(Integer.parseInt(gradYear.getText()));
		if(gradCgpaRB.isSelected()) 
		{
			applicant.getEducationInformation().getGraduation().setCgpa(Double.parseDouble(gradPerformanceCGPA.getText()));
			applicant.getEducationInformation().getGraduation().setCgpaSelected(true);
		}
		else applicant.getEducationInformation().getGraduation().setCgpaSelected(false);
		if(gradPercentageRB.isSelected()) 
		{
			applicant.getEducationInformation().getGraduation().setPercentage(Double.parseDouble(gradPerformancePercentage.getText()));
			applicant.getEducationInformation().getGraduation().setPercentageSelected(true);
		}
		else applicant.getEducationInformation().getGraduation().setPercentageSelected(false);

		//Post Graduation Information
		if(pgApplicable.isSelected())
		{
			applicant.getEducationInformation().getPostGraduation().setDegreeName(pgDegree.getText());
			applicant.getEducationInformation().getPostGraduation().setThesisTitle(pgThesis.getText());
			applicant.getEducationInformation().getPostGraduation().setDepartment(pgDept.getText());
			applicant.getEducationInformation().getPostGraduation().setCollege(pgCollege.getText());
			applicant.getEducationInformation().getPostGraduation().setUniversity(pgUniv.getText());
			applicant.getEducationInformation().getPostGraduation().setCity(pgCity.getText());
			applicant.getEducationInformation().getPostGraduation().setState(pgState.getValue());
			applicant.getEducationInformation().getPostGraduation().setYear(Integer.parseInt(pgYear.getText()));
			if(pgCgpaRB.isSelected()) 
			{
				applicant.getEducationInformation().getPostGraduation().setCgpa(Double.parseDouble(pgPerformanceCGPA.getText()));
				applicant.getEducationInformation().getPostGraduation().setCgpaSelected(true);
			}
			else applicant.getEducationInformation().getPostGraduation().setCgpaSelected(false);
			if(pgPercentageRB.isSelected()) 
			{
				applicant.getEducationInformation().getPostGraduation().setPercentage(Double.parseDouble(pgPerformancePercentage.getText()));
				applicant.getEducationInformation().getPostGraduation().setPercentageSelected(true);
			}
			else applicant.getEducationInformation().getPostGraduation().setPercentageSelected(false);
		}
		else applicant.getEducationInformation().setPostGraduation(null);

		//Other Academic Degrees
		if(oAApplicable.isSelected())
		{
			applicant.getEducationInformation().getOtherAcademic().getDegree().setDegreeName(oADegree.getText());
			applicant.getEducationInformation().getOtherAcademic().getDegree().setSubject(oASubject.getText());
			applicant.getEducationInformation().getOtherAcademic().getDegree().setInstitution(oACollege.getText());
			applicant.getEducationInformation().getOtherAcademic().getDegree().setYear(Integer.parseInt(oAYear.getText()));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setScore(Double.parseDouble(oAPerformance.getText()));
		}
		else applicant.getEducationInformation().getOtherAcademic().setDegree(null);

		//GATE
		if(gateApplicable.isSelected())
		{
			applicant.getEducationInformation().getOtherAcademic().getGate().setArea(gateArea.getText());
			applicant.getEducationInformation().getOtherAcademic().getGate().setYear(Integer.parseInt(gateYear.getText()));
			applicant.getEducationInformation().getOtherAcademic().getGate().setPercentage(Double.parseDouble(gatePercentage.getText()));
			applicant.getEducationInformation().getOtherAcademic().getGate().setScore(Double.parseDouble(gateScore.getText()));
			applicant.getEducationInformation().getOtherAcademic().getGate().setRank(Integer.parseInt(gateRank.getText()));
		}
		else applicant.getEducationInformation().getOtherAcademic().setGate(null);

		//Uploading Documents
		applicant.getEducationInformation().getAchievements().setDescription(otherAchieve.getText());
		applicant.getEducationInformation().getAchievements().setCv(cvUploadPath);
		applicant.getEducationInformation().getAchievements().setSop(sopUploadPath);


		//Feedback
		applicant.getFeedback().setFirstHear(feedbackQ1.getValue());
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

		//Set Today's Date to Record
		applicant.setApplicationSubmit(LocalDate.now());
		File outDir = new File("data/DATA" + applicant.getPersonalInformation().getEnrollmentNo());
		if (!outDir.exists()) outDir.mkdirs();
		Files.copy(new File(applicant.getEducationInformation().getAchievements().getCv()).toPath(),new File("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantCV.pdf").toPath());
		Files.copy(new File(applicant.getEducationInformation().getAchievements().getSop()).toPath(),new File("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantSOP.pdf").toPath());				
		applicant.getEducationInformation().getAchievements().setCv("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantCV.pdf");
		applicant.getEducationInformation().getAchievements().setSop("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantSOP.pdf");	
*/
	}
}
