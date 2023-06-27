package com.sample.mongo.springbootmongodbdemo.enums;

import java.util.Arrays;

public enum BaseLocation {
    PUNE("Pune"),
    BANGALORE("Bangalore"),
    MUMBAI("Mumbai"),
    CHENNAI("Chennai"),
    USA_CALIFORNIA("USA-California");

    private String name;

    BaseLocation(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static BaseLocation fromValue(String value) {
        return Arrays.stream(BaseLocation.values())
                     .filter(s -> s.getName().equals(value))
                     .findFirst()
                     .orElseThrow();
    }
}
