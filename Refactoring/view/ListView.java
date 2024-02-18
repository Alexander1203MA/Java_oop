package Refactoring.view;

import Refactoring.model.ListCalculator;
import java.util.List;

public class ListView implements View<ListCalculator>{

    /**
     * Метод возвращающий строку для вывода результата функций калькулятора
     * @param funcIndex - целое число:
     *                  0 - sum Сумма элементов списка
     *                  1 - product умножение элементов списка
     *                  2 - div деление элементов списка
     */
    @Override
    public String printCalc(int funcIndex, ListCalculator calc, Object parameter){

        String funcName ;
        Double result ;
        switch (funcIndex){
            case 0:
                funcName = "Сумма всех наших значений";
                result = calc.sum((List<? extends Number>) parameter);
                break;
            case 1:
                funcName = "Перемножение всех наших значений";
                result = calc.product((List<? extends Number>) parameter);
                break;
            case 2:
                funcName = "Деление всех наших значений";
                result = calc.div((List<? extends Number>) parameter);
                break;
            default:
                return null;
        }

        return String.format("%s(%s) = %s",funcName, parameter.toString(), result.toString());
    }

}