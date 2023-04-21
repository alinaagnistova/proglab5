package command;


import client.ClientManager;
import collection.CollectionManager;
import error.InvalidInputException;
/**
 * Command add {element}
 */
public class AddCommand extends BaseCommand {
    private final CollectionManager collection;

    public AddCommand(CollectionManager collection) {
        this.collection = collection;
    }
    /**
     * add a new element to the collection
     *
     * @param args
     */
    public void execute(String[] args) {
        if (ExecuteScriptCommand.getFlag()) {
            collection.add(ClientManager.createSpaceMarineFromScript(ExecuteScriptCommand.getSpaceMarineList()));
        } else if (args.length > 1) {
            throw new InvalidInputException("Вы неправильно ввели команду");
        } else{
        collection.add(clientManager.getSpaceMarine());
            System.out.println("Команда выполнена");
        }
    }

    public void getDescription() {
        String description = "add {element}: добавить новый элемент в коллекцию";
        System.out.println(description);
    }
}