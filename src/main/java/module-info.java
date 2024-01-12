module com.example.databaseguiv1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.databaseguiv1 to javafx.fxml;
    exports com.example.databaseguiv1;
}