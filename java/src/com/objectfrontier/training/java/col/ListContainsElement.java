// Contains
// Consider the following Person:  new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE, "bob@example.com")
//  Check if the above Person is in the roster list obtained from Person class
package com.objectfrontier.training.java.col;

import java.time.chrono.IsoChronology;
import java.util.List;

public class ListContainsElement {

    public static void main(String[] args) {

        List<Person> roster = Person.createRoster();
        Person checkPerson = new Person("Bob",
                                      IsoChronology.INSTANCE.date(2000, 9, 12),
                                      Person.Sex.MALE,
                                      "bob@example.com");

        System.out.println(roster.stream().anyMatch(x -> x.getEmailAddress().contains(checkPerson.getEmailAddress())));
    }

}
