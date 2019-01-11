package com.objectfrontier.training.java.jdbc.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.java.jdbc.model.Address;
import com.objectfrontier.training.java.jdbc.model.Person;
import com.objectfrontier.training.java.jdbc.test.AppException;

public class PersonService {

   public Person create(Connection connection, Person person) throws SQLException, AppException {

        Person generatedPerson = new Person();
        PreparedStatement createPerson = null;

        if (connection != null) {

            connection.setAutoCommit(false);
            AddressService addressService = new AddressService();
            person.setAddress(addressService.create(connection, person.getAddress()));
            StringBuilder query = new StringBuilder().append("INSERT INTO person (`name`, email, address_id, birth_date,  created_date) ")
                                                     .append("VALUES (?, ?, ?, ?, ?)                                                    ");

            createPerson = connection.prepareStatement(query.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            createPerson.setString(1, person.getName());
            createPerson.setString(2, person.getEmail());
            createPerson.setLong(3, person.getAddress().getId());
            createPerson.setDate(4, person.getBirthDate());
            Date createdDate = new Date(System.currentTimeMillis());
            createPerson.setDate(5, createdDate);
            int createdResult = createPerson.executeUpdate();
            ResultSet newPerson = createPerson.getGeneratedKeys();

            newPerson.next();
            if (createdResult == 1) {
                generatedPerson.setId(newPerson.getLong(1));
                generatedPerson.setEmail(person.getEmail());
                connection.commit();
            } else {
                throw new SQLException();
            }
        }
        createPerson.close();
        connection.close();
        return generatedPerson;
    }

    public Person read(Connection connection, long personId, boolean includeAddress) throws SQLException, AppException {

        Person retrievedPerson = new Person();

        if (connection != null) {

            PersonService personService = new PersonService();

            if (includeAddress) {

                AddressService addressService = new AddressService();
                retrievedPerson = personService.readPerson(connection, personId);
                retrievedPerson.setAddress(addressService.read(connection, retrievedPerson.getAddress().getId()));
            } else {
                retrievedPerson = personService.readPerson(connection, personId);
            }
            connection.close();
            return retrievedPerson;
        } else {
            return null;
        }
    }

    public Person readPerson(Connection connection, long personId) throws SQLException, AppException {

        Address address = new Address();
        Person person = new Person();
        StringBuilder query = new StringBuilder().append("SELECT `name`, email, address_id, birth_date, created_date ")
                                                 .append("FROM person                                                ")
                                                 .append("WHERE id = ?                                               ");
        PreparedStatement readPerson = connection.prepareStatement(query.toString());
        readPerson.setLong(1, personId);
        ResultSet result = readPerson.executeQuery();

        if (result.next() != false) {
            person.setName(result.getString("name"));
            person.setEmail(result.getString("email"));
            address.setId(result.getLong("address_id"));
            person.setAddress(address);
            person.setBirthDate(result.getDate("birth_date"));
            person.setCreatedDate(result.getDate("created_date"));
        } else {
            throw new AppException("No person found in this ID " + personId);
        }
        return person;
    }

    public List<Person> readAllPerson(Connection connection) throws SQLException, AppException {

        List<Person> personDetails = new ArrayList<>();
        AddressService addressService = new AddressService();
        StringBuilder query = new StringBuilder().append("SELECT id, `name`, email, address_id, birth_date, created_date ")
                                                 .append("FROM person                                                ");
        PreparedStatement readAllPerson = connection.prepareStatement(query.toString());
        ResultSet result = readAllPerson.executeQuery();

        while (result.next()) {

            Person retrievedPerson = new Person();
            Address address = new Address();
            retrievedPerson.setId(result.getLong("id"));
            retrievedPerson.setName(result.getString("name"));
            retrievedPerson.setEmail(result.getString("email"));
            retrievedPerson.setBirthDate(result.getDate("birth_date"));
            address.setId(result.getLong("address_id"));
            retrievedPerson.setAddress(address);
            retrievedPerson.setCreatedDate(result.getDate("created_date"));
            retrievedPerson.setAddress(addressService.read(connection, retrievedPerson.getAddress().getId()));
            personDetails.add(retrievedPerson);
        }
        return personDetails;
    }

    public boolean update(Connection connection, Person person) throws SQLException, AppException {

        if (connection != null) {

            AddressService addressService = new AddressService();
            StringBuilder addressUpdate = new StringBuilder().append("SELECT address_id ")
                                                     .append("FROM person ")
                                                     .append("WHERE id = ?");
            PreparedStatement getAddress = connection.prepareStatement(addressUpdate.toString());
            getAddress.setLong(1, person.getId());
            ResultSet createdAddress = getAddress.executeQuery();

            if (createdAddress.next()) {
                person.getAddress().setId(createdAddress.getLong(1));
            }

            StringBuilder query = new StringBuilder().append("UPDATE person   ")
                                                     .append("SET name = ?,   ")
                                                     .append("email = ?,      ")
                                                     .append("address_id = ?, ")
                                                     .append("birth_date = ?  ")
                                                     .append("WHERE id = ?    ");
            PreparedStatement updatePerson = connection.prepareStatement(query.toString());
            updatePerson.setString(1, person.getName());
            updatePerson.setString(2, person.getEmail());
            updatePerson.setLong(3, person.getAddress().getId());
            updatePerson.setDate(4, person.getBirthDate());
            updatePerson.setLong(5, person.getId());
            addressService.update(connection, person.getAddress());
            int result = updatePerson.executeUpdate();

            if (result == 1) {
                getAddress.close();
                updatePerson.close();
                connection.close();
                return true;
            } else {
                throw new AppException("ID not found");
            }
        } else {
            return false;
        }
    }

    public boolean delete(Connection connection, Person person) throws SQLException, AppException {

        PreparedStatement deletePerson = null;
        StringBuilder query = new StringBuilder().append("DELETE       ")
                                                 .append("FROM person  ")
                                                 .append("WHERE id = ? ");
        deletePerson = connection.prepareStatement(query.toString());
        deletePerson.setLong(1, person.getId());

        if (deletePerson.executeUpdate() == 1) {
            AddressService addressService = new AddressService();
            addressService.delete(connection, person.getAddress());
            return true;
        } else {
            throw new AppException("No person found in this ID " + person.getId());
        }
    }
}
