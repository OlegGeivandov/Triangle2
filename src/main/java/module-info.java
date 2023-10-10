module com.example.triangle2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.triangle2 to javafx.fxml;
    exports com.example.triangle2;
}