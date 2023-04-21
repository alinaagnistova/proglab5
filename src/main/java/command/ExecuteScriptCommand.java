package command;
//TODO rewrite class


import collection.CollectionManager;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * execute_script file_name : read and execute the script from the specified file.
 * The script contains commands in the same form as they are entered by the user in interactive mode.
 */
public class ExecuteScriptCommand extends BaseCommand{
private final CollectionManager collection;
    private HashMap<String, BaseCommand> commandMap;
    private ArrayList<String> filePaths;
    static ArrayList<String> spaceMarineList = new ArrayList<>();
    static boolean flag = false;

    public ExecuteScriptCommand(CollectionManager collection) {
        this.collection = collection;
        this.commandMap = CommandManager.getCommandMap();
        this.filePaths = new ArrayList<>();
    }

    /**
     * performs a script reading with command processing
     * reads the file lines by adding the commands to the array
     * if the "add" command, creates an array with the persons characteristics
     *
     * @param args
     * @throws JAXBException
     * @throws IOException
     */
    @Override
    public void execute(String[] args) throws JAXBException, IOException {
        if (args.length != 2) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            flag = true;
            filePaths.add((String) getArgument());
            ArrayList<String> commandList = new ArrayList<>();
            try (Scanner reader = new Scanner(new FileInputStream((String) getArgument()))) {
                while (reader.hasNextLine()) {
                    String line = reader.nextLine().trim();
                    commandList.add(line);
                }

            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            }

            for (int i = 0; i < commandList.size(); i++) {
                while (commandList.get(i).contains("  "))
                    commandList.get(i).replaceAll("  ", " ");

                String[] commandAndArgument = commandList.get(i).split(" ");
                String argument;

                if (commandAndArgument.length == 1)
                    argument = null;
                else if (commandAndArgument.length == 2)
                    argument = commandAndArgument[1];
                else {
                    System.out.println("Введите команду и аргумент, если нужно");
                    return;
                }
                boolean a = !commandAndArgument[0].equals("add") && !commandAndArgument[0].equals("update"); //todo
                try {
                    if (commandMap.containsKey(commandAndArgument[0]) && a) {
                        if (commandAndArgument[0].equals("execute_script")) {
                            if (filePaths.contains(commandAndArgument[1])) {
                                System.out.println("Файл содержит рекурсию");
                                continue;
                            }
                        }
                        commandMap.get(commandAndArgument[0]).setArgument(argument);
                        commandMap.get(commandAndArgument[0]).execute(commandAndArgument);

                    } else if (!a) {
                        for (int j = 1; j < 10; j++) {
                            spaceMarineList.add(commandList.get(i + j));
                        }
                        commandMap.get(commandAndArgument[0]).execute(commandAndArgument);
                        i += 10;
                    }

                } catch (NullPointerException | IndexOutOfBoundsException e) {
                    System.out.println("Неверные данные в скрипте, персонаж не создан");
                }
            }
            filePaths.remove(getArgument());
        }
    }

    public static boolean getFlag() {
        return flag;
    }

    public static ArrayList<String> getSpaceMarineList() {
        return spaceMarineList;
    }

    @Override
    public void getDescription() {
        String description = "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме";
        System.out.println(description);
    }
}
