package com.objectfrontier.training.java.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.objectfrontier.training.java.jdbc.model.Address;
import com.objectfrontier.training.java.jdbc.service.AddressService;
import com.objectfrontier.training.java.jdbc.service.ConnectionService;

public class AddressServiceTest {

    private AddressService addressService;

    @BeforeClass
    private void init() {
        this.addressService = new AddressService();
    }

    @Test
    private void testCreate_positive() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Address address = new Address();
        address.setStreet("GandhiStreet");
        address.setCity("Pondy");
        address.setPostalCode(641004);
        testCreate_positive(connection, address);
    }

    private void testCreate_positive(Connection connection, Address address) throws SQLException {

        try {

            Address createdAddress = addressService.create(connection, address);
            Assert.assertEquals(createdAddress.getCity(), address.getCity(), "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    private void testCreate_negative() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Address address = new Address();
        address.setStreet("Invaild Street");
        address.setPostalCode(0);
        String experctedError = "Column 'city' cannot be null";
        testCreate_negative(connection, address, experctedError);
    }

    private void testCreate_negative(Connection connection, Address address, String expectedError) throws SQLException {

        try {

            addressService.create(connection, address);
            Assert.fail("failed");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), expectedError, "Success!");
        }
    }

    @Test
    private void testUpdate_positive() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Address address = new Address();
        address.setId(7);
        address.setStreet("JN_Street");
        address.setCity("Pondy");
        address.setPostalCode(605003);
        testUpdate_positive(connection, address);
    }

    private void testUpdate_positive(Connection connection, Address address) throws SQLException {

        try {

            boolean createdAddress = addressService.update(connection, address);
            Assert.assertEquals(createdAddress, true, "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    private void testUpdate_negative() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Address address = new Address();
        address.setId(0);
        address.setStreet("JN_Street");
        address.setCity("Pondy");
        address.setPostalCode(605003);
        String expectedError = "ID not found";
        testUpdate_negative(connection, address, expectedError);
    }

    private void testUpdate_negative(Connection connection, Address address, String expectedError) throws SQLException {

        try {

            addressService.update(connection, address);
            Assert.fail("failed");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), expectedError, "Success!");
        }
    }

    @Test
    private void testRead_positive() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Address address = new Address();
        address.setId(8);
        testRead_positive(connection, address);
    }

    private void testRead_positive(Connection connection, Address address) throws SQLException {

        try {

            Address createdAddress = addressService.read(connection, address.getId());
            Assert.assertEquals(createdAddress.getCity(), "PY", "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    private void testRead_negative() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Address address = new Address();
        address.setId(1);
        String expectedError = "No address found in this ID " + address.getId();
        testRead_negative(connection, address, expectedError);
    }

    private void testRead_negative(Connection connection, Address address, String expectedError) throws SQLException {

        try {

            addressService.read(connection, address.getId());
            Assert.fail("failed");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), expectedError, "Success!");
        }
    }

    @Test
    private void testDelete_positive() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Address address = new Address();
        address.setId(7);
        testDelete_positive(connection, address);
    }

    private void testDelete_positive(Connection connection, Address address) throws SQLException {

        try {

            boolean deletedAddress = addressService.delete(connection, address);
            Assert.assertEquals(deletedAddress, true, "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    private void testDelete_negative() throws SQLException {

        Connection connection = ConnectionService.getConnection();
        Address address = new Address();
        address.setId(1);
        String expectedError = "No address found in this ID " + address.getId();
        testDelete_negative(connection, address, expectedError);
    }

    private void testDelete_negative(Connection connection, Address address, String expectedError) throws SQLException {

        try {

            addressService.delete(connection, address);
            Assert.fail("failed");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), expectedError, "Success!");
        }
    }
}
