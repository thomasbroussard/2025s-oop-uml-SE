package fr.epita.biostat.launcher;

import fr.epita.biostat.datamodel.BioStatEntry;
import fr.epita.biostat.service.CSVService;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Launcher {

    public static void main(String[] args) throws IOException {
        //scannerPlusSystemInDemo();
        String filePath = "biostat/biostat.csv";
        List<BioStatEntry> entries = CSVService.readFromFile(filePath);

        String pathname = "biostat/biostat.out.csv";
        CSVService.writeToFile(pathname, entries);


        System.out.println(entries.size());
        double averageAge = 0.0;
        for (BioStatEntry entry : entries) {
            averageAge += entry.getAge();
        }
        averageAge /= entries.size();
        System.out.println("Average age: " + averageAge);

        Map<String,Integer> map = new LinkedHashMap<>();
        for (BioStatEntry entry : entries) {
            Integer count = map.getOrDefault(entry.getSex(), 0);
            map.put(entry.getSex(), count+1);
        }
        Map<Integer,Integer> countByAge = new LinkedHashMap<>();
        for (BioStatEntry entry : entries) {
            Integer count = map.getOrDefault(entry.getAge(), 0);
            countByAge.put(entry.getAge(), count+1);
        }
        System.out.println(countByAge);

        Map<String, Long> countBySex = entries
                .stream()
                .collect(Collectors.groupingBy(BioStatEntry::getSex, Collectors.counting()));
        System.out.println(countBySex);
        System.out.println(map);


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
