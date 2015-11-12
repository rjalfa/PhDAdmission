package ap.adm.phd.model;

import java.io.Serializable;
import java.time.LocalDate;

import ap.adm.phd.utilities.SerializableObjectProperty;
import javafx.beans.property.ObjectProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */

public class Applicant implements Serializable{
	private static final long serialVersionUID = 1L;
	private EducationInformation educationInformation;
	private Feedback feedback;
	private PersonalInformation personalInformation;
	private ObjectProperty<LocalDate> applicationSubmit;
	
	public Applicant()
	{
		educationInformation = new EducationInformation();
		personalInformation = new PersonalInformation();
		feedback = new Feedback();
		applicationSubmit = new SerializableObjectProperty<LocalDate>();
	}
	
	public LocalDate getApplicationSubmit() {
		return applicationSubmit.get();
	}
	
	public void setApplicationSubmit(LocalDate applicationSubmit) {
		this.applicationSubmit.set(applicationSubmit);
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