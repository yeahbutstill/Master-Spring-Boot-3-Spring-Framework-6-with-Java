package org.example;

import java.util.List;

public class FP01Exercises {

    public static void main(String[] args) {
        printOddNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));
        System.out.println();

        List<String> courses = List.of("Spring", "Spring boot", "API",  "Microservice",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
        System.out.println();

        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);

    }

    private static void printOddNumbersInListStructured(List<Integer> numbers) {
        numbers.stream() // Convert to stream
                .filter(number -> number % 2 != 0) // Lambda expression
                .forEach(System.out::println); // Method reference
    }

}
