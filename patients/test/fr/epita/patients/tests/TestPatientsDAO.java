package fr.epita.patients.tests;

import fr.epita.patients.datamodel.Patient;
import fr.epita.patients.services.PatientsDAO;

import java.sql.*;
import java.time.LocalDate;

public class TestPatientsDAO {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                "user",
                "pwd");

        PatientsDAO patientsDAO = new PatientsDAO();


        Patient patient = new Patient("2758965423102", "testLN","test", 1, LocalDate.now() );

        patientsDAO.create(patient);
        displayPatients(connection);

        patientsDAO.update(patient);
        displayPatients(connection);

        patientsDAO.delete(patient);
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
