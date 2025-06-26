package WeatherApplication;
	
import java.io.IOException;
import javafx.util.Duration;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@FXML
	private AnchorPane mainPane;
	private Scene splashScreen;
	private Scene mainScene;
	
	
	public static void main(String[] args) {
		// runs the application
		Application.launch();
	}
	
	

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoadingScreen.fxml"));
		Parent root = loader.load();
		splashScreen = new Scene(root);
		splashScreen.getStylesheets().add(getClass().getResource("loadingScreen.css").toExternalForm());
		Image icon = new Image("favicon.png");
		stage.getIcons().add(icon);
		stage.setScene(splashScreen);
		stage.setMinHeight(500);
		stage.setMinWidth(800);
		stage.setResizable(false);
		stage.setTitle("SkyDesk Weather");
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
		
		
		
		
		 // Wait 5 seconds, then load main scene
	    PauseTransition pause = new PauseTransition(Duration.seconds(3));
	    pause.setOnFinished(event -> {
	        try {
	            // Load main scene
	            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("theWeatherApp.fxml"));
	            Parent mainRoot = mainLoader.load();
	            mainScene = new Scene(mainRoot);
	            mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	            stage.setScene(mainScene);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    });
	    pause.play();
	    
	}
	
	
}
