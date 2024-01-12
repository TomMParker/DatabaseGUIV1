package com.example.databaseguiv1;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TerminalTest {




        public static void main(String[] args) {
            // JDBC connection parameters
            String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
            String username = "tp558_select";
            String password = "P_;2,}lafy}r";

            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish a connection
                Connection connection = DriverManager.getConnection(url, username, password);

                // Create a statement
                Statement statement = connection.createStatement();

                // Execute a query
                String sqlQuery = "SELECT * FROM tAppointment";
                ResultSet resultSet = statement.executeQuery(sqlQuery);

                // Print table header
                System.out.printf("%-15s %-10s %-25s %-10s %-20s %-15s%n",
                        "AppointmentID", "AnimalID", "AppointmentStartTime", "StaffID", "BranchName", "Service");
                System.out.println("----------------------------------------------------------------------------");

                // Process the result set
                while (resultSet.next()) {
                    // Access data from the result set for each column
                    int appointmentID = resultSet.getInt("appointmentID");
                    String animalID = resultSet.getString("animalID");
                    String appointmentStartTime = resultSet.getString("appointmentStartTime");
                    String staffID = resultSet.getString("staffID");
                    String branchName = resultSet.getString("branchName");
                    String service = resultSet.getString("service");

                    // Print data in a formatted manner
                    System.out.printf("%-15s %-10s %-25s %-10s %-20s %-15s%n",
                            appointmentID, animalID, appointmentStartTime, staffID, branchName, service);
                }

                // Close resources
                resultSet.close();
                statement.close();
                connection.close();

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


