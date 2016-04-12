package com.xebia.jetter.enums;

/**
 * Created by gurinder on 12/4/16.
 */
public enum Status {
    SUCCESS("success"),
    FAILURE("failure");

    private String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
