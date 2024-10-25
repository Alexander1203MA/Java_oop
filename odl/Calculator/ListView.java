package Calculator;
import java.util.List;

public class ListView implements View<ListCalculator>{

    /**
     * @param funcIndex - целое число:
     * @param parameter - List<? extends Number> - параметр для вычисления
     * @return строка с результатом
     */
    @Override
    public String printCalc(int funcIndex, ListCalculator calc,Object parameter){

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