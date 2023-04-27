package collection;

import console.ConsoleManager;
import data.SpaceMarine;
import error.IncorrectCollectionException;

import javax.xml.bind.*;
import java.io.*;

public final class Parser {
    static ConsoleManager consoleManager = new ConsoleManager();

        private static String fileName;
    public Parser(String fileName) {
        fileName = this.fileName;
    }
    public Parser() {
    }

    /**
     * converts JavaObject to XML file
     *
     * @param collectionManager
     * @throws JAXBException
     * @throws IOException
     */
    public static void saveToXml(CollectionManager collectionManager){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            marshaller.marshal(collectionManager, writer);
            writer.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * converts XML to JavaObject
     *
     * @return unmarshal file
     * @throws JAXBException
     */
    public static CollectionManager loadFromXml(String fileName) throws FileNotFoundException, JAXBException {
        Parser.fileName = fileName;
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (CollectionManager) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            System.out.println("С файлом что-то не так, либо он пуст. В коллекции нет исходных данных");
            return new CollectionManager();
        } catch (FileNotFoundException ex) {
            System.out.println("Указанный файл не найден");
            consoleManager.fileRead();
        }
        return null;
        }
    }



