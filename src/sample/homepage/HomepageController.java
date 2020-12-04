package sample.homepage;

import sample.Main;
import sample.Model.*;
import sample.SQLTools.*;
import sample.SQLTools.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.animation.FadeTransition;
import javafx.util.Duration;


public class HomepageController implements Initializable {
    @FXML
    private Button signUp;
    @FXML
    private Button login;
    @FXML
    private TextField userNameInput;
    @FXML
    private PasswordField passwordInput;
    @FXML
    private ImageView superShiro;
    @FXML
    private ImageView lockIcon;
    @FXML
    private ImageView userIcon;
    @FXML
    private Label errorLabel;

    public Main mainApp = new Main();
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        superShiro.setImage(new Image("file:images/IMG_0005.PNG"));
        lockIcon.setImage(new Image("file:images/uniE6C0.png"));
        userIcon.setImage(new Image("file:images/uniE90E.png"));
    }

    @FXML
    public void handleLoginButton() {
        String userName = userNameInput.getText();
        String password = passwordInput.getText();
        if (Checks.checkNamePwd(userName, password)) {
            User user = JDBCTools.getUser(userName, password);
            if (user == null) {
                errorLabel.setText("Username/Password error");
                userNameInput.clear();
                passwordInput.clear();
                FadeTransition ft = new FadeTransition();
                ft.setDuration(Duration.seconds(0.1));
                ft.setNode(mainApp.getScene().getRoot());
                ft.setFromValue(0);
                ft.setToValue(1);
                ft.play();
            }
            else {
                mainApp.showSystemView();
            }
        }
        else {
            errorLabel.setText("Username/Password format error");
            userNameInput.clear();
            passwordInput.clear();
            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.seconds(0.1));
            ft.setNode(mainApp.getScene().getRoot());
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.play();
        }
    }
    @FXML
    public void handleRegisterButton() {
        mainApp.showRegisterView();
    }
}
