package Exceptions;

import Exceptions.Control.DataValidation;
import Exceptions.Model.SaveInterface;
import Exceptions.Model.SaveToFile;
import Exceptions.View.DataFromConsole;
import Exceptions.View.DataInterface;

public class Main {
    public static void main(String[] args) {
        DataInterface data = new DataFromConsole();
        SaveInterface saveToFile = new SaveToFile();
        saveToFile.save(data);

    }
}
