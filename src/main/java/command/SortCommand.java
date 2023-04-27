package command;

import collection.CollectionManager;
import error.InvalidInputException;
/**
 * sort : sort the collection in natural order
 */
public class SortCommand extends BaseCommand{
    private final CollectionManager collection;

    public SortCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Вы неправильно ввели команду");
        } if (collection.getCollection().size() == 0){
            System.out.println("Сортировать нечего, файл пуст...");
        } else {
            collection.sort();
            System.out.println("Команда выполнена");
        }
    }


    public void getDescription() {
        String description = "sort : отсортировать коллекцию в естественном порядке";
        System.out.println(description);
    }
}
