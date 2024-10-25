package Refactoring.model;

import java.util.ArrayList;
import java.util.List;

public class ListCalculator<C extends Number> extends Calculator implements iCalculator, iListCalculator<C> {
    private List<C> numbers;

    public ListCalculator(List<C> numbers) {
        this.numbers = numbers;
    }

    public ListCalculator() {
        numbers = new ArrayList<C>();
    }

    public List<C> getNumbers() {
        return numbers;
    }


    public void setNumbers(List<C> numbers) {
        this.numbers = numbers;
    }

    public Double sum(List<C> numbers) {
        double res = 0;
        for (Number number : numbers) {
            res += number.doubleValue();
        }
        return res;
    }

    public Double product(List<C> numbers) {
        double res = 1;
        for (Number number : numbers) {
            res *= number.doubleValue();
        }
        return res;
    }

    public Double div(List<C> numbers) {
        double res = numbers.get(0).doubleValue();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i).doubleValue() != 0)
                res /= numbers.get(i).doubleValue();
        }
        return res;
    }


}