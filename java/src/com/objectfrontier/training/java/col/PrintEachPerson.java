//Print all the persons in the roster using java.util.Stream<T>#forEach
package com.objectfrontier.training.java.col;

import java.util.List;
import java.util.stream.Collectors;

public class PrintEachPerson {

    public static void main(String[] args) {

        List<Person> person = Person.createRoster();
        person.stream().collect(Collectors.toList()).forEach(x -> System.out.println(x));
    }
}
