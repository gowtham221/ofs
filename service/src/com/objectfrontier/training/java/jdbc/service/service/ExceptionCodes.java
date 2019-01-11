package com.objectfrontier.training.java.jdbc.service.service;

public enum ExceptionCodes {

    FIRSTNAME_EMPTY("First name cannot be empty"),
    LASTNAME_EMPTY("Last name cannot be empty"),
    EMAIL_EMPTY("Email address cannot be empty"),
    BIRTHDATE_EMPTY("Birth date cannot be empty"),
    INVALID_DATEFORMAT("Invalid date format"),
    EMAIL_ADDRESS_DUPLICATE("Duplicate Email address entry"),
    ID_AUTOINCREMENT("Id have be auto-incremented"),
    SAME_FIRSTNAME_LASTNAME("First name and last name cannot be same"),
    ID_NOT_FOUND("Nothing found in the given ID"),
    STREETNAME_EMPTY("Street cannot be empty"),
    CITYNAME_EMPTY("City cannot be empty"),
    POSTALCODE_EMPTY("Postal code cannot be empty"),
    CREATED_DATE_EMPTY("Created date cannot be empty");

    private String errorMsg;

    private ExceptionCodes(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }
}
