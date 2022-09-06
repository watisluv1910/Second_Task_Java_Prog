package com.secondTask.thirdSubtask;

import java.util.Scanner;
import java.util.function.Function;

public class ThirdSubtask {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Book book = new Book();

        while (true) {
            Integer navigationVar = inputInteger("""
               Enter 1 to add a new book.
               Enter 2 to start reading.
               Enter 3 to view the information about current book.
               Enter any other digit to stop the program.""", Integer::valueOf);

            switch (navigationVar) {
                case 1:
                    book = InitBook();
                    break;
                case 2:
                    try {
                        System.out.println("You made a good progress! Today you've read "
                                + book.read(inputInteger("Enter the number of ours you are planning to read:", Integer::valueOf),
                                            inputInteger("Enter the number of words you read per minute:", Integer::valueOf))
                                + " pages.");
                    } catch (com.secondTask.thirdSubtask.InitializationException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(book);
                    break;
                default:
                    System.out.println("Executing the program...");
                    System.exit(1);
                    break;
            }
        }
    }

    public static Book InitBook() {
        Book newBook = new Book();
        newBook.setAuthorName(inputString("Enter the author name: ", v -> v));
        newBook.setTitle(inputString("Enter the title of the book: ", v -> v));
        newBook.setCoverColour(inputString("Enter the cover colour: ", v -> v));
        newBook.setTotalPages(inputInteger("Enter the total amount of pages", Integer::valueOf));
        return newBook;
    }

    private static <T> T inputInteger(String message, Function<Integer, T> converter) {
        while (true) { // Чтобы не ругался на возможное отсутствие return'a
            try {
                System.out.println(message);
                return converter.apply(scanner.nextInt());
            } catch (Exception ex) {
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
