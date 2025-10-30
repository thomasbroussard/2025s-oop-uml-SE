package fr.epita.patients.tests;

import fr.epita.patients.datamodel.Patient;
import fr.epita.patients.services.PatientsCSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class TestPatientsCSVReader {

    public static void main(String[] args) throws FileNotFoundException {
        //readAllTest();

        testHCnumExtraction();
    }

    private static void readAllTest() throws FileNotFoundException {
        File homeDirectory = new File("./patients/");
        System.out.println(homeDirectory.getAbsolutePath());
        PatientsCSVReader patientsCSVReader = new PatientsCSVReader(new File(homeDirectory,"patients.csv"));
        List<Patient> patients = patientsCSVReader.readAll();

        System.out.println("Number of patients: " + patients.size());
        System.out.println(patients);
        System.out.println("expecting patients list to have 6 entries ");
    }

    public static void testHCnumExtraction() throws FileNotFoundException {
        File homeDirectory = new File("./patients/");
        System.out.println(homeDirectory.getAbsolutePath());
        PatientsCSVReader patientsCSVReader = new PatientsCSVReader(new File(homeDirectory,"patients.csv"));
        Map<String, String> hCnumElements =
                patientsCSVReader.extractSocialSecurityNumber("2758965423102");

        System.out.println(hCnumElements);
    }
}
