package Refactoring.view;

import Refactoring.model.BinaryCalculator;

public class BinaryView implements View<BinaryCalculator> {
    /**
     * Метод возвращающий строку для вывода результата функций калькулятора
     * <BinaryCalculator> - двоичный калькулятор
     */
    @Override
    public String printCalc(int funcIndex, BinaryCalculator calc, Object parameter) {

        String funcName ;
        String result ;
        switch (funcIndex){
            case 3:
                funcName = "Двоичное в десятичное";
                try {
                    result = calc.fromBinary(parameter).toString();
                }
                catch (Exception e){
                    return String.format("Не верное представление %s%n",parameter.toString());
                }
                break;
            case 4:
                funcName = "Натуральное в двоичное";
                try{
                    result = calc.toBinary(parameter);
                }
                catch (Exception e){
                    return String.format("Нет возможности конвертировать",parameter);
                }
                break;
            default:
                return String.format("Параметр неизвестен %s",funcIndex);
        }

        return String.format("%s(%s) = %s",funcName, parameter.toString(), result);
    }
}