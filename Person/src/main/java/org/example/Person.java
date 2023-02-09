package org.example;

import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author David Castaños Benedicto
 */

public class Person {

    private final String name;
    private final int age;
    private final String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name(){
        return name;
    }

    public int age(){
        return age;
    }

    public String gender(){
        return gender;
    }

    /*
     * Computes the average age of male and female persons in a list and returns the result in
     * an array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param person
     * @return
     */
    public double[] averageAgePerGender(List<Person> persons) {
        double acummale = 0, contmale = 0;
        double acumfemale = 0, contfemale = 0;

        for (Person person : persons) {
            if (person.gender.compareTo("Male") == 0) {
                acummale += person.age;
                ++contmale;
            } else {
                acumfemale += person.age;
                ++contfemale;
            }
        }
        if (acummale == 0) {
            return new double[]{0, acumfemale / contfemale};
        } else if (acumfemale == 0) {
            return new double[]{acummale / contmale, 0};
        } else {
            return new double[]{acummale / contmale, acumfemale / contfemale};
        }
    }
}