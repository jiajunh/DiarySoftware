package sample;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import sample.findDiary.FindDiaryController;
import sample.homepage.HomepageController;
import sample.register.RegisterController;
import sample.system.SystemControl;
import sample.writeDiary.WriteDiaryController;
import sample.Model.*;

public class Main extends Application {
    private Stage stage;
    private Scene scene;
    private User user;

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            showLoginView();
            primaryStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLoginView() {
        try {
            stage.setTitle("Login");
            HomepageController hpController = (HomepageController) replaceSceneContent("/sample/homepage/Homepage.fxml");
            hpController.setMainApp(this);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void showSystemView() {
        try {
            stage.setTitle("Options");
            SystemControl sController = (SystemControl) replaceSceneContent("/sample/system/System.fxml");
            sController.setMainApp(this);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void showRegisterView() {
        try {
            stage.setTitle("Sign Up");
            RegisterController rController = (RegisterController) replaceSceneContent("/sample/register/Register.fxml");
            rController.setMainApp(this);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void showWriteDiaryView() {
        try {
            stage.setTitle("Write Diary");
            WriteDiaryController wdController = (WriteDiaryController) replaceSceneContent("/sample/writeDiary/WriteDiary.fxml");
            wdController.setMainApp(this);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void showFindDiaryView() {
        try {
            stage.setTitle("Find Diary");
            FindDiaryController wdController = (FindDiaryController) replaceSceneContent("/sample/findDiary/FindDiary.fxml");
            wdController.setMainApp(this);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private Object replaceSceneContent(String fxmlFile) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(fxmlFile));
        AnchorPane ap = null;
        try {
            ap = (AnchorPane)loader.load();
        }catch(IOException e) {
            e.printStackTrace();
        }
        scene = new Scene(ap);
        stage.setScene(scene);
        stage.setResizable(false);
        return loader.getController();
    }

    public Scene getScene() {
        return scene;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User u) {
        this.user = u;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
