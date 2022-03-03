package persistence;

import model.Dinosaur;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Codes referenced from JsonSerializationDemo.
public class JsonTest {
    protected void checkDino(String name, String era, String diet, String location, Integer size, String description, Dinosaur dino) {
        assertEquals(name, dino.getName());
        assertEquals(era, dino.getEra());
        assertEquals(diet, dino.getDiet());
        assertEquals(location, dino.getLocation());
        assertEquals(size, dino.getSize());
        assertEquals(description, dino.getDescription());
    }
}
