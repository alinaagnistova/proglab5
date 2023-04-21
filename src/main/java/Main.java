//package main.java;

import collection.CollectionManager;
import command.CommandManager;
import javax.xml.bind.*;
import java.io.*;


import static collection.Parser.loadFromXml;


public class Main {

    public static void main(String[] args) throws IOException, IllegalArgumentException, JAXBException {
        System.out.println("Для начала работы с коллекцией укажите файл с данными");
        System.out.println("После того, как вы подключите файл для работы с коллекцией, введите help для получения справки о доступных командах");
        try {
            CollectionManager collectionManager = new CollectionManager();
            collectionManager.setCollection(loadFromXml(args[0]).getCollection());
            new CommandManager(collectionManager);
            while (CommandManager.getWork()) {
                CommandManager.existCommand();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Приложение не может запуститься");
        }

    }


}
