package com.objectfrontier.training.java.jdbc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectfrontier.training.java.jdbc.model.Address;
import com.objectfrontier.training.java.jdbc.model.Person;
import com.objectfrontier.training.java.jdbc.service.ConnectionService;
import com.objectfrontier.training.java.jdbc.service.PersonService;

public class PersonServiceTest {

    private PersonService personService;

    @BeforeClass
    private void init() {
        this.personService = new PersonService();
    }

    @Test
    private void testCreate_positive() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Person person = new Person();
        Address address = new Address();
        person.setName("Rohan");
        person.setEmail("rohan@gmail.com");
        person.setBirthDate(Date.valueOf("1996-02-07"));
        address.setStreet("Jeeva Nagar");
        address.setCity("Pondicherry");
        address.setPostalCode(605004);
        person.setAddress(address);
        Person expectedPerson = person;
        testCreate_positive(connection, person, expectedPerson);
    }

    private void testCreate_positive(Connection connection, Person person, Person expectedPerson) throws SQLException {

        try {

            Person createdPerson = personService.create(connection, person);
            Assert.assertEquals(createdPerson.getEmail(), expectedPerson.getEmail(), "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    private void testCreate_negative() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Person person = new Person();
        Address address = new Address();
        person.setName("Pal");
        person.setEmail("Pal@gmail.com");
        person.setBirthDate(Date.valueOf("1997-08-08"));
        address.setStreet("South street");
        address.setCity("Pondy");
        address.setPostalCode(641001);
        person.setAddress(address);
        String expected = "Duplicate entry " + "'" + person.getEmail() + "'" + " for key 'email'";
        testCreate_negative(connection, person, expected);
    }

   private void testCreate_negative(Connection connection, Person person, String expectedError) throws SQLException {

        try {

            personService.create(connection, person);
            Assert.fail("failed");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), expectedError, "Success!");
        }
    }

    @Test
    private void testUpdate_positive() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Person person = new Person();
        Address address = new Address();
        person.setId(3);
        person.setName("Sakthivel");
        person.setEmail("sakthi@gmail.com");
        person.setBirthDate(Date.valueOf("1996-08-01"));
        address.setStreet("Lawspet");
        address.setCity("Pondy");
        address.setPostalCode(605004);
        person.setAddress(address);
        Person expectedPerson = person;
        testUpdate_positive(connection, person, expectedPerson);
    }

    private void testUpdate_positive(Connection connection, Person person, Person expectedPerson) throws SQLException {

        try {

            boolean createdPerson = personService.update(connection, person);
            Assert.assertEquals(createdPerson, true, "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    private void testUpdate_negative() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Person person = new Person();
        Address address = new Address();
        person.setId(1);
        person.setName("Sakthivel");
        person.setEmail("sakthi@gmail.com");
        person.setBirthDate(Date.valueOf("1996-08-01"));
        address.setStreet("Lawspet");
        address.setCity("Pondy");
        address.setPostalCode(605004);
        person.setAddress(address);
        String expected = "ID not found";
        testUpdate_negative(connection, person, expected);
    }

    private void testUpdate_negative(Connection connection, Person person, String expectedError) throws SQLException {

        try {

            personService.update(connection, person);
            Assert.fail("failed");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), expectedError, "Success!");
        }
    }

    @Test
    private void testRead_positive() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Person person = new Person();
        person.setId(3);
        testRead_positive(connection, person, true);
    }

    private void testRead_positive(Connection connection, Person person, boolean includeAddress) {

        try {
            Person personDetails = personService.read(connection, person.getId(), includeAddress);
            Assert.assertEquals(personDetails.getAddress().getId(), 3, "Success");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    private void testRead_negative() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Person person = new Person();
        person.setId(6);
        String expectedError = "No person found in this ID " + person.getId();
        testRead_negative(connection, person, true, expectedError);
    }

    private void testRead_negative(Connection connection, Person person, boolean includeAddress, String experctedError) {

        try {
            personService.read(connection, person.getId(), includeAddress);
            Assert.fail("Failed");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), experctedError, "Success");
        }
    }

    @Test
    private void testDelete_positive() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Person person = new Person();
        Address address = new Address();
        person.setId(6);
        address.setId(102);
        person.setAddress(address);
        testDelete_positive(connection, person);
    }

    private void testDelete_positive(Connection connection, Person person) {

        try {
            boolean personDetails = personService.delete(connection, person);
            Assert.assertEquals(personDetails, true, "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    private void testDelete_negative() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Person person = new Person();
        person.setId(5);
        String expectedError = "No person found in this ID " + person.getId();
        testDelete_negative(connection, person, expectedError);
    }

    private void testDelete_negative(Connection connection, Person person, String experctedError) {

        try {
            personService.delete(connection, person);
            Assert.fail("Failed");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), experctedError, "Success!");
        }
    }
}
