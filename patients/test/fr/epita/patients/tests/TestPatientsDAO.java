package fr.epita.patients.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            VALUES('2758965423102','test','Paris', 1)
        """;


        connection.prepareStatement(insertStatement).execute();

        displayPatients(connection);


        connection.close();


    }

    private static void displayPatients(Connection connection) throws SQLException {
        String selectStatement = """
               select hcNum,firstName,address,insurance
               from patients
                """;
        ResultSet resultSet = connection.prepareStatement(selectStatement).executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("hcNum"));
            System.out.println(resultSet.getString("firstName"));
            System.out.println(resultSet.getString("address"));
            System.out.println(resultSet.getString("insurance"));
        }
    }
}
