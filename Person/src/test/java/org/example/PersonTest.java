package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    List<Person> lista;
    @BeforeEach
    void setup(){
        Person Margarita = new Person("Mar", 8, "Female");
        Person Paco = new Person("Mal", 9, "Female");
        lista = new ArrayList<>();
        lista.add(Paco);
        lista.add(Margarita);
    }

    @Test
    void CorrectGender(){
        for (Person persona : lista) {
            assertTrue(persona.gender().compareTo("Male") == 0 || persona.gender().compareTo("Female") == 0);
        }
    }

    @Test
    void AgeGreaterthan0() {
        for (Person persona : lista) {
            assertTrue(persona.age() >= 0);
        }
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



}


