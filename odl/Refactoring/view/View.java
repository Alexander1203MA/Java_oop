package Refactoring.view;

/**
 * Интерфейс классов View для классов Calculator
 */
public interface View<C>{

    String printCalc(int funcIndex, C calc, Object parameter);
}