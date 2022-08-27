package graph;


import java.util.Iterator;

public interface GraphIterator<City> extends Iterator<City> {
    @Override
    boolean hasNext();
    @Override
    City next();
}
