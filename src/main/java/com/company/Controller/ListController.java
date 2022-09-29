package com.company.Controller;

import com.company.DB.DataBaseController;
import com.company.Model.Employee;
import com.company.Model.EmployeesList;
import com.company.Model.Manager;
import com.company.Model.Tradesman;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.IntStream;

public final class ListController {

    public static void updateListOfEmployees() {
        ArrayList<Employee> list = EmployeesList.getListOfEmployees();
        if (list.isEmpty()) {
            addResultSetToList(DataBaseController.employeesListFromDB());
            EmployeesList.setCurrentEmployee(null);
        } else {
            list.removeAll(list);
            EmployeesList.setCurrentEmployee(null);
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
                    EmployeesList.getListOfEmployees().add(tm);
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
                    EmployeesList.getListOfEmployees().add(m);
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
                    EmployeesList.getListOfEmployees().add(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int isEmployeeExists(String pesel) {
        ArrayList<Employee> list = EmployeesList.getListOfEmployees();
        return IntStream.range(0, list.size())
                .filter(i -> list.get(i).getPesel().equals(pesel))
                .findFirst().orElse(-1);
    }
}
