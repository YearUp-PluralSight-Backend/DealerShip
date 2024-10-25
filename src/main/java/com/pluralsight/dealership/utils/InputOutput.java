package com.pluralsight.dealership.utils;

public class InputOutput {




    public static void formatOutput(String prompt) {

        String info =
                """
                ----------------------------------------------------------------------------------------------------
                %s
                ----------------------------------------------------------------------------------------------------

                """.formatted(prompt);
        System.out.println(info);
    }
}
