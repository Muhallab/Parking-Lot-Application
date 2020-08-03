/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingLot;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author almuh
 */
public class ManagerState extends AppState{
    Scene managerScene;
	@Override
	public void setGUI(ParkingApp app){
		Pane managerPane = new Pane();
		managerScene = new Scene(managerPane, 300, 250);
		
		Label managerScreenLabel = new Label();
		setDimensions(managerScreenLabel, 10, 0, 280, managerPane);
		managerScreenLabel.setText("Manager Ticket Center");
		managerScreenLabel.setAlignment(Pos.CENTER);
		managerScreenLabel.setFont(new Font("Calibri", 20));
		
		Line topLineBreak = new Line();
		topLineBreak.setStartX(0);
		topLineBreak.setEndX(300);
		topLineBreak.setStartY(35);
		topLineBreak.setEndY(35);
		managerPane.getChildren().add(topLineBreak);
		
		Label ticketNumberLabel = new Label();
		setDimensions(ticketNumberLabel, 10, 50, 135, managerPane);
		ticketNumberLabel.setText("Ticket Number");
		ticketNumberLabel.setAlignment(Pos.CENTER_RIGHT);
		ticketNumberLabel.setFont(new Font("Calibri", 20));
		
		TextField ticketNumberField = new TextField();
		setDimensions(ticketNumberField, 155, 50, 135, managerPane);
               
                Button modifyTicketButton = new Button();
		setDimensions(modifyTicketButton, 10, 100, 280, managerPane);
		modifyTicketButton.setText("Modify Ticket");
//        	createUserButton.setOnAction(new createUserEventHandler( ticketNumberField));
		
		Button createUserButton = new Button();
		setDimensions(createUserButton, 10, 130, 280, managerPane);
		createUserButton.setText("Delete Ticket");
		createUserButton.setOnAction(new deleteUserEventHandler(ticketNumberField));
		
		Button deleteUserButton = new Button();
		setDimensions(deleteUserButton, 10, 160, 280, managerPane);
		deleteUserButton.setText("Add Ticket");
//		deleteUserButton.setOnAction(new deleteUserEventHandler(usernameField));
		
		Line bottomLineBreak = new Line();
		bottomLineBreak.setStartX(0);
		bottomLineBreak.setEndX(300);
		bottomLineBreak.setStartY(200);
		bottomLineBreak.setEndY(200);
		managerPane.getChildren().add(bottomLineBreak);
		
		Button loginButton = new Button();
		setDimensions(loginButton, 10, 210, 280, managerPane);
		loginButton.setText("Logout");
		loginButton.setOnAction(new logoutEventHandler());
		
		app.stage1.setTitle("Manager Screen");
		app.stage1.setScene(managerScene);
		app.stage1.show();
	}
	
	private static class createUserEventHandler implements EventHandler<ActionEvent> {
		private final TextField ticketNumberField;
		public createUserEventHandler(TextField ticketNumberField) {
			this.ticketNumberField = ticketNumberField;
		}
		@Override
		public void handle(ActionEvent e) {
			//Check if file exists
                        
//			if(ticketNumberField.getText().matches("[a-zA-Z0-9]+") && passwordField.getText().matches("[a-zA-Z0-9]+")){
//				File file = new File(ParkingApp.getSingleton().currentDirectory + usernameField.getText() + ".txt");
//				System.out.println(usernameField.getText());
//				if(file.exists()){
//					Alert duplicateUserError = new Alert(Alert.AlertType.NONE, "User creation failed - Only unique usernames allowed", ButtonType.OK);
//					duplicateUserError.setTitle("Account Creation Attempt Detected");
//					duplicateUserError.showAndWait();
//				}else{
//					try{
//						List<String> lines = Arrays.asList(""+passwordField.getText()+"",""+100.00+"");
//						Path path = Paths.get(ParkingApp.getSingleton().currentDirectory + usernameField.getText() + ".txt");
//						Files.write(path, lines, StandardCharsets.UTF_8);
//						Alert userCreationSuccess = new Alert(Alert.AlertType.NONE, "User creation success - User created with $100.00", ButtonType.OK);
//						userCreationSuccess.setTitle("Account Creation Attempt Detected");
//						userCreationSuccess.showAndWait();
//					}catch(IOException error){
//						Alert fileCreationError = new Alert(Alert.AlertType.NONE, "User creation failed - File Creation Error", ButtonType.OK);
//						fileCreationError.setTitle("Account Creation Attempt Detected");
//						fileCreationError.showAndWait();
//					}
//				}
//			}else{
//				System.out.println(usernameField.getText().matches("[a-zA-Z0-9]+"));
//				System.out.println(passwordField.getText().matches("[a-zA-Z0-9]+"));
//				Alert userInputError = new Alert(Alert.AlertType.NONE, "User creation failed - Only alphanumerics allowed in username & password", ButtonType.OK);
//				userInputError.setTitle("Account Creation Attempt Detected");
//				userInputError.showAndWait();
//			}
		}
	}
	
	private static class deleteUserEventHandler implements EventHandler<ActionEvent> {
		private final TextField ticketNumber;
		public deleteUserEventHandler(TextField ticketNumber) {
			this.ticketNumber = ticketNumber;
		}
		@Override
		public void handle(ActionEvent e) {
			File file = new File(ParkingApp.getSingletonMain().currentDirectory + ticketNumber.getText() + ".txt");
			if(file.exists()){
				file.delete();
				Alert userDeletionSuccess = new Alert(Alert.AlertType.NONE, "Ticket deletion success - Ticket file deleted", ButtonType.OK);
				userDeletionSuccess.setTitle("Ticket Deletion Attempt Detected");
				userDeletionSuccess.showAndWait();
			}else{
				Alert userNotFoundError = new Alert(Alert.AlertType.NONE, "Ticket deletion failed - Ticket not found", ButtonType.OK);
				userNotFoundError.setTitle("Ticket Deletion Attempt Detected");
				userNotFoundError.showAndWait();
			}
		}
	}
	
	private static class logoutEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Alert logoutDetected = new Alert(Alert.AlertType.NONE, "Logging out...", ButtonType.OK);
			logoutDetected.setTitle("Logout Attempt Detected");
			logoutDetected.showAndWait();
			ParkingApp.getSingletonMain().setState(new EntrancePanel());
		}
	}	
	
	private static void setDimensions(Control c, int positionX, int positionY, int width, Pane pane){
		c.setMaxHeight(30);
		c.setMinHeight(30);
		c.setMaxWidth(width);
		c.setMinWidth(width);
		c.setLayoutX(positionX);
		c.setLayoutY(positionY);
		pane.getChildren().add(c);
	}
}
