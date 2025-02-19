package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {
    public Connection connect() {
        Connection conn;
        try {
            conn = tryConnect();
            return conn;
        } catch (Exception e) {
            System.err.println("nem csati :(");
            System.err.println(e.getMessage());
            return null;
        }
    }
    private Connection tryConnect() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hengerdb","root","");
        return conn;
    }
}
