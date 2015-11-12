package ap.adm.phd.model;

import java.io.Serializable;

import ap.adm.phd.utilities.SerializableStringProperty;
import javafx.beans.property.StringProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */

public class Achievements implements Serializable{
	private static final long serialVersionUID = 1L;
	private StringProperty description;
	private StringProperty cv;
	private StringProperty sop;
	
	public Achievements()
	{
		description = new SerializableStringProperty();
		cv = new SerializableStringProperty();
		sop = new SerializableStringProperty();
	}
	
	public String getCv() {
		return cv.get();
	}
	public void setCv(String cv) {
		this.cv.set(cv);
	}
	public String getSop() {
		return sop.get();
	}
	public void setSop(String sop) {
		this.sop.set(sop);
	}
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description.set(description);
	}
}
