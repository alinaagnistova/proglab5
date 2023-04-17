package command;

import collection.CollectionManager;
import collection.Parser;
import console.ConsoleManager;
import error.InvalidInputException;

import javax.xml.bind.JAXBException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SaveCommand extends BaseCommand{
    private final CollectionManager collection;

    public SaveCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) throws JAXBException, IOException {
        if (args.length > 1) {
            throw new InvalidInputException("Вы неправильно ввели команду");
        } else{
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();
            Parser.saveToXml(collection, new File(filename));
            System.out.println("Команда выполнена");
        }
    }


    public String getDescription() {
        String description = "save : сохранить коллекцию в файл";
        return description;
    }
}

