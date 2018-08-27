package ui.login;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.kingkingyyk.SampleCMS;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.User;

public class LoginController implements Initializable{
	public static LoginController ctrl=new LoginController();
	@FXML private TextField textFieldUsername;
	@FXML private PasswordField passwordField;
	@FXML private Label lblStatus;
	@FXML private Button btnLogin;
	@FXML private Button btnQuit;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	private boolean userExists() {
		/*
		 * SELECT * FROM USER WHERE USERNAME=abc AND PASSWORD=def
		 */
		CriteriaBuilder cb=SampleCMS.session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> from=criteria.from(User.class);
		criteria.select(from);
		criteria.where(cb.and(
							cb.equal(from.get("username"), textFieldUsername.getText()),
							cb.equal(from.get("password"), passwordField.getText())
							)
						);
		return SampleCMS.session.createQuery(criteria).getResultList().size() == 1;
	}
	
	@FXML
	private void onLoginClicked() {
		if (textFieldUsername.getText().length() == 0) setStatusText("Username must not be empty!", "red");
		else if (passwordField.getText().length() == 0) setStatusText("Password must not be empty!", "red");
		else if (!userExists()) setStatusText("Credential is incorrect!", "red");
		else setStatusText("Welcome back "+textFieldUsername.getText()+"!", "green");
	}
	
	@FXML
	private void onQuitClicked() {
		Platform.exit();
		System.exit(0);
	}
	
	private void setStatusText(String s, String color) {
		Platform.runLater(() -> { 
			lblStatus.setText(s);
			lblStatus.setTextFill(Color.web(color));
		});
	}
}
