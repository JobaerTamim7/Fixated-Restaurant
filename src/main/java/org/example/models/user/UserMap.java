package org.example.models.user;

public enum UserMap {
    ADMIN("00","admin"),
    MANAGER("01","manager");

    private final String value;
    private final String name;

    UserMap(String value, String name) {
        this.value = value;
        this.name = name;
    }
    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
