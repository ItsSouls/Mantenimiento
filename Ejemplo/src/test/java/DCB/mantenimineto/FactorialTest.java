package DCB.mantenimineto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    Test cases
    1. factorial 0 -> 1
    2. factorial 1 -> 1
    3. factorial 2 -> 2
    3. factorial 3 -> 6
 */

class FactorialTest {
    Factorial factorial;
    @BeforeEach
    void setup(){
        factorial = new Factorial();
    }

    @AfterEach
    void shutdown(){
        factorial = null;
    }

    @Test
    @Tag("Result")
    void factorialOfZeroIsOne(){
        int obtainedValue = factorial.compute(0);
        int expectedValue = 1;

        assertEquals(expectedValue,obtainedValue);
    }
    @Test
    @Tag("Result")
    void factorialOfOneIsOne(){
         int obtainedValue = factorial.compute(1);
        int expectedValue = 1;

        assertEquals(expectedValue,obtainedValue);
    }
    @Test
    @Tag("Result")
    void factorialOfTwoIsTwo(){
        int obtainedValue = factorial.compute(2);
        int expectedValue = 2;

        assertEquals(expectedValue,obtainedValue);
    }
    @Test
    @Tag("Result")
    void factorialOfThreeIsSix(){
        int obtainedValue = factorial.compute(3);
        int expectedValue = 6;

        assertEquals(expectedValue,obtainedValue);
    }
    @Test
    @Tag("Result")
    void factorialOf5Is120(){
        int obtainedValue = factorial.compute(5);
        int expectedValue = 120;

        assertEquals(expectedValue,obtainedValue);
    }
    @Test
    @Tag("Exception")
    void factorialOfMinusOneIs(){
        assertThrows(RuntimeException.class, () -> factorial.compute(-1));
    }

    @Test
    @Tag("Exception")
    void factorialOfMinusOneIsNegativeValueException(){
        fail("Not implemented yet");
        //assertThrows(NegativeValueException.class, () -> factorial.compute(-1));
    }
}