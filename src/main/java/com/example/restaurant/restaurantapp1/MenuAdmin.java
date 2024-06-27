package com.example.restaurant.restaurantapp1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class MenuAdmin {
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnBack;
    @FXML
    public Button btnDelete;
    @FXML
    public TableView<Dish> menuTable;

    @FXML
    public void initialize() {
        initializeTable();
    }
    public static class Dish {
        private final int id;
        private final String name;

        public Dish(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    private void initializeTable() {
        // Очищаем таблицу
        menuTable.getItems().clear();

        // Устанавливаем фабрику для столбцов
        TableColumn<Dish, Integer> idColumn = new TableColumn<>("№");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Dish, String> nameColumn = new TableColumn<>("Название блюда");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Добавляем столбцы к таблице
        menuTable.getColumns().clear();
        menuTable.getColumns().addAll(idColumn, nameColumn);

        // Загружаем данные из базы данных
        loadDishesFromDatabase();
    }

    private void loadDishesFromDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/deniz",
                    "Чурсина Анастасия",
                    "2323");

            String query = "SELECT id_dishes, name FROM dishes";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            ObservableList<Dish> dishes = FXCollections.observableArrayList();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_dishes");
                String name = resultSet.getString("name");
                dishes.add(new Dish(id, name));
            }

            menuTable.setItems(dishes);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void toAdd(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnAdd.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("add_dish_admin.fxml"));
        stage.setScene(new Scene(root, 700, 513));
        stage.show();
    }

    @FXML
    public void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("admin_profile.fxml"));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    public void toDelete(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnDelete.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("delete_dish_admin.fxml"));
        stage.setScene(new Scene(root, 700, 423));
        stage.show();
    }

}
