package sample.system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import sample.Main;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class SystemControl implements Initializable {
    @FXML
    private Button readDiary;
    @FXML
    private Button writeDiary;
    @FXML
    private Label logOut;


    public Main mainApp = new Main();
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void handleLogOutLabel() {
        mainApp.showLoginView();
    }
    @FXML
    public void handleWriteDiaryButton() {
        mainApp.showWriteDiaryView();
    }
    @FXML
    public void handleReadDiaryButton() {
        mainApp.showFindDiaryView();
    }
}
