package entity;

import java.util.ArrayList;

public class City {
    private int num;
    private String name;
    private int countOfNeighbours;
    private ArrayList<Edge> ways;
    private String from = "none";
    private int sum = 10000;


    public City (int num, String name, int countOfNeighbours, ArrayList<Edge> ways) {
        this.num = num;
        this.name = name;
        this.countOfNeighbours = countOfNeighbours;
        this.ways = ways;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Edge> getWays() {
        return ways;
    }

    public void setWays(ArrayList<Edge> ways) {
        this.ways = ways;
    }

    public void print_info () {
        System.out.println("Information about " + this.name + " city :");
        System.out.println("Count of neighbours :" + this.countOfNeighbours);
        System.out.println("Information about ways to the neighbours");
        for (int i=0;i<ways.size();i++) {
            ways.get(i).printInfoAboutEdge();
        }
        System.out.println("-------------------------------");
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
