package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationTest {
    private Location testLocation;
    private Dinosaur testDinosaur;

    @Test
    void testConstructor() {
        testLocation = new Location();
        List<Dinosaur> location1 = testLocation.returnLocationOfDiscovery("Africa");
        assertTrue(location1.isEmpty());
    }

    @Test
    void testAddToEraGroup() {
        testLocation = new Location();
        testLocation.addToLocationGroup(testDinosaur,"Africa");
        List<Dinosaur> location1 = testLocation.returnLocationOfDiscovery("Africa");
        assertEquals(testDinosaur, location1.get(0));
        assertEquals(1, location1.size());
    }
}

