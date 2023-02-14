package org.example;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        printAllNumbersInListFuntional(integerList);
        System.out.println("===========================");
        printEvenNumbersInListStrutured(integerList);

    }

    private static void callPrint(int number) {
        System.out.println(number);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printAllNumbersInListFuntional(List<Integer> numbers) {
        // What to do
        numbers.stream().forEach(FP01Functional::callPrint);

        System.out.println("====================================");

        // How to
        for (int number:numbers) {
            System.out.println(number);
        }
    }

    private static void printEvenNumbersInListStrutured(List<Integer> numbers) {
        // What to do
        numbers.stream()
                // .filter(FP01Functional::isEven) // Filter - Only allow even numbers
                .filter(number -> number % 2 == 0) // Lambda expression
                .forEach(System.out::println); // Method Reference
    }

}
