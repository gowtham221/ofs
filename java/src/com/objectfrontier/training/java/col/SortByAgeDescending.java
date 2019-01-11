
package com.objectfrontier.training.java.col;

import java.util.Comparator;
import java.util.List;

public class SortByAgeDescending {

    public static void main(String[] args) {

        List<Person> person = Person.createRoster();
        person.stream().sorted(Comparator.comparing(Person::getAge).reversed());
        person.stream().forEach(x -> System.out.println(x));
    }

}
