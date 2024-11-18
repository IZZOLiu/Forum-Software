package di0retsa.userlogin.entity;

import lombok.Data;

public enum StatusCode {
    SUCCESS(200),
    CLIENT_ERROR(400),
    SERVER_ERROR(500);
    private final Integer statusCode;

    StatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }


    @Override
    public String toString() {
        return String.valueOf(statusCode);
    }
}
