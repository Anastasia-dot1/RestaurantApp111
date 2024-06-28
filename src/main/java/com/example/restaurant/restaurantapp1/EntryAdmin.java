package com.example.restaurant.restaurantapp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EntryAdmin {
    @FXML
    public PasswordField password;
    @FXML
    public Button btnNext;
    @FXML
    public Button btnBack;

    @FXML
    public TextField login;
    public Label errorLogin;
    public Label errorInn;

    @FXML
    public void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_admin.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toNext(ActionEvent event) throws IOException {
        if (!login.getText().isEmpty() && !password.getText().isEmpty()) {

            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin_profile.fxml")));
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }
        else {
            errorInn.setText("заполните все поля");
            errorLogin.setText("заполните все поля");
        }
    }
}
