/*
  Test cases
  1. factorial 0 -> 1
  2. factorial 1 -> 1
  3. factorial 2 -> 2
  4. factorial 3 -> 6
  5. factorial 5 -> 120
  6. factorial 12 -> 479001600
  7. factorial of a negative value -> raises an exception
  8. factorial of a big number -> raises an exception

  Extended cases when using BigInteger
  9. factorial of 13 ->  6227020800
  10. factorial of 18 -> 6402373705728000

  https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested
  https://github.com/fabriciorby/maven-surefire-junit5-tree-reporter
 */

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.condition.JRE.JAVA_21;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import es.uma.Factorial;
import es.uma.NegativeValueException;
import es.uma.ParameterValueCausesOverflow;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit tests for class {@link Factorial}
 *
 *  @author David Castaños Benedicto
 */

@DisplayName("Factorial")
class ImprovedFactorialTest {

  Factorial factorial;

  @Nested
  @DisplayName("of int values")
  class TestCasesForIntValues {

    @BeforeEach
    void setup() {
      factorial = new Factorial();
    }

    @ParameterizedTest
    @DisplayName("that return valid results")
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "5, 120",
        "12, 479001600"
    })
    void theComputeMethodReturnsAValidResult(int number, int expectedValue) {
      int actualValue = factorial.compute(number);
      assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("that throw exceptions when needed")
    void testThrownExceptions() {
      assertAll(
          () -> assertThrows(NegativeValueException.class, () -> factorial.compute(-1)),
          () -> assertThrows(ParameterValueCausesOverflow.class, () -> factorial.compute(13)));
    }

    @AfterEach
    void shutdown() {
      factorial = null;
    }
  }

  @Nested
  @DisplayName("of BigInteger value")
  @EnabledForJreRange(min = JAVA_8, max = JAVA_21)
  class TestCasesForBigIntegerResults {

    @BeforeEach
    void setup() {
      factorial = new Factorial();
    }

    @Test
    @DisplayName("That return valid results")
    void computeBigValueMethodReturnsValidResults() {
      List<Integer> values = List.of(0, 1, 2, 3, 5, 12);
      List<BigInteger> expectedResults = Stream.of(1, 1, 2, 6, 120, 479001600).map(
          BigInteger::valueOf).collect(
          Collectors.toList());

      List<BigInteger> actualValues = values.stream().map(i -> factorial.computeBigValue(i))
          .collect(Collectors.toList());

      assertIterableEquals(expectedResults, actualValues);
    }

    @ParameterizedTest
    @DisplayName("That return expected result for high values")
    @CsvSource({
        "13, 6227020800.0",
        "18, 6402373705728000.0"
    })
    void computeBigValueReturnTheExceptedResult(int number, double expectedValue) {
      assertEquals(expectedValue, factorial.computeBigValue(number).doubleValue());
    }

    @Test
    @DisplayName("That raises an exception when the given value is negative")
    void factorialOfMinusOneRaisesAnException() {
      assertThrows(NegativeValueException.class, () -> factorial.computeBigValue(-1));
    }

    @AfterEach
    void shutdown() {
      factorial = null;
    }
  }
}