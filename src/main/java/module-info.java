module com.recepeit.recepeit {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.recipeit to javafx.fxml;
    exports com.recipeit;
}