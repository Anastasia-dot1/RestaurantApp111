package com.example.restaurant.restaurantapp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BookingAdmin {
    public Button btnBack;
    public Button btnAdd;
    public TableView booking;

    public void toAdd(ActionEvent actionEvent) {
    }

    public void toBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin_profile.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
}
