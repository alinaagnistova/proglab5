package collection;

import data.SpaceMarine;

import javax.xml.bind.*;
import java.io.*;

public final class Parser {
    private Parser() {
    }
    public static void saveToXml(CollectionManager collectionManager, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            marshaller.marshal(collectionManager, writer);
            writer.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static CollectionManager loadFromXml(File file) {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (CollectionManager) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            System.out.println("С файлом что-то не так, либо он пуст. В коллекции нет исходных данных");
            return new CollectionManager();
//            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Указанный файл не найден");
        }
    }
}



