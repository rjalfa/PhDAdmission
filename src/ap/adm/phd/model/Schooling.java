package ap.adm.phd.model;

import java.io.Serializable;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class Schooling implements Serializable{
	private static final long serialVersionUID = 1L;
	private String tenthBoardName;
	private Double tenthBoardResults;
	private Integer tenthYear;
	private String twelfthBoardName;
	private Double twelfthBoardResults;
	private Integer twelfthYear;
	
	public Schooling() {
		tenthBoardName = new String();
		tenthBoardResults = 0.0;
		tenthYear = 0;
		twelfthBoardName = new String();
		twelfthBoardResults = 0.0;
		twelfthYear = 0;		
	}
	public String getTenthBoardName(){
		return tenthBoardName;
	}
	public void setTenthBoardName(String tenthBoardName) {
		this.tenthBoardName = tenthBoardName;
	}
	public Double getTenthBoardResults() {
		return tenthBoardResults;
	}
	public void setTenthBoardResults(Double tenthBoardResults) {
		this.tenthBoardResults = tenthBoardResults;
	}
	public Integer getTenthYear() {
		return tenthYear;
	}
	public void setTenthYear(Integer tenthYear) {
		this.tenthYear = tenthYear;
	}
	public String getTwelfthBoardName() {
		return twelfthBoardName;
	}
	public void setTwelfthBoardName(String twelfthBoardName) {
		this.twelfthBoardName = twelfthBoardName;
	}
	public Double getTwelfthBoardResults() {
		return twelfthBoardResults;
	}
	public void setTwelfthBoardResults(Double twelfthBoardResults) {
		this.twelfthBoardResults = twelfthBoardResults;
	}
	public Integer getTwelfthYear() {
		return twelfthYear;
	}
	public void setTwelfthYear(Integer twelfthYear) {
		this.twelfthYear = twelfthYear;
	}
}