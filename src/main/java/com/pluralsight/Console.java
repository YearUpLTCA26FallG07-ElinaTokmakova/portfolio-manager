package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int promptForInt(String prompt) {
        int result = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                result = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                isValid = true;     // Input was successful, exit loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid whole number.");
                scanner.nextLine(); // Clear the bad input from the scanner buffer
            }
        } while (!isValid);

        return result;
    }

    public static double promptForDouble(String prompt) {
        double result = 0.0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                result = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline
                isValid = true;     // Input was successful, exit loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the bad input from the scanner buffer
            }
        } while (!isValid);

        return result;
    }

    public static BigDecimal promptForBigDecimal(String prompt) {
        String input = "";

        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextLine().trim();

                // if input is not empty convert to BigDecimal
                if (!input.isEmpty()) {
                    BigDecimal result = new BigDecimal(input);

                    // 2 decimals format
                    result = result.setScale(2, RoundingMode.HALF_UP);

                    return result;

                    // if empty return 0
                } else {
                    return BigDecimal.ZERO;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the newline from the scanner buffer
                System.out.println("""
                        \nInvalid input. Please enter a valid number.
                        › Try again: """);
            }
        }
    }
}
