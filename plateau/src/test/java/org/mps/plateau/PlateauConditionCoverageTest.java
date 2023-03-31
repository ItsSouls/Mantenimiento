package org.mps.plateau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mps.plateau.Plateau.longestPlateau;

@Tag("ConditionCoverage")
class PlateauConditionCoverageTest {
    int[] array;

    @BeforeEach
    void setUp(){
        array = null;
    }

    @Test
    void ConditionCoverageExceptionWithFirstCondition() {
        assertThrows(IllegalArgumentException.class, () -> longestPlateau(array));
        array = new int[]{1,2};
        assertThrows(IllegalArgumentException.class, () -> longestPlateau(array));
    }

    @Test
    void ConditionCoverageWhileLoop() {
        array = new int[]{2,1,3};
        int position = -1;
        int length = 0;
        assertEquals(position, longestPlateau(array).position());
        assertEquals(length, longestPlateau(array).length());
    }

    @Test
    void CoverageForIfStatementLoop() {
        array = new int[]{1,5,5,5};
        int position = -1;
        int length = 0;
        assertEquals(position, longestPlateau(array).position());
        assertEquals(length, longestPlateau(array).length());
    }

    @Test
    void CoverageForIfStatementLoop2() {
        array = new int[]{0,1,2,2,1,4,2};
        int position = 2;
        int length = 2;
        assertEquals(position, longestPlateau(array).position());
        assertEquals(length, longestPlateau(array).length());
    }
}