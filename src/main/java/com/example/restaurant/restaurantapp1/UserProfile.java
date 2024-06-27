package com.example.restaurant.restaurantapp1;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
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

    public void initialize() {
        isUsersSql = new IsUsers_SQL(); // Инициализация объекта для работы с базой данных
        listMenu.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }


    @FXML
    public void toBook(ActionEvent actionEvent) {
        ObservableList<String> menuItems = getMenuItemsFromDatabase();

        // Далее вы можете использовать полученный список блюд для отображения в вашем интерфейсе
        listMenu.setItems(menuItems);
    }
    private ObservableList<String> getMenuItemsFromDatabase() {
        ObservableList<String> menuItems = FXCollections.observableArrayList();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deniz");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM dishes");

            while (rs.next()) {
                String dishName = rs.getString("name");
                menuItems.add(dishName);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuItems;
    }
    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
}

