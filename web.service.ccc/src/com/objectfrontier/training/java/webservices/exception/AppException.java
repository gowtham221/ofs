package com.objectfrontier.training.java.webservices.exception;

import java.util.ArrayList;
import java.util.List;

public class AppException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

//    private int errorCode;
//    public String errorMsg;
    private List<ExceptionCodes> errorList = new ArrayList<>();

//    public AppException(Exception e) {
//        super();
//    }

    public AppException(ExceptionCodes code) {
//        this.errorCode = code.getErrorCode();
//        this.errorMsg = code.getErrorMessage();
        errorList.add(code);
    }

    public AppException(List<ExceptionCodes> errorCodes) {
        super();
        this.errorList = errorCodes;
    }

    public List<ExceptionCodes> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ExceptionCodes> errorList) {
        this.errorList = errorList;
    }

//    public int getErrorCode() {
//        return errorCode;
//    }
//
//    public String getErrorMessage() {
//        return errorMsg;
//    }
}
