module com.example.achrifbouarga {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.achrifbouarga to javafx.fxml;
    exports com.example.achrifbouarga;
}