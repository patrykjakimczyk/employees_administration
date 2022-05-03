package com.company.db;

import com.company.model.Employee;
import com.company.model.Manager;
import com.company.model.Tradesman;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataBaseController {
    public static void addToDB(Object employee) {
        DataBaseConnection dbConnection = new DataBaseConnection();
        String query = "";
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            if (employee instanceof Employee) {
                query = String.format("INSERT INTO employees " +
                        "(pesel, first_name, last_name, job, team, salary, phone_nr) " +
                        "VALUES (%s)", employee.toString());
            } else if (employee instanceof Manager) {
                Manager m = (Manager) employee;
                query = String.format("INSERT INTO employees " +
                        "(pesel, first_name, last_name, job, team, salary, phone_nr, bonus_salary, nr_of_card)" +
                        "(%s)", m.toString());
            } else if (employee instanceof Tradesman) {
                Tradesman tm = (Tradesman) employee;
                query = String.format("INSERT INTO employees " +
                        "(pesel, first_name, last_name, job, team, salary, phone_nr, provision, limit_of_provision)" +
                        "(%s)", tm.toString());
            } else {
                System.out.println("Podano zły obiekt");
            }
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int employeesSizeDB() {
        DataBaseConnection dbConnection = new DataBaseConnection();
        String query = "";
        ResultSet result;
        int size = 0;
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            query = "SELECT COUNT(*) FROM employees";
            result = statement.executeQuery(query);
            if (result.next()) {
                size = Integer.parseInt(result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return size;
    }

    public static ResultSet employeesListFromDB() {
        DataBaseConnection dbConnection = new DataBaseConnection();
        String query = "";
        ResultSet result;
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            query = "SELECT * FROM employees";
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }
}
