package com.company.Controller;

import com.company.DB.DataBaseController;
import com.company.Model.Employee;
import com.company.Model.List;
import com.company.Model.Manager;
import com.company.Model.Tradesman;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class ListController {

    public static void updateListOfEmployees() {
        ArrayList<Employee> list = List.getListOfEmployees();
        if (list.size() == 0) {
            addResultSetToList(DataBaseController.employeesListFromDB());
        } else {
            list.removeAll(list);
            addResultSetToList(DataBaseController.employeesListFromDB());
        }
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
                    List.getListOfEmployees().add(tm);
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
                    List.getListOfEmployees().add(m);
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
                    List.getListOfEmployees().add(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int isEmployeeExists(String pesel) {
        List.getListOfEmployees();
        int index = 0;
        for (Employee e : List.getListOfEmployees()) {
            if (e.getPesel().equals(pesel)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
