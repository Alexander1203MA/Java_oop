package Picnic.model;

import java.util.Comparator;

public class FruitsComparator implements Comparator<Fruits> {
    @Override
    public int compare(Fruits o1, Fruits o2) {
        return Integer.compare(o1.getNameLength(),o2.getNameLength());
    }
}