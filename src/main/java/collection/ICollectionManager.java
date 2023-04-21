package collection;

import data.SpaceMarine;
import data.Weapon;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface ICollectionManager {
    void info();
    void show();
    void add(SpaceMarine spaceMarine);
    void updateId(SpaceMarine spaceMarine, Long id);
    void removeById(Long id);
    void clear();
    void shuffle();
    void removeGreater(Float health);
    void sort();
    void filterByWeapon(Weapon weaponType);
    void printUniqueMeleeWeapon();
    void printFieldDescendingWeapon();
}
