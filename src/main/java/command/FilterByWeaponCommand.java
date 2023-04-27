package command;

import collection.CollectionManager;
import data.Weapon;
import error.InvalidInputException;
/**
 * filter_by_weapon_type weaponType :
 * output elements whose value of the weaponType field is equal to the specified
 */
public class FilterByWeaponCommand extends BaseCommand{
    private final CollectionManager collection;

    public FilterByWeaponCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) {
        Weapon weapon;
        if (args.length != 2) {
            System.out.println("Вы неправильно ввели команду");
        } if (collection.getCollection().size() == 0){
            System.out.println("Фильтровать нечего, файл пуст...");
        }
        else {
            try {
                weapon = Weapon.valueOf(args[1].toUpperCase());
                collection.filterByWeapon(weapon);
                System.out.println("Команда выполнена");
            }catch (IllegalArgumentException e){
                System.out.println("Тип оружия введен неверно, попробуйте снова:(");
            }
        }
    }


    public void getDescription() {
        String description = "filter_by_weapon_type weaponType : вывести элементы, значение поля weaponType которых равно заданному";
        System.out.println(description);
    }
}
