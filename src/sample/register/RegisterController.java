package sample.register;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.util.Duration;
import jdk.nashorn.internal.scripts.JD;
import sample.Main;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.SQLTools.Checks;
import javafx.scene.control.Label;
import sample.SQLTools.JDBCTools;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Properties;

public class RegisterController implements Initializable {
    @FXML
    private Button Register;
    @FXML
    private ImageView registerBack;
    @FXML
    private TextField registUserName;
    @FXML
    private PasswordField registPassword;
    @FXML
    private PasswordField registConfirmPassword;
    @FXML
    private Label veryficationCode;
    @FXML
    private TextField probAnswer;
    @FXML
    private Label registErrorInfo;
    String operation = " ";
    java.util.List<Integer> l = null;

    public Main mainApp = new Main();
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerBack.setImage(new Image("file:images/back.png"));
        this.l = Checks.randomProbs();
        int cal = l.get(0);

        switch (cal) {
            case 0:
                operation = " + ";
                break;
            case 1:
                operation = " - ";
                break;
            case 2:
                operation = " * ";
                break;
            case 3:
                operation = " / ";
                break;
            default:
                break;
        }
        String temp = l.get(1) + operation + l.get(2) + " = ";
        veryficationCode.setText(temp);
    }

    @FXML
    public void handleRegisterButton() {
        String userName = registUserName.getText();
        String password = registPassword.getText();
        String confirmPwd = registConfirmPassword.getText();
        String answer = probAnswer.getText().trim();
        if (answer.isEmpty())
            answer = "-1";
        boolean flag1 = true;
        if (Checks.checkNamePwd(userName, password) == false) {
            flag1 = false;
            registErrorInfo.setText("用户名或密码格式不正确");
        }
        else if (!password.equals(confirmPwd)) {
            flag1 = false;
            registErrorInfo.setText("密码不同");
        }
        else if (JDBCTools.checkUser(userName) != null) {
            flag1 = false;
            registErrorInfo.setText("该用户已存在");
        }
        else if (Checks.verifyProbs(l) != Integer.parseInt(answer)) {
            flag1 = false;
            registErrorInfo.setText("验证码错误");
        }

        if (flag1) {
            Properties p = new Properties();
            FileInputStream in;
            String databaseName = " ";
            try {
                in = new FileInputStream("sql.properties");
                p.load(in);
                databaseName = p.getProperty("databaseName");
            }
            catch (FileNotFoundException f) {
                f.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            String sql = "insert into " + databaseName + "(name, password) values(" + userName +", " + password + ")";
            JDBCTools.insertUser(sql);
            registErrorInfo.setText("注册成功，请返回登陆界面");
        }
        else {
            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.seconds(0.1));
            ft.setNode(mainApp.getScene().getRoot());
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.play();
        }
    }
    @FXML
    public void handleRegisterBackButton() {
        mainApp.showLoginView();
    }
}
