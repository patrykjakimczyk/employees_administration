package com.company.DB;

import com.company.Model.Manager;
import com.company.Model.Tradesman;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataBaseController {
    private static DataBaseConnection dbConnection = new DataBaseConnection();

    public static boolean addToDB(Object employee) {
        String query = "";
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            if (employee instanceof Manager) {
                Manager m = (Manager) employee;
                query = String.format("INSERT INTO employees " +
                        "(pesel, first_name, last_name, job, team, salary, phone_nr, bonus_salary, nr_of_card) VALUES " +
                        "(%s);", m.toString());
            } else if (employee instanceof Tradesman) {
                Tradesman tm = (Tradesman) employee;
                query = String.format("INSERT INTO employees " +
                        "(pesel, first_name, last_name, job, team, salary, phone_nr, provision, limit_of_provision) VALUES " +
                        "(%s);", tm.toString());
            } else {
                query = String.format("INSERT INTO employees " +
                        "(pesel, first_name, last_name, job, team, salary, phone_nr) VALUES" +
                        "(%s);", employee.toString());
            }
            System.out.println(query);
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet employeesListFromDB() {
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

    public static boolean deleteEmployeeFromDB(String pesel) {
        String query = "DELETE FROM employees WHERE pesel = '" + pesel + "';";

        try {
            Statement statement = dbConnection.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
