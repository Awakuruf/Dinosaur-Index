package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MesozoicEraTest {

    private MesozoicEra testEra;
    private Dinosaur testDinosaur;

    @Test
    void testConstructor() {
        testEra = new MesozoicEra();
        List<Dinosaur> era1 = testEra.returnMesozoicEra("Cretaceous");
        assertTrue(era1.isEmpty());
    }

    @Test
    void testAddToEraGroup() {
        testEra = new MesozoicEra();
        testEra.addToEraGroup(testDinosaur,"Cretaceous");
        List<Dinosaur> era1 = testEra.returnMesozoicEra("Cretaceous");
        assertEquals(testDinosaur, era1.get(0));
        assertEquals(1, era1.size());
    }
}
