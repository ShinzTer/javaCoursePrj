module com.course.courseproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.course.courseproject to javafx.fxml;
    exports com.course.courseproject;
    exports com.course.courseproject.Controllers;
    opens com.course.courseproject.Controllers to javafx.fxml;
}