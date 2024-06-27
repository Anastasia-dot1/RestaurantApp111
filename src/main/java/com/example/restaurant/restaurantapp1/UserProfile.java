package com.example.restaurant.restaurantapp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UserProfile {
    @FXML
    public Button btnBook;
    @FXML
    public Button btnBack;
    @FXML
    public ComboBox waiterComb;
    @FXML
    public ListView listMenu;
    @FXML
    public TextField textDate;
    private IsUsers_SQL isUsersSql = new IsUsers_SQL();

    @FXML
    public void toBook(ActionEvent actionEvent) {

    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
}
