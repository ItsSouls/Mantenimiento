package org.mps.plateau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mps.plateau.Plateau.longestPlateau;

@Tag("BranchCoverage")
class PlateauBranchCoverageTest {

    int[] array;

    @BeforeEach
    void setUp(){
        array = null;
    }

    @Test
    void BranchCoverageException() {
        assertThrows(IllegalArgumentException.class, () -> longestPlateau(array));
    }

    @Test
    void BranchCoverage() {
        array = new int[]{0,1,3,3,3,3,2,1};
        int position = 2;
        int length = 4;
        assertEquals(position, Plateau.longestPlateau(array).position());
        assertEquals(length, Plateau.longestPlateau(array).length());
    }


}