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

public class MenuAdmin {
    public Button btnAdd;
    public Button btnBack;
    public Button btnDelete;
    public TableView menuTable;

    public void toAdd(ActionEvent actionEvent)  throws IOException {
        Stage stage = (Stage) btnAdd.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_dish_admin.fxml")));
        stage.setScene(new Scene(root, 700, 513));
        stage.show();
    }

    public void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin_profile.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    public void toDelete(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnDelete.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("delete_dish_admin.fxml")));
        stage.setScene(new Scene(root, 700, 423));
        stage.show();
    }
}
