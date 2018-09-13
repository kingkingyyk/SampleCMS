package ui.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import ui.manager.AppLoader;

public class Dummy implements Initializable{
    public static Dummy dummy=new Dummy();
    @FXML private Label lblDisplay;
    @FXML private Button btnGoBack;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }
    
    @FXML
    public void goBackLOL() {
    	AppLoader.drawFormOnMainWindow("Login.fxml", new LoginController());
    }
}
