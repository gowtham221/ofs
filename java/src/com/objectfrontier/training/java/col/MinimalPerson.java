// Write a program to print minimal Person with name and email address from the Person class using java.util.Stream<T>#map

package com.objectfrontier.training.java.col;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// class Minimal Person {
public class MinimalPerson {

    // String name;
    String name;
    // String emailAddress;
    String emailAddress;

    // execute {
    public static void main(String[] args) {

        // List person = createPersonList();
        List<Person> person = Person.createRoster();

        // List minimalPerson = minimalPerson(person);
        List<MinimalPerson> minimalPerson = MinimalPerson.minimalPerson(person);

        // print(minimalPerson);
        for (MinimalPerson minimal : minimalPerson) {
            System.out.println(minimal.name + " " + minimal.emailAddress);
        }
    }

    // minimalPerson() {
    private static List<MinimalPerson> minimalPerson(List<Person> person) {

        // toMinimal = person -> {
        Function<Person, MinimalPerson> toMinimal = input -> {

            MinimalPerson minimaldto = new MinimalPerson();

            // minimaldto.name = person.name;
            minimaldto.name = input.name;

            // minimaldto.emailAddress = person.emailAddress;
            minimaldto.emailAddress = input.emailAddress;

            // return minimaldto;
            return minimaldto;
        };

        List<MinimalPerson> miniamlPerson = person.stream()
                                                  .map(toMinimal)
                                                  .collect(Collectors.toList());
        return miniamlPerson;
    }
}
