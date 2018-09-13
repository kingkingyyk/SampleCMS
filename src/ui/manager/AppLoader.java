package ui.manager;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.login.LoginController;

public class AppLoader extends Application {
	private static Stage myMainWindow;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.myMainWindow=primaryStage;
		primaryStage.setTitle("Sample CMS");
        primaryStage.setResizable(true);
        AppLoader.drawFormOnMainWindow("Login.fxml", LoginController.ctrl);
        primaryStage.show();
	}
	
	public static void drawFormOnMainWindow (String fxmlName, Initializable ctrl) {
		Platform.runLater( () -> {
	        try {
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(AppLoader.class.getClassLoader().getResource(fxmlName));
	            loader.setController(ctrl);
	            Scene scene = new Scene((Pane) loader.load());
	            AppLoader.myMainWindow.setScene(scene);
	            AppLoader.myMainWindow.sizeToScene();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		});
	}
	
	public static void main() {
		launch(new String [] {});
	}
}
