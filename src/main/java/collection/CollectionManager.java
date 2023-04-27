package collection;

import client.ClientManager;
import data.LocalDateAdapter;
import data.MeleeWeapon;
import data.SpaceMarine;
import data.Weapon;
import error.IncorrectCollectionException;


import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * The class that implements collection related methods
 */
@XmlRootElement
@XmlSeeAlso({SpaceMarine.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionManager implements ICollectionManager {
    CollectionUtil collectionUtil = new CollectionUtil();
    ClientManager clientManager = new ClientManager();
    private String filename = "s";

    @XmlElement
    private static LinkedList<SpaceMarine> collection = new LinkedList<>();
    @XmlTransient
    private LocalDate date = LocalDate.now();

    public CollectionManager(LinkedList<SpaceMarine> collection, String filename) {
        this.collection = collection;
        this.filename = filename;
    }

    public CollectionManager() {
    }

    /**
     * @return
     */
    public static LinkedList<SpaceMarine> getCollection() {
        Collections.sort(collection);
        return collection;
    }

    @XmlElement(name = "creation_date_collectionManager")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCollection(LinkedList<SpaceMarine> spaceMarineCollection) {
        for (SpaceMarine spaceMarine : spaceMarineCollection) {
            spaceMarine.setName(spaceMarine.getName());
            spaceMarine.setCoordinates(spaceMarine.getCoordinates());
            spaceMarine.setHealth(spaceMarine.getHealth());
            spaceMarine.setChapter(spaceMarine.getChapter());
            spaceMarine.setCategory(spaceMarine.getCategory());
            spaceMarine.setWeaponType(spaceMarine.getWeaponType());
            spaceMarine.setMeleeWeapon(spaceMarine.getMeleeWeapon());
        }
        this.collection = spaceMarineCollection;
    }

    /**
     * print info about collection
     */
    @Override
    public void info() {
        String info = "Type of collection:" + collection.getClass().getSimpleName() + "\nDate of initialization:" + date + "\nNumbers of elements:" + collection.size();
        System.out.println(info);
    }
    /**
     * print info about each element in collection
     */
    @Override
    public void show() {
        if (collection.size() != 0) {
            collection.forEach(CollectionUtil::display);
        } else {
            System.out.println("В коллекции нет объектов, доступных для просмотра");
        }
    }

    /**
     * adds SpaceMarine
     *
     * @param spaceMarine
     */
    @Override
    public void add(SpaceMarine spaceMarine) {
        collection.add(spaceMarine);

    }

    /**
     * updates data of spaceMarine, ID stays the same
     *
     * @param newSpaceMarine
     * @param ID
     */
    @Override
    public void updateId(SpaceMarine newSpaceMarine, Long ID) {
        for (SpaceMarine spaceMarine : collection){
            if (spaceMarine.getId().equals(ID)){
                spaceMarine.setName(newSpaceMarine.getName());
                spaceMarine.setCoordinates(newSpaceMarine.getCoordinates());
                spaceMarine.setHealth(newSpaceMarine.getHealth());
                spaceMarine.setChapter(newSpaceMarine.getChapter());
                if (spaceMarine.getCategory() != null) {
                        spaceMarine.setCategory(newSpaceMarine.getCategory());
                    }
                    if (spaceMarine.getWeaponType() != null) {
                        spaceMarine.setWeaponType(newSpaceMarine.getWeaponType());
                    }
                    if (spaceMarine.getMeleeWeapon() != null) {
                        spaceMarine.setMeleeWeapon(newSpaceMarine.getMeleeWeapon());
                    }
            }
        }
    }

    /**
     * remove SpaceMarine by id
     *
     * @param ID
     */

    @Override
    public void removeById(Long ID) {
        Iterator<SpaceMarine> iterator = collection.iterator();
        while (iterator.hasNext()) {
            SpaceMarine spaceMarine = iterator.next();
            {
                if (spaceMarine.getId().equals(ID)) {
                    iterator.remove();
                    System.out.println("Элемент удален из коллекции");
                } else if (!iterator.hasNext()) {
                    System.out.println("Элемента с таким ID не существует");
                }
            }
        }
    }
    /**
     * clear collection
     *
     */
    @Override
    public void clear() {
        collection.clear();
    }
    /**
     * shuffle collection
     *
     */
    @Override
    public void shuffle() {
        Collections.shuffle(collection);
    }

    /**
     * removes the healthiest person
     *
     * @param health
     */
    @Override
    public void removeGreater(Float health) {
        Iterator<SpaceMarine> iterator = collection.iterator();
        while (iterator.hasNext()) {
            SpaceMarine spaceMarine = iterator.next();
            {
                if (spaceMarine.getHealth() > health) {
                    iterator.remove();
                    System.out.println("Элемент удален из коллекции: " + spaceMarine.getName());
                } else if (!iterator.hasNext()) {
                    System.out.println("Нет элементов с таким же уровнем здоровья");
                }
            }
        }
    }

    /**
     * sort collection
     *
     */
    @Override
    public void sort() {
        Collections.sort(collection);
    }
    /**
     * show elements with this kind of weapon
     *
     * @param weaponType
     */
    @Override
    public void filterByWeapon(Weapon weaponType) {
        ArrayList<SpaceMarine> filterObjects = new ArrayList<>();
        for (SpaceMarine spaceMarine : collection) {
            if (spaceMarine.getWeaponType() == weaponType) {
                filterObjects.add(spaceMarine);
            }
        }
        if (filterObjects.size() == 0) {
            System.out.println("Нет ни одного экземпляра с таким полем");
        } else {
            filterObjects.forEach(CollectionUtil::display);
        }
    }
    /**
     * find unique meleeWeapons and print them
     *
     */
    @Override
    public void printUniqueMeleeWeapon() {
        ArrayList<MeleeWeapon> uniq = new ArrayList<>();
        for (SpaceMarine spaceMarine : collection) {
            MeleeWeapon meleeWeapon = spaceMarine.getMeleeWeapon();
            if (Collections.frequency(uniq, meleeWeapon) == 0) {
                uniq.add(meleeWeapon);
            }
        }
        System.out.println(uniq);
    }

    /**
     * find all weapons in collection and print it (descending)
     *
     */
    @Override
    public void printFieldDescendingWeapon() {
        ArrayList<Weapon> descendingWeapon = new ArrayList<>();
        for (SpaceMarine spaceMarine : collection) {
            Weapon weaponType = spaceMarine.getWeaponType();
            if (Collections.frequency(descendingWeapon, weaponType) == 0) {
                descendingWeapon.add(weaponType);
            }
        }
            Collections.sort(descendingWeapon, Collections.reverseOrder());
            System.out.println(descendingWeapon);
        }
        public void checkCollection(){
            for (SpaceMarine spaceMarine : collection){
                if (!collectionUtil.checkIfCorrect(spaceMarine)){
                    throw new IncorrectCollectionException("Исходные данные в коллекции неверны, исправьте файл и попробуйте ещё раз");
                }
            }
        }
    public void save(String file) throws JAXBException, IOException {
//        try {
//            String sc = file.trim();
//            Parser.saveToXml(this, sc);
////        } catch (FileNotFoundException e) {
////            System.out.println("Файл для сохранения не найден");
//        } catch (NullPointerException e) {
//            System.out.println("Сохранит в текущий файл");
//            Parser.saveToXml(this, file);
//        }
    }

    }





