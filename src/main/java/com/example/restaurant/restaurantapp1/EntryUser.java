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

public class EntryUser {
    @FXML
    public PasswordField password;
    @FXML
    public Button btnNext;
    @FXML
    public Button btnBack;

    @FXML
    public TextField inn;
    @FXML
    public Label errorPassword;
    @FXML
    public Label errorInn;

    @FXML
    void toNext(ActionEvent event) throws IOException {
        /*Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user_profile.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();*/

        if (!inn.getText().isEmpty() && !password.getText().isEmpty()) {
/*            IsUsers_SQL sql = new IsUsers_SQL();
            String flag = sql.isUsers(inn.getText(), password.getText());

            if (flag.equals("существует")) {
                Stage stage = (Stage) btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user_profile.fxml")));
                stage.setScene(new Scene(root, 700, 600));
                stage.show();
            }*/

            Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user_profile.fxml")));
        stage.setScene(new Scene(root, 700, 700));
        stage.show();

        } else {
            errorPassword.setText("заполните все поля");
            errorInn.setText("заполните все поля");
        }
    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
}
