module com.example.labassignment2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.labassignment2 to javafx.fxml;
    exports com.example.labassignment2;
}