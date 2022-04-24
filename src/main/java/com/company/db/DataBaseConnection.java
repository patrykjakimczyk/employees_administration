package com.company.db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Getter
public class DataBaseConnection {
    private Connection connection;

    public DataBaseConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jakimczyk.company", "postgres", "admin");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("pesel"));
            }
        } catch (Exception e) {
            System.out.println("Nie udało połączyć się z bazą danych");
        }
    }
}
