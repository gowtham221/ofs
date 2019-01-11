package com.objectfrontier.training.java.webservices.exception;

public enum ExceptionCodes {

    FIRST_NAME_EMPTY(401, "First name cannot be empty"),
    LAST_NAME_EMPTY(402, "Last name cannot be empty"),
    EMAIL_EMPTY(403, "Email address cannot be empty"),
    BIRTH_DATE_EMPTY(404, "Birth date cannot be empty"),
    CREATED_DATE_EMPTY(405, "Created date cannot be empty"),
    INVALID_DATE_FORMAT(406, "Invalid date format"),
    EMAIL_ADDRESS_DUPLICATE(407, "Duplicate Email address entry"),
    ID_AUTOINCREMENT(408, "Id must be auto-incremented"),
    SAME_FIRST_NAME_LAST_NAME(409, "First name and last name cannot be same"),
    ID_NOT_FOUND(410, "No entry found in the given ID"),
    STREET_NAME_EMPTY(411, "Street cannot be empty"),
    CITY_NAME_EMPTY(412, "City cannot be empty"),
    POSTAL_CODE_EMPTY(413, "Postal code cannot be empty"),
    CREATION_ERROR(414, "Error occured due to invalid input"),
    INTERNAL_SERVER_ERROR(415, "Something Went Wrong");

    private final int errorCode;
    private final String errorMsg;

    ExceptionCodes(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMsg = errorMessage;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public String getErrorMessage() {
        return errorMsg;
    }
}


