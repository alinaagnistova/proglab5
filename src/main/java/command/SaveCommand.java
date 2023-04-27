package command;

import collection.CollectionManager;
import collection.Parser;
import console.ConsoleManager;
import error.InvalidInputException;

import javax.xml.bind.JAXBException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * save : save the collection to a file
 */
public class SaveCommand extends BaseCommand{
    private final CollectionManager collection;

    public SaveCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) throws JAXBException, IOException {
        if (args.length != 2) {
            System.out.println("Вы неправильно ввели команду");
        } else{
//            Parser.saveToXml(collection);
            collection.save(args[1]);
            System.out.println("Команда выполнена");
        }
    }


    public void getDescription() {
        String description = "save : сохранить коллекцию в файл";
        System.out.println(description);
    }
}

