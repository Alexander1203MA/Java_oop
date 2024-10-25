package Solid2.view;

import java.util.Scanner;

public class ConsoleView implements View {
    @Override
    public void displayResult(double result) {
        System.out.println("Результат: " + result);
    }

    @Override
    public void displayError(String errorMessage) {
        System.out.println("Ошибка: " + errorMessage);
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
