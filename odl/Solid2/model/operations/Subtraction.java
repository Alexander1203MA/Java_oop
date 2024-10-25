package Solid2.model.operations;

import Solid2.model.ComplexNumber;
import Solid2.model.Operation;

public class Subtraction implements Operation {
    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        double realResult = a.getReal() - b.getReal();
        double imaginaryResult = a.getImaginary() - b.getImaginary();
        return new ComplexNumber(realResult, imaginaryResult);
    }
}