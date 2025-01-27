package org.example;

public enum Endpoint {
    BASE_URL("http://localhost:8080/api"),
    LOGIN_URL(BASE_URL.url + "/login"),
    SIGNUP_URL(BASE_URL.url + "/signup");

    private String url;

    Endpoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
