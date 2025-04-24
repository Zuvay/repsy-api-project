package com.repsy.repsy_api.library.enums;

public enum MessageCodes {
    SUCCESS("200", "Success"),
    FAIL("500", "Fail"),
    BAD_REQUEST("400", "Bad Request"),
    NOT_FOUND("404", "Not Found"),
    ;
    private final String code;
    private final String message;

    MessageCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
