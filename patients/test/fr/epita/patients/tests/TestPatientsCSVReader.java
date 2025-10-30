package fr.epita.patients.tests;

import fr.epita.patients.datamodel.Patient;
import fr.epita.patients.services.PatientsCSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class TestPatientsCSVReader {

    public static void main(String[] args) throws FileNotFoundException {
        File homeDirectory = new File("./patients/");
        System.out.println(homeDirectory.getAbsolutePath());
        PatientsCSVReader patientsCSVReader = new PatientsCSVReader(new File(homeDirectory,"patients.csv"));
        List<Patient> patients = patientsCSVReader.readAll();

        System.out.println("Number of patients: " + patients.size());
        System.out.println(patients);
        System.out.println("expecting patients list to have 6 entries ");

    }
}
