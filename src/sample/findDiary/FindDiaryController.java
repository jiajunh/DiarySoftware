package sample.findDiary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.omg.CORBA.INITIALIZE;
import javafx.scene.image.ImageView;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class FindDiaryController implements Initializable {
    @FXML
    private ImageView searchIcon;

    public Main mainApp = new Main();
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchIcon.setImage(new Image("file:images/search.png"));
    }

}
