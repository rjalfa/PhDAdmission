package ap.adm.phd.model;

import java.io.Serializable;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */

public class EducationInformation implements Serializable{
	private static final long serialVersionUID = 1L;
	Schooling schooling;
	Graduation graduation;
	PostGraduation postGraduation;
	OtherAcademic otherAcademic;
	Achievements achievements;
	
	public EducationInformation()
	{
		schooling = new Schooling();
		graduation = new Graduation();
		postGraduation = new PostGraduation();
		otherAcademic = new OtherAcademic();
		achievements = new Achievements();
	}
	
	public Schooling getSchooling() {
		return schooling;
	}
	public void setSchooling(Schooling schooling) {
		this.schooling = schooling;
	}
	public Graduation getGraduation() {
		return graduation;
	}
	public void setGraduation(Graduation graduation) {
		this.graduation = graduation;
	}
	public PostGraduation getPostGraduation() {
		return postGraduation;
	}
	public void setPostGraduation(PostGraduation postGraduation) {
		this.postGraduation = postGraduation;
	}
	public OtherAcademic getOtherAcademic() {
		return otherAcademic;
	}
	public void setOtherAcademic(OtherAcademic otherAcademic) {
		this.otherAcademic = otherAcademic;
	}
	public Achievements getAchievements() {
		return achievements;
	}
	public void setAchievements(Achievements achievements) {
		this.achievements = achievements;
	}
}
