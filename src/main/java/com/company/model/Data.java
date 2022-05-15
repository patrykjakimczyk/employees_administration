package com.company.model;

import com.company.db.DataBaseController;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Data {

    private static ArrayList<Employee> listOfEmployees = new ArrayList<>();

    public static ArrayList<Employee> getListOfEmployees() {
        if (listOfEmployees.size() == 0) {
            addResultSetToList(DataBaseController.employeesListFromDB());
        } else {
            listOfEmployees.removeAll(listOfEmployees);
            addResultSetToList(DataBaseController.employeesListFromDB());
        }
        return listOfEmployees;
    }

    public static void addResultSetToList(ResultSet table) {
        try {
            while (table.next()) {
                if (table.getString("job").equals("Tradesman")) {
                    Tradesman tm = new Tradesman(
                            table.getString("pesel"),
                            table.getString("first_name"),
                            table.getString("last_name"),
                            table.getString("job"),
                            Integer.parseInt(table.getString("team")),
                            new BigDecimal(table.getString("salary")),
                            table.getString("phone_nr"),
                            new BigDecimal(table.getString("provision")),
                            new BigDecimal(table.getString("limit_of_provision"))
                    );
                    listOfEmployees.add(tm);
                } else if (table.getString("job").equals("Manager")) {
                    Manager m = new Manager(
                            table.getString("pesel"),
                            table.getString("first_name"),
                            table.getString("last_name"),
                            table.getString("job"),
                            Integer.parseInt(table.getString("team")),
                            new BigDecimal(table.getString("salary")),
                            table.getString("phone_nr"),
                            new BigDecimal(table.getString("bonus_salary")),
                            table.getString("nr_of_card")
                    );
                    listOfEmployees.add(m);
                } else {
                    Employee e = new Employee(
                            table.getString("pesel"),
                            table.getString("first_name"),
                            table.getString("last_name"),
                            table.getString("job"),
                            Integer.parseInt(table.getString("team")),
                            new BigDecimal(table.getString("salary")),
                            table.getString("phone_nr")
                    );
                    listOfEmployees.add(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int isEmployeeExists(String pesel) {
        getListOfEmployees();
        int index = 0;
        for (Employee e : listOfEmployees) {
            if (e.getPesel().equals(pesel)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
