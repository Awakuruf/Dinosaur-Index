package persistence;

import model.Dinosaur;
import model.DinosaurList;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//Represents the loader for DinoIndex that analyzes the stored dinosaurs in the files.
//Codes referenced from JsonSerializationDemo.
public class JsonDinoAnalyzer {
    private String source;

    //EFFECTS: Constructs the loader that analyzes the source file.
    public JsonDinoAnalyzer(String source) {
        this.source = source;
    }

    //EFFECTS: Loads the listOfDinosaurs from file and returns it.
    //         Throws IOException if an error occurs when loading the data from file.
    public DinosaurList analyze() throws IOException {
        String jsonData = analyzeFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDinosaurList(jsonObject);
    }

    //EFFECTS: Analyzes source file as a string and returns it.
    private String analyzeFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses dinosaurList from JSON object and returns it
    private DinosaurList parseDinosaurList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        DinosaurList dinosaurList = new DinosaurList(name);
        addDinosaurs(dinosaurList, jsonObject);
        return dinosaurList;
    }

    // MODIFIES: DinosaurList
    // EFFECTS: parses DinosaurList from JSON object and adds them to workroom
    private void addDinosaurs(DinosaurList dl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("dinosaurList");
        for (Object json : jsonArray) {
            JSONObject nextDinosaur = (JSONObject) json;
            addDinosaur(dl, nextDinosaur);
        }

    }

    // MODIFIES: DinosaurList
    // EFFECTS: parses Dinosaur from JSON object and adds it to DinosaurList
    private void addDinosaur(DinosaurList dl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String diet = jsonObject.getString("diet");
        String era = jsonObject.getString("era");
        String location = jsonObject.getString("location");
        Integer size = jsonObject.getInt("size");
        String description = jsonObject.getString("description");
        String image = jsonObject.getString("image");
        Dinosaur dinosaur = new Dinosaur(name);
        dl.addToCatalogueOfDino(dinosaur);
        dinosaur.addDiet(diet);
        dinosaur.addEra(era);
        dinosaur.addLocationFound(location);
        dinosaur.addSize(size);
        dinosaur.addDescription(description);
        dinosaur.addImageDirectory(image);
    }





}
