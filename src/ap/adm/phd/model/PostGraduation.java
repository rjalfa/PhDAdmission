package ap.adm.phd.model;

import java.io.Serializable;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class PostGraduation implements Serializable{
	private static final long serialVersionUID = 1L;
	private Boolean completedPostGraduation;
	private String degreeName;
	private String thesisTitle;
	private String department;
	private String college;
	private String university;
	private String city;
	private String state;
	private Integer year;
	private Boolean cgpaSelected;
	private Boolean percentageSelected;
	private Double cgpa;
	private Double percentage;
	
	public PostGraduation()
	{
		completedPostGraduation = false;
		degreeName = new String();
		thesisTitle = new String();
		department = new String();
		college = new String();
		university = new String();
		city = new String();
		state = new String();
		year = 0;
		cgpaSelected = false;
		percentageSelected = false;
		cgpa = 0.0;
		percentage = 0.0;
	}
	
	// TODO: create constructor
	public Boolean getCompletedPostGraduation() {
		return completedPostGraduation;
	}
	public void setCompletedPostGraduation(Boolean completedPostGraduation) {
		this.completedPostGraduation = completedPostGraduation;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degree) {
		this.degreeName = degree;
	}
	public String getThesisTitle() {
		return thesisTitle;
	}
	public void setThesisTitle(String thesisTitle) {
		this.thesisTitle = thesisTitle;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
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
	public Integer getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Boolean getCgpaSelected() {
		return cgpaSelected;
	}
	public void setCgpaSelected(Boolean cgpaSelected) {
		this.cgpaSelected = cgpaSelected;
	}
	public Boolean getPercentageSelected() {
		return percentageSelected;
	}
	public void setPercentageSelected(Boolean percentageSelected) {
		this.percentageSelected = percentageSelected;
	}
	public Double getCgpa() {
		return cgpa;
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

