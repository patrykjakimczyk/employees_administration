package com.company.DB;

import com.company.Model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataBaseController {
    private static DataBaseConnection dbConnection = new DataBaseConnection();

    public static boolean addToDB(Employee employee) {
        String query = employee.insertStatement();
        try {
            Statement statement = dbConnection.getConnection().createStatement();
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
            query = "SELECT * FROM employees ORDER BY first_name, last_name;";
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

    public static boolean updateEmployeeInDB(Employee em, String pesel) {
        String query = em.updateStatement() + "WHERE pesel='" + pesel + "';";
        System.out.println(query);

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
