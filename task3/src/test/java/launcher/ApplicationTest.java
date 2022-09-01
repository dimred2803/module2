package launcher;

import entity.City;
import entity.Edge;

import java.util.ArrayList;

import static launcher.Application.func;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @org.junit.jupiter.api.Test
    void funcTest() {
        String from = "Kharkiv", to = "Krakow";
        Edge way1 = new Edge(1,3,5);
        Edge way2 = new Edge(2, 4, 6);
        Edge way3 = new Edge(3, 1, 5);
        Edge way4 = new Edge(3,4,3);
        Edge way5 = new Edge(3, 5, 4);
        Edge way6 = new Edge(4, 2, 6);
        Edge way7 = new Edge(4,3,3);
        Edge way8 = new Edge(5, 3,4 );

        ArrayList<Edge> ways1  = new ArrayList<>();
        ArrayList<Edge> ways2  = new ArrayList<>();
        ArrayList<Edge> ways3  = new ArrayList<>();
        ArrayList<Edge> ways4  = new ArrayList<>();
        ArrayList<Edge> ways5  = new ArrayList<>();
        ways1.add(way1);
        ways2.add(way2);
        ways3.add(way3);
        ways3.add(way4);
        ways3.add(way5);
        ways4.add(way6);
        ways4.add(way7);
        ways5.add(way8);
        City one = new City (1, "Milan",1, ways1);
        City two = new City (2, "Kharkiv",1, ways2);
        City three = new City (3, "Paris",3, ways3);
        City four = new City (4, "Cologne",2, ways4);
        City five = new City (5, "Krakow",1, ways5);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(one); cities.add(two); cities.add(three); cities.add(four); cities.add(five);
        ArrayList<City> res = func(cities, from, to);
        String s = "";
        String expected = "Kharkiv Cologne Paris Krakow ";
        for (City c: res) {
            s+=c.getName()+" ";
        }
        assertEquals(expected,s);
    }
}