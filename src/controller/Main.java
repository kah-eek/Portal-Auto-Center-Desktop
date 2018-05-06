package controller;
	
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utils.Utils;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;


public class Main extends Application {
	
	// get fields from window
	@FXML TextField txtUsername;
	@FXML TextField txtPassword;
	
    static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		
		// open main window
		Main.openWindow("Main");
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Open system's windows 
	 * @param xmlFile
	 */
	static public void openWindow(String xmlFile)
	{
		// main windows
		Parent window;
		
		try {
			
			// try to load XML file into variable
			window = FXMLLoader.load(Main.class.getResource("../view/"+xmlFile+".fxml"));
			
			// create the scene
			Scene scene = new Scene(window);
			
			// set scene on window
			primaryStage.setScene(scene);
			
			// start window on "full screen" mode
			//primaryStage.setMaximized(true);
				
			// disable resizable option
			primaryStage.setResizable(false);
			
			// set window's title
			primaryStage.setTitle("Portal Auto Center");
			
			// set window icon
			primaryStage.getIcons().add(new Image("/resources/pictures/logo/portal_auto_center_icon.png"));
			
			// show the window
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	// ********************** Controller *********************************
	
	@FXML public void signIn()
	{
		if(txtUsername.getText().isEmpty())
		{
			txtUsername.setStyle("-fx-background-color: #D50000");
		}
		else if(txtPassword.getText().isEmpty())
		{
			txtPassword.setStyle("-fx-background-color: #D50000");
		}
		else
		{
			// Create authentication object with data to authenticate
			Authentication authentication = new Authentication(txtUsername.getText(),txtPassword.getText());
			
			// Verifies if exists the authentication
			if(authentication.existentCredential(authentication))
			{
				// Go to home page
				Main.openWindow("Home");
			}
			else
			{
				// Shows message about the wrong authentication
				Utils.showError
				(
					null,
					"Autenticação",
					"Usuário ou senha incorreto!"
				);
			}
		}
		
	}
	
	@FXML public void cleanUsernameField()
	{
		txtUsername.setStyle("-fx-background-color: #ffffff");
	}
	
	@FXML public void cleanPasswordField()
	{
		txtPassword.setStyle("-fx-background-color: #ffffff");
	}
	
	// **********************************************
	
}
