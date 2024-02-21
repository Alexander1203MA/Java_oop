package Solid2;

import Solid2.controller.CalculatorController;
import Solid2.model.CalculatorModel;
import Solid2.model.ComplexNumber;
import Solid2.model.operations.Addition;
import Solid2.model.operations.Division;
import Solid2.model.operations.Multiplication;
import Solid2.model.operations.Subtraction;
import Solid2.view.CalculatorView;
import Solid2.view.ConsoleViewFactory;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class intApp {

    private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static {
        try(FileInputStream in = new FileInputStream("E:\\VS\\Java\\Solid2\\logging.properties")){
            LogManager.getLogManager().readConfiguration(in);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    void init() {
        LOGGER.info("Запуск программы");
        CalculatorModel model = new CalculatorModel();
        LOGGER.info("Запуск модели");
        CalculatorController controller = new CalculatorController();
        LOGGER.info("Запуск управления");
        CalculatorView calculatorView = new CalculatorView(new ConsoleViewFactory());
        LOGGER.info("Загрузка интерфейса");
        controller.registerOperation("+", new Addition());
        controller.registerOperation("-", new Subtraction());
        controller.registerOperation("*", new Multiplication());
        controller.registerOperation("/", new Division());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Введите требуемое вам действие из следующего списка: \n").trimToSize();
        stringBuilder.append(" + Сложение.\n - Вычитание.\n * Умножение.\n / Деление.\n Укажите символом что вам требуется сделать: ");
        System.out.println(stringBuilder);
        String operation = calculatorView.getInput();
        LOGGER.info("Пользователь ввел следующий параметр " + operation + " в данной операции");
        System.out.println("Введите реальное число А:");
        double realComplexA = Double.parseDouble(calculatorView.getInput().trim());
        System.out.println("Введите мнимое число А:");
        double imaginaryComplexA = Double.parseDouble(calculatorView.getInput().trim());
        ComplexNumber a = new ComplexNumber(realComplexA,imaginaryComplexA);
        System.out.println("Введите реальное число B:");
        double realComplexB = Double.parseDouble(calculatorView.getInput().trim());
        System.out.println("Введите мнимое число B:");
        double imaginaryComplexB = Double.parseDouble(calculatorView.getInput().trim());
        ComplexNumber b = new ComplexNumber(realComplexB,imaginaryComplexB);
        ComplexNumber result = controller.performOperation(operation, a, b);
        model.setResult(result);
        calculatorView.displayResult(model.getResult());
    }
}