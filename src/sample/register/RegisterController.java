package sample.register;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import sample.Main;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private Button Register;
    @FXML
    private ImageView registerBack;

    public Main mainApp = new Main();
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerBack.setImage(new Image("file:images/back.png"));
    }

    @FXML
    public void handleRegisterButton() {
        mainApp.showSystemView();
    }
    @FXML
    public void handleRegisterBackButton() {
        mainApp.showLoginView();
    }
}
