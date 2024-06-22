package com.example.restaurant.restaurantapp1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserRegistration {
    @FXML
    public Button btnNext;
    @FXML
    public TextField inn;
    @FXML
    public TextField patronymic;

    @FXML
    public Button btnBack;
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public PasswordField password;

    private static String varFirstName;
    private static String varLastName;
    private static String varPatronymic;
    private static String varInn;
    private static String varPassword;
    @FXML
    public Label errorPasswordText;
    @FXML
    public Label errorPatronymicText;
    @FXML
    public Label errorLastNameText;
    @FXML
    public Label errorNameText;
    @FXML
    public Label errorInnText;


    @FXML
    void toNext(ActionEvent event) throws IOException {
        varFirstName = firstName.getText();
        varLastName = lastName.getText();
        varPatronymic = patronymic.getText();
        varInn = inn.getText();
        varPassword = password.getText();


        errorNameText.setText(errorFirstName());
        errorLastNameText.setText(errorLastName());
        errorPatronymicText.setText(errorPatronymic());
        errorInnText.setText(errorInn());
        errorPasswordText.setText(errorPassword());

        if (errorNameText.getText().isEmpty() && errorLastNameText.getText().isEmpty() && errorPatronymicText.getText().isEmpty() && errorInnText.getText().isEmpty() && errorPasswordText.getText().isEmpty()) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user_profile.fxml")));
            stage.setScene(new Scene(root, 700, 700));
            stage.show();
        }
    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    private String errorFirstName() {
        if (!varFirstName.matches("([А-ЯЁ][а-яё]+)|([а-яё][а-яё]+)")) {
            return "Имя введено неправильно";
        }
        return "";
    }
    private String errorLastName() {
        if (!varLastName.matches("([А-ЯЁ][а-яё]+)|([а-яё][а-яё]+)")) {
            return "Фамилия введена неправильно";
        }
        return "";
    }

    private String errorPatronymic() {
        if (!varPatronymic.isEmpty()) {
            if (!varPatronymic.matches("([А-ЯЁ][а-яё]+)|([а-яё][а-яё]+)")) {
                return "Отчество введено неправильно";
            }
        }
        return "";
    }

    @FXML
    private String errorInn() {
        if (!varInn.isEmpty()) {
            if (!varInn.matches("^\\d{10}$")) {
                return "Инн введено неправильно";
            }
        }else if(varInn.isEmpty()){
            return "Инн введено неправильно";
        }
        return "";
    }

    private String errorPassword() {
        if (varPassword.isEmpty()) {
            return "Введите пароль";
        }
        return "";
    }

}
