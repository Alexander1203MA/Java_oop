package Refactoring.model;

public class Calculator implements iCalculator{

    public Double sum(double a, double b){
        return a+b;
    }

    public Double div(double a, double b ){
        return a/b;
    }

    public Double product(double a, double b){
        return a * b;
    }
}