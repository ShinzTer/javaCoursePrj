module com.course.courseproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.course.courseproject to javafx.fxml;
    exports com.course.courseproject;
    exports com.course.courseproject.Controllers;
    opens com.course.courseproject.Controllers to javafx.fxml;
    exports com.course.courseproject.Consts;
    opens com.course.courseproject.Consts to javafx.fxml;
}