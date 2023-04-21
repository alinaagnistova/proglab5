package command;


import collection.CollectionManager;
import error.InvalidInputException;
/**
 * Command clear : clear the collection
 */
public class ClearCommand extends BaseCommand{
    private final CollectionManager collection;

    public ClearCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) {
        if (args.length > 1) {
            throw new InvalidInputException("Вы неправильно ввели команду");
        } else {
            collection.clear();
            System.out.println("Команда выполнена");
        }
    }


    public void getDescription() {
        String description = "clear : очистить коллекцию";
        System.out.println(description);
    }
}
