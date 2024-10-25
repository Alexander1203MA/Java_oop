package Calculator;
import java.util.List;

public class NumberCalculator<N extends Number> implements Calculators {

    private List<N> numbers;

    public Double sum() {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }

    @Override
    public Double mult() {
        double res = 1.0;
        return numbers.stream().mapToDouble(Number::doubleValue).reduce(res, (a, b) -> a * b);
    }

    @Override
    public Double div() {
        double res = numbers.get(0).doubleValue();
        for (int i = 1; i < numbers.size(); i++) {
            res /= numbers.get(i).doubleValue();
        }
        return res;
    }

    @Override
    public N fromBinary() {
        return null;
    }

    @Override
    public String toBinary(Object number) {
        return null;
    }
}
