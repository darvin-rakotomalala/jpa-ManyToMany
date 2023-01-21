package com.poc.exception;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */

    ERR_MCS_STUDENT_NAME_EMPTY("Error occurred - Student name shouldn't be NULL or EMPTY"),
    ERR_MCS_STUDENT_ID_EMPTY("Error occurred - Student id or object shouldn't be NULL or EMPTY"),
    ERR_MCS_COURSE_NAME_EMPTY("Error occurred - Course name shouldn't be NULL or EMPTY"),
    ERR_MCS_COURSE_NOT_FOUND("Error occurred - no Course found with this name"),
    ERR_MCS_STUDENT_NOT_FOUND("Error occurred - no Student found with this id");

    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
