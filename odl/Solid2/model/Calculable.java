package Solid2.model;

@FunctionalInterface
@Deprecated
public interface Calculable <T,N extends Number> {
        double calculate(T real,char ch, N imaginary);
}