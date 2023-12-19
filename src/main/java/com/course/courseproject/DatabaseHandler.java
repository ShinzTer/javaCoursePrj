package com.course.courseproject;

import com.course.courseproject.Consts.FeedbackConst;
import com.course.courseproject.Consts.UserConst;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        dbConnection = DriverManager.getConnection(connectionString, dbLogin, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + UserConst.USER_TABLE + "(" +
                UserConst.USERS_LOGIN + "," + UserConst.USERS_PASSWORD + ")" +
                "VALUES(?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + UserConst.USER_TABLE + " WHERE " +
                UserConst.USERS_LOGIN + "=? AND " + UserConst.USERS_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }

    //---------------------------------------------------FEEDBACK-------------------------------------------------------

    public void sendFeedback(Feedback feedback) {

        boolean isExist = getFeedbackById(feedback);

        if (!isExist) {
            String insert = "INSERT INTO " + FeedbackConst.FEEDBACK_TABLE + "("
                    + FeedbackConst.FEEDBACK_ID + "," + FeedbackConst.FEEDBACK_Q1 + ","
                    + FeedbackConst.FEEDBACK_Q2 + "," + FeedbackConst.FEEDBACK_Q3 + ","
                    + FeedbackConst.FEEDBACK_Q4 + "," + FeedbackConst.FEEDBACK_Q5 + ","
                    + FeedbackConst.FEEDBACK_Q6 + ")" + "VALUES(?,?,?,?,?,?,?)";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setInt(1, feedback.getIduser());
                prSt.setInt(2, feedback.getQ1());
                prSt.setInt(3, feedback.getQ2());
                prSt.setInt(4, feedback.getQ3());
                prSt.setInt(5, feedback.getQ4());
                prSt.setInt(6, feedback.getQ5());
                prSt.setInt(7, feedback.getQ6());

                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (isExist) {
            String insert = "UPDATE " + FeedbackConst.FEEDBACK_TABLE + " SET "
                    + FeedbackConst.FEEDBACK_ID + "=?," + FeedbackConst.FEEDBACK_Q1 + "=?,"
                    + FeedbackConst.FEEDBACK_Q2 + "=?," + FeedbackConst.FEEDBACK_Q3 + "=?,"
                    + FeedbackConst.FEEDBACK_Q4 + "=?," + FeedbackConst.FEEDBACK_Q5 + "=?,"
                    + FeedbackConst.FEEDBACK_Q6 + "=? WHERE " + FeedbackConst.FEEDBACK_ID + "=?";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setInt(1, feedback.getIduser());
                prSt.setInt(8, feedback.getIduser());
                prSt.setInt(2, feedback.getQ1());
                prSt.setInt(3, feedback.getQ2());
                prSt.setInt(4, feedback.getQ3());
                prSt.setInt(5, feedback.getQ4());
                prSt.setInt(6, feedback.getQ5());
                prSt.setInt(7, feedback.getQ6());

                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean getFeedbackById(Feedback feedback) {
        String select = "SELECT * FROM " + FeedbackConst.FEEDBACK_TABLE + " WHERE " +
                FeedbackConst.FEEDBACK_ID + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, feedback.getIduser());
            ResultSet resultSet = prSt.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
