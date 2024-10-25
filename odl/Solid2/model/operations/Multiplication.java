package Solid2.model.operations;

import Solid2.model.ComplexNumber;
import Solid2.model.Operation;

public class Multiplication extends ComplexNumber implements Operation{


    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        double realResult = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double imaginaryResult = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        return new ComplexNumber(realResult, imaginaryResult);
    }
}