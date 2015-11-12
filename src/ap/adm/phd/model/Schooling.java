package ap.adm.phd.model;

import java.io.Serializable;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import ap.adm.phd.utilities.SerializableDoubleProperty;
import ap.adm.phd.utilities.SerializableIntegerProperty;
import ap.adm.phd.utilities.SerializableStringProperty;
import javafx.beans.property.StringProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class Schooling implements Serializable{
	private static final long serialVersionUID = 1L;
	private final StringProperty tenthBoardName;
	private final DoubleProperty tenthBoardResults;
	private final IntegerProperty tenthYear;
	private final StringProperty twelfthBoardName;
	private final DoubleProperty twelfthBoardResults;
	private final IntegerProperty twelfthYear;
	
	public Schooling() {
		tenthBoardName = new SerializableStringProperty();
		tenthBoardResults = new SerializableDoubleProperty();
		tenthYear = new SerializableIntegerProperty();
		twelfthBoardName = new SerializableStringProperty();
		twelfthBoardResults = new SerializableDoubleProperty();
		twelfthYear = new SerializableIntegerProperty();		
	}
	public String getTenthBoardName(){
		return tenthBoardName.get();
	}
	public void setTenthBoardName(String tenthBoardName) {
		this.tenthBoardName.set(tenthBoardName);
	}
	public Double getTenthBoardResults() {
		return tenthBoardResults.get();
	}
	public void setTenthBoardResults(Double tenthBoardResults) {
		this.tenthBoardResults.set(tenthBoardResults);
	}
	public Integer getTenthYear() {
		return tenthYear.get();
	}
	public void setTenthYear(Integer tenthYear) {
		this.tenthYear.set(tenthYear);
	}
	public String getTwelfthBoardName() {
		return twelfthBoardName.get();
	}
	public void setTwelfthBoardName(String twelfthBoardName) {
		this.twelfthBoardName.set(twelfthBoardName);
	}
	public Double getTwelfthBoardResults() {
		return twelfthBoardResults.get();
	}
	public void setTwelfthBoardResults(Double twelfthBoardResults) {
		this.twelfthBoardResults.set(twelfthBoardResults);
	}
	public Integer getTwelfthYear() {
		return twelfthYear.get();
	}
	public void setTwelfthYear(Integer twelfthYear) {
		this.twelfthYear.set(twelfthYear);
	}
}