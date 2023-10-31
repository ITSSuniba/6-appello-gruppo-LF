module com.example.integrazione {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.integrazione.hw1 to javafx.fxml;
    exports com.example.integrazione.hw1;
}