package org.example;

public enum Endpoint {
    BASE_URL("http://localhost:8080/api"),
    LOGIN_URL(BASE_URL.url + "/login"),
    SIGNUP_URL(BASE_URL.url + "/signup"),
    ADD_USER(BASE_URL.url + "/adduser"),
    FETCH_MANAGERS(BASE_URL.getUrl()+"/users/role/manager"),
    VALIDATE_MANAGER(BASE_URL.getUrl()+"/validateuser"),
    FOODS(BASE_URL.getUrl()+"/foods");

    private String url;

    Endpoint(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
