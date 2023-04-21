package command;


import collection.CollectionManager;
import java.util.ArrayList;

/**
 * help : print help for available commands
 */
public class HelpCommand extends BaseCommand {


    @Override
    public void execute(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        BaseCommand add = new AddCommand(collectionManager);
        BaseCommand clear = new ClearCommand(collectionManager);
        BaseCommand executeScript = new ExecuteScriptCommand(collectionManager);
        BaseCommand exit = new ExitCommand();
        BaseCommand filterByWeapon = new FilterByWeaponCommand(collectionManager);
        BaseCommand info = new InfoCommand(collectionManager);
        BaseCommand printField = new PrintFieldDescendingWeapon(collectionManager);
        BaseCommand printUniqueWeapon = new PrintUniqueMeleeWeaponCommand(collectionManager);
        BaseCommand removeById = new RemoveByIdCommand(collectionManager);
        BaseCommand remove = new RemoveGreaterCommand(collectionManager);
        BaseCommand help = new HelpCommand();
        BaseCommand updateId = new UpdateIdCommand(collectionManager);
        BaseCommand show = new ShowCommand(collectionManager);
        BaseCommand save = new SaveCommand(collectionManager);
        BaseCommand shuffle = new ShuffleCommand(collectionManager);
        BaseCommand sort = new SortCommand(collectionManager);
        ArrayList<BaseCommand> commands = new ArrayList<>();
        commands.add(show);
        commands.add(add);
        commands.add(clear);
        commands.add(executeScript);
        commands.add(exit);
        commands.add(save);
        commands.add(filterByWeapon);
        commands.add(info);
        commands.add(printField);
        commands.add(printUniqueWeapon);
        commands.add(removeById);
        commands.add(remove);
        commands.add(shuffle);
        commands.add(sort);
        commands.add(updateId);
        commands.add(help);
        if (args.length > 1) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            commands.forEach(BaseCommand::getDescription);
        }
    }

    @Override
    public void getDescription() {
        String description = "help : получить краткую справку по доступным командам";
        System.out.println(description);
    }
}

