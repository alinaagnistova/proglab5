package collection;
import java.io.*;
import java.util.HashSet;


/**
 * A class that creates a unique id for each character
 */
public class GenerationID {
    private static final String fileName = "last_id.txt";
    private static HashSet<Long> generatedIDs = new HashSet<>();

    static {
        readLastIDFromFile();
    }
    /**
     * generates a unique id greater than zero
     *
     * @return id (Long)
     */
    public static Long generateID() {
        Long ID = System.currentTimeMillis();
        while (generatedIDs.contains(ID)) {
            ID = System.currentTimeMillis();
        }
        generatedIDs.add(ID);
        saveLastIDToFile(ID);
        return ID;
    }
    /**
     * read last id from file
     *
     */
    private static void readLastIDFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String lastIDString = reader.readLine();
            if (lastIDString != null) {
                Long lastID = Long.parseLong(lastIDString);
                generatedIDs.add(lastID);
            }
        } catch (IOException | NumberFormatException e) { //todo строчка не нужна, но что тогда вставить в блок catch?
            // В случае ошибки чтения из файла просто продолжаем работу со случайно сгенерированными ID
            System.err.println("Не удалось прочитать последнее значение ID, значение сгенерировано случайным образом.");

        }
    }
    /**
     * save last id to file
     * @param ID
     */
    private static void saveLastIDToFile(Long ID) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(ID);
        } catch (IOException e) {
            System.err.println("Не удалось сохранить последнее значение ID");
        }
    }
}

