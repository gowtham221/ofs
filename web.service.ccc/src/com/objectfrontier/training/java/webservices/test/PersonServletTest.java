package com.objectfrontier.training.java.webservices.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.java.webservices.exception.AppException;
import com.objectfrontier.training.java.webservices.exception.ExceptionCodes;
import com.objectfrontier.training.java.webservices.pojo.Address;
import com.objectfrontier.training.java.webservices.pojo.Person;
import com.objectfrontier.training.java.webservices.service.PersonService;
import com.objectfrontier.training.java.webservices.servlet.HttpMethod;
import com.objectfrontier.training.java.webservices.servlet.JsonConverter;
import com.objectfrontier.training.java.webservices.servlet.RequestHelper;

public class PersonServletTest {

    private PersonService personService;
    String baseUrl = "http://localhost:8080/ws.ccc/personccc";
    private Connection connection = null;

    private static final String INPUTS_MSG = "INPUTS: given = %s, expected = %s.";
    private static final String ASSERT_FAIL_MSG = " expected:<%s> but was:<%s>";

    /* Before Test */

    @BeforeTest
    private void init() throws IOException {

        try {
            this.personService = new PersonService();
            RequestHelper.setBaseUrl(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Positive testcase for create Person */

    @Test(dataProvider = "testCreatePositive", enabled = true)
    private void testCreatePositive(Person givenPerson, Person expectedPerson) {

        try {
            Person createdPerson = new RequestHelper().setMethod(HttpMethod.PUT)
                                                      .setInput(givenPerson)
                                                      .setSecured(false)
                                                      .requestObject("/create", Person.class);
            Assert.assertEquals(createdPerson.getId(), expectedPerson.getId(), "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /* Dataprovider for positive testcase for create Person */

    @DataProvider(name = "testCreatePositive")
    private Object[][] testCreate_positiveValues() {

        Address givenAddress = new Address("Taramani", "Chennai", 600028);
        Person givenPerson = new Person("sri", "ram", "sriram@gmail.com", "07-11-1995", Timestamp.from(Instant.now()), givenAddress, "Welcome123", false);
        Person expectedPerson = givenPerson;
        expectedPerson.setId(5);
        return new Object[][] {
            { givenPerson, expectedPerson }
        };
    }

    /* Negative testcase for create Person */

    @Test(dataProvider = "testCreateNegative", enabled = false)
    private void testCreate_negative(Person givenPerson, List<ExceptionCodes> expectedError) throws SQLException, IOException {

        try {
            Person createdPerson = new RequestHelper().setMethod(HttpMethod.PUT)
                                                      .setInput(givenPerson)
                                                      .setSecured(false)
                                                      .requestObject("/create", Person.class);
            Assert.fail("Person Creation failed!");
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Person creation failed!");
            }
        }
    }

    /* Dataprovider for negative testcase for create Person */

//    @DataProvider(name = "testCreateNegative")
//    private Object[][] testCreateNegativeValues() {
//
//        Address givenAddress1 = new Address("", "", 0);
//        Address givenAddress2 = new Address("MG Road", "Pondy", 605005);
//        Person givenPerson1 = new Person("dipak", "yadav", "dipak@gmail.com", "2-10-1996", Timestamp.from(Instant.now()), givenAddress1);
//        Person givenPerson2 = new Person("", "yadav", "", "2-10-1996", Timestamp.from(Instant.now()), givenAddress2);
//        List<ExceptionCodes> errorList1 = new ArrayList<>();
//        List<ExceptionCodes> errorList2 = new ArrayList<>();
//        errorList1.add(ExceptionCodes.STREET_NAME_EMPTY);
//        errorList1.add(ExceptionCodes.CITY_NAME_EMPTY);
//        errorList1.add(ExceptionCodes.POSTAL_CODE_EMPTY);
//        errorList2.add(ExceptionCodes.FIRST_NAME_EMPTY);
//        errorList2.add(ExceptionCodes.EMAIL_EMPTY);
//        return new Object[][] {
//                                { givenPerson1, errorList1 },
//                                { givenPerson2, errorList2 }
//        };
//    }

    /* Positive testcase for update Person */

    @Test(dataProvider = "testUpdatePositive", enabled = false)
    private void testUpdate_positive(Person givenPerson, Person expectedPerson) {

        try {
            Person updatedAddress = new RequestHelper().setMethod(HttpMethod.POST)
                                                       .setInput(givenPerson)
                                                       .setSecured(false)
                                                       .requestObject("/update", Person.class);
            Assert.assertEquals(updatedAddress.getEmail(), expectedPerson.getEmail(), "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /* Dataprovider for positive testcase for update Person */

    @DataProvider(name = "testUpdatePositive")
    private Object[][] testUpdatePositiveValues() {

        Address givenAddress = new Address("Taramani", "Chennai", 600028);
        Person givenPerson = new Person(2, "yadav", "dipak", "manikavel@gmail.com", "07-11-1996", givenAddress, "Password221", true);
        Person expectedPerson = givenPerson;
        return new Object[][] {
                                { givenPerson, expectedPerson }
        };
    }

    /* Negative testcase for update Person */

    @Test(dataProvider = "testUpdateNegative", enabled = false)
    private void testUpdate_negative(Person givenPerson, List<ExceptionCodes> expectedError) throws SQLException, IOException {

        try {
            Person updatedAddress = new RequestHelper().setMethod(HttpMethod.POST)
                                                       .setInput(givenPerson)
                                                       .setSecured(false)
                                                       .requestObject("/update", Person.class);
            Assert.fail("Person updation failed!");
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Person updation failed!");
            }
        }
    }

    /* Dataprovider for negative testcase for update Person */

//    @DataProvider(name = "testUpdateNegative")
//    private Object[][] testUpdateNegativeValues() {
//
//        Address givenAddress1 = new Address("", "", 0);
//        Address givenAddress2 = new Address("lawspet", "pondy", 605001);
//        Person givenPerson1 = new Person(1, "yadav", "dipak", "yadav@gmail.com", "07-11-1996", givenAddress1);
//        Person givenPerson2 = new Person(1, "yadav", "", "vcg.cnidsq@bdi", "15-08-1996", givenAddress2);
//        List<ExceptionCodes> errorList1 = new ArrayList<>();
//        List<ExceptionCodes> errorList2 = new ArrayList<>();
//        errorList1.add(ExceptionCodes.STREET_NAME_EMPTY);
//        errorList1.add(ExceptionCodes.CITY_NAME_EMPTY);
//        errorList1.add(ExceptionCodes.POSTAL_CODE_EMPTY);
//        errorList2.add(ExceptionCodes.LAST_NAME_EMPTY);
////        errorList2.add(ExceptionCodes.EMAIL_EMPTY);
////        errorList2.add(ExceptionCodes.INVALID_DATE_FORMAT);
//        return new Object[][] {
//                                { givenPerson1, errorList1 },
//                                { givenPerson2, errorList2 },
//        };
//    }

    /* Positive testcase for read Person */

    @Test(dataProvider = "testReadPositive", enabled = false)
    private void testRead_positive(long personId, Person expectedPerson) {

        try {
            String retrivedPerson = new RequestHelper().setMethod(HttpMethod.GET)
                                                       .setSecured(false)
                                                       .requestString("/read?id=" + personId + "&address=true");
            Person person = JsonConverter.toObject(retrivedPerson, Person.class);
            Assert.assertEquals(person.getId(), expectedPerson.getId(), "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /* Dataprovider for positive testcase for read Person */

    @DataProvider(name = "testReadPositive")
    private Object[][] testReadPositiveValues() {

        long personId = 1;
        Person expectedPerson = new Person();
        expectedPerson.setId(personId);
        return new Object[][] {
                                { personId, expectedPerson }
        };
    }

    /* Negative testcase for read Person */

    @Test(dataProvider = "testReadNegative", enabled = false)
    private void testRead_negative(long personId, List<ExceptionCodes> expectedError) throws SQLException, IOException {

        try {
            String retrivedPerson = new RequestHelper().setMethod(HttpMethod.GET)
                                                       .setSecured(false)
                                                       .requestString("/read?id=" + personId + "&address=false");
            Assert.fail(String.format("Person read failed!"));
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Person read failed!");
            }
        }
    }

    /* Dataprovider for negative testcase for read Person */

    @DataProvider(name = "testReadNegative")
    private Object[][] testReadNegativeValues() {

        long personId = 330;
        List<ExceptionCodes> errorList = new ArrayList<>();
        errorList.add(ExceptionCodes.ID_NOT_FOUND);
        return new Object[][] {
                                { personId, errorList }
        };
    }

    /* Positive testcase for delete Person */

    @Test(dataProvider = "testDeletePositive", enabled = false)
    private void testDelete_positive(Person givenPerson) {

        try {
            Person deletedPerson = new RequestHelper().setMethod(HttpMethod.POST)
                                                      .setInput(givenPerson)
                                                      .setSecured(false)
                                                      .requestObject("/delete", Person.class);
            Assert.assertEquals(deletedPerson.getId(), givenPerson.getId(), "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /* Dataprovider for positive testcase for delete Person */

    @DataProvider(name = "testDeletePositive")
    private Object[][] testDeletePositiveValues() {

        Person givenPerson = new Person(1);
        return new Object[][] {
                                { givenPerson }
        };
    }

    /* Negative testcase for delete Person */

    @Test(dataProvider = "testDeleteNegative", enabled = false)
    private void testDelete_negative(Person person, List<ExceptionCodes> expectedError) throws SQLException, IOException {

        try {
            Person deletedPerson = new RequestHelper().setMethod(HttpMethod.POST)
                                                      .setInput(person)
                                                      .setSecured(false)
                                                      .requestObject("/delete", Person.class);
            Assert.fail("Person deletion failed!");
        } catch (Exception e) {
            if (e instanceof AppException) {
                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Success!");
            }
        }
    }

    /* Dataprovider for positive testcase for delete Person */

    @DataProvider(name = "testDeleteNegative")
    private Object[][] testDeleteNegativeValues() {

        Person givenPerson = new Person(0);
        List<ExceptionCodes> errorList = new ArrayList<>();
        errorList.add(ExceptionCodes.ID_NOT_FOUND);
        return new Object[][] {
                                { givenPerson, errorList }
        };
    }
}
