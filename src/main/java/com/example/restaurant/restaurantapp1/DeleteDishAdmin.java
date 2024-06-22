package com.example.restaurant.restaurantapp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DeleteDishAdmin {
    public Button btnBack;

    public void toDelDish(ActionEvent actionEvent) {
    }

    public void toBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu_admin.fxml")));
        stage.setScene(new Scene(root, 800, 900));
        stage.show();
    }
}
