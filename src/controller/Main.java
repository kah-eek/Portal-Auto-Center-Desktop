package controller;

import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import utils.Utils;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {

	// Get fields from window
	@FXML TextField txtUsername;
	@FXML TextField txtPassword;

    static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;

		// open main window
		Main.openWindow("Main", null);

	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Open system's windows
	 * @param xmlFile
	 */
	static public void openWindow(String xmlFile, Object controller)
	{
		try {

			// try to load XML file
			FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../view/"+xmlFile+".fxml"));

			// Verify if is to set controller into FXML file
			if(controller != null)
			{
				fxmlLoader.setController(controller);
			}

			// create the scene
			Scene scene = new Scene(fxmlLoader.load());

			// set scene on window
			primaryStage.setScene(scene);

			// start window on "full screen" mode
			primaryStage.setMaximized(true);

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
				// Get user's information from DB
				User user = User.getUser(txtUsername.getText(), txtPassword.getText());

				// Get employee's information from DB
				Employee employee = new Employee().getEmployeesInformation(user.getIdUsuario());

				// Go to home page
				Main.openWindow("Home", new Home(employee));
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
