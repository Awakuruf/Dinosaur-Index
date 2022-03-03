package persistence;

import model.Dinosaur;
import model.DinosaurList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonDinoAnalyzerTest extends JsonTest {

    @Test
    void testLoadingNonExistentFile() {
        JsonDinoAnalyzer analyzer = new JsonDinoAnalyzer("./data/noSuchFile.json");
        try {
            DinosaurList dL = analyzer.analyze();
            fail("IOException expected.");
        }
         catch (IOException e) {
            //pass
        }
    }

    @Test
    void testLoadingEmptyDinosaurList() {
        JsonDinoAnalyzer analyzer = new JsonDinoAnalyzer("./data/testLoadingEmptyDinosaurList.json");
        try {
            DinosaurList dl = analyzer.analyze();
            assertEquals("My DinoIndex",dl.getName());
            assertEquals(0, dl.returnSize());
        } catch (IOException e) {
            fail("IOException thrown.");
        }
    }

    @Test
    void testReaderGeneralDinosaurList() {
        JsonDinoAnalyzer analyzer = new JsonDinoAnalyzer("./data/testReaderGeneralDinosaurList.json");
        try {
            DinosaurList dl = analyzer.analyze();
            assertEquals("My DinoIndex", dl.getName());
            List<Dinosaur> dinosaurs = dl.returnCatalogueOfDinosaur();
            assertEquals(2, dinosaurs.size());
            checkDino("Ankylosaur", "Cretaceous", "Herbivore", "North America", 10, "Armored Lizard", dinosaurs.get(0));
            checkDino("Stegosaurus", "Jurassic", "Herbivore", "Africa", 9, "Spiked Lizard", dinosaurs.get(1));
        } catch (IOException e) {
            fail("Couldn't analyze the correct file");
        }
    }
}

