package fr.epita.biostat.launcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) throws IOException {
        //scannerPlusSystemInDemo();
        Path path = Paths.get("biostat/biostat.csv");
        Scanner sc = new Scanner(path);
        List<BioStatEntry> entries = new ArrayList<>();
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        System.out.println(entries.size());

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
