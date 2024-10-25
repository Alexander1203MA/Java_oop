package Exceptions.Model;

import Exceptions.Control.DataValidation;
import Exceptions.View.DataFromConsole;
import Exceptions.View.DataInterface;

public interface SaveInterface {
    void save(DataInterface data);
}