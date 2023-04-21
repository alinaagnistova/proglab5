package command;

import collection.CollectionManager;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

/**
 * The class is responsible for checking for the correctness of commands and running them
 */
public class CommandManager {
    private final CollectionManager collection;
    private static boolean isWorking = true;
    private static HashMap<String, BaseCommand> commandMap = new HashMap<>();

    /**
     * creates a commandMap with commands
     *
     * @param collection
     */
    public CommandManager(CollectionManager collection) {
        this.collection = collection;
        commandMap = new HashMap<>();
        commandMap.put("help", new HelpCommand());
        commandMap.put("info", new InfoCommand(collection));
        commandMap.put("show", new ShowCommand(collection));
        commandMap.put("add", new AddCommand(collection));
        commandMap.put("update", new UpdateIdCommand(collection));
        commandMap.put("remove_by_id", new RemoveByIdCommand(collection));
        commandMap.put("clear", new ClearCommand(collection));
        commandMap.put("save", new SaveCommand(collection));
        commandMap.put("execute_script", new ExecuteScriptCommand(collection));
        commandMap.put("exit", new ExitCommand());
        commandMap.put("shuffle", new ShuffleCommand(collection));
        commandMap.put("remove_greater", new RemoveGreaterCommand(collection));
        commandMap.put("sort", new SortCommand(collection));
        commandMap.put("filter_by_weapon_type", new FilterByWeaponCommand(collection));
        commandMap.put("print_unique_melee_weapon", new PrintUniqueMeleeWeaponCommand(collection));
        commandMap.put("print_field_descending_weapon_type", new PrintFieldDescendingWeapon(collection));
    }


    public static HashMap<String, BaseCommand> getCommandMap() {
        return commandMap;
    }


    /**
     *checks for the correctness of the command and starts
     */
    public static void existCommand() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите команду: ");
            String command = sc.nextLine().trim().toLowerCase();

            String[] commandArg = command.split(" ");
            String argument;

            if (commandArg.length == 1)
                argument = null;
            else if (commandArg.length == 2)
                argument = commandArg[1];
            else {
                return;
            }

            if (commandMap.containsKey(commandArg[0])) {
                commandMap.get(commandArg[0]).setArgument(argument);
                try {
                    commandMap.get(commandArg[0]).execute(commandArg);
                } catch (JAXBException | IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Команды " + commandArg[0] + " не существует");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Теперь наши пути расходятся, как в море корабли...");
            isWorking = false;
            System.exit(0);
        }
    }

    public static boolean getWork() {
        return isWorking;
    }

}

