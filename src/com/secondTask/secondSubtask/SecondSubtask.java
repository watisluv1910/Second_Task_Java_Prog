package com.secondTask.secondSubtask;

import com.secondTask.InitializationException;
import com.secondTask.MyInput;

public class SecondSubtask {

    public static void main(String[] args) {

        Ball ball = new Ball();

        while (true) {
            Integer navigationVar = MyInput.inputInteger("""
               Enter 1 to create a new ball.
               Enter 2 to kick the ball.
               Enter 3 to view the information about ball.
               Enter any other digit to stop the program.""", Integer::valueOf);

            switch (navigationVar) {
                case 1:
                    ball.Clear();
                    ball = initBall();
                    break;
                case 2:
                    try {
                        ball.Kick(MyInput.inputInteger("Input the strength:", Integer::valueOf),
                                MyInput.inputInteger("Input the angle:", Integer::valueOf));
                    }
                    catch (InitializationException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ball.CalcProperties();
                    }
                    catch (InitializationException ex) {
                        System.err.println(ex.getMessage());
                    }
                    System.out.println(ball);
                    break;
                default:
                    System.out.println("Executing the program...");
                    System.exit(1);
                    break;
            }
        }
    }

    public static Ball initBall() {
        Ball ball = new Ball();
        ball.setManufacturer_(MyInput.inputString("Input the manufacturer: ", v -> v));
        ball.setColour_(MyInput.inputString("Input colour: ", v -> v));
        ball.setMaterial_(MyInput.inputString("Input material: ", v -> v));
        ball.setCostRub_(MyInput.inputInteger("Input cost in rubles: ", Integer::valueOf));
        ball.setRadiusInch_(MyInput.inputInteger("Input radius in inches: ", Integer::valueOf));
        return ball;
    }
}
