package ap.adm.phd.model;

import java.io.Serializable;

import ap.adm.phd.utilities.SerializableBooleanProperty;
import ap.adm.phd.utilities.SerializableDoubleProperty;
import ap.adm.phd.utilities.SerializableIntegerProperty;
import ap.adm.phd.utilities.SerializableStringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class Graduation implements Serializable{
	private static final long serialVersionUID = 1L;
	private StringProperty degreeName;
	private StringProperty department;
	private StringProperty collegeName;
	private StringProperty universityName;
	private StringProperty city;
	private StringProperty state;
	private IntegerProperty graduationYear;
	private BooleanProperty cgpaSelected;
	private BooleanProperty percentageSelected;
	private DoubleProperty cgpa;
	private DoubleProperty percentage;
	
	public Graduation()
	{
		degreeName = new SerializableStringProperty();
		department = new SerializableStringProperty();
		collegeName = new SerializableStringProperty();
		universityName = new SerializableStringProperty();
		city = new SerializableStringProperty();
		state = new SerializableStringProperty();
		graduationYear = new SerializableIntegerProperty();
		cgpaSelected = new SerializableBooleanProperty();
		percentageSelected = new SerializableBooleanProperty();
		cgpa = new SerializableDoubleProperty();
		percentage = new SerializableDoubleProperty();
	}
	
	public String getDegreeName() {
		return degreeName.get();
	}
	public void setDegreeName(String degree) {
		this.degreeName.set(degree);
	}
	public String getDepartment() {
		return department.get();
	}
	public void setDepartment(String department) {
		this.department.set(department);
	}
	public String getCollegeName() {
		return collegeName.get();
	}
	public void setCollegeName(String collegeName) {
		this.collegeName.set(collegeName);
	}
	public String getUniversityName() {
		return universityName.get();
	}
	public void setUniversityName(String universityName) {
		this.universityName.set(universityName);
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
	public Integer getGraduationYear() {
		return graduationYear.get();
	}
	public void setGraduationYear(Integer graduationYear) {
		this.graduationYear.set(graduationYear);
	}
	public Double getCgpa() {
		return cgpa.get();
	}
	public void setCgpaSelected(Boolean cgpaSelected){
		this.cgpaSelected.set(cgpaSelected);
	}
	public Boolean getPercentageSelected(){
		return this.percentageSelected.get();
	}
	public void setPercentageSelected(Boolean percentageSelected){
		this.percentageSelected.set(percentageSelected);
	}
	public Boolean getCgpaSelected(){
		return this.cgpaSelected.get();
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

