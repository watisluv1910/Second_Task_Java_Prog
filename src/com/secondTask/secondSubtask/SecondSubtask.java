package com.secondTask.secondSubtask;

import java.util.Scanner;
import java.util.function.Function;

public class SecondSubtask {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Ball ball = new Ball();

        while (true) {
            Integer navigationVar = inputInteger("""
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
                        ball.Kick(inputInteger("Input the strength:", Integer::valueOf),
                                inputInteger("Input the angle:", Integer::valueOf));
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
        ball.setManufacturer_(inputString("Input the manufacturer: ", v -> v));
        ball.setColour_(inputString("Input colour: ", v -> v));
        ball.setMaterial_(inputString("Input material: ", v -> v));
        ball.setCostRub_(inputInteger("Input cost in rubles: ", Integer::valueOf));
        ball.setRadiusInch_(inputInteger("Input radius in inches: ", Integer::valueOf));
        return ball;
    }

    private static <T> T inputInteger(String message, Function<Integer, T> converter) {
        while (true) { // Чтобы не ругался на возможное отсутствие return'a
            try {
                System.out.println(message);
                return converter.apply(scanner.nextInt());
            }
            catch (Exception ex) {
                System.err.println("Incorrect input format.");
                System.exit(1);
            }
        }
    }

    private static <T> T inputString(String message, Function<String, T> converter) {
        while (true) { // Чтобы не ругался на возможное отсутствие return'a
            try {
                System.out.println(message);
                return converter.apply(scanner.next());
            } catch (Exception ex) {
                System.err.println("Incorrect input format.");
                System.exit(1);
            }
        }
    }
}
