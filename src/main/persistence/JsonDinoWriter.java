package persistence;

import model.DinosaurList;
import model.Event;
import model.EventLog;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


//Represents a writer that writes JSON representation of workroom to file.
//Codes referenced from JsonSerializationDemo.
public class JsonDinoWriter {

    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    //EFFECTS: Constructs a writer to write to the given destination
    public JsonDinoWriter(String destination) {
        this.destination = destination;
    }

    //MODIFIES: this
    //EFFECTS: If the file is cannot be found for opening,
    //         throws FileNotFoundException,
    //         otherwise opens the writer
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    //MODIFIES: this
    //EFFECTS: Writes the JSON representation of the DinosaurList to file
    public void write(DinosaurList dl) {
        JSONObject json = dl.toJson();
        saveToFile(json.toString(TAB));
    }

    //MODIFIES: this
    //EFFECTS: Closes the writer
    public void close() {
        writer.close();
    }

    //MODIFIES: this
    //EFFECTS: Writes string to the file
    public void saveToFile(String json) {
        writer.print(json);
    }

}
