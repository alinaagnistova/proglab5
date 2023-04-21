package console;


import java.io.File;
import java.util.Scanner;

public class ConsoleManager implements ReaderWriter {

    public ConsoleManager (){
    }
    @Override
    public Long readLong() {
        Scanner scanner = new Scanner(System.in);
        Long number = Long.valueOf(scanner.nextLine().trim());
        return number;
    }

    @Override
    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().trim();
        return text;
    }

    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }

    @Override
    public void write(String text) {
        System.out.print(text);
    }

    @Override
    public String getValidatedValue(String message) {
        write(message);
        while (true) {
            String userPrint = readLine();
            if (!userPrint.isEmpty() && !userPrint.isBlank()) {
                return userPrint;
            }
        }

    }
    @Override
    public File readFileName(){
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(String.valueOf(path));
        return file;
    }
}
