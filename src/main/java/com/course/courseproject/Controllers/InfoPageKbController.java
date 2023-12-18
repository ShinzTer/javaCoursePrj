package com.course.courseproject.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoPageKbController {

    @FXML
    protected Button kbBack;

    @FXML
    protected Button kbFeedback;

    @FXML
    protected Button kbMain;

    @FXML
    protected Button kbAuthor;

    @FXML
    protected void onKbAuthorClick() {
        kbAuthor.getScene().getWindow().hide();
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
    protected void onKbBackClick() {
            kbBack.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/course/courseproject/info_page_wdr.fxml"));

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

    @FXML
    protected void onKbFeedbackClick() {
        kbFeedback.getScene().getWindow().hide();
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
    protected void onKbMainClick() {
            kbMain.getScene().getWindow().hide();

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
}
