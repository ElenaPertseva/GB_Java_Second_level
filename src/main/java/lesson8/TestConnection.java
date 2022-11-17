package lesson8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/students";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Musya2017";

    public static void main(String[] args) {
        Connection connection;
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()){
                System.out.println("Соединение с БД установлено");
            }
            connection.isClosed();

        } catch (SQLException e){
            e.printStackTrace();
        }



    }
}