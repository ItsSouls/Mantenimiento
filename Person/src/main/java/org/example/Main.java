package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person Margarita = new Person("Mar", 8, "Female");
        Person Paco = new Person("Mal", 9, "Female");
        List<Person> lista = new ArrayList<>();
        lista.add(Margarita);
        lista.add(Paco);
        System.out.println(Margarita.averageAgePerGender(lista)[0]+ " " + Margarita.averageAgePerGender(lista)[1]);
    }
}
