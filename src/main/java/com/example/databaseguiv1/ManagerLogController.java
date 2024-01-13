package com.example.databaseguiv1;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.time.LocalDate;

public class ManagerLogController {

    @FXML
    private TableView<ManagerLog> managerLogTableView;

    @FXML
    private TableColumn<ManagerLog, String> managerLogIDColumn;
    @FXML
    private TableColumn<ManagerLog, String> staffIDColumn;
    @FXML
    private TableColumn<ManagerLog, String> managerStaffIDColumn;
    @FXML
    private TableColumn<ManagerLog, LocalDate> managerStartDateColumn;
    @FXML
    private TableColumn<ManagerLog, LocalDate> managerEndDateColumn;

    @FXML
    public void initialize() {

        managerLogIDColumn.setCellValueFactory(new PropertyValueFactory<>("managerLogID"));
        staffIDColumn.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        managerStaffIDColumn.setCellValueFactory(new PropertyValueFactory<>("managerStaffID"));
        managerStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("managerStartDate"));
        managerEndDateColumn.setCellValueFactory(new PropertyValueFactory<>("managerEndDate"));

        loadManagers();

    }

    @FXML
    public void loadManagers() {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "SELECT * FROM tManagerLog";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<ManagerLog> managers = FXCollections.observableArrayList();

            while (resultSet.next()) {

                ManagerLog managerLog = new ManagerLog(
                        resultSet.getString("managerLogID"),
                        resultSet.getString("staffID"),
                        resultSet.getString("managerStaffID"),
                        resultSet.getDate("managerStartDate") != null ? resultSet.getDate("managerStartDate").toLocalDate() : null,
                        resultSet.getDate("managerEndDate") != null ? resultSet.getDate("managerEndDate").toLocalDate() : null


                );
                managers.add(managerLog);

            }

            managerLogTableView.setItems(managers);
            managerLogTableView.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
