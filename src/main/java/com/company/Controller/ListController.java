package com.company.Controller;

import com.company.model.Employee;
import com.company.model.List;
import com.company.model.Manager;
import com.company.model.Tradesman;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListController {

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
