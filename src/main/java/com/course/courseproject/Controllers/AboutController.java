package com.course.courseproject.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class AboutController {

    @FXML
    protected Button l7Btn;

    @FXML
    protected Button ShBtn;

    @FXML
    protected Button wdrBtn;

    @FXML
    protected Button kbBtn;

    @FXML
    protected void onl7BtnClick() {
            l7Btn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/course/courseproject/info_page_l7.fxml"));

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
    protected  void onShBtnClick() {
            ShBtn.getScene().getWindow().hide();

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

    @FXML
    protected  void onWdrBtnClick() {
            wdrBtn.getScene().getWindow().hide();

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
    protected  void onKbBtnClick() {
            kbBtn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/course/courseproject/info_page_kb.fxml"));

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
