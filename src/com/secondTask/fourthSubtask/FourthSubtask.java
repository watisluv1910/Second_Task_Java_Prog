package com.secondTask.fourthSubtask;

import com.secondTask.MyInput;

public class FourthSubtask {

    public static void main(String[] args) {

        Nursery nursery = new Nursery();

        while (true) {
            Integer navigationVar = MyInput.inputInteger("""
                    Enter 1 to add a new dog to the nursery.
                    Enter 2 to figure out the human age of the dog.
                    Enter 3 to view information about chosen dog.
                    Enter 4 to view all the dogs in the nursery.
                    Enter any other digit to stop the program.""", Integer::valueOf);

            switch (navigationVar) {
                case 1:
                    nursery.addDog();
                    break;
                case 2:
                    navigationVar = MyInput.inputInteger("Enter the number of a dog in a nursery (beg. with 1): ", Integer::valueOf);
                    System.out.println("The human age of the dog number " + navigationVar + " is " + nursery.getDogs().get(navigationVar - 1).getHumanAge() + ".");
                    break;
                case 3:
                    navigationVar = MyInput.inputInteger("Enter the number of a dog in a nursery (beg. with 1): ", Integer::valueOf);
                    System.out.println(nursery.getDogs().get(navigationVar - 1));
                    break;
                case 4:
                    System.out.println(nursery);
                    break;
                default:
                    System.out.println("Executing the program...");
                    System.exit(1);
                    break;
            }
        }
    }
}
