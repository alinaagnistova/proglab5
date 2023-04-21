package command;

import client.ClientManager;
import collection.CollectionManager;
import collection.CollectionUtil;
import error.InvalidInputException;
/**
 * Command update id {element} : update the value of the collection item whose id is equal to the given one
 */
public class UpdateIdCommand extends BaseCommand {
    private final CollectionManager collection;
    CollectionUtil collectionUtil = new CollectionUtil();

    public UpdateIdCommand(CollectionManager collection) {
        this.collection = collection;
    }

    public void execute(String[] args) {
        if (ExecuteScriptCommand.getFlag()) {
            collection.add(ClientManager.createSpaceMarineFromScript(ExecuteScriptCommand.getSpaceMarineList()));
        }else if (args.length != 2) {
            throw new InvalidInputException("Вы неправильно ввели команду");
        } else {
            try {
                Long ID = Long.parseLong(args[1]);
                if (collectionUtil.checkExist(ID)) {
                    collection.updateId(clientManager.getSpaceMarine(), ID);
                    System.out.println("Команда выполнена");
                } else{
                    System.out.println("Элемента с таким ID не существует");
                }
            }catch (NumberFormatException e) {
                System.out.println("Введён неккоретный ID, попробуйте снова");
            }
        }
    }

        public void getDescription () {
            String description = "update id {element} : обновить значение элемента коллекции, id которого равен заданному";
            System.out.println(description);
        }
    }


