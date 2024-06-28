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
    private MenuAdmin.Dish selectedWaiter;
    static User user;

    public void initialize() {
        isUsersSql = new IsUsers_SQL(); // Инициализация объекта для работы с базой данных
        listMenu.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        fillMenuListView();
        fillWaitersComboBox();
    }
    public static void setUser(User user) {
        UserProfile.user = user;
    }

    public static User getUser() {
        return user;
    }

    private void fillMenuListView() {
        ObservableList<String> menuItems = FXCollections.observableArrayList(isUsersSql.getAllDishes());
        listMenu.setItems(menuItems);
    }

    private void fillWaitersComboBox() {
        ObservableList<String> waiters = FXCollections.observableArrayList(isUsersSql.getAllWaiters());
        waiterComb.setItems(waiters);
    }
    @FXML
    public void toBook(ActionEvent actionEvent) {

        /*ObservableList<MenuAdmin.Dish> selectedDishes = listMenu.getSelectionModel().getSelectedItems();
        String selectedWaiter = (String) waiterComb.getValue();
        String date = textDate.getText();

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/deniz",
                "Чурсина Анастасия", "2323")) {

            String mealsQuery = "INSERT INTO meals (id_table, id_waiters, dat, time_start, time_end) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement mealsStatement = connection.prepareStatement(mealsQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            mealsStatement.setInt(1, 1);
            mealsStatement.setInt(2, 1);
            mealsStatement.setString(3, date);
            mealsStatement.setTime(4, java.sql.Time.valueOf("12:00:00"));
            mealsStatement.setTime(5, java.sql.Time.valueOf("13:30:00"));
            //mealsStatement.executeUpdate();

            ResultSet generatedKeys = mealsStatement.getGeneratedKeys();
            int id_meals = -1;
            if (generatedKeys.next()) {
                id_meals = generatedKeys.getInt(1);
            }

            String clientsMealsQuery = "INSERT INTO clients_meals (id_client, id_meals) VALUES (?, ?)";
            PreparedStatement clientsMealsStatement = connection.prepareStatement(clientsMealsQuery);
            clientsMealsStatement.setInt(1, user.get_id());
            clientsMealsStatement.setInt(2, id_meals);
            clientsMealsStatement.executeUpdate();

            System.out.println("Бронирование успешно выполнено!");

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }


    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
}
