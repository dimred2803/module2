package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<String> func2 (String[] seq) {
        return Arrays.stream(seq).collect(Collectors.groupingBy(w -> w, HashMap::new, Collectors.counting()))
                .entrySet().stream().filter(a -> 1L == a.getValue()).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String s = "Vasya Nikita Andrey Roma Roma Dima Roma Vasya Andrey Roma Nikita Nikita Andrey";
        String[] sequency = s.split(" ");

        System.out.println(func2(sequency));
    }
}