package Refactoring.controller;

import Refactoring.model.BinaryCalculator;
import Refactoring.model.iBinaryCalculator;
import Refactoring.view.BinaryView;
import Refactoring.view.View;

public class BinaryController {
    public BinaryController() {
        model = getBinaryModel();
        viewBinary = new BinaryView();
    }

    public BinaryController(iBinaryCalculator model, View<BinaryCalculator> viewBinary) {
        this.model = model;
        this.viewBinary = viewBinary;
    }

    private iBinaryCalculator model;

    private View<BinaryCalculator> viewBinary;

    private BinaryCalculator getBinaryModel(){
        return new BinaryCalculator();
    }

    public void runBinary(){
        String separator = "========================================================================";
        System.out.println(separator);
        System.out.println("Из двочного  в десятичное");
        System.out.println(viewBinary.printCalc(3, (BinaryCalculator) model, model.getNumber()));
        System.out.println("Из Long в десятичное");
        System.out.println(viewBinary.printCalc(3, (BinaryCalculator) model, Long.valueOf("101010101011101101")));
        System.out.println("Из Long в десятичное с ошибкой");
        System.out.println(viewBinary.printCalc(3, (BinaryCalculator) model, Long.valueOf("201010101011101101")));
        System.out.println(separator);
        System.out.println("Из целочисленного в двоичное");
        System.out.println(viewBinary.printCalc(4, (BinaryCalculator) model, (int) 79));
        System.out.println("Из Long в двоичное");
        System.out.println(viewBinary.printCalc(4, (BinaryCalculator) model, Long.valueOf("100")));
        System.out.println("Из дробного значения в двоичное");
        System.out.println(viewBinary.printCalc(4, (BinaryCalculator) model, (double) 79.056));
        System.out.println("Из строчного значения (String) в двоичное");
        System.out.println(viewBinary.printCalc(4, (BinaryCalculator) model, "101010101011101101"));

    }
}