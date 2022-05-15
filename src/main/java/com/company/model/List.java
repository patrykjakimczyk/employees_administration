package com.company.model;

import com.company.Controller.ListController;
import com.company.db.DataBaseController;

import java.util.ArrayList;

public class List {

    private static ArrayList<Employee> listOfEmployees = new ArrayList<>();

    public static ArrayList<Employee> getListOfEmployees() {
        if (listOfEmployees.size() == 0) {
            ListController.addResultSetToList(DataBaseController.employeesListFromDB());
        } else {
            listOfEmployees.removeAll(listOfEmployees);
            ListController.addResultSetToList(DataBaseController.employeesListFromDB());
        }
        return listOfEmployees;
    }
}
