package com.course.courseproject.Controllers;

import com.course.courseproject.DatabaseHandler;
import com.course.courseproject.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    protected Button toSignInBtn;

    @FXML
    protected TextField loginField;

    @FXML
    protected TextField passField;

    @FXML
    protected TextField passConfField;

    @FXML
    protected Label incorrectLabel, emptyField1, emptyField2, incorrectLogin;

    @FXML
    protected Button signUpBtn;

    @FXML
    protected void signInBtnClicked() {
        toSignInBtn.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/course/courseproject/signin_page.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 500));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    protected void signUpBtnClicked() {
        incorrectLabel.setVisible(false);
        emptyField1.setVisible(false);
        emptyField2.setVisible(false);

        DatabaseHandler dbHandler = new DatabaseHandler();

        String login = loginField.getText().trim();
        String password = passField.getText().trim();

        User user = new User(login, password);

        if(login.isEmpty()){
            emptyField1.setVisible(true);
        }
        if (password.isEmpty()){
            emptyField2.setVisible(true);
        }
        if(!login.isEmpty() && !password.isEmpty() && !dbHandler.getUserById(user)) {
            if (passField.getText().equals(passConfField.getText())) {
                dbHandler.signUpUser(user);

                signUpBtn.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/course/courseproject/signin_page.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 600, 500));
                stage.setResizable(false);
                stage.show();
            } else {
                incorrectLabel.setVisible(true);
                passField.setText("");
                passConfField.setText("");
            }
        } else {
            incorrectLogin.setVisible(true);
            loginField.setText("");
            passField.setText("");
            passConfField.setText("");
        }
    }

    @FXML
    protected void labelHideLogin() {
        emptyField1.setVisible(false);
        incorrectLogin.setVisible(false);
    }

    @FXML
    protected void labelHidePass() {
        emptyField2.setVisible(false);
    }

    @FXML
    protected void labelHidePassConf() {
        incorrectLabel.setVisible(false);
    }
}
