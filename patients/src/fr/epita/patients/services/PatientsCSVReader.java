package fr.epita.patients.services;

import fr.epita.patients.datamodel.Patient;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientsCSVReader {

    private File file;

   public PatientsCSVReader(File file) {
        this.file = file;
    }

    public List<Patient> readAll() throws FileNotFoundException {
        //"1256987452365";Martin;Bernard;Chatillon;"0106060606";2;01/10/2010
        List<Patient> patients = new ArrayList<Patient>();
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Patient patient = getPatient(line);
            patients.add(patient);
        }
        return patients;
    }

    private static Patient getPatient(String line) {
        String[] parts = line.split(";");
        String[] dateParts = parts[6].split("/");
        Patient patient = new Patient(
                parts[0],
                parts[1],
                parts[2],
                Integer.parseInt(parts[5]),
                LocalDate.of(Integer.parseInt(dateParts[2]),
                        Integer.parseInt(dateParts[1]),
                        Integer.parseInt(dateParts[0]))
        );
        patient.setPatTel(parts[3]);
        patient.setPatAddress(parts[4]);
        return patient;
    }
}
