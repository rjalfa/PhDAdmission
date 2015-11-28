package ap.adm.phd.controller;

import static ap.adm.phd.utilities.GlobalVars.CBChoice;
import static ap.adm.phd.utilities.GlobalVars.CSEChoice;
import static ap.adm.phd.utilities.GlobalVars.ECEChoice;
import static ap.adm.phd.utilities.GlobalVars.IndianStates;
import static ap.adm.phd.utilities.GlobalVars.blankChoice;
import static ap.adm.phd.utilities.GlobalVars.casteList;
import static ap.adm.phd.utilities.GlobalVars.countries;
import static ap.adm.phd.utilities.GlobalVars.genderList;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ap.adm.phd.adapter.AdapterTextField;

import ap.adm.phd.model.Applicant;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.AdapterDatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.AdapterToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */ 
public class ApplicantFormController
{
	private Applicant applicant;
	
	//Tab: Personal Information
	private AdapterTextField name;
	private AdapterTextField email;
	private AdapterTextField enrollmentNumber;
	private AdapterTextArea corrAddress;
	private AdapterTextField mobNumber;
	private AdapterDatePicker dobField;
	private AdapterToggleGroup phdStreamSelector;
	private AdapterChoiceBox<String> preferences1;
	private AdapterChoiceBox<String> preferences2;
	private AdapterChoiceBox<String> preferences3;
	private AdapterChoiceBox<String> preferences4;
	private AdapterChoiceBox<String> gender;
	private AdapterChoiceBox<String> category;
	private AdapterToggleGroup phyDisabled;
	private AdapterToggleGroup defence;
	private AdapterTextField fatherName;
	private ComboBox<String> nationality;
	private AdapterTextArea permAddress;
	private AdapterTextField pincode;
	private Button p_info_saveButton;

	//Tab: Education Information
	//Sub-Tab: Schooling Information
	private AdapterTextField xBoard;
	private AdapterTextField xMarks;
	private AdapterTextField xYear;
	private AdapterTextField xiiBoard;
	private AdapterTextField xiiMarks;
	private AdapterTextField xiiYear;

	//Sub-Tab: Graduation Information
	private AdapterTextField gradDegree;
	private AdapterTextField gradDept;
	private AdapterTextField gradCollege;
	private AdapterTextField gradUniv;
	private AdapterTextField gradCity;
	private ComboBox<String> gradState;
	private AdapterTextField gradYear;
	private RadioButton gradCgpaRB;
	private RadioButton gradPercentageRB;
	private AdapterToggleGroup gradPerformanceSelector;
	private AdapterTextField gradPerformanceCGPA;
	private AdapterTextField gradPerformancePercentage;

	//Sub-Tab: Post Graduation Information
	private ToggleButton pgApplicable;
	private AdapterTextField pgDegree;
	private AdapterTextField pgThesis;
	private AdapterTextField pgDept;
	private AdapterTextField pgCollege;
	private AdapterTextField pgUniv;
	private AdapterTextField pgCity;
	private ComboBox<String> pgState;
	private AdapterTextField pgYear;
	private RadioButton pgCgpaRB;
	private RadioButton pgPercentageRB;
	private AdapterToggleGroup pgPerformanceSelector;
	private AdapterTextField pgPerformanceCGPA;
	private AdapterTextField pgPerformancePercentage;

	//Sub-Tab: OtherAcademic Academic Degrees
	private ToggleButton oAApplicable;
	private AdapterTextField oADegree;
	private AdapterTextField oASubject;
	private AdapterTextField oAYear;
	private AdapterTextField oACollege;
	private AdapterTextField oAPerformance;

	//Sub-Tab: GATE
	private ToggleButton gateApplicable;
	private AdapterTextField gateArea;
	private AdapterTextField gateYear;
	private AdapterTextField gatePercentage;
	private AdapterTextField gateScore;
	private AdapterTextField gateRank;

	//Sub-Tab: Miscellaneous
	private AdapterTextArea otherAchieve;
	private FileChooser cvUploader;
	private FileChooser sopUploader;
	private Button cvUpload;
	private Button sopUpload;
	private Label cvUploadLabel;
	private Label sopUploadLabel;
	private String cvUploadPath;
	private String sopUploadPath;


	private Button e_info_saveButton;

	//Tab: Feedback and Submit
	private AdapterChoiceBox<String> feedbackQ1;
	private CheckBox feedbackQ2op1;
	private CheckBox feedbackQ2op2;
	private CheckBox feedbackQ2op3;
	private CheckBox feedbackQ2op4;
	private CheckBox feedbackQ2op5;
	private CheckBox feedbackQ2op6;
	private CheckBox feedbackQ2op7;
	private CheckBox feedbackQ2op8;
	private CheckBox feedbackQ2op9;
	private CheckBox feedbackQ2op10;

	private Button submitButton;
	private Label submitFeedbackLabel;


	public void testRespond()
	{
		System.out.println("Response!");
	}

	public void initialize(URL arg0, ResourceBundle arg1)
	{
		//Populating and Presets
		//FXML Controls
		//Tab: Personal Information
		enrollmentNumber.setDisable(true);
//		makeNumeric(mobNumber);
		preferences1.setItems(blankChoice);
		preferences2.setItems(blankChoice);
		preferences3.setItems(blankChoice);
		preferences4.setItems(ECEChoice);
		preferences4.setDisable(true);
		gender.setItems(genderList);
		category.setItems(casteList);
		nationality.setItems(countries);
//		makeNumeric(pincode);

		//Tab: Education Information
		//Sub-Tab: Schooling Information
//		makeNumericF(xMarks);
//		makeNumeric(xYear);
//		makeNumericF(xiiMarks);
//		makeNumeric(xiiYear);

		//Sub-Tab: Graduation Information
		gradState.setItems(IndianStates);
//		makeNumeric(gradYear);
//		makeNumericF(gradPerformanceCGPA);
		gradPerformanceCGPA.setDisable(true);
//		makeNumericF(gradPerformancePercentage);
		gradPerformancePercentage.setDisable(true);


		//Sub-Tab: Post Graduation Information
		pgDegree.setDisable(true);
		pgThesis.setDisable(true);
		pgDept.setDisable(true);
		pgCollege.setDisable(true);
		pgUniv.setDisable(true);
		pgCity.setDisable(true);
		pgState.setDisable(true);
		pgState.setItems(IndianStates);
		pgYear.setDisable(true);
//		makeNumeric(pgYear);
		pgCgpaRB.setDisable(true);
		pgPercentageRB.setDisable(true);
		pgPerformanceCGPA.setDisable(true);
//		makeNumericF(pgPerformanceCGPA);
		pgPerformancePercentage.setDisable(true);
//		makeNumericF(pgPerformancePercentage);

		//Sub-Tab: OtherAcademic Academic Degrees
		oADegree.setDisable(true);
		oASubject.setDisable(true);
		oAYear.setDisable(true);
//		makeNumeric(oAYear);
		oACollege.setDisable(true);
		oAPerformance.setDisable(true);
//		makeNumericF(oAPerformance);

		//Sub-Tab: GATE
		gateArea.setDisable(true);
		gateYear.setDisable(true);
//		makeNumeric(gateYear);
		gatePercentage.setDisable(true);
//		makeNumericF(gatePercentage);
		gateScore.setDisable(true);
//		makeNumeric(gateScore);
		gateRank.setDisable(true);
//		makeNumeric(gateRank);

		//Sub-Tab: Miscellaneous 
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
		cvUploader = new FileChooser();
		sopUploader = new FileChooser();
		cvUploader.getExtensionFilters().add(extFilter);
		sopUploader.getExtensionFilters().add(extFilter);

		//Tab: Feedback and Submit
		feedbackQ1.setItems(FXCollections.observableArrayList("Advertisement in the Dainik Jagran","Advertisement in the Hindu","Advertisement in the Hindustan Times","PhD flier","IIIT-Delhi Website","Other Website","Talk/Presentation","College/Teacher/Academic relation","Friend/Family/Personal relation","Other"));
		feedbackQ2op1.setSelected(false);
		feedbackQ2op2.setSelected(false);
		feedbackQ2op3.setSelected(false);
		feedbackQ2op4.setSelected(false);
		feedbackQ2op5.setSelected(false);
		feedbackQ2op6.setSelected(false);
		feedbackQ2op7.setSelected(false);
		feedbackQ2op8.setSelected(false);
		feedbackQ2op9.setSelected(false);
		feedbackQ2op10.setSelected(false);
	}

	//Numeric Text Fields Constraint Event
//	private void makeNumeric(AdapterTextField text)
//	{
//		text.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>()
//		{
//			public void handle( KeyEvent t )
//			{
//				char ar[] = t.getCharacter().toCharArray();
//				char ch = ar[t.getCharacter().toCharArray().length - 1];
//				if (!(ch >= '0' && ch <= '9')) t.consume();
//			}
//		});
//	}

	//Numeric Text Fields (Floating Point Values) Constraint Event
//	private void makeNumericF(AdapterTextField text)
//	{
//		text.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>()
//		{
//			public void handle( KeyEvent t )
//			{
//				char ar[] = t.getCharacter().toCharArray();
//				char ch = ar[t.getCharacter().toCharArray().length - 1];
//				if (!(ch >= '0' && ch <= '9' || ch == '.')) t.consume();
//			}
//		});
//	}

	//File Picker Events
//	private void cvUploadEvent()
//	{
//		File temp = cvUploader.showOpenDialog(primaryStage);
//		if(temp != null) 
//		{
//			cvUploadPath = temp.getAbsolutePath();
//			cvUploadLabel.setText(temp.getName());
//		}
//	}

//	private void sopUploadEvent()
//	{
//		File temp = sopUploader.showOpenDialog(primaryStage);
//		if(temp != null) 
//		{
//			sopUploadPath = temp.getAbsolutePath();
//			sopUploadLabel.setText(temp.getName());
//		}
//	}

	//Toggle Events

	private void isPGApplicable()
	{
		boolean toggleValue = !pgApplicable.isSelected();
		pgDegree.setDisable(toggleValue);
		pgThesis.setDisable(toggleValue);
		pgDept.setDisable(toggleValue);
		pgCollege.setDisable(toggleValue);
		pgUniv.setDisable(toggleValue);
		pgCity.setDisable(toggleValue);
		pgState.setDisable(toggleValue);
		pgYear.setDisable(toggleValue);
		pgCgpaRB.setDisable(toggleValue);
		pgPercentageRB.setDisable(toggleValue);
		pgPerformanceCGPA.setDisable(toggleValue || !pgCgpaRB.isSelected());
		pgPerformancePercentage.setDisable(toggleValue || !pgPercentageRB.isSelected());
	}


	private void isOAApplicable()
	{
		boolean toggleValue = !oAApplicable.isSelected();
		oADegree.setDisable(toggleValue);
		oASubject.setDisable(toggleValue);
		oAYear.setDisable(toggleValue);
		oACollege.setDisable(toggleValue);
		oAPerformance.setDisable(toggleValue);
	}


	private void isGATEApplicable()
	{
		boolean toggleValue = !gateApplicable.isSelected();
		gateArea.setDisable(toggleValue);
		gateYear.setDisable(toggleValue);
		gatePercentage.setDisable(toggleValue);
		gateScore.setDisable(toggleValue);
		gateRank.setDisable(toggleValue);
	}


	private void setGradPerformanceMode()
	{
		gradPerformanceCGPA.setDisable(!gradCgpaRB.isSelected());
		gradPerformancePercentage.setDisable(!gradPercentageRB.isSelected());
	}


	private void setPGPerformanceMode()
	{
		pgPerformanceCGPA.setDisable(!pgCgpaRB.isSelected());
		pgPerformancePercentage.setDisable(!pgPercentageRB.isSelected());
	}

	//Stream Selector Events

	private void setStreamSpecialisation()
	{
		//TO DO
		String selectedStream = ((RadioButton)(phdStreamSelector.getSelectedToggle())).getText();
		switch(selectedStream)
		{
		case "Computer Science":
			preferences1.setItems(CSEChoice);
			preferences2.setItems(CSEChoice);
			preferences3.setItems(CSEChoice);
			preferences4.setValue("");
			preferences4.setDisable(true);
			break;
		case "Electronics and Comm.":
			preferences1.setItems(ECEChoice);
			preferences2.setItems(ECEChoice);
			preferences3.setItems(ECEChoice);
			preferences4.setDisable(false);
			break;
		case "Computational Biology":
			preferences1.setItems(CBChoice);
			preferences2.setItems(CBChoice);
			preferences3.setItems(CBChoice);
			preferences4.setValue("");
			preferences4.setDisable(true);
			break;
		default:
		}
	}


	//Main Save Events


	private void page1Save()
	{
		//..
//		if(validatePI()) System.out.println("Data Valid!");
	}


	private void page2Save()
	{
		//..
//		if(validateEI()) System.out.println("Data Valid!");
	}

	private void onFormSubmit()
	{
		boolean flag = true;
//		flag &= validatePI();
//		flag &= validateEI();
//		flag &= validateFS();
		if(flag)
		{
			try
			{
				//Blank Applicant Object
				this.applicant = new Applicant();
//				enrollmentNumber.setText(mainApp.egn.next());
				//Personal Information
				applicant.getPersonalInformation().setApplicantName(name.getText());
				applicant.getPersonalInformation().setEmail(email.getText());
				applicant.getPersonalInformation().setEnrollmentNo(enrollmentNumber.getText());
				applicant.getPersonalInformation().setCorrespondenceAddress(corrAddress.getText());
				applicant.getPersonalInformation().setMobileNo(mobNumber.getText());
				applicant.getPersonalInformation().setDateOfBirth(dobField.getValue());
				applicant.getPersonalInformation().setStream(((RadioButton)(phdStreamSelector.getSelectedToggle())).getText());
				applicant.getPersonalInformation().setPreferences(preferences1.getValue(),preferences2.getValue(),preferences3.getValue(),preferences4.getValue());
				applicant.getPersonalInformation().setGender(gender.getValue());
				applicant.getPersonalInformation().setCategory(category.getValue());
				applicant.getPersonalInformation().setDisabled(((RadioButton)(phyDisabled.getSelectedToggle())).getText().equals("Yes"));
				applicant.getPersonalInformation().setDefence(((RadioButton)(defence.getSelectedToggle())).getText().equals("Yes"));	
				applicant.getPersonalInformation().setFatherName(fatherName.getText());
				applicant.getPersonalInformation().setNationality(nationality.getValue());
				applicant.getPersonalInformation().setPermanentAddress(permAddress.getText());
				applicant.getPersonalInformation().setPincode(pincode.getText());

				//Schooling Information
				applicant.getEducationInformation().getSchooling().setTenthBoardName(xBoard.getText());
				applicant.getEducationInformation().getSchooling().setTenthBoardResults(Double.parseDouble(xMarks.getText()));
				applicant.getEducationInformation().getSchooling().setTenthYear(Integer.parseInt(xYear.getText()));
				applicant.getEducationInformation().getSchooling().setTwelfthBoardName(xiiBoard.getText());
				applicant.getEducationInformation().getSchooling().setTwelfthBoardResults(Double.parseDouble(xiiMarks.getText()));
				applicant.getEducationInformation().getSchooling().setTwelfthYear(Integer.parseInt(xiiYear.getText()));

				//Graduation Information
				applicant.getEducationInformation().getGraduation().setDegreeName(gradDegree.getText());
				applicant.getEducationInformation().getGraduation().setDepartment(gradDept.getText());
				applicant.getEducationInformation().getGraduation().setCollegeName(gradCollege.getText());
				applicant.getEducationInformation().getGraduation().setUniversityName(gradUniv.getText());
				applicant.getEducationInformation().getGraduation().setCity(gradCity.getText());
				applicant.getEducationInformation().getGraduation().setState(gradState.getValue());
				applicant.getEducationInformation().getGraduation().setGraduationYear(Integer.parseInt(gradYear.getText()));
				if(gradCgpaRB.isSelected()) 
				{
					applicant.getEducationInformation().getGraduation().setCgpa(Double.parseDouble(gradPerformanceCGPA.getText()));
					applicant.getEducationInformation().getGraduation().setCgpaSelected(true);
				}
				else applicant.getEducationInformation().getGraduation().setCgpaSelected(false);
				if(gradPercentageRB.isSelected()) 
				{
					applicant.getEducationInformation().getGraduation().setPercentage(Double.parseDouble(gradPerformancePercentage.getText()));
					applicant.getEducationInformation().getGraduation().setPercentageSelected(true);
				}
				else applicant.getEducationInformation().getGraduation().setPercentageSelected(false);

				//Post Graduation Information
				if(pgApplicable.isSelected())
				{
					applicant.getEducationInformation().getPostGraduation().setDegreeName(pgDegree.getText());
					applicant.getEducationInformation().getPostGraduation().setThesisTitle(pgThesis.getText());
					applicant.getEducationInformation().getPostGraduation().setDepartment(pgDept.getText());
					applicant.getEducationInformation().getPostGraduation().setCollege(pgCollege.getText());
					applicant.getEducationInformation().getPostGraduation().setUniversity(pgUniv.getText());
					applicant.getEducationInformation().getPostGraduation().setCity(pgCity.getText());
					applicant.getEducationInformation().getPostGraduation().setState(pgState.getValue());
					applicant.getEducationInformation().getPostGraduation().setYear(Integer.parseInt(pgYear.getText()));
					if(pgCgpaRB.isSelected()) 
					{
						applicant.getEducationInformation().getPostGraduation().setCgpa(Double.parseDouble(pgPerformanceCGPA.getText()));
						applicant.getEducationInformation().getPostGraduation().setCgpaSelected(true);
					}
					else applicant.getEducationInformation().getPostGraduation().setCgpaSelected(false);
					if(pgPercentageRB.isSelected()) 
					{
						applicant.getEducationInformation().getPostGraduation().setPercentage(Double.parseDouble(pgPerformancePercentage.getText()));
						applicant.getEducationInformation().getPostGraduation().setPercentageSelected(true);
					}
					else applicant.getEducationInformation().getPostGraduation().setPercentageSelected(false);
				}
				else applicant.getEducationInformation().setPostGraduation(null);

				//Other Academic Degrees
				if(oAApplicable.isSelected())
				{
					applicant.getEducationInformation().getOtherAcademic().getDegree().setDegreeName(oADegree.getText());
					applicant.getEducationInformation().getOtherAcademic().getDegree().setSubject(oASubject.getText());
					applicant.getEducationInformation().getOtherAcademic().getDegree().setInstitution(oACollege.getText());
					applicant.getEducationInformation().getOtherAcademic().getDegree().setYear(Integer.parseInt(oAYear.getText()));
					applicant.getEducationInformation().getOtherAcademic().getDegree().setScore(Double.parseDouble(oAPerformance.getText()));
				}
				else applicant.getEducationInformation().getOtherAcademic().setDegree(null);

				//GATE
				if(gateApplicable.isSelected())
				{
					applicant.getEducationInformation().getOtherAcademic().getGate().setArea(gateArea.getText());
					applicant.getEducationInformation().getOtherAcademic().getGate().setYear(Integer.parseInt(gateYear.getText()));
					applicant.getEducationInformation().getOtherAcademic().getGate().setPercentage(Double.parseDouble(gatePercentage.getText()));
					applicant.getEducationInformation().getOtherAcademic().getGate().setScore(Double.parseDouble(gateScore.getText()));
					applicant.getEducationInformation().getOtherAcademic().getGate().setRank(Integer.parseInt(gateRank.getText()));
				}
				else applicant.getEducationInformation().getOtherAcademic().setGate(null);

				//Uploading Documents
				applicant.getEducationInformation().getAchievements().setDescription(otherAchieve.getText());
				applicant.getEducationInformation().getAchievements().setCv(cvUploadPath);
				applicant.getEducationInformation().getAchievements().setSop(sopUploadPath);


				//Feedback
				applicant.getFeedback().setFirstHear(feedbackQ1.getValue());
				ArrayList<String> q2messages = new ArrayList<>();
				if(feedbackQ2op1.isSelected()) q2messages.add(feedbackQ2op1.getText());
				if(feedbackQ2op2.isSelected()) q2messages.add(feedbackQ2op2.getText());
				if(feedbackQ2op3.isSelected()) q2messages.add(feedbackQ2op3.getText());
				if(feedbackQ2op4.isSelected()) q2messages.add(feedbackQ2op4.getText());
				if(feedbackQ2op5.isSelected()) q2messages.add(feedbackQ2op5.getText());
				if(feedbackQ2op6.isSelected()) q2messages.add(feedbackQ2op6.getText());
				if(feedbackQ2op7.isSelected()) q2messages.add(feedbackQ2op7.getText());
				if(feedbackQ2op8.isSelected()) q2messages.add(feedbackQ2op8.getText());
				if(feedbackQ2op9.isSelected()) q2messages.add(feedbackQ2op9.getText());
				if(feedbackQ2op10.isSelected()) q2messages.add(feedbackQ2op10.getText());
				applicant.getFeedback().setReasonOfInterest(q2messages.toArray(new String[q2messages.size()]));

				//Set Today's Date to Record
				applicant.setApplicationSubmit(LocalDate.now());
				File outDir = new File("data/DATA" + applicant.getPersonalInformation().getEnrollmentNo());
				if (!outDir.exists()) outDir.mkdirs();
				Files.copy(new File(applicant.getEducationInformation().getAchievements().getCv()).toPath(),new File("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantCV.pdf").toPath());
				Files.copy(new File(applicant.getEducationInformation().getAchievements().getSop()).toPath(),new File("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantSOP.pdf").toPath());				
				applicant.getEducationInformation().getAchievements().setCv("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantCV.pdf");
				applicant.getEducationInformation().getAchievements().setSop("data/DATA"+applicant.getPersonalInformation().getEnrollmentNo()+"/applicantSOP.pdf");	
//				mainApp.createText(applicant);

				//Commit Record
//				mainApp.commitRecord(applicant);
				submitFeedbackLabel.setText("The application has been submitted successfully! ["+applicant.getPersonalInformation().getEnrollmentNo()+"]");
				submitFeedbackLabel.setTextFill(Color.GREEN);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				submitFeedbackLabel.setText("Some Internal Error Occured!");
				submitFeedbackLabel.setTextFill(Color.ORANGE);
			}

		}
		else
		{
			submitFeedbackLabel.setText("Some of the fields are not filled successfully. Please review the form.");
			submitFeedbackLabel.setTextFill(Color.RED);
		}
	}

	//Validation Functions
	//Personal Information : Page 1
//	private boolean validatePI()
//	{
//		boolean flag = true;
//		if(name.getText().trim().length() == 0) {flag=false;setInvalid(name);}
//		else setValid(name);
//		if(email.getText().trim().length() == 0 || !email.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {flag=false;setInvalid(email);}
//		else setValid(email);
//		if(corrAddress.getText().trim().length() == 0) {flag=false;setInvalid(corrAddress);}
//		else setValid(corrAddress);
//		if(mobNumber.getText().trim().length() == 0) {flag=false;setInvalid(mobNumber);}
//		else setValid(mobNumber);
//		if(dobField.getValue() == null || (dobField.getValue()!=null && !dobField.getValue().isBefore(LocalDate.now().minusYears(15)))) {flag=false;setInvalid(dobField);}
//		else setValid(dobField);
//		if(phdStreamSelector.getSelectedToggle() == null) {flag=false;for(AdapterToggle i:phdStreamSelector.getToggles()) setInvalid((RadioButton)i);}
//		else for(AdapterToggle i:phdStreamSelector.getToggles()) setValid((RadioButton)i);
//		if(preferences1.getValue() == null) {flag=false;setInvalid(preferences1);}
//		else setValid(preferences1);
//		if(gender.getValue() == null) {flag=false;setInvalid(gender);}
//		else setValid(gender);
//		if(category.getValue() == null) {flag=false;setInvalid(category);}
//		else setValid(category);
//		if(phyDisabled.getSelectedToggle() == null) {flag=false;for(AdapterToggle i:phyDisabled.getToggles()) setInvalid((RadioButton)i);}
//		else for(AdapterToggle i:phyDisabled.getToggles()) setValid((RadioButton)i);
//		if(defence.getSelectedToggle() == null) {flag=false;for(AdapterToggle i:defence.getToggles()) setInvalid((RadioButton)i);}
//		else for(AdapterToggle i:defence.getToggles()) setValid((RadioButton)i);
//		if(fatherName.getText().trim().length() == 0) {flag=false;setInvalid(fatherName);}
//		else setValid(fatherName);
//		if(nationality.getValue() == null) {flag=false;setInvalid(nationality);}
//		else setValid(nationality);
//		if(permAddress.getText().trim().length() == 0) {flag=false;setInvalid(permAddress);}
//		else setValid(permAddress);
//		if(pincode.getText().trim().length() < 5 || pincode.getText().trim().length() > 6) {flag=false;setInvalid(pincode);}
//		else setValid(pincode);
//		return flag;
//	}
//
//	//Education Information : Page 2
//	private boolean validateEI()
//	{
//		boolean flag = true;
//
//		//Schooling Information
//		if(!xBoard.isDisabled() && xBoard.getText().trim().length() == 0) {flag=false;setInvalid(xBoard);}
//		else setValid(xBoard);
//		if(!xMarks.isDisabled() && (xMarks.getText().trim().length() == 0 || !checkDouble(xMarks.getText()) || Double.parseDouble(xMarks.getText()) > 100)) {flag=false;setInvalid(xMarks);}
//		else setValid(xMarks);
//		if(!xYear.isDisabled() && xYear.getText().trim().length() != 4) {flag=false;setInvalid(xYear);}
//		else setValid(xYear);
//		if(!xiiBoard.isDisabled() && xiiBoard.getText().trim().length() == 0) {flag=false;setInvalid(xiiBoard);}
//		else setValid(xiiBoard);
//		if(!xiiMarks.isDisabled() && (xiiMarks.getText().trim().length() == 0 || !checkDouble(xiiMarks.getText()) || Double.parseDouble(xiiMarks.getText()) > 100)) {flag=false;setInvalid(xiiMarks);}
//		else setValid(xiiMarks);
//		if(!xiiYear.isDisabled() && xiiYear.getText().trim().length() != 4) {flag=false;setInvalid(xiiYear);}
//		else setValid(xiiYear);
//
//		//Graduation Information
//		if(gradDegree.getText().trim().length() == 0) {flag=false;setInvalid(gradDegree);}
//		else setValid(gradDegree);
//		if(gradDept.getText().trim().length() == 0) {flag=false;setInvalid(gradDept);}
//		else setValid(gradDept);
//		if(gradCollege.getText().trim().length() == 0) {flag=false;setInvalid(gradCollege);}
//		else setValid(gradCollege);
//		if(gradUniv.getText().trim().length() == 0) {flag=false;setInvalid(gradUniv);}
//		else setValid(gradUniv);
//		if(gradCity.getText().trim().length() == 0) {flag=false;setInvalid(gradCity);}
//		else setValid(gradCity);
//		if(gradState.getValue() == null) {flag=false;setInvalid(gradState);}
//		else setValid(gradState);
//		if(gradYear.getText().trim().length() != 4) {flag=false;setInvalid(gradYear);}
//		else setValid(gradYear);
//		if(gradPerformanceSelector.getSelectedToggle() == null) {flag=false;for(AdapterToggle i:gradPerformanceSelector.getToggles()) setInvalid((RadioButton)i);}
//		else for(AdapterToggle i:gradPerformanceSelector.getToggles()) setValid((RadioButton)i);
//		if(!gradPerformanceCGPA.isDisabled() && (gradPerformanceCGPA.getText().trim().length() == 0 || !checkDouble(gradPerformanceCGPA.getText()) || Double.parseDouble(gradPerformanceCGPA.getText()) > 10)) {flag=false;setInvalid(gradPerformanceCGPA);}
//		else setValid(gradPerformanceCGPA);
//		if(!gradPerformancePercentage.isDisabled() && (gradPerformancePercentage.getText().trim().length() == 0 || !checkDouble(gradPerformancePercentage.getText()) || Double.parseDouble(gradPerformancePercentage.getText()) > 100)) {flag=false;setInvalid(gradPerformancePercentage);}
//		else setValid(gradPerformancePercentage);
//
//		//Post Graduation Information
//		if(!pgDegree.isDisabled() && pgDegree.getText().trim().length() == 0) {flag=false;setInvalid(pgDegree);}
//		else setValid(pgDegree);
//		if(!pgThesis.isDisabled() && pgThesis.getText().trim().length() == 0) {flag=false;setInvalid(pgThesis);}
//		else setValid(pgThesis);
//		if(!pgDept.isDisabled() && pgDept.getText().trim().length() == 0) {flag=false;setInvalid(pgDept);}
//		else setValid(pgDept);
//		if(!pgCollege.isDisabled() && pgCollege.getText().trim().length() == 0) {flag=false;setInvalid(pgCollege);}
//		else setValid(pgCollege);
//		if(!pgUniv.isDisabled() && pgUniv.getText().trim().length() == 0) {flag=false;setInvalid(pgUniv);}
//		else setValid(pgUniv);
//		if(!pgCity.isDisabled() && pgCity.getText().trim().length() == 0) {flag=false;setInvalid(pgCity);}
//		else setValid(pgCity);
//		if(!pgState.isDisabled() && pgState.getValue() == null) {flag=false;setInvalid(pgState);}
//		else setValid(pgState);
//		if(!pgYear.isDisabled() && pgYear.getText().trim().length() != 4) {flag=false;setInvalid(pgYear);}
//		else setValid(pgYear);
//		if(!pgCgpaRB.isDisabled() && pgPerformanceSelector.getSelectedToggle() == null) {flag=false;for(AdapterToggle i:pgPerformanceSelector.getToggles()) setInvalid((RadioButton)i);}
//		else for(AdapterToggle i:pgPerformanceSelector.getToggles()) setValid((RadioButton)i);
//		if(!pgPerformanceCGPA.isDisabled() && (pgPerformanceCGPA.getText().trim().length() == 0 || !checkDouble(pgPerformanceCGPA.getText()) || Double.parseDouble(pgPerformanceCGPA.getText()) > 10)) {flag=false;setInvalid(pgPerformanceCGPA);}
//		else setValid(pgPerformanceCGPA);
//		if(!pgPerformancePercentage.isDisabled() && (pgPerformancePercentage.getText().trim().length() == 0 || !checkDouble(pgPerformancePercentage.getText()) || Double.parseDouble(pgPerformancePercentage.getText()) > 100)) {flag=false;setInvalid(pgPerformancePercentage);}
//		else setValid(pgPerformancePercentage);
//
//		//Other Academic Degrees
//		if(oAApplicable.isSelected())
//		{
//			if(!oADegree.isDisabled() && oADegree.getText().trim().length() == 0) {flag=false;setInvalid(oADegree);}
//			else setValid(oADegree);
//			if(!oASubject.isDisabled() && oASubject.getText().trim().length() == 0) {flag=false;setInvalid(oASubject);}
//			else setValid(oASubject);
//			if(!oAYear.isDisabled() && oAYear.getText().trim().length() != 4) {flag=false;setInvalid(oAYear);}
//			else setValid(oAYear);
//			if(!oACollege.isDisabled() && oACollege.getText().trim().length() == 0) {flag=false;setInvalid(oACollege);}
//			else setValid(oACollege);
//			if(!oAPerformance.isDisabled() && (oAPerformance.getText().trim().length() == 0 || !checkDouble(oAPerformance.getText()) || Double.parseDouble(oAPerformance.getText()) > 100)) {flag=false;setInvalid(oAPerformance);}
//			else setValid(oAPerformance);
//		}
//
//		//GATE
//		if(gateApplicable.isSelected())
//		{
//			if(!gateArea.isDisabled() && gateArea.getText().trim().length() == 0) {flag=false;setInvalid(gateArea);}
//			else setValid(gateArea);
//			if(!gateYear.isDisabled() && gateYear.getText().trim().length() != 4) {flag=false;setInvalid(gateYear);}
//			else setValid(gateYear);
//			if(!gatePercentage.isDisabled() && (gatePercentage.getText().trim().length() == 0 || !checkDouble(gatePercentage.getText()) || Double.parseDouble(gatePercentage.getText()) > 100)) {flag=false;setInvalid(gatePercentage);}
//			else setValid(gatePercentage);
//			if(!gateScore.isDisabled() && gateScore.getText().trim().length() == 0) {flag=false;setInvalid(gateScore);}
//			else setValid(gateScore);
//			if(!gateRank.isDisabled() && (gateRank.getText().trim().length() == 0 || Integer.parseInt(gateRank.getText()) <= 0)) {flag=false;setInvalid(gateRank);}
//			else setValid(gateRank);
//		}
//
//		//Miscellaneous
//		if(cvUploadLabel.getText().equals("No File Selected")) {flag=false;setInvalid(cvUpload);}
//		else setValid(cvUpload);
//		if(sopUploadLabel.getText().equals("No File Selected")) {flag=false;setInvalid(sopUpload);}
//		else setValid(sopUpload);
//
//		return flag;
//	}

	//Feedback and Submit : Page 3
//	private boolean validateFS()
//	{
//		boolean flag = true;
//		if(feedbackQ1.getValue() == null) {flag=false;setInvalid(feedbackQ1);}
//		else setValid(feedbackQ1);
//		if(!(feedbackQ2op1.isSelected() || feedbackQ2op2.isSelected() || feedbackQ2op3.isSelected() || feedbackQ2op4.isSelected() || feedbackQ2op5.isSelected() || feedbackQ2op6.isSelected() || feedbackQ2op7.isSelected() || feedbackQ2op8.isSelected() || feedbackQ2op9.isSelected() || feedbackQ2op10.isSelected()))
//		{
//			flag = false;
//			setInvalid(feedbackQ2op1);
//			setInvalid(feedbackQ2op2);
//			setInvalid(feedbackQ2op3);
//			setInvalid(feedbackQ2op4);
//			setInvalid(feedbackQ2op5);
//			setInvalid(feedbackQ2op6);
//			setInvalid(feedbackQ2op7);
//			setInvalid(feedbackQ2op8);
//			setInvalid(feedbackQ2op9);
//			setInvalid(feedbackQ2op10);
//		}
//		else
//		{
//			setValid(feedbackQ2op1);
//			setValid(feedbackQ2op2);
//			setValid(feedbackQ2op3);
//			setValid(feedbackQ2op4);
//			setValid(feedbackQ2op5);
//			setValid(feedbackQ2op6);
//			setValid(feedbackQ2op7);
//			setValid(feedbackQ2op8);
//			setValid(feedbackQ2op9);
//			setValid(feedbackQ2op10);
//		}
//		return flag;
//	}

	//Superclass Valid/Invalid CSS Apply method
//	private void setValid(Control control) {control.setStyle("-fx-border-color: none;");}
//	private void setInvalid(Control control) {control.setStyle("-fx-border-color: red;");}
	private boolean checkDouble(String s)
	{
		if(s.matches("[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*"))
		{
			return (Double.parseDouble(s) >= 0);
		}
		return false;
	}

	//Prefetch : Fills Saved Data in Form
	/*public void prefetchData(Applicant A)
	{
		//Page 1: Personal Information
		PersonalInformation pi = A.getPersonalInformation();
		if(pi!=null)
		{
			name.setText(pi.getApplicantName());
			email.setText(pi.getEmail());
			enrollmentNumber.setText(pi.getEnrollmentNo());
			corrAddress.setText(pi.getCorrespondenceAddress());
			mobNumber.setText(pi.getMobileNo());
			dobField.setValue(pi.getDateOfBirth());
			phdStreamSelector.getToggles().get(pi.getStream()).setSelected(true);
			setStreamSpecialisation();
			if(pi.getPreferences()[0] != null) preferences1.setValue(pi.getPreferences()[0]);
			if(pi.getPreferences()[1] != null) preferences2.setValue(pi.getPreferences()[1]);
			if(pi.getPreferences()[2] != null) preferences3.setValue(pi.getPreferences()[2]);
//			 private AdapterChoiceBox<String> gender;
//			 private AdapterChoiceBox<String> category;
//			 private AdapterToggleGroup phyDisabled;
//			 private AdapterToggleGroup defence;
//			 private AdapterTextField fatherName;
//			 private AdapterTextField nationality;
//			 private AdapterTextArea permAddress;
//			 private AdapterTextField pincode;
//			 private Button p_info_saveButton;
		}
	}*/
}	