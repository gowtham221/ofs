package com.objectfrontier.training.java.jdbc.service.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.java.jdbc.service.pojo.Address;
import com.objectfrontier.training.java.jdbc.service.service.AddressService;
import com.objectfrontier.training.java.jdbc.service.service.AppException;
import com.objectfrontier.training.java.jdbc.service.service.ConnectionService;

public class AddressServiceTest {

    private AddressService addressService = new AddressService();
    private Connection connection = null;

    private static final String INPUTS_MSG = "INPUTS: given = %s, expected = %s.";
    private static final String ASSERT_FAIL_MSG = "Expected:<%s> but was:<%s>";

    @BeforeTest
    private void createConnection() throws IOException {

        try {
            connection = ConnectionService.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    private void closeConnection() {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test(dataProvider = "testCreatePositive", enabled = false)
    private void testCreate_positive(Address givenAddress, Address expectedAddress) throws SQLException {

        try {
            Address createdAddress = addressService.create(connection, givenAddress);
            Assert.assertEquals(createdAddress.getCity(), expectedAddress.getCity(), "Success!");
        } catch (AppException e) {
            Assert.fail(e.getErrorMessage());
        }
    }


    @DataProvider(name = "testCreatePositive")
    private Object[][] testCreatePositiveValues() {

        Address givenAddress = new Address("north street", "Pondy", 605001);
        Address expectedAddress = givenAddress;
        return new Object[][] {
                                { givenAddress, expectedAddress }
        };
    }


    @Test(dataProvider = "testCreateNegative", enabled = false)
    private void testCreate_negative(Address givenAddress, String expectedError) throws SQLException {

        try {
            Address createdAddress = addressService.create(connection, givenAddress);
            Assert.fail(String.format(INPUTS_MSG, createdAddress.getStreet(), givenAddress.getStreet()) +
                        String.format(INPUTS_MSG, createdAddress.getCity(), givenAddress.getCity()) +
                        String.format(INPUTS_MSG, createdAddress.getPostalCode(), givenAddress.getPostalCode()) +
                        String.format(ASSERT_FAIL_MSG, givenAddress.getId(), createdAddress.getId()));
        } catch (AppException e) {
            Assert.assertEquals(e.getErrorMessage(), expectedError, "Address creation failed!");
        }
    }


    @DataProvider(name = "testCreateNegative")
    private Object[][] testCreateNegativeValues() {

        Address givenAddress1 = new Address("", "Pondy", 605001);
        Address givenAddress2 = new Address("north street", "", 605001);
        Address givenAddress3 = new Address("north street", "Pondy", 0);
        String expectedError1 = "Street cannot be empty";
        String expectedError2 = "City cannot be empty";
        String expectedError3 = "Postal code cannot be empty";
        return new Object[][] {
                                { givenAddress1, expectedError1 },
                                { givenAddress2, expectedError2 },
                                { givenAddress3, expectedError3 }
        };
    }


    @Test(dataProvider = "testUpdatePositive", enabled = false)
    private void testUpdate_positive(Address givenAddress, Address expectedAddress) throws SQLException {

        try {
            boolean createdAddress = addressService.update(connection, givenAddress);
            Assert.assertEquals(createdAddress, true, "Success!");
        } catch (AppException e) {
            Assert.fail(e.getErrorMessage());
        }
    }


    @DataProvider(name = "testUpdatePositive")
    private Object[][] testUpdatePositiveValues() {

        Address givenAddress = new Address(3, "east street", "Pondy", 605001);
        Address expectedAddress = givenAddress;
        return new Object[][] {
                                {givenAddress, expectedAddress}
        };
    }


    @Test(dataProvider = "testUpdateNegative", enabled = false)
    private void testUpdate_negative(Address givenAddress, String expectedError) throws SQLException {

        try {
            boolean updatedAddress = addressService.update(connection, givenAddress);
            Assert.fail(String.format(INPUTS_MSG, updatedAddress, true, "Testcase failed!") +
                        String.format(ASSERT_FAIL_MSG, givenAddress.getId(), updatedAddress));
        } catch (AppException e) {
            Assert.assertEquals(e.getErrorMessage(), expectedError, "Address updation failed!");
        }
    }


    @DataProvider(name = "testUpdateNegative")
    private Object[][] testUpdateNegativeValues() {

        Address givenAddress1 = new Address(0, "north street", "Pondy", 605001);
        Address givenAddress2 = new Address(3, "", "Pondy", 605001);
        Address givenAddress3 = new Address(3, "north street", "", 605001);
        Address givenAddress4 = new Address(3, "north street", "Pondy", 0);
        String expectedError1 = "Nothing found in the given ID";
        String expectedError2 = "Street cannot be empty";
        String expectedError3 = "City cannot be empty";
        String expectedError4 = "Postal code cannot be empty";
        return new Object[][] {
                                { givenAddress1, expectedError1 },
                                { givenAddress2, expectedError2 },
                                { givenAddress3, expectedError3 },
                                { givenAddress4, expectedError4 }
        };
    }


    @Test(dataProvider = "testReadPositive", enabled = false)
    private void testRead_positive(long addressId) throws SQLException {

        try {
            Address retrivedAddress = addressService.read(connection, addressId);
            Assert.assertEquals(retrivedAddress.getCity(), "Pondy", "Success!");
        } catch (AppException e) {
            Assert.fail(e.getErrorMessage());
        }
    }


    @DataProvider(name = "testReadPositive")
    private Object[][] testReadPositiveValues() {

        long addressId = 3;
        return new Object[][] {
                                { addressId }
        };
    }


    @Test(dataProvider = "testReadNegative", enabled = false)
    private void testRead_negative(long addressId, String expectedError) throws SQLException {

        try {
            Address retrivedAddress = addressService.read(connection, addressId);
            Assert.fail(String.format(INPUTS_MSG, retrivedAddress.getStreet(), "Testcase failed!") +
                        String.format(ASSERT_FAIL_MSG, retrivedAddress.getCity(), retrivedAddress.getCity()));
        } catch (AppException e) {
            Assert.assertEquals(e.getErrorMessage(), expectedError, "Address read failed!");
        }
    }


    @DataProvider(name = "testReadNegative")
    private Object[][] testReadNegativeValues() {

        long addressId = 34;
        String expectedError = "Nothing found in the given ID";
        return new Object[][] {
                                { addressId, expectedError }
        };
    }

    @Test(dataProvider = "testDeletePositive", enabled = false)
    private void testDelete_positive(Address address) throws SQLException {

        try {

            boolean deletedAddress = addressService.delete(connection, address);
            Assert.assertEquals(deletedAddress, true);
        } catch (AppException e) {
            Assert.fail (e.getErrorMessage());
        }
    }

    @DataProvider(name = "testDeletePositive")
    private Object[][] testDelete_positive() {

        Address address = new Address();
        address.setId(94);
        return new Object[][] {
                                { address }
        };
    }

    @Test(dataProvider = "testDeleteNegative", enabled = false)
    private void testDelete_negative(Address address, String experctedError) throws SQLException, IOException {

        try {
            connection = ConnectionService.getConnection();
            boolean addressDetails = addressService.delete(connection, address);
            Assert.fail(String.format(INPUTS_MSG, addressDetails, 4) +
                    String.format(ASSERT_FAIL_MSG, 4, experctedError));
        } catch (AppException e) {
            Assert.assertEquals(e.getErrorMessage(), experctedError, "Success!");
        }
        connection.close();
    }


    @DataProvider(name = "testDeleteNegative")
    private Object[][] testDeleteNegativeValues() {

        Address givenAddress = new Address(1000);
        String expectedError = "Nothing found in the given ID";
        return new Object[][] {
                                { givenAddress, expectedError }
        };
    }

    @Test(enabled = false)
    private void testSearch() throws SQLException {

        try {
            String[] columnName = new String[] {"street" , "city", "postalCode"};
            addressService.search(connection, "Pondy", columnName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
