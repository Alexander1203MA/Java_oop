package Solid2.view;

public interface View {
    void displayResult(double result);
    void displayError(String errorMessage);
    String getInput();
}