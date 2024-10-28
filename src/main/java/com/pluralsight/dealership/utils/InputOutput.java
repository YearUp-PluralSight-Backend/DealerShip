package com.pluralsight.dealership.utils;

import java.util.Scanner;

public class InputOutput {


    private static Scanner scanner = new Scanner(System.in);


    public static void formatOutput(String prompt) {

        String info =
                """
                ----------------------------------------------------------------------------------------------------
                %s
                ----------------------------------------------------------------------------------------------------

                """.formatted(prompt);
        System.out.println(info);
    }

    public static String promptForString(String prompt) {
        System.out.println(prompt);
        return promptForString();
    }

    /**
     * Prompt for a string value from the user without a prompt message.
     *
     * @return The input value
     */
    public static String promptForString() {
        String value = "";
        try {
            value = scanner.nextLine().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Prompt for an integer value from the user.
     *
     * @param prompt Message to show the user
     * @return The input value
     */
    public static int promptForInteger(String prompt) {
        System.out.println(prompt);
        int value = 0;
        try {
            value = Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Prompt for an integer value from the user without a prompt message.
     *
     * @return The input value
     */
    public static int promptForInteger() {
        int value = 0;
        try {
            value = Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Prompt for a double value from the user.
     *
     * @param prompt Message to show the user
     * @return The input value
     */
    public static Double promptForDouble(String prompt) {
        System.out.println(prompt);
        double value = 0;
        try {
            String stringValue = scanner.nextLine().trim();
            if (stringValue.isBlank() && stringValue.isEmpty()) {
                value = 0;
            } else {
                value = Double.parseDouble(stringValue);
            }
        } catch (Exception e) {
            System.out.println("Number Format issue! Please enter the right format!");
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Prompt for a double value from the user with a default value.
     *
     * @param prompt Message to show the user
     * @param defaultValue The default value if input is empty
     * @return The input value
     */
    public static Double promptForDouble(String prompt, double defaultValue) {
        System.out.println(prompt);
        double value = 0;
        try {
            String stringValue = scanner.nextLine().trim();
            if (stringValue.isBlank() && stringValue.isEmpty()) {
                value = defaultValue;
            }
        } catch (Exception e) {
            System.out.println("Number Format issue! Please enter the right format!");
            e.printStackTrace();
        }
        return value;
    }






}
