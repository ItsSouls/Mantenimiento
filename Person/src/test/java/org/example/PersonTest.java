package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    List<Person> lista;
    List<Person> lista1;
    List<Person> lista2;
    @BeforeEach
    void setup(){
        Person Margarita = new Person("Mar", 8, "Female");
        Person Paco = new Person("Paco", 9, "Male");
        lista = new ArrayList<>();
        lista.add(Paco);
        lista.add(Margarita);
    }

    @BeforeEach
    void setupFemale(){
        Person Margarita = new Person("Mar", 10, "Female");
        Person Malena = new Person("Malena", 24, "Female");
        lista1 = new ArrayList<>();
        lista1.add(Malena);
        lista1.add(Margarita);
    }
    @BeforeEach
    void setupMale(){
        Person Paco = new Person("Paco", 18, "Male");
        Person Antonio = new Person("Antonio", 15, "Male");
        lista2 = new ArrayList<>();
        lista2.add(Paco);
        lista2.add(Antonio);
    }

    @Test
    void CorrectGender(){
        for (Person persona : lista) {
            assertTrue(persona.gender().compareTo("Male") == 0 || persona.gender().compareTo("Female") == 0);
        }
    }
    @Test
    void CorrectGenderFemale(){
        for (Person personafemale : lista1){
            assertEquals(0, personafemale.gender().compareTo("Female"));
        }
    }

    @Test
    void CorrectGenderMale(){
        for (Person personaMale: lista2){
            assertEquals(0, personaMale.gender().compareTo("Male"));
        }
    }
    @Test
    void AgeGreaterthan0() {
        for (Person persona : lista) {
            assertTrue(persona.age() >= 0);
        }
    }

    @Test
    public void testAllFemales() {
        // Create a list of Person objects, containing only female individuals
        // Invoke the averageAgePerGender function
        double[] result = lista1.get(0).averageAgePerGender(lista1);

        // Verify the result
        double[] expectedResult = {0, 17.0};
        assertArrayEquals(expectedResult, result, 0.001);
    }

    @Test
    public void testAllMales() {
        // Create a list of Person objects, containing only female individuals
        // Invoke the averageAgePerGender function
        double[] result = lista2.get(0).averageAgePerGender(lista2);

        // Verify the result
        double[] expectedResult = {16.5, 0};
        assertArrayEquals(expectedResult, result, 0.001);
    }
    @Test
    void AverageAgeGreaterthan0(){
        for (Person persona :lista) {
            assertTrue(persona.averageAgePerGender(lista)[0] >=0 && persona.averageAgePerGender(lista)[1] >=0);
        }
    }

    @Test
    void ListIsNotEmpty(){
        assertFalse(lista.isEmpty());
    }

    @Test
    void AverageAgeIsCorrect(){
        for (Person persona :lista) {
            assertTrue(persona.averageAgePerGender(lista)[0] == 9 && persona.averageAgePerGender(lista)[1] == 8);
        }
    }

    @Test
    void NameIsNotEmpty(){
        for (Person persona :lista) {
            assertFalse(persona.name().isEmpty());
        }
    }
}


