package ui.manager;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.login.LoginController;

public class AppLoader extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Sample CMS");
        primaryStage.setResizable(true);
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("Login.fxml"));
            loader.setController(LoginController.ctrl);
            Scene scene = new Scene((Pane) loader.load());
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.show();
	}
	
	public static void main() {
		launch(new String [] {});
	}
}
