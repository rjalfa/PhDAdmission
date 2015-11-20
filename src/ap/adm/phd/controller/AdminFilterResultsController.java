package ap.adm.phd.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ap.adm.phd.MainApp;
import ap.adm.phd.model.Applicant;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */

public class AdminFilterResultsController implements Initializable
{
	MainApp mainApp;
	@FXML private TableView<Applicant> filteredResult;
	@FXML private TableColumn<Applicant,String> enrollColumn;
	@FXML private TableColumn<Applicant,String> nameColumn;
	@FXML private TableColumn<Applicant,HBox> datalinkColumn;
	
	public void setMainApp(MainApp mainApp)
	{
		this.mainApp = mainApp;
		filteredResult.setItems(mainApp.filteredApplicants);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		filteredResult.setVisible(true);
		enrollColumn.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getPersonalInformation().getEnrollmentNo())));
		nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty((cellData.getValue().getPersonalInformation().getApplicantName())));
		datalinkColumn.setCellValueFactory(cellData -> buttonArray(cellData));
	}
	
	private SimpleObjectProperty<HBox> buttonArray(CellDataFeatures<Applicant, HBox> cellData)
	{
		Button btn1 = new Button("DATA");
		Button btn2 = new Button("CV");
		Button btn3 = new Button("SOP");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent e) {
			mainApp.hostServices.showDocument(System.getProperty("user.dir")+"/data/DATA" + cellData.getValue().getPersonalInformation().getEnrollmentNo() + "/applicantInformation.txt");
		}});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent e) {
				 mainApp.hostServices.showDocument(System.getProperty("user.dir")+"/"+cellData.getValue().getEducationInformation().getAchievements().getCv());
		}});
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent e) {
				 mainApp.hostServices.showDocument(System.getProperty("user.dir")+"/"+cellData.getValue().getEducationInformation().getAchievements().getSop());
		}});
		HBox t = new HBox();
		t.getChildren().add(btn1);
		t.getChildren().add(btn2);
		t.getChildren().add(btn3);
		return new SimpleObjectProperty<HBox>(t);
	}
	
	@FXML
	private void backPress()
	{
		mainApp.openAdminUI();
	}
}
