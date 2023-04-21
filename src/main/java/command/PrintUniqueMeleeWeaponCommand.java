package command;

import collection.CollectionManager;
import error.InvalidInputException;
/**
 * print_unique_melee_weapon :
 * print the unique values of the MeleeWeapon field of all items in the collection
 */
public class PrintUniqueMeleeWeaponCommand extends BaseCommand{
    private final CollectionManager collection;

    public PrintUniqueMeleeWeaponCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) {
        if (args.length > 1) {
            throw new InvalidInputException("Вы неправильно ввели команду");
        } else {
            collection.printUniqueMeleeWeapon();
        }
    }


    public void getDescription() {
        String description = "print_unique_melee_weapon : вывести уникальные значения поля meleeWeapon всех элементов в коллекции";
        System.out.println(description);
    }
}
