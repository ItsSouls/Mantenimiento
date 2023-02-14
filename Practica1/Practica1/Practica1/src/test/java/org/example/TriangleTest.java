/*Caso 1: El triangulo escaleno valido
  Caso 2: El triangulo equilatero es valido
  Caso 3: El triangulo isosceles es valido
  Caso 4: Triangulo isosceles valido con valores ejemplo permutados
  Caso 5: El triangulo tiene un lado nulo (0)
  Caso 6: El triangulo tiene un lado negativo
  Caso 7: La longitud de un lado es igual
  a la suma de las longitudes de otros lados
  Caso 8: Permutaciones donde la longitud de un lado es igual
  a la suma de las longitudes de los otros dos lados
  Caso 9: La suma de 2 enteros es menor que un tercero
  Caso 10: Permutaciones en el caso 9
  Caso 11: Todos los lados son nulos (0)
  Caso 12: Numero no enteros
  Caso 13: más o menos valores de los que necesita
*/
package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {
    Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test //Caso 1 todos los lados son diferentes
    void ScaleneIsValid() {
        assertEquals(triangle.getType(3, 4, 5), Triangle.TriangleType.SCALENE);
        assertEquals(triangle.getType(5, 6, 7), Triangle.TriangleType.SCALENE);
        assertEquals(triangle.getType(6, 7, 8), Triangle.TriangleType.SCALENE);
    }
    @Test //Caso 2 todos los lados son iguales
    void EquilateralIsValid() {
        assertEquals(triangle.getType(3, 3, 3), Triangle.TriangleType.EQUILATERAL);
        assertEquals(triangle.getType(5, 5, 5), Triangle.TriangleType.EQUILATERAL);
        assertEquals(triangle.getType(6, 6, 6), Triangle.TriangleType.EQUILATERAL);
    }

    @Test //Caso 3 dos lados son iguales
    void IsoscelesIsValid() {
        assertEquals(triangle.getType(3, 3, 4), Triangle.TriangleType.ISOSCELES);
        assertEquals(triangle.getType(5, 5, 6), Triangle.TriangleType.ISOSCELES);
        assertEquals(triangle.getType(6, 6, 7), Triangle.TriangleType.ISOSCELES);
    }

    @Test//Caso 4 Triangulo isosceles valido con valores ejemplo permutados
    void IsoscelesIsValidPermutations() {
        assertEquals(triangle.getType(3, 3, 4), Triangle.TriangleType.ISOSCELES);
        assertEquals(triangle.getType(4, 3, 3), Triangle.TriangleType.ISOSCELES);
        assertEquals(triangle.getType(3, 4, 3), Triangle.TriangleType.ISOSCELES);
    }

    @Test //Caso 5 , Caso 11 Tiene uno o todos los lados nulos
    void ZeroSide() {
        assertThrows(RuntimeException.class, () -> triangle.getType(0, 0, 0));
        assertThrows(RuntimeException.class, () -> triangle.getType(0, 3, 4));
        assertThrows(RuntimeException.class, () -> triangle.getType(3, 0, 4));
        assertThrows(RuntimeException.class, () -> triangle.getType(3, 4, 0));
    }

    @Test //Caso 6 Tiene uno o todos los lados negativos
    void NegativeSide() {
        assertThrows(RuntimeException.class, () -> triangle.getType(-1, -1, -1));
        assertThrows(RuntimeException.class, () -> triangle.getType(-1, 3, 4));
        assertThrows(RuntimeException.class, () -> triangle.getType(3, -1, 4));
        assertThrows(RuntimeException.class, () -> triangle.getType(3, 4, -1));
    }

    @Test //Caso 7 y 8 La longitud de un lado es igual a la suma de las longitudes de otros lados y sus permutaciones (Hecho con los valores de ejemplo)
    void SumOfTwoSidesIsEqualToThird() {
        assertThrows(RuntimeException.class, () -> triangle.getType(1, 2, 3));
        assertThrows(RuntimeException.class, () -> triangle.getType(1, 3, 2));
        assertThrows(RuntimeException.class, () -> triangle.getType(3, 1, 2));
    }

    @Test //Caso 9 y 10 La suma de 2 enteros es menor que un tercero y sus permutaciones (Hecho con los valores de ejemplo)
    void SumOfTwoSidesIsLessThanThird() {
        assertThrows(RuntimeException.class, () -> triangle.getType(1, 2, 4));
        assertThrows(RuntimeException.class, () -> triangle.getType(1, 4, 2));
        assertThrows(RuntimeException.class, () -> triangle.getType(4, 1, 2));
        assertThrows(RuntimeException.class, () -> triangle.getType(12, 15, 30));
        assertThrows(RuntimeException.class, () -> triangle.getType(15, 12, 30));
        assertThrows(RuntimeException.class, () -> triangle.getType(30, 12, 15));
    }

    @Test //Caso 12 Numero no enteros
    void NotInteger() {
        assertEquals(triangle.getType(2.5, 3.5, 5.5), Triangle.TriangleType.SCALENE);
        assertEquals(triangle.getType(2.5, 3, 5), Triangle.TriangleType.SCALENE);
        assertEquals(triangle.getType(2, 3.5, 5), Triangle.TriangleType.SCALENE);
        assertEquals(triangle.getType(2, 3, 4.5), Triangle.TriangleType.SCALENE);
    }
}