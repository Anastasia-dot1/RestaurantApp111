package com.example.restaurant.restaurantapp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static com.example.restaurant.restaurantapp1.IsUsers_SQL.addDish;

public class AddDishAdmin {
    public TextField nameDishText;
    public TextField descText;
    public Button btnAddDish;
    public Button btnBack;
    public Label errorDesc;
    public Label errorNameDish;
    public TextField consText;

    public void toAddDish(ActionEvent actionEvent) {
        String dishName = nameDishText.getText().trim();

        if (dishName.isEmpty()) {
            errorNameDish.setText("Название блюда не может быть пустым");
            return;
        }

        addDish(dishName);
        errorNameDish.setText("Блюдо добавлено успешно");
        errorDesc.setText("");
    }

    public void toBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu_admin.fxml")));
        stage.setScene(new Scene(root, 800, 900));
        stage.show();
    }
}
