package ap.adm.phd.model;

import java.io.Serializable;

import ap.adm.phd.utilities.SerializableDoubleProperty;
import ap.adm.phd.utilities.SerializableIntegerProperty;
import ap.adm.phd.utilities.SerializableStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class Degree implements Serializable{
	private static final long serialVersionUID = 1L;
	private StringProperty degreeName;
	private StringProperty subject;
	private IntegerProperty year;
	private StringProperty institution;
	private DoubleProperty score;
	
	public Degree()
	{
		degreeName = new SerializableStringProperty();
		subject = new SerializableStringProperty();
		year = new SerializableIntegerProperty();
		institution = new SerializableStringProperty();
		score = new SerializableDoubleProperty();
	}
	
	public String getDegreeName() {
		return degreeName.get();
	}
	public void setDegreeName(String degreeName) {
		this.degreeName.set(degreeName);
	}
	public String getSubject() {
		return subject.get();
	}
	public void setSubject(String subject) {
		this.subject.set(subject);
	}
	public Integer getYear() {
		return year.get();
	}
	public void setYear(Integer year) {
		this.year.set(year);
	}
	public String getInstitution() {
		return institution.get();
	}
	public void setInstitution(String institution) {
		this.institution.set(institution);
	}
	public Double getScore() {
		return score.get();
	}
	public void setScore(Double score) {
		this.score.set(score);
	}
}
