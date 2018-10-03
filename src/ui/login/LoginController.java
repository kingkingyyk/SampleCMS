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
import model.People.Staff;
import ui.People.HumanController;
import ui.SubjectEnrollment.MonthlyTSFeeController;
import ui.manager.AppLoader;

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
		CriteriaQuery<Staff> criteria = cb.createQuery(Staff.class);
		Root<Staff> from=criteria.from(Staff.class);
		criteria.select(from);
		criteria.where(cb.equal(from.get("username"), textFieldUsername.getText()));
		for (Staff s : SampleCMS.session.createQuery(criteria).getResultList()) if (s.isPasswordMatch(passwordField.getText())) return true;
		return false;
	}
	
	@FXML
	private void onLoginClicked() {
	    /*
		if (textFieldUsername.getText().length() == 0) setStatusText("Username must not be empty!", "red");
		else if (passwordField.getText().length() == 0) setStatusText("Password must not be empty!", "red");
		else if (!userExists()) setStatusText("Credential is incorrect!", "red");
		else {
			AppLoader.drawFormOnMainWindow("People.fxml", HumanController.ctrl);
			//setStatusText("Welcome back "+textFieldUsername.getText()+"!", "green");
		}
		*/
        //AppLoader.drawFormOnMainWindow("People.fxml", HumanController.ctrl);
		AppLoader.drawFormOnMainWindow("MonthlyTSFee.fxml", MonthlyTSFeeController.ctrl);

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
