// Iterate the roster list in Persons class and and print the Person without using forLoop/Stream

package com.objectfrontier.training.java.col;

import java.util.Iterator;
import java.util.List;

public class IterateOverList {

    public static void main(String[] args) {

        List<Person> person = Person.createRoster();
        Iterator<Person> iterated = person.iterator();

        while (iterated.hasNext()) {

            Person nextPerson = iterated.next();
            System.out.println(nextPerson.name);
        }
    }
}
