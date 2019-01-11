// Define AddressService class for CRUD (create, read, readAll, update and delete) operations for Address using JDBC
  // -> use PreparedStatement appropriately

package com.objectfrontier.training.java.jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objectfrontier.training.java.jdbc.model.Address;
import com.objectfrontier.training.java.jdbc.test.AppException;

public class AddressService {

        public Address create(Connection connection, Address address) throws SQLException, AppException {

        Address createdAddress = new Address();
        StringBuilder query = new StringBuilder()
                              .append("INSERT INTO address (street, city, postal_code) ")
                              .append("VALUES (?, ?, ?)                                ");

        PreparedStatement createAddress = connection.prepareStatement(query.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
        createAddress.setString(1, address.getStreet());
        createAddress.setString(2, address.getCity());
        createAddress.setLong(3, address.getPostalCode());
        int result = createAddress.executeUpdate();

        if (result == 1) {
            ResultSet generatedAddress = createAddress.getGeneratedKeys();
            generatedAddress.next();
            createdAddress.setId(generatedAddress.getLong(1));
            createdAddress.setCity(address.getCity());
        } else {
            throw new AppException("Column 'city' cannot be null");
        }
        createAddress.close();
        return createdAddress;
    }

    public Address read(Connection connection, long addressId) throws SQLException, AppException {

        Address address = new Address();
        StringBuilder query = new StringBuilder()
                             .append("SELECT id, street, city, postal_code ")
                             .append("FROM address                         ")
                             .append("WHERE id = ?                         ");
        PreparedStatement readAddress = connection.prepareStatement(query.toString());
        readAddress.setLong(1, addressId);
        ResultSet result = readAddress.executeQuery();

        if (result.next()) {
            address.setId(result.getLong("id"));
            address.setStreet(result.getString("street"));
            address.setCity(result.getString("city"));
            address.setPostalCode(result.getLong("postal_code"));
            readAddress.close();
            return address;
        } else {
            readAddress.close();
            throw new AppException("No address found in this ID " + addressId);
        }
    }

    public List<Address> readAll(Connection connection) throws SQLException {

        List<Address> addressDetails = new ArrayList<>();
        StringBuilder query = new StringBuilder().append("SELECT id, street, city, postal_code ")
                                                 .append("FROM address                         ");
        PreparedStatement readAllAddress = connection.prepareStatement(query.toString());
        ResultSet result = readAllAddress.executeQuery();

        while (result.next()) {

            Address retrievedAddress = new Address();
            retrievedAddress.setId(result.getLong("id"));
            retrievedAddress.setStreet(result.getString("street"));
            retrievedAddress.setCity(result.getString("city"));
            retrievedAddress.setPostalCode(result.getLong("postal_code"));
            addressDetails.add(retrievedAddress);
        }
        return addressDetails;
    }

    public boolean update(Connection connection, Address address) throws SQLException, AppException {

        StringBuilder query = new StringBuilder().append("UPDATE address      ")
                                                 .append("SET street = ?,      ")
                                                 .append("city = ?,        ")
                                                 .append("postal_code = ? ")
                                                 .append("WHERE id = ?        ");

        PreparedStatement updateAddress = connection.prepareStatement(query.toString());

        updateAddress.setString(1, address.getStreet());
        updateAddress.setString(2, address.getCity());
        updateAddress.setLong(3, address.getPostalCode());
        updateAddress.setLong(4, address.getId());
        int result = updateAddress.executeUpdate();

        if (result == 1) {
            updateAddress.close();
            return true;
        } else {
            throw new AppException("ID not found");
        }
    }

    public boolean delete(Connection connection, Address address) throws SQLException, AppException {

        StringBuilder query = new StringBuilder()
                              .append("DELETE       ")
                              .append("FROM address ")
                              .append("WHERE id = ? ");
        PreparedStatement deleteAddress = connection.prepareStatement(query.toString());
        deleteAddress.setLong(1, address.getId());

        if (deleteAddress.executeUpdate() == 1) {
            return true;
        } else {
            throw new AppException("No address found in this ID " + address.getId());
        }
    }
}
