package com.secondTask.thirdSubtask;

import com.secondTask.InitializationException;
import com.secondTask.MyInput;

public class ThirdSubtask {

    public static void main(String[] args) {

        Book book = new Book();

        while (true) {
            Integer navigationVar = MyInput.inputInteger("""
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
                                + book.read(MyInput.inputInteger("Enter the number of ours you are planning to read:", Integer::valueOf),
                                            MyInput.inputInteger("Enter the number of words you read per minute:", Integer::valueOf))
                                + " pages.");
                    } catch (InitializationException ex) {
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
        newBook.setAuthorName(MyInput.inputString("Enter the author name: ", v -> v));
        newBook.setTitle(MyInput.inputString("Enter the title of the book: ", v -> v));
        newBook.setCoverColour(MyInput.inputString("Enter the cover colour: ", v -> v));
        newBook.setTotalPages(MyInput.inputInteger("Enter the total amount of pages", Integer::valueOf));
        return newBook;
    }
}
