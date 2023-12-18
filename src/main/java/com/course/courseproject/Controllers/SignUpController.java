package com.course.courseproject.Controllers;

import com.course.courseproject.DatabaseHandler;
import com.course.courseproject.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        DatabaseHandler dbHandler = new DatabaseHandler();

        String login = loginField.getText();
        String password = passField.getText();

        User user = new User(login, password);

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
        }
        else {
            System.out.println("Wrong password confirmation");

            passField.setText("");
            passConfField.setText("");
        }
    }
}
