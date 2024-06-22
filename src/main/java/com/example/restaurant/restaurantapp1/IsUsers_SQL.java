package com.example.restaurant.restaurantapp1;

import java.sql.*;

public class IsUsers_SQL {
    public String isUsers(String phone, String password) {

        Connection connection = null;
        try {
            // Проверяем наличие драйвера JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Устанавливаем соединение с базой данных
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/veloprokat",
                    "veloprokat", "Stud249013!");

            // Создаем объект Statement для выполнения запросов к базе данных
            Statement statement = connection.createStatement();

            // Формируем SQL-запрос
            String query = "SELECT phone ,password FROM clients JOIN passwords USING(id_client); ";

            // Выполняем запрос и получаем результат
            ResultSet result = statement.executeQuery(query);

            // Обрабатываем результат запроса


            outLoop:
            while (result.next()) {

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

                //System.out.print(phone);
                //System.out.print(password);

            }

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

}
