package com.sample.mongo.springbootmongodbdemo.enums;

import java.util.Arrays;

public enum Role {
    JAVA_DEVELOPER("Java Developer"),
    ANDROID_DEVELOPER("Andriod Developer"),
    SALESFORCE_DEVELOPER("Salesforce Developer"),
    ENGINEERING_MANAGER("Engineering Manager"),
    DELIVERY_MANAGER("Delivery Manager"),
    ADMINISTRATOR("Administrator");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Role fromValue(String value) {
        return Arrays.stream(Role.values()).filter(s -> s.getName().equals(value)).findFirst().orElseThrow();
    }
}
