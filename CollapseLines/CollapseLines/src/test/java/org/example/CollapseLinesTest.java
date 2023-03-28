package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollapseLinesTest {

    @Test
    public void ExceptioThrow() { // 1
        assertThrows(IndexOutOfBoundsException.class, () -> CollapseLines.collapseNewLines(""));
    }

    @Test
    public void OneCharacter() { // 2
        String result = CollapseLines.collapseNewLines("\n");
        assertEquals("", result);
    }

    @Test
    public void OnlyNewLine(){ // 3
        String result = CollapseLines.collapseNewLines("a");
        assertEquals("a", result);
    }

    @Test
    public void NewLineAndLetter(){ // 4
        String result = CollapseLines.collapseNewLines("\na");
        assertEquals("a", result );
    }

    @Test
    public void TwoNewLines(){ // 5
        String result = CollapseLines.collapseNewLines("\n\n");
        assertEquals("", result);
    }

    @Test
    public void TwoLettersAndNewLine(){ // 6
        String result = CollapseLines.collapseNewLines("ab\n");
        assertEquals("ab\n", result);
    }

    @Test
    public void TwoLettersAndTwoNewLines(){ // 7
        String result = CollapseLines.collapseNewLines("ab\n\n");
        assertEquals("ab\n", result);
    }

    @Test
    public void TwoNewLinesAndTwoLetters(){ // 8
        String result = CollapseLines.collapseNewLines("\n\na");
        assertEquals("a", result);
    }

}