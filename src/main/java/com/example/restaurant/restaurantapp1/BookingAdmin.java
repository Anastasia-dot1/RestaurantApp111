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
import java.util.Objects;

public class BookingAdmin {
    public Button btnBack;
    public Button btnAdd;
    public TableView <Booking> booking;
    public TableColumn idColumn;

    public TableColumn bookingDateColumn;
    public TableColumn idWaiterColumn;
    public TableColumn idTable;
    @FXML
    public void initialize() {
        initializeTable();
    }

    public void toAdd(ActionEvent actionEvent) {
    }

    public void toBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin_profile.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
    private void initializeTable() {
        // Очищаем таблицу
        booking.getItems().clear();

        // Устанавливаем фабрику для столбцов
        TableColumn<Booking, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Booking, Integer> tableNumberColumn = new TableColumn<>("Номер стола");
        tableNumberColumn.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));

        TableColumn<Booking, String> bookingDateColumn = new TableColumn<>("Дата бронирования");
        bookingDateColumn.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));

        TableColumn<Booking, Integer> waiterNumberColumn = new TableColumn<>("Номер официанта");
        waiterNumberColumn.setCellValueFactory(new PropertyValueFactory<>("waiterNumber"));

        // Добавляем столбцы к таблице
        booking.getColumns().clear();
        booking.getColumns().addAll(idColumn, tableNumberColumn, bookingDateColumn, waiterNumberColumn);

        // Загружаем данные из базы данных
        loadBookingsFromDatabase();
    }

    private void loadBookingsFromDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/deniz",
                    "Чурсина Анастасия",
                    "2323");

            String query = "SELECT id_meals,id_table, dat, id_waiters FROM meals";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            ObservableList<Booking> bookings = FXCollections.observableArrayList();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_meals");
                int tableNumber = resultSet.getInt("id_table");
                String bookingDate = resultSet.getString("dat");
                int waiterNumber = resultSet.getInt("id_waiters");
                bookings.add(new Booking(id, tableNumber, bookingDate, waiterNumber));
            }

            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            idTable.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));
            bookingDateColumn.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
            idWaiterColumn.setCellValueFactory(new PropertyValueFactory<>("waiterNumber"));

            booking.setItems(bookings);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Booking {
        private int id;
        private int tableNumber;
        private String bookingDate;
        private int waiterNumber;

        public Booking(int id, int tableNumber, String bookingDate, int waiterNumber) {
            this.id = id;
            this.tableNumber = tableNumber;
            this.bookingDate = bookingDate;
            this.waiterNumber = waiterNumber;
        }

        public int getId() {
            return id;
        }

        public int getTableNumber() {
            return tableNumber;
        }

        public String getBookingDate() {
            return bookingDate;
        }

        public int getWaiterNumber() {
            return waiterNumber;
        }
    }
}
