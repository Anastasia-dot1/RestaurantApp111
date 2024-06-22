module com.example.restaurant.restaurantapp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires com.dlsc.formsfx;

    opens com.example.restaurant.restaurantapp1 to javafx.fxml;
    exports com.example.restaurant.restaurantapp1;
}