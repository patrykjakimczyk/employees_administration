package com.company.model;

import java.util.Map;
import java.util.TreeMap;

public class Data {

    private static Map<String, Employee> listOfEmployees = new TreeMap<>();

    public static Map<String, Employee> getListOfEmployees() {
        return listOfEmployees;
    }
}
