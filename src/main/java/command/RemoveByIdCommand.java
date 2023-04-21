package command;


import collection.CollectionManager;
import error.InvalidInputException;
/**
 * Command remove_by_id id : remove an item from the collection by its id
 */
public class RemoveByIdCommand extends BaseCommand{
    private final CollectionManager collection;

    public RemoveByIdCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) {
        if (args.length != 2) {
            throw new InvalidInputException("Вы неправильно ввели команду");
        } else {
            try {
                Long ID = Long.parseLong(args[1]);
                collection.removeById(ID);
                System.out.println("Команда выполнена");
            } catch (NumberFormatException e) {
                System.out.println("Введён неккоретный ID, попробуйте снова");
            }
        }
    }


    public void getDescription() {
        String description = "remove_by_id id : удалить элемент из коллекции по его id";
        System.out.println(description);
    }
}
