package ap.adm.phd.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class PersonalInformation implements Serializable{
	private static final long serialVersionUID = 1L;
	private String applicantName;
	private String email;
	private String enrollmentNo;
	private String correspondenceAddress;
	private String mobileNo;
	private String fatherName;
	private String permanentAddress;
	private String pinCode;
	private String nationality;
	private String stream;
	private String[] preferences;
	private String gender;
	private String category;
	private LocalDate dateOfBirth;
	private Boolean disabled;
	private Boolean defence;
	
	public PersonalInformation() {
		this.applicantName = new String();
		this.email = new String();
		this.enrollmentNo = new String();
		this.correspondenceAddress = new String();
		this.mobileNo = new String();
		this.stream = new String();
		this.preferences = null;
		this.gender = new String();
		this.category = new String();
		this.disabled = false;
		this.dateOfBirth = LocalDate.now();
		this.defence = false;
		this.fatherName = new String();
		this.nationality = new String();
		this.permanentAddress = new String();
		this.pinCode = new String();
	}
	
	public String getApplicantName() {return this.applicantName;}
	public void setApplicantName(String a) {this.applicantName = a;}
	
	public String getEmail() {return this.email;}
	public void setEmail(String a) {this.email = a;}
	
	public String getEnrollmentNo() {return this.enrollmentNo;}
	public void setEnrollmentNo(String a) {this.enrollmentNo = a;}
	
	public String getCorrespondenceAddress() {return this.correspondenceAddress;}
	public void setCorrespondenceAddress(String a) {this.correspondenceAddress = a;}
	
	public String getMobileNo() {return this.mobileNo;}
	public void setMobileNo(String a) {this.mobileNo = a;}
	
	public String getFatherName() {return this.fatherName;}
	public void setFatherName(String a) {this.fatherName = a;}
	
	public String getPermanentAddress() {return this.permanentAddress;}
	public void setPermanentAddress(String a) {this.permanentAddress = a;}
	
	public String getPincode() {return this.pinCode;}
	public void setPincode(String a) {this.pinCode = a;}
	
	public String getNationality() {return this.nationality;}
	public void setNationality(String a) {this.nationality = a;}
	
	public String getStream() {return this.stream;}
	public void setStream(String a) {this.stream = a;}
	
	public String[] getPreferences() {return this.preferences;}
	public void setPreferences(String a, String b, String c) {
		String[] temp = {a,b,c};
		this.preferences = temp;
	}
	
	public void setPreferences(String a, String b, String c, String d) {
		String[] temp = {a,b,c,d};
		this.preferences = temp;
	}
	
	public String getGender() {return this.gender; }
	public void setGender(String a) {this.gender = a;}
	
	public String getPinCode() { return pinCode; }
	public void setPinCode(String a){ this.pinCode = a;} 

	public String getCategory() {return this.category;}
	public void setCategory(String a) {this.category = a;}
	
	public LocalDate getDateOfBirth() {return this.dateOfBirth;}
	public void setDateOfBirth(LocalDate a) {this.dateOfBirth = a;}
	
	public boolean getDisabled() {return this.disabled;}
	public void setDisabled(boolean a) {this.disabled = a;}
	
	public boolean getDefence() {return this.defence;}
	public void setDefence(boolean a) {this.defence = a;}
}
