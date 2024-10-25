package Refactoring.controller;

import Refactoring.model.BinaryCalculator;
import Refactoring.model.iCalculator;
import Refactoring.model.ListCalculator;
import Refactoring.view.BinaryView;
import Refactoring.view.ListView;
import Refactoring.view.View;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    private ListController listController;

    private BinaryController binaryController;

    public AppController(ListController listController, BinaryController binaryController) {
        this.listController = listController;
        this.binaryController = binaryController;
    }

    public AppController() {
        listController = new ListController();
        binaryController = new BinaryController();
    }

    public void runCalc() {
        listController.runList();
        binaryController.runBinary();



    }

}