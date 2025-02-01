package org.example.models.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class LoginResponse {
    private int statusCode;
    private Instant timeStamp;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonCreator
    public LoginResponse(
            @JsonProperty("status_code") int statusCode,
            @JsonProperty("time_stamp") Instant timeStamp,
            @JsonProperty("message") String message
    ) {
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginResponse [statusCode=" + statusCode + ", timeStamp=" + timeStamp + ", message=" + message + "]";
    }
}
