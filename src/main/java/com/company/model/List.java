package com.company.model;

import java.util.ArrayList;

public class List {

    private static ArrayList<Employee> listOfEmployees = new ArrayList<>();

    public static ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

}
