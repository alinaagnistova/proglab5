package command;

import collection.CollectionManager;
import error.InvalidInputException;
/**
 * shuffle : shuffle collection items in random order
 */
public class ShuffleCommand extends BaseCommand{
    private final CollectionManager collection;

    public ShuffleCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Вы неправильно ввели команду");
        } if (collection.getCollection().size() == 0){
            System.out.println("Сортировать нечего, файл пуст...");
        } else {
            collection.shuffle();
            System.out.println("Команда выполнена");
        }
    }


    public void getDescription() {
        String description = "shuffle : перемешать элементы коллекции в случайном порядке";
        System.out.println(description);
    }
}
