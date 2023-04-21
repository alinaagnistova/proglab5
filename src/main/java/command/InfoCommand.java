package command;


import collection.CollectionManager;
import error.InvalidInputException;

/**
 * info :
 * output to the standard output stream information about the collection
 * (type, initialization date, number of items, etc.)
 */
public class InfoCommand extends BaseCommand{
    private final CollectionManager collection;

    public InfoCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) {
        if (args.length > 1) {
            throw new InvalidInputException("Вы неправильно ввели команду");
        } else {
            collection.info();
        }
    }


    public void getDescription() {
        String description = "info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
        System.out.println(description);
    }
}
