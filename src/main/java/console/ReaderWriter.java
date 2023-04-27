package console;

import java.io.File;

public interface ReaderWriter {
    Long readLong();
    String readLine();
    void writeLine(String text);
    void write(String text);
    String getValidatedValue(String message);
//    File readFileName();
}
