import collection.CollectionManager;
import collection.CollectionUtil;
import collection.Parser;
import command.CommandManager;
import console.ConsoleManager;
import data.SpaceMarine;
import error.IncorrectCollectionException;

import javax.xml.bind.*;
import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;


import static collection.Parser.loadFromXml;


public class Main {

    public static void main(String[] args) throws IOException, IllegalArgumentException, JAXBException {
        try {
            CollectionManager collectionManager = new CollectionManager();
            ConsoleManager consoleManager = new ConsoleManager();
            while (true) {
                try {
                    if (args.length > 0) {
                        String link = args[0];
                        File file = new File(link);
                        if (file.exists() && !file.isDirectory()) {
                            collectionManager.setCollection(loadFromXml(args[0]).getCollection());
                            CommandManager commandManager = new CommandManager(collectionManager);
                            commandManager.setFileLink(link);
                            while (CommandManager.getWork()) {
                                CommandManager.existCommand();
                            }
                        } else {
                            consoleManager.fileRead();
                        }
                    } else {
                        consoleManager.fileRead();
                    }
                } catch (IllegalArgumentException e) {
                    consoleManager.fileRead();
                }
            }
        } catch (JAXBException | NoSuchElementException e) {
            System.out.println("Отказываюсь работать в таких условиях, пока!");
        }
    }
}



