package Picnic.model;

import java.util.*;

public class Fruits implements Plant, Comparable<Plant>{
    private String name;
    private final int nameLength;

    private static Map<String, Fruits> fruits;
    static {
        fruits = new HashMap<>();
    }

    private Fruits(String name) {
        this.name = name;
        nameLength = name.length();
    }

    public static Fruits getFruitInstance(String name){
        return fruits.getOrDefault(name, new Fruits(name));
    }

    public String getName() {
        return name;
    }

    @Override
    public int getNameLength() {
        return nameLength;
    }

    @Override
    public int compareTo(Plant o) {
        int otherNameLength = o.getNameLength();
        return Integer.compare(this.nameLength, otherNameLength);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruits fruits = (Fruits) o;
        return Objects.equals(name, fruits.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("Плод %s",name);
    }
}