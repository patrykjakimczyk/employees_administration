package com.company.DB;

import com.company.Model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DataBaseController {
    private static DataBaseConnection dbConnection = new DataBaseConnection();

    public static boolean addToDB(Employee employee) {
        String query = employee.InsertStatement();
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
