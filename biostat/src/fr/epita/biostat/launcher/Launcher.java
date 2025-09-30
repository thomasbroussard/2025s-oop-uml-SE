package fr.epita.biostat.launcher;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) throws IOException {
        //scannerPlusSystemInDemo();
        Path path = Paths.get("biostat/biostat.csv");
        Scanner sc = new Scanner(path);
        List<BioStatEntry> entries = new ArrayList<>();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.trim().replace("\"", "");
            String[] cells = line.split(",");
            BioStatEntry entry = new BioStatEntry(
                    cells[0].trim(),
                    cells[1].trim(),
                    Integer.parseInt(cells[2].trim()),
                    Integer.parseInt(cells[3].trim()),
                    Integer.parseInt(cells[4].trim())
            );
            entries.add(entry);
        }

        File newFile = new File("biostat/biostat.out.csv");
        PrintWriter writer = new PrintWriter(newFile);
        String header = """
                "Name",     "Sex", "Age", "Height (in)", "Weight (lbs)" """;
        writer.println(header);
        for (BioStatEntry entry : entries) {
            String line = entry.getName() + ", "+
                    entry.getSex() + ", "+
                    entry.getAge() + ", " +
                    entry.getHeight() + ", " +
                    entry.getWeight();
            writer.println(line);
        }
        writer.close();


        System.out.println(entries.size());
        double averageAge = 0.0;
        for (BioStatEntry entry : entries) {
            averageAge += entry.getAge();
        }
        averageAge /= entries.size();
        System.out.println("Average age: " + averageAge);
        sc.close();

    }

    private static void scannerPlusSystemInDemo() {
        System.out.println("Hello World!");

        Scanner sc = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = sc.nextLine();

        System.out.println("your name is " + name);

        System.out.println("What is your age?");
        String age = sc.nextLine();
        try {
            Integer.parseInt(age);
        }catch (NumberFormatException e) {
            //TODO handle error message, and loop until we have a proper input?
            e.printStackTrace();
        }
        System.out.println("your age is " + age);
        sc.close();
    }
}
