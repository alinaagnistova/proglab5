package command;

/**
 * exit : terminate the program (without saving to a file)
 */
public class ExitCommand extends BaseCommand {

    @Override
    public void execute(String[] args){
        if (args.length>1){
            System.out.println("Вы неправильно ввели команду");
        } else {
            System.out.println("Работа завершена, до связи!");
            System.exit(0);
        }
    }

    @Override
    public void getDescription() {
        String description = "exit : завершить программу (без сохранения в файл)";
        System.out.println(description);
    }
}
