package command;
import client.ClientManager;
import client.ReadManager;
import collection.CollectionManager;
import console.ConsoleManager;
import console.ReaderWriter;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;


public abstract class BaseCommand{
    ClientManager clientManager = new ClientManager();
    ReaderWriter readerWriter = new ConsoleManager();
    private Object argument;

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
    public abstract void execute(String[] args) throws JAXBException, IOException, FileNotFoundException;
    public abstract void getDescription();
}
