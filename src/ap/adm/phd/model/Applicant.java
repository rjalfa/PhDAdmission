package ap.adm.phd.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */

public class Applicant implements Serializable{
	private static final long serialVersionUID = 1L;
	private EducationInformation educationInformation;
	private Feedback feedback;
	private PersonalInformation personalInformation;
	private LocalDate applicationSubmit;
	
	public Applicant()
	{
		educationInformation = new EducationInformation();
		personalInformation = new PersonalInformation();
		feedback = new Feedback();
		applicationSubmit = LocalDate.now();
	}
	
	public LocalDate getApplicationSubmit() {
		return applicationSubmit;
	}
	
	public void setApplicationSubmit(LocalDate applicationSubmit) {
		this.applicationSubmit = applicationSubmit;
	}
	
	public PersonalInformation getPersonalInformation() {
		return personalInformation;
	}
	public void setPersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}
	public EducationInformation getEducationInformation() {
		return educationInformation;
	}
	public void setEducationInformation(EducationInformation educationInformation) {
		this.educationInformation = educationInformation;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
}