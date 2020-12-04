package sample.writeDiary;

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

public class WriteDiaryController implements Initializable {
    @FXML
    private Button writeSave;
    @FXML
    private Button writeCancel;

    public Main mainApp = new Main();
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void handleWriteSaveButton() {

    }
    @FXML
    public void handleWriteCancelButton() {
        mainApp.showSystemView();
    }

}
