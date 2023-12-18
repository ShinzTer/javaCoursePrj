package com.course.courseproject.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoPageL7Controller {

    @FXML
    protected Button l7Feedback;

    @FXML
    protected Button l7Main;

    @FXML
    protected Button l7Author;

    @FXML
    protected Button l7Forward;

    @FXML
    protected void onL7AuthorClick() {
        l7Author.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/course/courseproject/author_page.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 1000, 625));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    protected void onL7FeedbackClick() {
        l7Feedback.getScene().getWindow().hide();
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
    protected void onL7MainClick() {
            l7Main.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/course/courseproject/about_page.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1294.401, 820));
            stage.setResizable(false);
            stage.show();
    }

    @FXML
    protected void onL7ForwardClick() {
            l7Forward.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/course/courseproject/info_page_sh.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1294.401, 780));
            stage.setResizable(false);
            stage.show();
    }
}
