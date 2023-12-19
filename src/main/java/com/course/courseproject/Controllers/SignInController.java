package com.course.courseproject.Controllers;

import com.course.courseproject.Consts.UserConst;
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
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInController {

    @FXML
    protected Button toSignUpBtn;

    @FXML
    protected TextField loginField;

    @FXML
    protected TextField passField;

    @FXML
    protected Button loginBtn;

    @FXML
    protected Label incorrectLabel, emptyField1, emptyField2;

    @FXML
    protected void signUpBtnClicked() {
        toSignUpBtn.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/course/courseproject/signup_page.fxml"));

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
    protected void loginBtnClicked() throws SQLException {
        incorrectLabel.setVisible(false);
        emptyField1.setVisible(false);
        emptyField2.setVisible(false);
        String userLogin = loginField.getText().trim();
        String userPassword = passField.getText().trim();

        if(userLogin.isEmpty()){
            emptyField1.setVisible(true);
        }
        if (userPassword.isEmpty()){
            emptyField2.setVisible(true);
        }
        if(!userLogin.isEmpty() && !userPassword.isEmpty())
            loginUser(userLogin, userPassword);
        else
            System.out.println("Incorrect Login or Password!");
    }

    private void loginUser(String userLogin, String userPassword) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(userLogin);
        user.setPassword(userPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            user.setIdUser(result.getInt(UserConst.USERS_ID));
            counter++;
        }

        if(counter == 1) {
            System.out.println("Success!");
            loginBtn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/course/courseproject/feedback_page.fxml"));



            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1294.401, 720));
            stage.setResizable(false);
            FeedbackController fbController = loader.getController();
            fbController.getUser(user);
            stage.show();
        }else {
            incorrectLabel.setVisible(true);
        }
    }
}
