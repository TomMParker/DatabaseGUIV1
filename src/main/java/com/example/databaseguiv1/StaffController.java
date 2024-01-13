package com.example.databaseguiv1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.sql.*;
public class StaffController {
    @FXML
    private TableView<Staff> staffTableView;
    @FXML
    private TableColumn<Staff, String> staffIDColumn;
    @FXML
    private TableColumn<Staff, String> staffFirstNameColumn;
    @FXML
    private TableColumn<Staff, String> staffSecondNameColumn;
    @FXML
    private TableColumn<Staff, String> staffAddress1Column;
    @FXML
    private TableColumn<Staff, String> staffAddress2Column;
    @FXML
    private TableColumn<Staff, String> staffPostcodeColumn;
    @FXML
    private TableColumn<Staff, String> staffTelephoneNumberColumn;
    @FXML
    private TableColumn<Staff, String> currentManagerStaffIDColumn;



    @FXML
    public void initialize() {

        staffIDColumn.setCellValueFactory(new PropertyValueFactory<>("staffID"));
        staffFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("staffFirstName"));
        staffSecondNameColumn.setCellValueFactory(new PropertyValueFactory<>("staffSecondName"));
        staffAddress1Column.setCellValueFactory(new PropertyValueFactory<>("staffAddress1"));
        staffAddress2Column.setCellValueFactory(new PropertyValueFactory<>("staffAddress2"));
        staffPostcodeColumn.setCellValueFactory(new PropertyValueFactory<>("staffPostcode"));
        staffTelephoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("staffTelephoneNumber"));
        currentManagerStaffIDColumn.setCellValueFactory(new PropertyValueFactory<>("currentManagerStaffID"));

        loadStaff();

    }

    @FXML
    public void loadStaff() {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "SELECT * FROM tStaff";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<Staff> staffList = FXCollections.observableArrayList();

            while (resultSet.next()) {

                Staff staff = new Staff(
                        resultSet.getString("staffID"),
                        resultSet.getString("staffFirstName"),
                        resultSet.getString("staffSecondName"),
                        resultSet.getString("staffAddress1"),
                        resultSet.getString("staffAddress2"),
                        resultSet.getString("staffPostcode"),
                        resultSet.getString("staffTelephoneNumber"),
                        resultSet.getString("currentManagerStaffID")


                );
                staffList.add(staff);

            }

            staffTableView.setItems(staffList);
            staffTableView.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
