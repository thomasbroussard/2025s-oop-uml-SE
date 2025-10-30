package fr.epita.patients.services;

import fr.epita.patients.datamodel.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientsDAO {

    public PatientsDAO() throws SQLException {
        String createTable = """
                   CREATE TABLE IF NOT EXISTS patients (
                   hcNum VARCHAR(255), 
                   firstName VARCHAR(255), 
                   address VARCHAR(255), 
                   insurance INT)
                """;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(Patient patient) throws SQLException {
        String insertStatement = """
                    INSERT INTO patients(hcNum,
                            firstName, 
                            address, 
                            insurance) 
                    VALUES(?,?,?,?)
                """;
        try (Connection connection = getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, patient.getPatNumHC());
            preparedStatement.setString(2, patient.getPatFirstname());
            preparedStatement.setString(3, patient.getPatAddress());
            preparedStatement.setInt(4, patient.getPatInsuranceId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Patient patient) throws SQLException {
        try (Connection connection = getConnection()) {
            String updateQuery = """
                    UPDATE PATIENTS set firstName = ? where hcNum = ?
                    """;

            PreparedStatement updatePst = connection.prepareStatement(updateQuery);
            updatePst.setString(1, patient.getPatFirstname());
            updatePst.setString(2, patient.getPatNumHC());
            updatePst.execute();
        }
    }

    public void delete(Patient patient) throws SQLException {

        try (Connection connection = getConnection()) {
            String deleteQuery = """
                    DELETE FROM PATIENTS where hcNum = ?
                    """;
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, patient.getPatNumHC());
            deleteStatement.execute();
        }
    }

    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                "user",
                "pwd");
        return connection;
    }
}
