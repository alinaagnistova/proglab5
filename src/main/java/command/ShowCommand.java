package command;

import collection.CollectionManager;
import error.InvalidInputException;
/**
 * Command show. Output to the standard output stream all elements of the collection in string representation
 */
public class ShowCommand extends BaseCommand{
    private final CollectionManager collection;

    public ShowCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) {
        if (args.length > 1) {
            throw new InvalidInputException("Вы неправильно ввели команду");
        } else {
            collection.show();
        }
    }


    public void getDescription() {
        String description = "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
        System.out.println(description);
    }
}
