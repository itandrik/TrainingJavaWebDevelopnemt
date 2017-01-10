package com.javaweb.controller;

import com.javaweb.model.Model;
import com.javaweb.model.entity.EmployeeType;
import com.javaweb.model.entity.Manager;
import com.javaweb.view.View;

/**
 * @author Andrii Chernysh;
 *         E-MAIL : itcherry97@gmail.com;
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        model.initEmployees();
        view.printlnMessage(model.toString());

        Manager manager = new Manager("Vasil","12-04-2054","12-04-2016");
        model.addEmployee(manager);
        model.removeEmployee(model.findEmployeeByName("Worker 1"),null);
        model.removeEmployee(model.findEmployeeByName("Manager 1"),manager);
        view.printlnMessage(model.toString());

        view.printlnMessage(View.SEPARATOR);
        model.changeTypeOfEmployee(model.findEmployeeByName("Worker 2"), EmployeeType.MANAGER);
        view.printlnMessage(model.toString());

        view.printlnMessage(View.SEPARATOR);
        model.changeTypeOfEmployee(model.findEmployeeByName("Manager 2"), EmployeeType.WORKER);
        view.printlnMessage(model.toString());
    }
}
