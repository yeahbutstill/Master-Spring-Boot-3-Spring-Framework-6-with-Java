package org.example;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptional {
    public static void main(String[] args) {

        List<String> fruits = List.of("apple", "banana", "manggo");
        Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
        Optional<String> stringOptional = fruits.stream().filter(predicate).findFirst();
        System.out.println(stringOptional);
        System.out.println(stringOptional.isEmpty());
        System.out.println(stringOptional.isPresent());
        System.out.println(stringOptional.get());

        System.out.println("================================================");

        Optional<String> banana = Optional.of("banana");
        System.out.println(banana);

        System.out.println("===================================================");

        Optional<String> empty = Optional.empty();
        System.out.println(empty);

    }
}
