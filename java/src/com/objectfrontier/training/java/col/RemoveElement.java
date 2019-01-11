package com.objectfrontier.training.java.col;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {

        List<Person> roster = Person.createRoster();
        Person check = new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE, "bob@example.com");

        // Creating newRoster List
        ArrayList<Person> newRoster = new ArrayList<>(4);

        // Adding elements to the newRoster List
        newRoster.add(new Person("John",
                                 IsoChronology.INSTANCE.date(1980, 6, 20),
                                 Person.Sex.MALE,
                                 "john@example.com"));
        newRoster.add(new Person("Jade",
                                 IsoChronology.INSTANCE.date(1990, 7, 15),
                                 Person.Sex.FEMALE,
                                 "jade@example.com"));
        newRoster.add(new Person("Donald",
                                 IsoChronology.INSTANCE.date(1991, 8, 13),
                                 Person.Sex.MALE,
                                 "donald@example.com"));
        newRoster.add(new Person("Bob",
                                 IsoChronology.INSTANCE.date(2000, 9, 12),
                                 Person.Sex.MALE,
                                 "bob@example.com"));

        // Adding newRoster List to the roster List
        roster.addAll(newRoster);

        // Printing the roster list after adding the newRoster list
        System.out.println("roster list after adding the newRoster list\n");
        roster.stream().forEach(x -> System.out.println(x));

        // Remove the newRoster list from the roster list
        roster.removeAll(newRoster);

        // Printing the roster list after removing the newRoster list
        System.out.println("\nroster list after removing the newRoster list\n");
        roster.stream().forEach(x -> System.out.println(x));

        Iterator<Person> iterate = roster.iterator();

        while (iterate.hasNext()) {

            // Remove given person from the roster list
            if (check.getEmailAddress().equals(iterate.next().getEmailAddress())) {
                iterate.remove();
            }
        }

        // Printing the roster list after removing the given person
        System.out.println("\nroster list after removing the given person\n");
        roster.forEach(x -> System.out.println(x));
    }

}
