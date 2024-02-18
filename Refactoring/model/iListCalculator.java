package Refactoring.model;

import java.util.List;

public interface iListCalculator<T extends Number> {
    Double sum(List<T> list);

    Double product(List<T> list);

    Double div(List<T> list);


    List<T> getNumbers();
}