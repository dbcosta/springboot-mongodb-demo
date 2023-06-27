package com.sample.mongo.springbootmongodbdemo.enums;

import java.util.Arrays;

public enum Seniority {
    ASSOCIATE("Associate"),
    SR("Senior"),
    SR_LEVEL_2("Senior Level 2"),
    SR_LEVEL_3("Senior Level 3"),
    LEAD("Lead"),
    ADVISOR("Advisor"),
    MANAGER("Manager"),
    MANAGER_LEVEL_2("Manager Level 2"),
    MANAGER_LEVEL_3("Manager Level 3"),
    HOD("Head of Department"),
    CFO("Chief Financial Officer"),
    CEO("Chief Executive Officer");

    private String name;

    Seniority(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Seniority fromValue(String value) {
        return Arrays.stream(Seniority.values())
                     .filter(s -> s.getName().equals(value))
                     .findFirst()
                     .orElseThrow();
    }
}
