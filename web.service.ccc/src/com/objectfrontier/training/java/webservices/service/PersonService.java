package com.objectfrontier.training.java.webservices.service;

import static com.objectfrontier.training.java.webservices.statements.PersonStatements.CREATE_QUERY;
import static com.objectfrontier.training.java.webservices.statements.PersonStatements.DELETE_QUERY;
import static com.objectfrontier.training.java.webservices.statements.PersonStatements.READ_ALL_QUERY;
import static com.objectfrontier.training.java.webservices.statements.PersonStatements.READ_QUERY;
import static com.objectfrontier.training.java.webservices.statements.PersonStatements.UPDATE_QUERY;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.java.webservices.exception.AppException;
import com.objectfrontier.training.java.webservices.exception.ExceptionCodes;
import com.objectfrontier.training.java.webservices.pojo.Address;
import com.objectfrontier.training.java.webservices.pojo.Person;


public class PersonService {

    public Person create(Connection connection, Person person) {

        try {
            if (connection != null) {

                AddressService addressService = new AddressService();
                person.setAddress(addressService.create(connection, person.getAddress()));

                PreparedStatement createPersonQuery = connection.prepareStatement(CREATE_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
                createPersonQuery.setString(1, person.getFirstName());
                createPersonQuery.setString(2, person.getLastName());
                createPersonQuery.setString(3, person.getEmail());

                try {
                    String[] dob = person.getBirthDate().split("-");
                    String birthDate = dob[2] + "-" + dob[1] + "-" + dob[0];
                    createPersonQuery.setDate(4, Date.valueOf(birthDate));
                } catch (Exception e) {
                    throw new AppException(ExceptionCodes.INVALID_DATE_FORMAT);
                }
                createPersonQuery.setTimestamp(5, person.getCreatedDate());

                if ((person.getCreatedDate() == null) || ((person.getCreatedDate()).equals(null))) {
                    throw new AppException(ExceptionCodes.CREATED_DATE_EMPTY);
                }
                createPersonQuery.setLong(6, person.getAddress().getId());
                createPersonQuery.setString(7, person.getPassword());
                createPersonQuery.setBoolean(8, person.getIs_admin());

                validatePerson(connection, person);
                int result = createPersonQuery.executeUpdate();

                if (result == 1) {
                    ResultSet generatedPerson = createPersonQuery.getGeneratedKeys();
                    generatedPerson.next();
                    person.setId(generatedPerson.getLong(1));
                } else {
                    throw new AppException(ExceptionCodes.CREATION_ERROR);
                }
            }
        } catch (SQLException e) {
            throw new AppException(ExceptionCodes.INTERNAL_SERVER_ERROR);
        }
        return person;
    }

    public Person read(Connection connection, long personId, boolean includeAddress) throws SQLException {

            Person retrievedPerson = new Person();
                PersonService personService = new PersonService();
//                boolean isValidPerson = false;
//                List<Person> personDetails = readAllPerson(connection);
//                for (Person personDetail : personDetails) {
//                    if (personDetail.getId() == personId) {
//                        isValidPerson = true;
//                    }
//                }
//                if (isValidPerson) {
                    if (includeAddress) {

                        AddressService addressService = new AddressService();
                        retrievedPerson = personService.readPerson(connection, personId);
                        retrievedPerson.setAddress(addressService.read(connection, retrievedPerson.getAddress().getId()));
                    } else {
                        retrievedPerson = personService.readPerson(connection, personId);
                    }
                    return retrievedPerson;
//                } else {
//                    throw new AppException(ExceptionCode.ID_NOT_FOUND);
//                }
    }

    public Person readPerson(Connection connection, long personId) throws SQLException {

        Address address = new Address();
        Person person = new Person();

            PreparedStatement readPersonQuery = connection.prepareStatement(READ_QUERY);
            readPersonQuery.setLong(1, personId);
            ResultSet result = readPersonQuery.executeQuery();

            if (result.next()) {
                person.setId(personId);
                person.setFirstName(result.getString("first_name"));
                person.setLastName(result.getString("last_name"));
                person.setEmail(result.getString("email"));
                address.setId(result.getLong("address_id"));
                person.setAddress(address);
                person.setBirthDate(result.getString("birth_date"));
                person.setCreatedDate(result.getTimestamp("created_date"));
                readPersonQuery.close();
            } else {
                readPersonQuery.close();
                throw new AppException(ExceptionCodes.ID_NOT_FOUND);
            }
        return person;
    }

    public List<Person> readAllPerson(Connection connection) {

        List<Person> personDetails = new ArrayList<>();
        AddressService addressService = new AddressService();

        try {
            PreparedStatement readAllPersonQuery = connection.prepareStatement(READ_ALL_QUERY);
            ResultSet result = readAllPersonQuery.executeQuery();

            while (result.next()) {
                Person retrievedPerson = new Person();
                Address address = new Address();
                retrievedPerson.setId(result.getLong("id"));
                retrievedPerson.setFirstName(result.getString("first_name"));
                retrievedPerson.setLastName(result.getString("last_name"));
                retrievedPerson.setEmail(result.getString("email"));
                retrievedPerson.setBirthDate(result.getString("birth_date"));
                address.setId(result.getLong("address_id"));
                retrievedPerson.setAddress(address);
                retrievedPerson.setCreatedDate(result.getTimestamp("created_date"));
                retrievedPerson.setAddress(addressService.read(connection, retrievedPerson.getAddress().getId()));
                personDetails.add(retrievedPerson);
            }
            readAllPersonQuery.close();
        } catch (SQLException e) {
            throw new AppException(ExceptionCodes.INTERNAL_SERVER_ERROR);
        }
        return personDetails;
    }

    public Person update(Connection connection, Person person) {

        try {
            if (connection != null) {
                AddressService addressService = new AddressService();
                boolean isValidPerson = false;

                person.setAddress(addressService.create(connection, person.getAddress()));
                PreparedStatement updatePersonQuery = connection.prepareStatement(UPDATE_QUERY);
                updatePersonQuery.setString(1, person.getFirstName());
                updatePersonQuery.setString(2, person.getLastName());
                updatePersonQuery.setString(3, person.getEmail());
                updatePersonQuery.setLong(4, person.getAddress().getId());
                try {
                    String[] dob = person.getBirthDate().split("-");
                    String birthDate = dob[2] + "-" + dob[1] + "-" + dob[0];
                    updatePersonQuery.setDate(5, Date.valueOf(birthDate));
                } catch (Exception e) {
                    throw new AppException(ExceptionCodes.INVALID_DATE_FORMAT);
                }
                updatePersonQuery.setString(6, person.getPassword());
                updatePersonQuery.setBoolean(7, person.getIs_admin());
                updatePersonQuery.setLong(8, person.getId());
                addressService.update(connection, person.getAddress());

                List<Person> personDetails = readAllPerson(connection);
                for (Person personDetail : personDetails) {
                    if (personDetail.getId() == person.getId()) {
                        isValidPerson = true;
                    }
                }

                if (isValidPerson) {
                    validatePerson(connection, person);
                    updatePersonQuery.executeUpdate();
                    updatePersonQuery.close();
                    return person;
                } else {
                    updatePersonQuery.close();
                    throw new AppException(ExceptionCodes.ID_NOT_FOUND);
                }
            } else {
                throw new AppException(ExceptionCodes.INTERNAL_SERVER_ERROR);
            }
        } catch (SQLException e) {
            throw new AppException(ExceptionCodes.INTERNAL_SERVER_ERROR);
        }
    }

    public Person delete(Connection connection, Person person) {

        try {
            if (connection != null) {
                Person deletedPerson = new Person();
                PreparedStatement deletePersonQuery = connection.prepareStatement(DELETE_QUERY);
                deletePersonQuery.setLong(1, person.getId());
                int result = deletePersonQuery.executeUpdate();

                if (result == 1) {
                    //            AddressService addressService = new AddressService();
                    //            addressService.delete(connection, person.getAddress());
                    deletePersonQuery.close();
                    deletedPerson.setId(person.getId());
                    return deletedPerson;
                } else {
                    deletePersonQuery.close();
                    throw new AppException(ExceptionCodes.ID_NOT_FOUND);
                }
            } else {
                throw new AppException(ExceptionCodes.INTERNAL_SERVER_ERROR);
            }
        } catch (SQLException e) {
            throw new AppException(ExceptionCodes.INTERNAL_SERVER_ERROR);
        }
    }

    public void validatePerson(Connection connection, Person person) throws SQLException {

        List<ExceptionCodes> exceptionList = new ArrayList<>();
        List<Person> personDetails = readAllPerson(connection);

        if (person.getFirstName().equals(person.getLastName())) {
            exceptionList.add(ExceptionCodes.SAME_FIRST_NAME_LAST_NAME);
        }
        if ((person.getFirstName().equals(null)) || ((person.getFirstName()).trim().length() <= 0)) {
            exceptionList.add(ExceptionCodes.FIRST_NAME_EMPTY);
        }
        if ((person.getLastName().equals(null) || ((person.getLastName()).trim().length() <= 0))) {
            exceptionList.add(ExceptionCodes.LAST_NAME_EMPTY);
        }
        if ((person.getEmail().equals(null)) || ((person.getEmail()).trim().length() <= 0)) {
            exceptionList.add(ExceptionCodes.EMAIL_EMPTY);
        }
        if ((person.getBirthDate().equals(null)) || ((person.getBirthDate()).trim().length() <= 0)) {
            exceptionList.add(ExceptionCodes.BIRTH_DATE_EMPTY);
        }

        for (Person personDetail : personDetails) {
            if ((personDetail.getEmail()).equals(person.getEmail())) {
                exceptionList.add(ExceptionCodes.EMAIL_ADDRESS_DUPLICATE);
            }
        }

        if (!(exceptionList.isEmpty())) {
            throw new AppException(exceptionList);
        }

//        StringBuilder query = new StringBuilder().append("SELECT Count(*)      ")
//                                                 .append("FROM service_person  ")
//                                                 .append("WHERE first_name = ? ")
//                                                 .append("AND last_name = ?    ");
//        PreparedStatement duplicateUserQuery = connection.prepareStatement(query.toString());
//        duplicateUserQuery.setString(1, '"' + person.getFirstName() + '"');
//        duplicateUserQuery.setString(2, '"' + person.getLastName() + '"');
//        ResultSet result = duplicateUserQuery.executeQuery();
//        if (result.next()) {
//            System.out.println(result.getInt(1) + "siva");
//        }
    }
}
