package Solid2.view;

public class ConsoleViewFactory implements ViewFactory {
    @Override
    public View createView() {
        return new ConsoleView();
    }
}