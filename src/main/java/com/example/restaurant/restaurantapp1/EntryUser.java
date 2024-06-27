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
        String innText = inn.getText(); // предполагается, что у вас есть поле inn (TextField)
        String passwordText = password.getText(); // предполагается, что у вас есть поле password (PasswordField)

        // Проверяем, что поля inn и password не пустые
        if (!innText.isEmpty() && !passwordText.isEmpty()) {
            // Вызываем метод для проверки пользователя
            boolean isValidUser = IsUsers_SQL.checkUser(innText, passwordText);

            if (isValidUser) {
                Stage stage = (Stage) btnBack.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user_profile.fxml")));
                stage.setScene(new Scene(root, 700, 700));
                stage.show();
            } else {
                // Если пользователь не найден, вы можете вывести сообщение или обработать иным способом
                errorPassword.setText("Неправильный inn или password");
                errorInn.setText("Неправильный inn или password");
            }
        } else {
            // Если одно из полей пустое, выводим сообщение об ошибке
            errorPassword.setText("Заполните все поля");
            errorInn.setText("Заполните все поля");
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
