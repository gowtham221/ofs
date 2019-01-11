//findFirst/last/any
//
//    Write a program to filter the Person, who are male and
//
//        find the first person from the filtered persons
//        find the last person from the filtered persons
//        find random person from the filtered persons


package com.objectfrontier.training.java.col;

import java.util.List;
import java.util.stream.Collectors;

import com.objectfrontier.training.java.col.Person.Sex;

// class FindPerson {
public class FindPerson {

    // execute {
    public static void main(String[] args) {

        // List person = createPersonList();
        List<Person> person = Person.createRoster();

        // List filteredPerson = filterPerson(person);
        List<Person> filteredPerson = FindPerson.filterPerson(person);

        // findFirstPerson(filteredPerson);
        FindPerson.findFirstPerson(filteredPerson);

        // findRandomPerson(filteredPerson);
        FindPerson.findRandomPerson(filteredPerson);

        // findLastPerson(filteredPerson);
        FindPerson.findLastPerson(filteredPerson);


    }

    // filterPerson() {
    private static List<Person> filterPerson(List<Person> person) {

        // List filterPerson = filter(MALE);
        List<Person> filterPerson = person.parallelStream()
                                          .filter(roster -> (roster.getGender() == Sex.MALE))
                                          .collect(Collectors.toList());
        return filterPerson;
    }

    // findFirstPerson() {
    private static String findFirstPerson(List<Person> person) {


       // System.out.println(person.stream().findFirst().get().name);

        return person.stream().findFirst().get().name;
    }

    // findRandomPerson() {
    private static String findRandomPerson(List<Person> person) {

         // System.out.println(person.parallelStream().findAny().get().name);

        return person.parallelStream().findAny().get().name;
    }

    // findLastPerson() {
    private static String findLastPerson(List<Person> person) {

        // System.out.println(person.get(person.size() - 1).name);

        return person.get(person.size() - 1).name;
    }
}
