package fr.epita.patients.tests;

import java.sql.Connection;
import java.sql.DriverManager;
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


    }
}
