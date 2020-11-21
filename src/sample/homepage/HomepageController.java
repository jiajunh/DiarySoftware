package sample.homepage;

import sample.Main;
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
        mainApp.showSystemView();
    }
    @FXML
    public void handleRegisterButton() {
        mainApp.showRegisterView();
    }
}
