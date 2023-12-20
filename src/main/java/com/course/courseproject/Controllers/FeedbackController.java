package com.course.courseproject.Controllers;

import com.course.courseproject.Feedback;
import com.course.courseproject.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import com.course.courseproject.DatabaseHandler;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class FeedbackController {

    @FXML
    protected Button sendFeedbackBtn;

    @FXML
    protected RadioButton rb1, rb2, rb3, rb4, rb5, rb6,
            rbL7True,rbL7False,rbL7Idk,
            rbShTrue,rbShFalse,rbShIdk,
            rbWdrTrue,rbWdrFalse,rbWdrIdk,
            rbKbTrue,rbKbFalse,rbKbIdk,
            rbFavourite1, rbFavourite2, rbFavourite3, rbFavourite4;

    protected int chosen = 10;
    protected int chosenL7 = 10;
    protected int chosenSh = 10;
    protected int chosenWdr = 10;
    protected int chosenKb = 10;
    protected int favouriteChosen = 10;
    protected User user;

    protected void getUser(User user) {
        this.user = user;
    }

    @FXML
    protected void isChosen() {
        chosen = rb1.isSelected() ? 0 :
                rb2.isSelected() ? 1 :
                        rb3.isSelected() ? 2 :
                                rb4.isSelected() ? 3 :
                                        rb5.isSelected() ? 4 : 5;
        sendFeedbackBtn.setText("Отправить отзыв");
        sendFeedbackBtn.setStyle("-fx-text-fill: white");
    }

    @FXML
    protected void isChosenL7() {
        chosenL7 = rbL7True.isSelected() ? 0 :
                rbL7False.isSelected() ? 1 : 2;
        sendFeedbackBtn.setText("Отправить отзыв");
        sendFeedbackBtn.setStyle("-fx-text-fill: white");
    }

    @FXML
    protected void isChosenSh() {
        chosenSh = rbShTrue.isSelected() ? 0 :
                rbShFalse.isSelected() ? 1 : 2;
        sendFeedbackBtn.setText("Отправить отзыв");
        sendFeedbackBtn.setStyle("-fx-text-fill: white");
    }

    @FXML
    protected void isChosenWdr() {
        chosenWdr = rbWdrTrue.isSelected() ? 0 :
                rbWdrFalse.isSelected() ? 1 : 2;
        sendFeedbackBtn.setText("Отправить отзыв");
        sendFeedbackBtn.setStyle("-fx-text-fill: white");
    }

    @FXML
    protected void isChosenKb() {
        chosenKb = rbKbTrue.isSelected() ? 0 :
                rbKbFalse.isSelected() ? 1 : 2;
        sendFeedbackBtn.setText("Отправить отзыв");
        sendFeedbackBtn.setStyle("-fx-text-fill: white");
    }

    @FXML
    protected void isFavouriteChosen() {
        favouriteChosen = rbFavourite2.isSelected() ? 1 :
                rbFavourite3.isSelected() ? 2 :
                        rbFavourite4.isSelected() ? 3 : 0;
        sendFeedbackBtn.setText("Отправить отзыв");
        sendFeedbackBtn.setStyle("-fx-text-fill: white");
    }

    @FXML
    protected void onSendFeedbackBtnClick() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Feedback fb = new Feedback();

        fb.setIduser(user.getIdUser());
        fb.setQ1(chosen);
        fb.setQ2(chosenL7);
        fb.setQ3(chosenSh);
        fb.setQ4(chosenWdr);
        fb.setQ5(chosenKb);
        fb.setQ6(favouriteChosen);

        if(fb.getQ1() == 10 || fb.getQ2() == 10 || fb.getQ3() == 10 || fb.getQ4() == 10 || fb.getQ5() == 10 || fb.getQ6() == 10) {
            sendFeedbackBtn.setText("Пожалуйста, оставьте свой полный отзыв!");
            sendFeedbackBtn.setStyle("-fx-text-fill: red");
        } else {

            dbHandler.sendFeedback(fb);

            sendFeedbackBtn.setText("Спасибо за ваш отзыв!");
            sendFeedbackBtn.setStyle("-fx-text-fill: green");
            sendFeedbackBtn.setOnMouseClicked(e -> {
                Stage stage = (Stage) sendFeedbackBtn.getScene().getWindow();
                stage.close();
            });
        }
    }
}
