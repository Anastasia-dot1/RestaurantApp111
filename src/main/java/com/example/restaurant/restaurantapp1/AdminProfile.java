package com.example.restaurant.restaurantapp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminProfile {
    public Button btnBook;
    public Button btnBack;
    public Button btnMenu;
    public Label loginInsert;
    public Label innInsert;

    public void toMenu(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnMenu.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu_admin.fxml")));
        stage.setScene(new Scene(root, 800, 900));
        stage.show();
    }

    public void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_admin.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    public void toBook(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBook.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("booking_admin.fxml")));
        stage.setScene(new Scene(root, 800, 900));
        stage.show();
    }
}
