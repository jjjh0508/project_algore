package com.algore.application.employee.dto;

import java.util.Arrays;

public class TestDTO {

    private String[] name;
    private int[] test;

    public TestDTO() {
    }

    public TestDTO(String[] name, int[] test) {
        this.name = name;
        this.test = test;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public int[] getTest() {
        return test;
    }

    public void setTest(int[] test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "name=" + Arrays.toString(name) +
                ", test=" + Arrays.toString(test) +
                '}';
    }
}
