package ap.adm.phd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import ap.adm.phd.model.Applicant;
import ap.adm.phd.utilities.GlobalVars;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */
public class Database {
	
	private static ArrayList<Applicant> applicants = new ArrayList<>();
	public static void fillUser(Applicant applicant,HashMap<String,String> params)
	{
		applicant.getPersonalInformation().setApplicantName(params.get("name"));
		applicant.getPersonalInformation().setEmail(params.get("email"));
		applicant.getPersonalInformation().setEnrollmentNo(params.get("enrollmentNumber"));
		applicant.getPersonalInformation().setCorrespondenceAddress(params.get("corrAddress"));
		applicant.getPersonalInformation().setMobileNo(params.get("mobNumber"));
		applicant.getPersonalInformation().setDateOfBirth(LocalDate.parse(params.get("dobField"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		applicant.getPersonalInformation().setStream(params.get("phdStreamSelector"));
		if(params.get("phdStreamSelector").equals("Electronics and Communication")) applicant.getPersonalInformation().setPreferences(params.get("preferences1"),params.get("preferences2"),params.get("preferences3"),params.get("preferences4"));
		else applicant.getPersonalInformation().setPreferences(params.get("preferences1"),params.get("preferences2"),params.get("preferences3"));
		applicant.getPersonalInformation().setGender(params.get("gender"));
		applicant.getPersonalInformation().setCategory(GlobalVars.casteList[Integer.parseInt(params.get("category"))-1]);
		if(params.get("phyDisabled") != null) applicant.getPersonalInformation().setDisabled(true);
		else applicant.getPersonalInformation().setDisabled(false);
		if(params.get("defence") != null) applicant.getPersonalInformation().setDefence(true);
		else applicant.getPersonalInformation().setDefence(false);
		applicant.getPersonalInformation().setFatherName(params.get("fatherName"));
		applicant.getPersonalInformation().setNationality(params.get("nationality"));
		applicant.getPersonalInformation().setPermanentAddress(params.get("permAddress"));
		applicant.getPersonalInformation().setPincode(params.get("pincode"));

		//Schooling Information
		applicant.getEducationInformation().getSchooling().setTenthBoardName(params.get("xBoard"));
		applicant.getEducationInformation().getSchooling().setTenthBoardResults(Double.parseDouble(params.get("xMarks")));
		applicant.getEducationInformation().getSchooling().setTenthYear(Integer.parseInt(params.get("xYear")));
		applicant.getEducationInformation().getSchooling().setTwelfthBoardName(params.get("xiiBoard"));
		applicant.getEducationInformation().getSchooling().setTwelfthBoardResults(Double.parseDouble(params.get("xiiMarks")));
		applicant.getEducationInformation().getSchooling().setTwelfthYear(Integer.parseInt(params.get("xiiYear")));

		//Graduation Information
		applicant.getEducationInformation().getGraduation().setDegreeName(params.get("gradDegree"));
		applicant.getEducationInformation().getGraduation().setDepartment(params.get("gradDept"));
		applicant.getEducationInformation().getGraduation().setCollegeName(params.get("gradCollege"));
		applicant.getEducationInformation().getGraduation().setUniversityName(params.get("gradUniv"));
		applicant.getEducationInformation().getGraduation().setCity(params.get("gradCity"));
		applicant.getEducationInformation().getGraduation().setState(params.get("gradState"));
		applicant.getEducationInformation().getGraduation().setGraduationYear(Integer.parseInt(params.get("gradYear")));
		if(params.get("gradPerformanceCGPA")!=null) 
		{
			applicant.getEducationInformation().getGraduation().setCgpa(Double.parseDouble(params.get("gradPerformance")));
			applicant.getEducationInformation().getGraduation().setCgpaSelected(true);
			applicant.getEducationInformation().getGraduation().setPercentageSelected(false);
		}
		else
		{
			applicant.getEducationInformation().getGraduation().setPercentage(Double.parseDouble(params.get("gradPerformance")));
			applicant.getEducationInformation().getGraduation().setPercentageSelected(true);
			applicant.getEducationInformation().getGraduation().setCgpaSelected(false);
		} 

		//Post Graduation Information
		if(params.get("pgApplicable")!=null)
		{
			applicant.getEducationInformation().getPostGraduation().setDegreeName(params.get("pgDegree"));
			applicant.getEducationInformation().getPostGraduation().setThesisTitle(params.get("pgThesis"));
			applicant.getEducationInformation().getPostGraduation().setDepartment(params.get("pgDept"));
			applicant.getEducationInformation().getPostGraduation().setCollege(params.get("pgCollege"));
			applicant.getEducationInformation().getPostGraduation().setUniversity(params.get("pgUniv"));
			applicant.getEducationInformation().getPostGraduation().setCity(params.get("pgCity"));
			applicant.getEducationInformation().getPostGraduation().setState(params.get("pgState"));
			applicant.getEducationInformation().getPostGraduation().setYear(Integer.parseInt(params.get("pgYear")));
			if(params.get("pgPerformanceCGPA")!=null) 
			{
				applicant.getEducationInformation().getPostGraduation().setCgpa(Double.parseDouble(params.get("pgPerformance")));
				applicant.getEducationInformation().getPostGraduation().setCgpaSelected(true);
				applicant.getEducationInformation().getPostGraduation().setPercentageSelected(false);
			}
			else  
			{
				applicant.getEducationInformation().getPostGraduation().setPercentage(Double.parseDouble(params.get("pgPerformance")));
				applicant.getEducationInformation().getPostGraduation().setPercentageSelected(true);
				applicant.getEducationInformation().getPostGraduation().setCgpaSelected(false);
			}
		}
		else applicant.getEducationInformation().setPostGraduation(null);

		//Other Academic Degrees
		if(params.get("oAApplicable")!=null)
		{
			applicant.getEducationInformation().getOtherAcademic().getDegree().setDegreeName(params.get("oADegree"));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setSubject(params.get("oASubject"));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setInstitution(params.get("oACollege"));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setYear(Integer.parseInt(params.get("oAYear")));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setScore(Double.parseDouble(params.get("oAPerformance")));
		}
		else applicant.getEducationInformation().getOtherAcademic().setDegree(null);

		//GATE
		if(params.get("gateApplicable")!=null)
		{
			applicant.getEducationInformation().getOtherAcademic().getGate().setArea(params.get("gateArea"));
			applicant.getEducationInformation().getOtherAcademic().getGate().setYear(Integer.parseInt(params.get("gateYear")));
			applicant.getEducationInformation().getOtherAcademic().getGate().setPercentage(Double.parseDouble(params.get("gatePercentage")));
			applicant.getEducationInformation().getOtherAcademic().getGate().setScore(Double.parseDouble(params.get("gateScore")));
			applicant.getEducationInformation().getOtherAcademic().getGate().setRank(Integer.parseInt(params.get("gateRank")));
		}
		else applicant.getEducationInformation().getOtherAcademic().setGate(null);

		//Uploading Documents
		applicant.getEducationInformation().getAchievements().setDescription(params.get("otherAchieve"));

		//Feedback
		applicant.getFeedback().setFirstHear(params.get("feedbackQ1"));
		applicant.getFeedback().setReasonOfInterest(params.get("feedbackQ2string").split(";"));

		//Set Today's Date to Record
		applicant.setApplicationSubmit(LocalDate.now());
		File outDir = new File("data/DATA" + applicant.getPersonalInformation().getEnrollmentNo());
		if (!outDir.exists()) outDir.mkdirs();
		System.out.println(outDir.getAbsolutePath());
		applicant.getEducationInformation().getAchievements().setCv(outDir.getAbsolutePath()+"/applicantCV.pdf");
		applicant.getEducationInformation().getAchievements().setSop(outDir.getAbsolutePath()+"/applicantSOP.pdf");
		try
		{
			commitRecord(applicant);
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		
	}
	private static String eidGenerator()
	{
		return "PHD" + System.currentTimeMillis();
	}
	
	public static void createText(Applicant applicant) throws IOException{
		PrintWriter outStream = new PrintWriter("data/DATA" + applicant.getPersonalInformation().getEnrollmentNo() + "/applicantInformation.txt");
		outStream.println("Personal Information");
		outStream.println("====================");
		outStream.println("Name: " + applicant.getPersonalInformation().getApplicantName());
		outStream.println("Email: " + applicant.getPersonalInformation().getEmail());
		outStream.println("Enrollment No.: " + applicant.getPersonalInformation().getEnrollmentNo());
		outStream.println("Correspondence Address:\n" + applicant.getPersonalInformation().getCorrespondenceAddress());
		outStream.println("Mobile Number: " + applicant.getPersonalInformation().getMobileNo());
		outStream.println("DOB: " + applicant.getPersonalInformation().getDateOfBirth());
		outStream.println("Stream: " + applicant.getPersonalInformation().getStream());
		outStream.println("Preferences:");for (String i : applicant.getPersonalInformation().getPreferences()) outStream.println(i);
		outStream.println("Gender: " + applicant.getPersonalInformation().getGender());
		outStream.println("Category: " + applicant.getPersonalInformation().getCategory());
		outStream.println("Disabled: " + applicant.getPersonalInformation().getDisabled());
		outStream.println("Defence Category: " + applicant.getPersonalInformation().getDefence());
		outStream.println("Father's Name: " + applicant.getPersonalInformation().getFatherName());
		outStream.println("Nationality: " + applicant.getPersonalInformation().getNationality());
		outStream.println("Permanent Address:\n" + applicant.getPersonalInformation().getPermanentAddress());
		outStream.println("PIN/ZIP Code: " + applicant.getPersonalInformation().getPincode());

		outStream.println("\nSchooling Information");
		outStream.println("=====================");
		outStream.println("Class X:-");
		outStream.println("Board: " + applicant.getEducationInformation().getSchooling().getTenthBoardName());
		outStream.println("Percentage: " + applicant.getEducationInformation().getSchooling().getTenthBoardResults());
		outStream.println("Year of Passing: " + applicant.getEducationInformation().getSchooling().getTenthYear());
		outStream.println("Class XII:-");
		outStream.println("Board: " + applicant.getEducationInformation().getSchooling().getTwelfthBoardName());
		outStream.println("Percentage: " + applicant.getEducationInformation().getSchooling().getTwelfthBoardResults());
		outStream.println("Year of Passing: " + applicant.getEducationInformation().getSchooling().getTwelfthYear());

		outStream.println("\nGraduation Information");
		outStream.println("======================");
		outStream.println("Degree: " + applicant.getEducationInformation().getGraduation().getDegreeName());
		outStream.println("Department: " + applicant.getEducationInformation().getGraduation().getDepartment());
		outStream.println("College: " + applicant.getEducationInformation().getGraduation().getCollegeName());
		outStream.println("University: " + applicant.getEducationInformation().getGraduation().getUniversityName());
		outStream.println("City: " + applicant.getEducationInformation().getGraduation().getCity());
		outStream.println("State: " + applicant.getEducationInformation().getGraduation().getState());
		outStream.println("Year of Graduation:" + applicant.getEducationInformation().getGraduation().getGraduationYear());
		if(applicant.getEducationInformation().getGraduation().getCgpaSelected()) outStream.println("CGPA: " + applicant.getEducationInformation().getGraduation().getCgpa());
		else outStream.println("Percentage: " + applicant.getEducationInformation().getGraduation().getPercentage());
	
		if(applicant.getEducationInformation().getPostGraduation() != null)
		{
			outStream.println("\nPost Graduation Information");
			outStream.println("===========================");
			outStream.println("Degree: " + applicant.getEducationInformation().getPostGraduation().getDegreeName());
			outStream.println("Thesis:" + applicant.getEducationInformation().getPostGraduation().getThesisTitle());
			outStream.println("Department: " + applicant.getEducationInformation().getPostGraduation().getDepartment());
			outStream.println("College: " + applicant.getEducationInformation().getPostGraduation().getCollege());
			outStream.println("University: " + applicant.getEducationInformation().getPostGraduation().getUniversity());
			outStream.println("City: " + applicant.getEducationInformation().getPostGraduation().getCity());
			outStream.println("State: " + applicant.getEducationInformation().getPostGraduation().getState());
			outStream.println("Year of Post Graduation: " + applicant.getEducationInformation().getPostGraduation().getYear());
			if(applicant.getEducationInformation().getPostGraduation().getCgpaSelected()) outStream.println("CGPA: " + applicant.getEducationInformation().getPostGraduation().getCgpa());
			else outStream.println("Percentage: " + applicant.getEducationInformation().getPostGraduation().getPercentage());
		}
		
		//Other Academic Degrees
		if(applicant.getEducationInformation().getOtherAcademic().getDegree() != null)
		{
			outStream.println("\nOther Academic Information");
			outStream.println("===========================");
			outStream.println("Degree: " + applicant.getEducationInformation().getOtherAcademic().getDegree().getDegreeName());
			outStream.println("Subject: " + applicant.getEducationInformation().getOtherAcademic().getDegree().getSubject());
			outStream.println("Institution: " + applicant.getEducationInformation().getOtherAcademic().getDegree().getInstitution());
			outStream.println("Year: " + applicant.getEducationInformation().getOtherAcademic().getDegree().getYear());
			outStream.println("Score: " + applicant.getEducationInformation().getOtherAcademic().getDegree().getScore());
		}
		
		//GATE
		if(applicant.getEducationInformation().getOtherAcademic().getGate() != null)
		{
			outStream.println("\nGATE Information");
			outStream.println("================");
			outStream.println("Area: " + applicant.getEducationInformation().getOtherAcademic().getGate().getArea());
			outStream.println("Year: " + applicant.getEducationInformation().getOtherAcademic().getGate().getYear());
			outStream.println("Percentage: " + applicant.getEducationInformation().getOtherAcademic().getGate().getPercentage());
			outStream.println("Score: " + applicant.getEducationInformation().getOtherAcademic().getGate().getScore());
			outStream.println("Rank: " + applicant.getEducationInformation().getOtherAcademic().getGate().getRank());
		}
		
		if (applicant.getEducationInformation().getAchievements().getDescription().trim().length() > 0){
			outStream.println("\nOther Achievements:");
			outStream.println(applicant.getEducationInformation().getAchievements().getDescription());
		}
		outStream.close();
	}
	
	public static Applicant newApplicant()
	{
		Applicant a = new Applicant();
		a.getPersonalInformation().setEnrollmentNo(eidGenerator());
		return a;
	}
	
	public static void commitRecord(Applicant applicant) throws IOException{
		createText(applicant);
		ObjectOutputStream outStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data/DATA" + applicant.getPersonalInformation().getEnrollmentNo() + "/applicantData.adm")));
		outStream.writeObject(applicant);
		outStream.close();
	}
	public static void readRecord() throws IOException, ClassNotFoundException{
		Applicant applicant = null;
		int i;
		ObjectInputStream inStream = null;
		applicants.clear();
		File[] dataFolder = (new File("data")).listFiles();
		for(i=0;i<dataFolder.length;i++)
		{
			if (dataFolder[i].getName().equals("enrollCounter.adm")) continue;
			inStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("data/"+dataFolder[i].getName()+"/applicantData.adm")));
			try{
				while (true)
				{	
					applicant = (Applicant)inStream.readObject();
					applicants.add(applicant);
				}
			}
			catch(EOFException e){
				inStream.close();
			}
		}
	}
}
