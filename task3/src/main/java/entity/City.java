package entity;

import java.util.ArrayList;

public class City {
    private String name;
    private int countOfNeighbours;
    private ArrayList<Edge> ways;
    private boolean isVisited = false;

    public City (String name, int countOfNeighbours, ArrayList<Edge> ways) {
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

    public ArrayList<Edge> getNeighbours() {
        return ways;
    }

    public void setNeighbours(ArrayList<Edge> ways) {
        this.ways = ways;
    }

    public void print_info () {
        System.out.println("Information about " + this.name + " city :");
        System.out.println("Count of neighbours :" + this.countOfNeighbours);
        System.out.println("Information about ways to the neighbours");
        for (int i=0;i<ways.size();i++) {
            ways.get(i).printInfoAboutEdge();
        }
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
