package fr.epita.biostat.service;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class CSVService {

    public static final String DELIMITER = ",";

    /**
     * reads a list of biostat entries from the given file
     * usage:
     * <pre><code>
     *     List<BioStatEntry> entries = CSVService.readFromFile("path/to/file");
     *     //do sth
     * </code></pre>
     * @param pathToFile : string representing a file path (preferably absolute)
     * @return list of biostat entries
     * @throws IOException
     */
    public static List<BioStatEntry> readFromFile(String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile);
        Scanner sc = new Scanner(path);
        List<BioStatEntry> entries = new ArrayList<>();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.trim().replace("\"", "");
            String[] cells = line.split(DELIMITER);
            BioStatEntry entry = new BioStatEntry(
                    cells[0].trim(),
                    cells[1].trim(),
                    Integer.parseInt(cells[2].trim()),
                    Integer.parseInt(cells[3].trim()),
                    Integer.parseInt(cells[4].trim())
            );
            entries.add(entry);
        }
        sc.close();
        return entries;
    }


    public static void writeToFile(String pathname, List<BioStatEntry> entries) throws FileNotFoundException {
        File newFile = new File(pathname);
        PrintWriter writer = new PrintWriter(newFile);
        String header = """
                "Name",     "Sex", "Age", "Height (in)", "Weight (lbs)" """;
        writer.println(header);
        for (BioStatEntry entry : entries) {
            String line = entry.getName() + DELIMITER +
                    entry.getSex() + DELIMITER+
                    entry.getAge() + DELIMITER +
                    entry.getHeight() + DELIMITER +
                    entry.getWeight();
            writer.println(line);
        }
        writer.close();
    }
}
