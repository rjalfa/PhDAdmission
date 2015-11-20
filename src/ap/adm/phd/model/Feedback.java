package ap.adm.phd.model;

import java.io.Serializable;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */

public class Feedback implements Serializable{
	private static final long serialVersionUID = 1L;
	private String firstHear;
	private String[] reasonOfInterest;
	
	public Feedback()
	{
		firstHear = new String();
		reasonOfInterest = null;
	}
	
	public String getFirstHear() {
		return firstHear;
	}
	public void setFirstHear(String firstHear) {
		this.firstHear = firstHear;
	}
	public String[] getReasonOfInterest() {
		return reasonOfInterest;
	}
	public void setReasonOfInterest(String[] reasonOfInterest) {
		this.reasonOfInterest = reasonOfInterest;
	}
}
