// Addition/Update/Deletion of element to and from collections (addAll(), removeAll, add(), remove(), size())
// Create a roster from the Person class and add each Person in the newRoster to the existing list and print the new roster List
// Print the number of Persons in roster list after the above addition
// Remove the all the Person in the roster list
// package com.objectfrontier.training.java.col;*/

package com.objectfrontier.training.java.col;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class AddRemoveElement {

    public static void main(String[] args) {

        List<Person> roster = Person.createRoster();

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

        // Printing roster List
        roster.stream().forEach(x -> System.out.println(x));

        // Printing the number of person in the roaster List
        System.out.println(roster.size());

        // Removing all the person from the roaster List
        roster.removeAll(roster);

        // Printing the number of person in the roaster List after removing all the person from the list
        System.out.println(roster.size());
    }
}
