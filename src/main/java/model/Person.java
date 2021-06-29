package model;

import validation.Demo;

public class Person {

    @Demo
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
