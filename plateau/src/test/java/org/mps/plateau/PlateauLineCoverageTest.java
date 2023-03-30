package org.mps.plateau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("LineCoverage")
class PlateauLineCoverageTest {
    int[] array;

    @BeforeEach
    void setUp(){
        array = null;
    }

    @Test
    void LineCoverageException2() {
        array = new int[]{1,2};
        assertThrows(IllegalArgumentException.class, () -> Plateau.longestPlateau(array));
    }

    @Test
    void LineCoverage() {
        array = new int[]{0,1,3,3,3,3,2,1};
        int position = 2;
        int length = 4;
        assertEquals(position, Plateau.longestPlateau(array).position());
        assertEquals(length, Plateau.longestPlateau(array).length());
    }
}