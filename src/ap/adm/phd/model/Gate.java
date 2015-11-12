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

public class Gate implements Serializable{
	private static final long serialVersionUID = 1L;
	private StringProperty area;
	private IntegerProperty year;
	private DoubleProperty percentage;
	private DoubleProperty score;
	private IntegerProperty rank;
	
	public Gate()
	{
		area = new SerializableStringProperty();
		year = new SerializableIntegerProperty();
		percentage = new SerializableDoubleProperty();
		score = new SerializableDoubleProperty();
		rank = new SerializableIntegerProperty();
	}
	
	public String getArea() {
		return area.get();
	}
	public void setArea(String area) {
		this.area.set(area);
	}
	public Integer getYear() {
		return year.get();
	}
	public void setYear(Integer year) {
		this.year.set(year);
	}
	public Double getPercentage() {
		return percentage.get();
	}
	public void setPercentage(Double percentage) {
		this.percentage.set(percentage);
	}
	public Double getScore() {
		return score.get();
	}
	public void setScore(Double score) {
		this.score.set(score);
	}
	public Integer getRank() {
		return rank.get();
	}
	public void setRank(Integer rank) {
		this.rank.set(rank);
	}
}
