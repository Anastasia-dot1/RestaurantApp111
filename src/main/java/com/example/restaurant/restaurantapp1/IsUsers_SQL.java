package com.example.restaurant.restaurantapp1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;


public class IsUsers_SQL {
    private static IsUsers_SQL instance;
    private String id_client;

    protected IsUsers_SQL() {
    }

    // Публичный статический метод для получения единственного экземпляра класса
    public static synchronized IsUsers_SQL getInstance() {
        if (instance == null) {
            instance = new IsUsers_SQL();
        }
        return instance;
    }


    public static void addUser(String name, String last_name, String patronymic, String inn, String password) {
        Connection connection = null;
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/deniz",
                    "Чурсина Анастасия", "2323");
            String insertClientQuery = "INSERT INTO clients (name, last_name, patronymic, инн, passwords) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertClientStatement = connection.prepareStatement(insertClientQuery);
            insertClientStatement.setString(1, name);
            insertClientStatement.setString(2, last_name);
            insertClientStatement.setString(3, patronymic);
            insertClientStatement.setString(4, inn);
            insertClientStatement.setString(5, password);
            int clientRowsAffected = insertClientStatement.executeUpdate();

            if (clientRowsAffected > 0) {
                success = true;
            } else {
                System.out.println("ошибка");
            }
            insertClientStatement.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
    }
    public static boolean checkUser(String inn, String password) {
        Connection connection = null;
        boolean userExists = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deniz",
                    "Чурсина Анастасия", "2323");

            String selectUserQuery = "SELECT * FROM clients WHERE инн = ? AND passwords = ?";
            PreparedStatement selectUserStatement = connection.prepareStatement(selectUserQuery);
            selectUserStatement.setString(1, inn);
            selectUserStatement.setString(2, password);

            ResultSet resultSet = selectUserStatement.executeQuery();

            if (resultSet.next()) {
                userExists = true; // Пользователь существует в базе данных
            }
            resultSet.close();
            selectUserStatement.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }

        return userExists;
    }
    public static void addDish(String dishName) {
        Connection connection = null;
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/deniz",
                    "Чурсина Анастасия",
                    "2323");
            String insertDishQuery = "INSERT INTO dishes (name) VALUES (?)";
            PreparedStatement insertDishStatement = connection.prepareStatement(insertDishQuery);
            insertDishStatement.setString(1, dishName);
            int dishRowsAffected = insertDishStatement.executeUpdate();
            if (dishRowsAffected > 0) {
                success = true;
            } else {
                System.out.println("Ошибка при добавлении блюда");
            }
            insertDishStatement.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
    }

    public static void deleteDish(int dishId) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/deniz",
                    "Чурсина Анастасия",
                    "2323");

            String deleteDishQuery = "DELETE FROM dishes WHERE id_dishes = ?";
            PreparedStatement deleteDishStatement = connection.prepareStatement(deleteDishQuery);
            deleteDishStatement.setInt(1, dishId);

            int rowsAffected = deleteDishStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Блюдо успешно удалено.");
            } else {
                System.out.println("Ошибка при удалении блюда.");
            }

            deleteDishStatement.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
    }
    public ObservableList<String> getAllDishes() {
        ObservableList<String> menuItems = FXCollections.observableArrayList();
        String query = "SELECT id_dishes,name FROM dishes";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deniz", "Чурсина Анастасия", "2323");
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String id = resultSet.getString("id_dishes");
                String dishName = resultSet.getString("name");
                menuItems.add(dishName);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        }

        return menuItems;
    }


}


