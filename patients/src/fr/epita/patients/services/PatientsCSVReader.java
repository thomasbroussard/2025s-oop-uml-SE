package fr.epita.patients.services;

import fr.epita.patients.datamodel.Patient;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

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

    public Map<String,String> extractSocialSecurityNumber(String patNumHC) {
       Map<String,String > result = new HashMap<>();
       if (patNumHC == null || patNumHC.isEmpty()) {
           return result;
       }
       result.put("gender",patNumHC.substring(0,1));
       result.put("birthYear",patNumHC.substring(1,3));
       result.put("birthMonth",patNumHC.substring(3,5));
       result.put("birthLocation",patNumHC.substring(5,7));
       return result;
    }

    private static Patient getPatient(String line) {
        String[] parts = line.split(";");
        String[] dateParts = parts[6].split("/");
        Patient patient = new Patient(
                parts[0].replace("\"",""),
                parts[1],
                parts[2],
                Integer.parseInt(parts[5]),
                LocalDate.of(Integer.parseInt(dateParts[2]),
                        Integer.parseInt(dateParts[1]),
                        Integer.parseInt(dateParts[0]))
        );
        patient.setPatTel(parts[3].replace("\"",""));
        patient.setPatAddress(parts[4]);
        return patient;
    }
}
