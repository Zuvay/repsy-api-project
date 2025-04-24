package com.repsy.repsy_api.library.exception;

import com.repsy.repsy_api.library.enums.MessageCodes;

public class CoreException extends RuntimeException {

    private final MessageCodes code;
    private final String message;
    private final Object[] args;

    public CoreException(MessageCodes code, Object... args) {
        this.code = code;
        this.args = args;
        this.message = null;
    }

    public CoreException(MessageCodes code, String message) {
        this.code = code;
        this.args = null;
        this.message = message;
    }

    public MessageCodes getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object[] getArgs() {
        return args;
    }
}
