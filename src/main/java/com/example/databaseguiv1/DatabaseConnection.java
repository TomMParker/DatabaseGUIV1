package com.example.databaseguiv1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection databaseConnection() throws SQLException {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2?noAccessToProcedureBodies=true";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        return DriverManager.getConnection(url, username, password);
    }
}
