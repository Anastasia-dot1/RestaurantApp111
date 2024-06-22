package com.example.restaurant.restaurantapp1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartUserOrAdmin {
    @FXML
    public Button btnAdmin;

    @FXML
    public Button btnUser;
    @FXML
    public Button btnBack;
    @FXML
    public Button btnEntr;


    @FXML
    void toAdmin(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnAdmin.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_admin.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }


    @FXML
    void toUser(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnUser.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_user_or_admin.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toEntr(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnEntr.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("entry_admin.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
}