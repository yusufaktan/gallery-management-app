package com.aktanyusuf.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    RESOURCE_NOT_FOUND("1001", "no record exists"),
    TOKEN_EXPIRED("1002", "token expired"),
    USERNAME_NOT_FOUND("1003", "username not found"),
    REFRESH_TOKEN_NOT_FOUND("1004", "refresh token not found"),
    USERNAME_OR_PASSWORD_INVALID("1005", "username or password is incorrect"),
    REFRESH_TOKEN_EXPIRED("1006", "refresh token expired"),
    GENERAL_EXCEPTION("9999","General Exception");

    private String code;

    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
