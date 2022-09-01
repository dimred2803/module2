package entity;

public class Edge {
    private int from;
    private int to;
    private int distance;

    public Edge (int from, int to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public void printInfoAboutEdge () {
        System.out.println("Information about edge:");
        System.out.println("From " + this.from);
        System.out.println("To " + this.to);
        System.out.println("Distance " + this.distance);
    }

    public void setFrom (int from ){
        this.from = from;
    }
    public void setTo (int to) {
        this.to = to;
    }
    public int getFrom (){
        return this.from;
    }
    public int getTo () {
        return this.to;
    }
    public void setDistance (int distance) {
        this.distance = distance;
    }
    public int getDistance () {
        return this.distance;
    }
}
