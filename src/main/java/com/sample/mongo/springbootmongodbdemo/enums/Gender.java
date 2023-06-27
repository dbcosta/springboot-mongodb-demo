package com.sample.mongo.springbootmongodbdemo.enums;

import java.util.Arrays;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Gender fromValue(String value) {
        return Arrays.stream(Gender.values())
                     .filter(s -> s.getName().equals(value))
                     .findFirst()
                     .orElseThrow();
    }
}
