package com.secondTask.fourthSubtask;

public class Dog {

    private String name;
    private Integer doggyAge;

    private final Integer DOGGY_TO_HUMAN_AGE = 7;

    public Dog(String name, Integer doggyAge) {
        this.name = name;
        this.doggyAge = doggyAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDoggyAge() {
        return doggyAge;
    }

    public void setDoggyAge(Integer doggyAge) {
        this.doggyAge = doggyAge;
    }

    public final Integer getHumanAge() {
        return this.doggyAge * DOGGY_TO_HUMAN_AGE;
    }

    @Override
    public String toString() {
        return "Dog { " +
                "name = '" + name + '\'' +
                ", doggyAge = " + doggyAge +
                " }";
    }
}
