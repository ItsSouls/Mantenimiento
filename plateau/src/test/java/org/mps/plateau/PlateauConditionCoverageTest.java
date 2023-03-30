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
    void ConditionCoverageExceptionWithOneCondition() {
        assertThrows(IllegalArgumentException.class, () -> longestPlateau(array));
    }

    @Test
    void ConditionCoverageExceptionWithoutAnyCondition() {
        array = new int[]{1,2,3};
        assertDoesNotThrow(() -> longestPlateau(array));
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
        array = new int[]{1,2,2,1};
        int position = 1;
        int length = 2;
        assertEquals(position, longestPlateau(array).position());
        assertEquals(length, longestPlateau(array).length());
    }
}