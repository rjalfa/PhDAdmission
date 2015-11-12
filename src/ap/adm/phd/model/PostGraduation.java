package ap.adm.phd.model;

import java.io.Serializable;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import ap.adm.phd.utilities.SerializableDoubleProperty;
import ap.adm.phd.utilities.SerializableIntegerProperty;
import ap.adm.phd.utilities.SerializableStringProperty;
import ap.adm.phd.utilities.SerializableBooleanProperty;
import javafx.beans.property.StringProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class PostGraduation implements Serializable{
	private static final long serialVersionUID = 1L;
	private BooleanProperty completedPostGraduation;
	private StringProperty degreeName;
	private StringProperty thesisTitle;
	private StringProperty department;
	private StringProperty college;
	private StringProperty university;
	private StringProperty city;
	private StringProperty state;
	private IntegerProperty year;
	private BooleanProperty cgpaSelected;
	private BooleanProperty percentageSelected;
	private DoubleProperty cgpa;
	private DoubleProperty percentage;
	
	public PostGraduation()
	{
		completedPostGraduation = new SerializableBooleanProperty();
		degreeName = new SerializableStringProperty();
		thesisTitle = new SerializableStringProperty();
		department = new SerializableStringProperty();
		college = new SerializableStringProperty();
		university = new SerializableStringProperty();
		city = new SerializableStringProperty();
		state = new SerializableStringProperty();
		year = new SerializableIntegerProperty();
		cgpaSelected = new SerializableBooleanProperty();
		percentageSelected = new SerializableBooleanProperty();
		cgpa = new SerializableDoubleProperty();
		percentage = new SerializableDoubleProperty();
	}
	
	// TODO: create constructor
	public Boolean getCompletedPostGraduation() {
		return completedPostGraduation.get();
	}
	public void setCompletedPostGraduation(Boolean completedPostGraduation) {
		this.completedPostGraduation.set(completedPostGraduation);
	}
	public String getDegreeName() {
		return degreeName.get();
	}
	public void setDegreeName(String degree) {
		this.degreeName.set(degree);
	}
	public String getThesisTitle() {
		return thesisTitle.get();
	}
	public void setThesisTitle(String thesisTitle) {
		this.thesisTitle.set(thesisTitle);
	}
	public String getDepartment() {
		return department.get();
	}
	public void setDepartment(String department) {
		this.department.set(department);
	}
	public String getCollege() {
		return college.get();
	}
	public void setCollege(String college) {
		this.college.set(college);
	}
	public String getUniversity() {
		return university.get();
	}
	public void setUniversity(String university) {
		this.university.set(university);
	}
	public String getCity() {
		return city.get();
	}
	public void setCity(String city) {
		this.city.set(city);
	}
	public String getState() {
		return state.get();
	}
	public void setState(String state) {
		this.state.set(state);
	}
	public Integer getYear() {
		return year.get();
	}
	public void setYear(int year) {
		this.year.set(year);
	}
	public Boolean getCgpaSelected() {
		return cgpaSelected.get();
	}
	public void setCgpaSelected(Boolean cgpaSelected) {
		this.cgpaSelected.set(cgpaSelected);
	}
	public Boolean getPercentageSelected() {
		return percentageSelected.get();
	}
	public void setPercentageSelected(Boolean percentageSelected) {
		this.percentageSelected.set(percentageSelected);
	}
	public Double getCgpa() {
		return cgpa.get();
	}
	public void setCgpa(Double cgpa) {
		this.cgpa.set(cgpa);
	}
	public Double getPercentage() {
		return percentage.get();
	}
	public void setPercentage(Double percentage) {
		this.percentage.set(percentage);
	}
}

