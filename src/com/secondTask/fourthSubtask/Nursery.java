package com.secondTask.fourthSubtask;

import com.secondTask.MyInput;

import java.util.ArrayList;

public class Nursery {

    private ArrayList<Dog> dogs = new ArrayList<>();

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public final void addDog() {
        dogs.add(new Dog(MyInput.inputString("Enter the dog's name: ", v -> v),
                MyInput.inputInteger("Enter the dog's age: ", Integer::valueOf)));
    }

    @Override
    public String toString() {
        return "Nurcery { " +
                "dogs = " + dogs +
                " }";
    }
}
