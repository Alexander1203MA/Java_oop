package Calculator;

public interface View<C>{

    /**
     * <C> - дженерик Calculator
     * @param funcIndex - целое число:<br>
     *                  0 - Сумма элементов списка<br>
     *                  1 - Перемножение элементов списка<br>
     *                  2 - Деление элементов списка<br>
     *                  3 - Конвертируем из двоичного в десятичный<br>
     *                  4 - Конвертируем из десятичного в двоичный<br>
     */
    String printCalc(int funcIndex, C calc, Object parameter);
}