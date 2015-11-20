package ap.adm.phd.utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import ap.adm.phd.model.Applicant;

/*
* @author Rounaq Jhunjhunu Wala 2014089
* @author Ambar Pal 2014012
*/

public class ImportCSV {
	private static Applicant parseCSVRecord(CSVRecord r){
		Applicant applicant = new Applicant();
		//Personal Information
		applicant.getPersonalInformation().setApplicantName(r.get(1));
		applicant.getPersonalInformation().setEmail(r.get(0));
		applicant.getPersonalInformation().setEnrollmentNo(r.get(59));
		applicant.getPersonalInformation().setCorrespondenceAddress(r.get(2));
		applicant.getPersonalInformation().setMobileNo(r.get(3));
		applicant.getPersonalInformation().setDateOfBirth(LocalDate.parse(r.get(11), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		applicant.getPersonalInformation().setStream(r.get(4));
		if(r.get(31).equals("Yes")) applicant.getPersonalInformation().setPreferences(r.get(32),r.get(33),r.get(34),r.get(35));
		else applicant.getPersonalInformation().setPreferences(r.get(5),r.get(6),r.get(7),"");
		applicant.getPersonalInformation().setGender(r.get(8));
		applicant.getPersonalInformation().setCategory(r.get(9));
		applicant.getPersonalInformation().setDisabled(r.get(10).equals("Yes"));
		applicant.getPersonalInformation().setDefence(r.get(12).equals("Yes"));	
		applicant.getPersonalInformation().setFatherName(r.get(13));
		applicant.getPersonalInformation().setNationality(r.get(14));
		applicant.getPersonalInformation().setPermanentAddress(r.get(15));
		applicant.getPersonalInformation().setPincode(r.get(16));
		
		//Schooling Information
		applicant.getEducationInformation().getSchooling().setTenthBoardName(r.get(17));
		applicant.getEducationInformation().getSchooling().setTenthBoardResults(Double.parseDouble(r.get(18)));
		applicant.getEducationInformation().getSchooling().setTenthYear(Integer.parseInt(r.get(19)));
		applicant.getEducationInformation().getSchooling().setTwelfthBoardName(r.get(20));
		applicant.getEducationInformation().getSchooling().setTwelfthBoardResults(Double.parseDouble(r.get(21)));
		applicant.getEducationInformation().getSchooling().setTwelfthYear(Integer.parseInt(r.get(22)));
		
		//Graduation Information
		applicant.getEducationInformation().getGraduation().setDegreeName(r.get(23));
		applicant.getEducationInformation().getGraduation().setDepartment(r.get(24));
		applicant.getEducationInformation().getGraduation().setCollegeName(r.get(25));
		applicant.getEducationInformation().getGraduation().setUniversityName(r.get(26));
		applicant.getEducationInformation().getGraduation().setCity(r.get(27));
		applicant.getEducationInformation().getGraduation().setState(r.get(28));
		applicant.getEducationInformation().getGraduation().setGraduationYear(Integer.parseInt(r.get(29)));
		if(r.get(30).substring(0, 4).equals("CGPA")) 
		{
			applicant.getEducationInformation().getGraduation().setCgpa(Double.parseDouble(r.get(30).substring(5)));
			applicant.getEducationInformation().getGraduation().setCgpaSelected(true);
		}
		else applicant.getEducationInformation().getGraduation().setCgpaSelected(false);
		if(r.get(30).substring(0, 6).equals("Marks:")) 
		{
			applicant.getEducationInformation().getGraduation().setPercentage(Double.parseDouble(r.get(30).substring(6)));
			applicant.getEducationInformation().getGraduation().setPercentageSelected(true);
		}
		else applicant.getEducationInformation().getGraduation().setPercentageSelected(false);
		
		//Post Graduation Information
		if(r.get(36).equals("Yes"))
		{
			applicant.getEducationInformation().getPostGraduation().setDegreeName(r.get(37));
			applicant.getEducationInformation().getPostGraduation().setThesisTitle(r.get(40));
			applicant.getEducationInformation().getPostGraduation().setDepartment(r.get(38));
			applicant.getEducationInformation().getPostGraduation().setCollege(r.get(39));
			applicant.getEducationInformation().getPostGraduation().setUniversity(r.get(39));
			applicant.getEducationInformation().getPostGraduation().setCity(r.get(41));
			applicant.getEducationInformation().getPostGraduation().setState(r.get(42));
			applicant.getEducationInformation().getPostGraduation().setYear(Integer.parseInt(r.get(43)));
			if(r.get(44).substring(0, 4).equals("CGPA"))
			{
				applicant.getEducationInformation().getPostGraduation().setCgpa(Double.parseDouble(r.get(44).substring(5)));
				applicant.getEducationInformation().getPostGraduation().setCgpaSelected(true);
			}
			else applicant.getEducationInformation().getPostGraduation().setCgpaSelected(false);
			if(r.get(44).substring(0, 6).equals("Marks:")) 
			{
				applicant.getEducationInformation().getPostGraduation().setPercentage(Double.parseDouble(r.get(44).substring(6)));
				applicant.getEducationInformation().getPostGraduation().setPercentageSelected(true);
			}
			else applicant.getEducationInformation().getPostGraduation().setPercentageSelected(false);
		}
		else applicant.getEducationInformation().setPostGraduation(null);
		
		//Other Academic Degrees
		if(r.get(45).trim().length() > 0)
		{
			applicant.getEducationInformation().getOtherAcademic().getDegree().setDegreeName(r.get(46));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setSubject(r.get(47));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setInstitution("NA");
			applicant.getEducationInformation().getOtherAcademic().getDegree().setYear(Integer.parseInt(r.get(48)));
			applicant.getEducationInformation().getOtherAcademic().getDegree().setScore(Double.parseDouble(r.get(49)));
		}
		else applicant.getEducationInformation().getOtherAcademic().setDegree(null);
		
		//GATE
		if(r.get(51).equals("Yes"))
		{
			applicant.getEducationInformation().getOtherAcademic().getGate().setArea(r.get(52));
			applicant.getEducationInformation().getOtherAcademic().getGate().setYear(Integer.parseInt(r.get(53)));
			applicant.getEducationInformation().getOtherAcademic().getGate().setPercentage(Double.parseDouble(r.get(54)));
			applicant.getEducationInformation().getOtherAcademic().getGate().setScore(Double.parseDouble(r.get(55)));
			applicant.getEducationInformation().getOtherAcademic().getGate().setRank(Integer.parseInt(r.get(56)));
		}
		else applicant.getEducationInformation().getOtherAcademic().setGate(null);
		
		//Uploading Documents
		applicant.getEducationInformation().getAchievements().setDescription(r.get(57));
		
		//Feedback
		applicant.getFeedback().setFirstHear("NA");
		String[] x = {"NA"};
		applicant.getFeedback().setReasonOfInterest(x);
		
		//Set Today's Date to Record
		try{
		applicant.setApplicationSubmit((new SimpleDateFormat("YY-MMM-dd HH:mm:ss")).parse(r.get(58)).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		}catch(Exception e){
		}
		return applicant;
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
		outStream.println("Preferences:");
		for (String i : applicant.getPersonalInformation().getPreferences())
			outStream.println(i);
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
	public static void commitRecord(Applicant applicant) throws IOException{
		ObjectOutputStream outStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("data/DATA" + applicant.getPersonalInformation().getEnrollmentNo() + "/applicantData.adm")));
		outStream.writeObject(applicant);
		outStream.close();
	}
	public static void main(String[] args){
		FileReader fileReader = null;
		CSVParser csvParser = null;
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("Email","Name","Address of Correspondence","Mobile","PhD Stream","PhD Area Preference 1","PhD Area Preference 2","PhD Area Preference 3","Gender","Category","Physically Disabled","DOB","Children/War Widows of Defence Personnel killed/Disabled in Action","Father's Name","Nationality","Permanent Address","Pin Code","Xth Board","Xth Marks (%)","Year of Passing Xth","XIIth Board","XIIth Marks (%)","Year of Passing XIIth","Graduation Degree","Graduation Department","Graduation College","Graduation University","Graduation City","Graduation State","Year of Graduation","Grad CGPA or Marks","Applying for ECE PhD","ECE PhD Subject Preference 1","ECE PhD Subject Preference 2","ECE PhD Subject Preference 3","ECE PhD Subject Preference 4","Completed Post Grad","Post Grad Degree","Post Grad Department","Post Grad College","Post Grad Thesis","Post Grad City","Post Grad State","Year of Post Grad","Post Grad CGPA or Marks","Other Academic Degrees","Exam Name","Subject","Year","Score","Rank","Taken GATE Exam","GATE Area","Year of Gate","Marks(%)","Gate Score","Gate Rank","Achievements","Timestamp","EnrollmentNo");
		try{
			fileReader = new FileReader("externalData/Data_to_Import.csv");
			csvParser = new CSVParser(fileReader, csvFormat);
			List<CSVRecord> records = csvParser.getRecords();
			for (int i = 1; i < records.size(); i++){
				CSVRecord r = (CSVRecord) records.get(i);
				Applicant applicant = parseCSVRecord(r);
				File outDir = new File("data/DATA" + applicant.getPersonalInformation().getEnrollmentNo());
				if (!outDir.exists()) outDir.mkdirs();
				createText(applicant);
				commitRecord(applicant);
			}
			fileReader.close();
			csvParser.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}