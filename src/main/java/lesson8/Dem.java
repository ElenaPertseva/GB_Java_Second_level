package lesson8;

import java.sql.*;
import java.util.ArrayList;

public class Dem {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Musya2017");
             Statement statement = connection.createStatement()) {

            performDropTable(statement);

            performCreatedDB(statement);

            poulateDB(statement, connection);

            performUpdateDb(statement);

            performDeleteRows(statement);

            performPreparedStatement(connection);
            readStudentsFromDB(statement);

        }

    }


    private static void performPreparedStatement(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?)")) {
            for (int i = 1; i < 10; i++) {
                preparedStatement.setString(1, "Tom" + i);
                preparedStatement.setInt(2, i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
    }

    private static void performDeleteRows(Statement statement) throws SQLException {
        statement.executeUpdate("DELETE FROM students WHERE id > 9000");
    }

    private static void performUpdateDb(Statement statement) throws SQLException {
        performUpdateStudents("UPDATE students SET score = 0 WHERE id > 100", statement);
    }

    private static void performUpdateStudents(String s, Statement statement) throws SQLException {
        statement.executeUpdate(s);
    }

    private static void poulateDB(Statement statement, Connection connection) throws SQLException {
        long start = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i < 10_000; i++) {
            statement.executeUpdate(
                    "INSERT INTO students(name, score) VALUES('students" + i + "'," + i + ");"
            );
        }
        connection.commit();
        System.out.println(System.currentTimeMillis() - start);

    }

    private static void performDropTable(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS students");
    }

    private static void performCreatedDB(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                "name STRING, score  INTEGER NOT NULL);");
    }

    private static void readStudentsFromDB(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        ArrayList<MyClass> arrayList = new ArrayList<MyClass>();
        while (resultSet.next()) {
            System.out.println(
                    resultSet.getInt(1) + " - " +
                            resultSet.getString(2) + " - " +
                            resultSet.getDouble("score") + " - "
            );
            arrayList.add(new MyClass(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble("score")));
        }
        System.out.println("");
    }

    public static class MyClass {
        private Integer id;
        private String name;
        private Double score;

        public MyClass(Integer id, String name, Double score ){
            this.id = id;
            this.name = name;
            this.score = score;
        }

    }

}
