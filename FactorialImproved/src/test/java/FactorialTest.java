/*
  Test cases
  1. factorial 0 -> 1
  2. factorial 1 -> 1
  3. factorial 2 -> 2
  4. factorial 3 -> 6
  5. factorial 5 -> 120
  6. factorial of a negative value -> raises an exception
  7. factorial of a big number -> raises an exception
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import es.uma.Factorial;
import es.uma.NegativeValueException;
import es.uma.ParameterValueCausesOverflow;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactorialTest {
  Factorial factorial  ;

  @BeforeEach
  void setup() {
    factorial = new Factorial() ;
  }

  @AfterEach
  void shutdown() {
    factorial = null ;
  }

  @Test
  void factorialOfZeroIsOne() {
    int obtainedValue = factorial.compute(0) ;
    int expectedValue = 1 ;

    assertEquals(expectedValue, obtainedValue) ;
  }

  @Test
  void factorialOfOneIsOne() {
    int obtainedValue = factorial.compute(1) ;
    int expectedValue = 1 ;

    assertEquals(expectedValue, obtainedValue) ;
  }

  @Test
  void factorialOfTwoIsTwo() {
    int obtainedValue = factorial.compute(2) ;
    int expectedValue = 2 ;

    assertEquals(expectedValue, obtainedValue) ;
  }

  @Test
  void factorialOf3Is6() {
    int obtainedValue = factorial.compute(3) ;
    int expectedValue = 6 ;

    assertEquals(expectedValue, obtainedValue) ;
  }

  @Test
  void factorialOf5Is120() {
    int obtainedValue = factorial.compute(5) ;
    int expectedValue = 120 ;

    assertEquals(expectedValue, obtainedValue) ;
  }

  @Test
  void factorialOfMinusOneRaisesAnException() {
    assertThrows(NegativeValueException.class, () -> factorial.compute(-1)) ;
  }

  @Test
  void factorialOf13RaisesAndException() {
    assertThrows(ParameterValueCausesOverflow.class, () -> factorial.compute(13)) ;
  }
}