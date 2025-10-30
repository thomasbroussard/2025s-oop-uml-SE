package fr.epita.patients.tests;

import java.sql.*;

public class TestPatientsDAO {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                "user",
                "pwd");

        String createTable = """
                CREATE TABLE patients (
                    hcNum VARCHAR(255), 
                    firstName VARCHAR(255), 
                    address VARCHAR(255), 
                    insurance INT)
                """;
        connection.prepareStatement(createTable).execute();
        String insertStatement = """
            INSERT INTO patients(hcNum,
                    firstName, 
                    address, 
                    insurance) 
            VALUES(?,?,?,?)
        """;
        PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
        preparedStatement.setString(1, "2758965423102");
        preparedStatement.setString(2, "test");
        preparedStatement.setString(3, "Paris");
        preparedStatement.setInt(4, 3);
        preparedStatement.execute();

        displayPatients(connection);

        String updateStatement = """
                UPDATE PATIENTS set firstName = 'test2'
                """;

        connection.prepareStatement(updateStatement).execute();
        displayPatients(connection);
        String deleteStatement = """
                DELETE FROM PATIENTS where hcNum = '2758965423102'
                """;

        connection.prepareStatement(deleteStatement).execute();
        displayPatients(connection);


        connection.close();


    }

    private static void displayPatients(Connection connection) throws SQLException {
        String selectStatement = """
               select hcNum,firstName,address,insurance
               from patients
                """;
        ResultSet resultSet = connection.prepareStatement(selectStatement).executeQuery();
        int count = 0;
        while (resultSet.next()) {
            count++;
            System.out.println(resultSet.getString("hcNum"));
            System.out.println(resultSet.getString("firstName"));
            System.out.println(resultSet.getString("address"));
            System.out.println(resultSet.getString("insurance"));
        }
        if (count == 0){
            System.out.println("No patients found");
        }
    }
}
