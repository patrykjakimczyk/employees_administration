package com.company.DB;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;

@Getter
public class DataBaseConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/jakimczyk.company";
    private static final String user = "postgres";
    private static final String password = "admin";
    public Connection connection;

    public DataBaseConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Couldn't connect to database");
        }
    }
}
