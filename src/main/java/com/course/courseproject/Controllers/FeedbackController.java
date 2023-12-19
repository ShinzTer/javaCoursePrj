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
    protected RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rbFavourite1, rbFavourite2, rbFavourite3, rbFavourite4;

    @FXML
    protected TextArea textAreaL7, textAreaSh, textAreaWdr, textAreaKb;

    protected int chosen = 0;
    protected int favouriteChosen = 0;
    protected User user;
    protected Feedback feedback;

    protected void getUser(User user) {
        this.user = user;
    }

    protected void getFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @FXML
    protected void isChosen() {
        chosen = rb1.isSelected() ? 0 :
                rb2.isSelected() ? 1 :
                        rb3.isSelected() ? 2 :
                                rb4.isSelected() ? 3 :
                                        rb5.isSelected() ? 4 : 5;
    }

    @FXML
    protected void isFavouriteChosen() {
        favouriteChosen = rbFavourite1.isSelected() ? 0 :
                rbFavourite2.isSelected() ? 1 :
                        rbFavourite3.isSelected() ? 2 : 3;
    }

    @FXML
    protected void onSendFeedbackBtnClick() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Feedback fb = new Feedback();

        fb.setIduser(user.getIdUser());
        fb.setQ1(chosen);
        fb.setQ2(textAreaL7.getText());
        fb.setQ3(textAreaSh.getText());
        fb.setQ4(textAreaWdr.getText());
        fb.setQ5(textAreaKb.getText());
        fb.setQ6(favouriteChosen);

        dbHandler.sendFeedback(fb);

        sendFeedbackBtn.setText("Спасибо за ваш отзыв!");
        sendFeedbackBtn.setOnMouseClicked(e -> {
            Stage stage = (Stage) sendFeedbackBtn.getScene().getWindow();
            stage.close();
        });
    }
}
