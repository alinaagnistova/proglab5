import collection.CollectionManager;
import command.CommandManager;
import console.ConsoleManager;
import data.*;

import javax.xml.bind.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;

import static collection.Parser.loadFromXml;
import static collection.Parser.saveToXml;


public class Main {


    public static void main(String[] args) throws IOException, IllegalArgumentException, JAXBException {
        System.out.println("Для начала работы с коллекцией укажите файл с данными");
        System.out.println("После того, как вы подключите файл для работы с коллекцией, введите help для получения справки о доступных командах");
        ConsoleManager consoleManager = new ConsoleManager();
        File fileName = consoleManager.readFileName();


        try {
            CollectionManager collectionManager = new CollectionManager();
            collectionManager.setCollection(loadFromXml(fileName).getCollection());
            new CommandManager(collectionManager);
            while (CommandManager.getWork()) {
                CommandManager.existCommand();
            }
        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
            System.out.println("Приложение не может запуститься");
        }

    }


}
