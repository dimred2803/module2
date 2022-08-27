package graph;

public interface Graph<City> extends Iterable<City> {
    void add(City value);
    void delete(City value);
    boolean contains (City value);
    //void FindFunc ();
}
