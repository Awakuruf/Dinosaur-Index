package persistence;

import model.Dinosaur;
import model.DinosaurList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonDinoWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            DinosaurList dL = new DinosaurList("DinosaurIndex #1");
            JsonDinoWriter writer = new JsonDinoWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyDinosaurList() {
        try {
            DinosaurList dL = new DinosaurList("My DinosaurIndex");
            JsonDinoWriter writer = new JsonDinoWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(dL);
            writer.close();

            JsonDinoAnalyzer reader = new JsonDinoAnalyzer("./data/testWriterEmptyWorkroom.json");
            dL = reader.analyze();
            assertEquals("My DinosaurIndex", dL.getName());
            assertEquals(0, dL.returnSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            DinosaurList dL = new DinosaurList("My DinoIndex");
            dL.addToCatalogueOfDino(new Dinosaur("Ankylosaur"));
            dL.addToCatalogueOfDino(new Dinosaur("Velociraptor"));
            JsonDinoWriter writer = new JsonDinoWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(dL);
            writer.close();

            JsonDinoAnalyzer analyzer = new JsonDinoAnalyzer("./data/testWriterGeneralWorkroom.json");
            dL = analyzer.analyze();
            assertEquals("My DinoIndex", dL.getName());
            List<Dinosaur> dinosaurCatalogue = dL.returnCatalogueOfDinosaur();
            assertEquals(2, dinosaurCatalogue.size());
            checkDino("Ankylosaur", "No Mesozoic Era inputted", "No Diet inputted", "No Location of Discovery inputted", 0, "No Description inputted", dinosaurCatalogue.get(0));
            checkDino("Velociraptor", "No Mesozoic Era inputted", "No Diet inputted", "No Location of Discovery inputted", 0, "No Description inputted", dinosaurCatalogue.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown!");
        }
    }
}
