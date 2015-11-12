package ap.adm.phd.model;

import java.io.Serializable;
import java.time.LocalDate;

import ap.adm.phd.utilities.SerializableBooleanProperty;
import ap.adm.phd.utilities.SerializableObjectProperty;
import ap.adm.phd.utilities.SerializableStringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class PersonalInformation implements Serializable{
	private static final long serialVersionUID = 1L;
	private final StringProperty applicantName;
	private final StringProperty email;
	private final StringProperty enrollmentNo;
	private final StringProperty correspondenceAddress;
	private final StringProperty mobileNo;
	private final StringProperty fatherName;
	private final StringProperty permanentAddress;
	private final StringProperty pinCode;
	private final StringProperty nationality;
	private final StringProperty stream;
	private final ObjectProperty<String[]> preferences;
	private final StringProperty gender;
	private final StringProperty category;
	private final ObjectProperty<LocalDate> dateOfBirth;
	private final BooleanProperty disabled;
	public final BooleanProperty defence;
	
	public PersonalInformation() {
		this.applicantName = new SerializableStringProperty();
		this.email = new SerializableStringProperty();
		this.enrollmentNo = new SerializableStringProperty();
		this.correspondenceAddress = new SerializableStringProperty();
		this.mobileNo = new SerializableStringProperty();
		this.stream = new SerializableStringProperty();
		this.preferences = new SerializableObjectProperty<String[]>();
		this.gender = new SerializableStringProperty();
		this.category = new SerializableStringProperty();
		this.disabled = new SerializableBooleanProperty();
		this.dateOfBirth = new SerializableObjectProperty<LocalDate>();
		this.defence = new SerializableBooleanProperty();
		this.fatherName = new SerializableStringProperty();
		this.nationality = new SerializableStringProperty();
		this.permanentAddress = new SerializableStringProperty();
		this.pinCode = new SerializableStringProperty();
	}
	
	public String getApplicantName() {return this.applicantName.get();}
	public void setApplicantName(String a) {this.applicantName.set(a);}
	
	public String getEmail() {return this.email.get();}
	public void setEmail(String a) {this.email.set(a);}
	
	public String getEnrollmentNo() {return this.enrollmentNo.get();}
	public void setEnrollmentNo(String a) {this.enrollmentNo.set(a);}
	
	public String getCorrespondenceAddress() {return this.correspondenceAddress.get();}
	public void setCorrespondenceAddress(String a) {this.correspondenceAddress.set(a);}
	
	public String getMobileNo() {return this.mobileNo.get();}
	public void setMobileNo(String a) {this.mobileNo.set(a);}
	
	public String getFatherName() {return this.fatherName.get();}
	public void setFatherName(String a) {this.fatherName.set(a);}
	
	public String getPermanentAddress() {return this.permanentAddress.get();}
	public void setPermanentAddress(String a) {this.permanentAddress.set(a);}
	
	public String getPincode() {return this.pinCode.get();}
	public void setPincode(String a) {this.pinCode.set(a);}
	
	public String getNationality() {return this.nationality.get();}
	public void setNationality(String a) {this.nationality.set(a);}
	
	public String getStream() {return this.stream.get();}
	public void setStream(String a) {this.stream.set(a);}
	
	public String[] getPreferences() {return this.preferences.get();}
	public void setPreferences(String a, String b, String c) {
		String[] temp = {a,b,c};
		this.preferences.set(temp);
	}
	
	public String getGender() {return this.gender.get(); }
	public void setGender(String a) {this.gender.set(a);}
	
	public String getPinCode() { return pinCode.get(); }
	public void setPinCode(String a){ this.pinCode.set(a); } 

	public String getCategory() {return this.category.get();}
	public void setCategory(String a) {this.category.set(a);}
	
	public LocalDate getDateOfBirth() {return this.dateOfBirth.get();}
	public void setDateOfBirth(LocalDate a) {this.dateOfBirth.set(a);}
	
	public boolean getDisabled() {return this.disabled.get();}
	public void setDisabled(boolean a) {this.disabled.set(a);}
	
	public boolean getDefence() {return this.defence.get();}
	public void setDefence(boolean a) {this.defence.set(a);}
}
