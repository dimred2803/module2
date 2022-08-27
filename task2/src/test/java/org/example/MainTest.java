package org.example;

import java.util.List;

import static org.example.Main.func2;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void func2Test() {
        String s = "Vasya Nikita Andrey Roma Roma Dima Roma Vasya Andrey Roma Nikita Nikita Andrey";
        String[] sequency = s.split(" ");
        List<String> test = func2(sequency);
        boolean actual = false;
        if (test.get(0).equals("Dima")) {
             actual = true;
        }
        boolean expected = true;
        assertEquals(expected, actual);
    }
}