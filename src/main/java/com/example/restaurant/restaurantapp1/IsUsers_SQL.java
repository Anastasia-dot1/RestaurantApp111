package com.example.restaurant.restaurantapp1;

import java.sql.*;

public class IsUsers_SQL {
    private static IsUsers_SQL instance;
    private IsUsers_SQL(){}
    // Публичный статический метод для получения единственного экземпляра класса
    public static synchronized IsUsers_SQL getInstance() {
        if (instance == null) {
            instance = new IsUsers_SQL();
        }
        return instance;
    }
    public String isUsers(String phone, String password) {
        Connection connection = null;
        try {
            // Проверяем наличие драйвера JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/deniz",
                    "Чурсина Анастасия", "2323");

            // Создаем объект Statement для выполнения запросов к базе данных
            Statement statement = connection.createStatement();

            // Формируем SQL-запрос
            String query = "SELECT phone ,password FROM clients JOIN passwords USING(id_client); ";

            // Выполняем запрос и получаем результат
            ResultSet result = statement.executeQuery(query);

            // Обрабатываем результат запроса


            outLoop:
            /*    while (result.next()) {

                String ph = result.getString("phone");
                String pas = result.getString("password");
                User user = new User(phone,password);


                if (ph.equals(phone)){
                    if (pas.equals(password)){
                        return "существует";

                    }
                    else {
                        return "пароль введен неправильно";

                    }

                }


            }*/
            // Закрываем ресурсы
            result.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Не найден драйвер JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении SQL-запроса: " + e.getMessage());
        } finally {
            try {
                // Закрываем соединение в блоке finally для обеспечения его закрытия в любом случае
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
        return null;
    }
    public static void addUser(String name, String last_name, String patronymic, String inn) {
        Connection connection = null;
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/deniz",
                    "Чурсина Анастасия", "2323");
            String insertClientQuery = "INSERT INTO clients (name, last_name, patronymic, инн) VALUES (?, ?, ?, ?)";
            PreparedStatement insertClientStatement = connection.prepareStatement(insertClientQuery);
            insertClientStatement.setString(1, name);
            insertClientStatement.setString(2, last_name);
            insertClientStatement.setString(3, patronymic);
            insertClientStatement.setString(4, inn);
            int clientRowsAffected = insertClientStatement.executeUpdate();

            if (clientRowsAffected > 0) {
                success = true;
            }
            else{
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
}
