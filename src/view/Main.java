package view;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
    static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		
		// open main window
		Main.openWindow("Home");
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
			window = FXMLLoader.load(Main.class.getResource(xmlFile+".fxml"));
			
			// create the scene
			Scene scene = new Scene(window);
			
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
	
}
