package org.example;

public enum ErrorCodes {
    ADD(0, "Failed to add film"),
    UPDATE(1, "Failed to update film"),
    DELETE(2, "Failed to delete film"),
    GET(3, "Failed to get film"),;

    public final int code;
    public final String message;

    ErrorCodes(int code, String message){
        this.code = code;
        this.message = message;
    }
}
