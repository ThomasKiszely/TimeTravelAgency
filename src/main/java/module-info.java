module com.thomas.timetravelagency {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.thomas.timetravelagency to javafx.fxml;
    exports com.thomas.timetravelagency;
}