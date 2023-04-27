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
                            collectionManager.setCollection(loadFromXml(file).getCollection());
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
//                    System.out.println(e.getMessage());
                    consoleManager.fileRead();
                }
            }
        } catch (JAXBException | NoSuchElementException e) {
            System.out.println("Отказываюсь работать в таких условиях, пока!");
        }
    }
}











//        System.out.println("Для начала работы с коллекцией укажите файл с данными");
//        System.out.println("После того, как вы подключите файл для работы с коллекцией, введите help для получения справки о доступных командах");
//        try {
//            CollectionManager collectionManager = new CollectionManager();
//            try {
//                if (args.length > 0) {
//                    File file = new File(args[0]);
//                    Parser parser = new Parser(file);
//                    collectionManager.setCollection(parser.loadFromXml().getCollection());
//                }
//            }catch(ArrayIndexOutOfBoundsException ex){
//                ex.getMessage();
////                File file = new File("С://Users//agnis//IdeaProjects//Prog_lab5Aline-main//test.xml");
////                Parser parser = new Parser(file);
//            }
//                collectionManager.checkCollection();
//            new CommandManager(collectionManager);
//            while (CommandManager.getWork()) {
//                CommandManager.existCommand();
//            }
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//            System.out.println("Отказываюсь работать в таких условиях, пока!");
//        }


