package ap.adm.phd.model;

import java.io.Serializable;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class Graduation implements Serializable{
	private static final long serialVersionUID = 1L;
	private String degreeName;
	private String department;
	private String collegeName;
	private String universityName;
	private String city;
	private String state;
	private Integer graduationYear;
	private Boolean cgpaSelected;
	private Boolean percentageSelected;
	private Double cgpa;
	private Double percentage;
	
	public Graduation()
	{
		degreeName = new String();
		department = new String();
		collegeName = new String();
		universityName = new String();
		city = new String();
		state = new String();
		graduationYear = 0;
		cgpaSelected = false;
		percentageSelected = false;
		cgpa = 0.0;
		percentage = 0.0;
	}
	
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degree) {
		this.degreeName = degree;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(Integer graduationYear) {
		this.graduationYear = graduationYear;
	}
	public Double getCgpa() {
		return cgpa;
	}
	public void setCgpaSelected(Boolean cgpaSelected){
		this.cgpaSelected = cgpaSelected;
	}
	public Boolean getPercentageSelected(){
		return this.percentageSelected;
	}
	public void setPercentageSelected(Boolean percentageSelected){
		this.percentageSelected = percentageSelected;
	}
	public Boolean getCgpaSelected(){
		return this.cgpaSelected;
	}
	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
}

