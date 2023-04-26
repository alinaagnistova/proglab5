//package main.java;

import collection.CollectionManager;
import collection.CollectionUtil;
import command.CommandManager;
import data.SpaceMarine;
import error.IncorrectCollectionException;

import javax.xml.bind.*;
import java.io.*;
import java.util.LinkedList;


import static collection.Parser.loadFromXml;


public class Main {

    public static void main(String[] args) throws IOException, IllegalArgumentException, JAXBException {
        System.out.println("Для начала работы с коллекцией укажите файл с данными");
        System.out.println("После того, как вы подключите файл для работы с коллекцией, введите help для получения справки о доступных командах");
        try {
            CollectionManager collectionManager = new CollectionManager();
            CollectionUtil collectionUtil = new CollectionUtil();
            collectionManager.setCollection(loadFromXml().getCollection());
            collectionManager.checkCollection();
            new CommandManager(collectionManager);
            while (CommandManager.getWork()) {
                CommandManager.existCommand();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Отказываюсь работать в таких условиях, пока!");
        }

    }


}
