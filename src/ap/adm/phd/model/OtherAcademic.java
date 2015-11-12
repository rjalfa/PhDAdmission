package ap.adm.phd.model;

import java.io.Serializable;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class OtherAcademic implements Serializable{
	private static final long serialVersionUID = 1L;
	private Degree degree;
	private Gate gate;
	
	public OtherAcademic()
	{
		degree = new Degree();
		gate = new Gate();
	}
	
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	public Gate getGate() {
		return gate;
	}
	public void setGate(Gate gate) {
		this.gate = gate;
	}
	
}
