package ap.adm.phd.model;

import java.io.Serializable;

import ap.adm.phd.utilities.SerializableObjectProperty;
import ap.adm.phd.utilities.SerializableStringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */

public class Feedback implements Serializable{
	private static final long serialVersionUID = 1L;
	private StringProperty firstHear;
	private ObjectProperty<String[]> reasonOfInterest;
	
	public Feedback()
	{
		firstHear = new SerializableStringProperty();
		reasonOfInterest = new SerializableObjectProperty<String[]>();
	}
	
	public String getFirstHear() {
		return firstHear.get();
	}
	public void setFirstHear(String firstHear) {
		this.firstHear.set(firstHear);
	}
	public String[] getReasonOfInterest() {
		return reasonOfInterest.get();
	}
	public void setReasonOfInterest(String[] reasonOfInterest) {
		this.reasonOfInterest.set(reasonOfInterest);
	}
}
