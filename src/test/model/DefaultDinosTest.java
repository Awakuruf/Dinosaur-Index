package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefaultDinosTest {

    private DefaultDinos testDino;

    @BeforeEach
    void runBefore() {
        testDino = new DefaultDinos();
    }

    @Test
    void testMakeDinos() {
        testDino.makeDinosaur1();
        testDino.makeDinosaurs2();
        testDino.makeDinosaurs3();
        testDino.makeDinosaurs4();
        testDino.makeDinosaurs5();
        testDino.makeDinosaurs6();
    }

    @Test
    void testInitialise() {
        testDino.setDefaultDinoIndex();}
}
