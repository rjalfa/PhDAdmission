package ap.adm.phd.controller;

import java.io.IOException;

import ap.adm.phd.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/*
 * @author Rounaq Jhunjhunu Wala 2014089
 * @author Ambar Pal 2014012
 */

public class RootLayoutController {
	
	private MainApp mainApp;
	private BorderPane rootLayout;
	@FXML private void showApplicantUI()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ApplicantForm.fxml"));
			AnchorPane applicantForm;
			applicantForm = (AnchorPane) loader.load();
			rootLayout.setCenter(applicantForm);
			
			ApplicantFormController controller = loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML public void showAdminUI()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/AdminEntryFilter.fxml"));
			AnchorPane applicantForm;
			applicantForm = (AnchorPane) loader.load();
			rootLayout.setCenter(applicantForm);
			
			AdminFilterController controller = loader.getController();
			controller.setMainApp(mainApp);
			controller.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML private void exitApp()
	{
		Platform.exit();
	}
	
	public void oafr()
	{
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/AdminFilterResults.fxml"));
			AnchorPane applicantForm;
			applicantForm = (AnchorPane) loader.load();
			rootLayout.setCenter(applicantForm);
			
			AdminFilterResultsController controller = loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML private void aboutDialog()
	{
		StackPane A = new StackPane();
		Text message = 	new Text("Creators: Rounaq Jhunjhunu Wala and Ambar Pal\nThis software is sole property of its creators and copyrighted to the same.\nAP Project 2015");
		message.setFont(new Font(24));
		A.getChildren().add(message);
		/*
		Alert alert = new Alert(AlertType.INFORMATION)
		alert.setWidth(300);
		alert.setHeight(400);
		alert.initOwner(mainApp.getPrimaryStage());
		alert.setTitle("About PhDAdmissions");
		alert.setHeaderText("About");
		alert.setContentText("Creators: Rounaq Jhunjhunu Wala and Ambar Pal\nThis software is sole property of its creators and copyrighted to the same.\nAP Project 2015");
		alert.showAndWait();
		*/
		rootLayout.setCenter(A);
	}
	
	public void setMainApp(MainApp mainApp,BorderPane rootLayout)
	{
		this.mainApp = mainApp;
		this.rootLayout = rootLayout;
	}
	
	@FXML private void helpDialog()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setWidth(300);
		alert.setHeight(400);
		alert.initOwner(mainApp.getPrimaryStage());
		alert.setTitle("PhDAdmissions | Help");
		alert.setHeaderText("Help");
		alert.setContentText("Help not found.");
		alert.showAndWait();
	}
	
}
