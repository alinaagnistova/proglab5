package console;


import collection.CollectionManager;
import command.CommandManager;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static collection.Parser.loadFromXml;

public class ConsoleManager implements ReaderWriter {

    public ConsoleManager (){
    }
    @Override
    public Long readLong() {
        Scanner scanner = new Scanner(System.in);
        Long number = Long.valueOf(scanner.nextLine().trim());
        return number;
    }

    @Override
    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().trim();
        return text;
    }

    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }

    @Override
    public void write(String text) {
        System.out.print(text);
    }

    @Override
    public String getValidatedValue(String message) {
        write(message);
        while (true) {
            String userPrint = readLine();
            if (!userPrint.isEmpty() && !userPrint.isBlank()) {
                return userPrint;
            }
        }

    }
    public void fileRead() throws JAXBException, FileNotFoundException {
        while (true) {
            try {
                System.out.println("Введите название файла еще раз");
                Scanner scanner = new Scanner(System.in);
                String Path = scanner.nextLine();
                File file = new File(String.valueOf(Path));
                CollectionManager collectionManager = new CollectionManager();
                collectionManager.setCollection(loadFromXml(Path).getCollection());
                CommandManager commandManager = new CommandManager(collectionManager);
                commandManager.setFileLink(Path);
                while (CommandManager.getWork()) {
                    CommandManager.existCommand();
                }
            } catch (IllegalArgumentException e){
                System.out.println("Файл не найден");
            }
        }
    }
//    @Override
//    public File readFileName(){
//        Scanner scanner = new Scanner(System.in);
//        String path = scanner.nextLine();
//        File file = new File(String.valueOf(path));
//        return file;
//    }
}
