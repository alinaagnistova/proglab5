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
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Указанный файл не найден");
        }
    }
}

//    /**
//     * Converts JavaObject to XML file.
//     *
//     * @param spaceMarine JavaObject to be converted to XML file.
//     * @param path        Path to the XML file.
//     * @throws JAXBException
//     * @throws IOException
//     */
//    public static void convertToXML(CollectionManager collectionManager, String path) throws JAXBException, IOException {
//        try{
//            JAXBContext context = JAXBContext.newInstance(CollectionManager.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
//            marshaller.marshal(collectionManager, writer);
//            writer.close();
//        } catch (IOException | JAXBException e) {
//            System.out.println("Права к файлу ограничены");
//        }
//    }
//
//    /**
//     * Converts XML file to JavaObject.
//     *
//     * @param file XML file to be converted to JavaObject.
//     * @return JavaObject representing the XML file.
//     * @throws JAXBException
//     */
//    public static CollectionManager convertToJavaObject(File file) throws JAXBException, FileNotFoundException {
//        try {
////            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file)))
//            JAXBContext context = JAXBContext.newInstance(CollectionManager.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            return (CollectionManager) unmarshaller.unmarshal(file);
//        }catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Указанный файл не найден");
//        }catch (JAXBException e) {
//            System.out.println("С файлом что-то не так, либо он пуст. В коллекции ничего нет");
//            e.printStackTrace();
//            return new CollectionManager();
//        } catch (NullPointerException e) {
//            throw new RuntimeException();
//        }
//    }


