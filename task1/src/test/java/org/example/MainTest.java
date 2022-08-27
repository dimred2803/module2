package org.example;

import java.util.ArrayList;

import static org.example.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void isValid1Test1() {
        boolean actual = isValid1("2002/04/23");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void isValid1Test2() {
        boolean actual = isValid1("2002/13/23");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void isValid1Test3() {
        boolean actual = isValid1("12/2002/23");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void isValid2Test1() {
        boolean actual = isValid2("23/04/2002");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void isValid2Test2() {
        boolean actual = isValid2("40/04/2002");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void isValid2Test3() {
        boolean actual = isValid2("04/23/2002");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void isValid3Test1() {
        boolean actual = isValid3("04-23-2002");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void isValid3Test2() {
        boolean actual = isValid3("04/23-2002");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void isValid3Test3() {
        boolean actual = isValid3("56-23-2002");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void funcTest1() {
        ArrayList<String> dates = new ArrayList<>();

        dates.add("2022/04/05");
        dates.add("05/04/2022");
        dates.add("04-05-2022");
        dates.add("19-19-2010");
        String actual = func(dates);
        String expected = "05042022 05042022 05042022";
        assertEquals(expected, actual);
    }
}