// Write a program to filter the Person, who are male and age greater than 21

package com.objectfrontier.training.java.col;

import java.util.List;
import java.util.stream.Collectors;

import com.objectfrontier.training.java.col.Person.Sex;

// class FilterPerson {
public class FilterPerson {

    // execute {
    public static void main(String[] args) {

        // List person = createPersonList();
        List<Person> person = Person.createRoster();

        // List filteredPerson = filterPerson(person);
        List<Person> filteredPerson = FilterPerson.filterPerson(person);

        // print(filteredPerson);
        for (Person filtered : filteredPerson) {
            filtered.printPerson();
        }
    }

    // filterPerson() {
    private static List<Person> filterPerson(List<Person> person) {

        // List filterPerson = filter(Gender, Age);
        List<Person> filterPerson = person.stream()
                                          .filter(roster -> (roster.getGender() == Sex.MALE) &&
                                                            (roster.getAge() > 21))
                                          .collect(Collectors.toList());
        return filterPerson;
    }
}
