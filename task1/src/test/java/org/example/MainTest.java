package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.example.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {




    @org.junit.jupiter.api.Test
    void funcTest1() {
        ArrayList<String> dates = new ArrayList<>();

        dates.add("2022/04/05");
        dates.add("05/04/2022");
        dates.add("04-05-2022");
        dates.add("19-19-2010");
        String res = func(dates);
        System.out.println(res);
        String expRes = "05042022 05042022 05042022";
        System.out.println(res.hashCode() + " " + expRes.hashCode());
        int actual = res.compareTo(expRes);
        int expected = 1;
        assertEquals(expected, actual);
    }
}