package com.example.databaseguiv1;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class CustomerController {
    @FXML
    private TableView<Customer> customerTableView;
/*
    private SimpleStringProperty customerHomePhone;
    private SimpleStringProperty customerAddress1;
    private SimpleStringProperty customerAddress2;
    private SimpleStringProperty customerPostcode;
    Column
    */

    @FXML
    private TableColumn<Customer, String> customerIDColumn;
    @FXML
    private TableColumn<Customer, String> customerFirstNameColumn;
    @FXML
    private TableColumn<Customer, String> customerSecondNameColumn;
    @FXML
    private TableColumn<Customer, String> customerEmailColumn;
    @FXML
    private TableColumn<Customer, String> customerMobileColumn;
    @FXML
    private TableColumn<Customer, String> customerHomePhoneColumn;
    @FXML
    private TableColumn<Customer, String> customerAddress1Column;
    @FXML
    private TableColumn<Customer, String> customerAddress2Column;
    @FXML
    private TableColumn<Customer, String> customerPostcodeColumn;

    @FXML
    public void initialize() {

        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerFirstName"));
        customerSecondNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerSecondName"));
        customerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
        customerMobileColumn.setCellValueFactory(new PropertyValueFactory<>("customerMobile"));
        customerHomePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("customerHomePhone"));
        customerAddress1Column.setCellValueFactory(new PropertyValueFactory<>("customerAddress1"));
        customerAddress2Column.setCellValueFactory(new PropertyValueFactory<>("customerAddress2"));
        customerPostcodeColumn.setCellValueFactory(new PropertyValueFactory<>("customerPostcode"));


        loadCustomers();

    }

    @FXML
    public void loadCustomers() {
        String url = "jdbc:mysql://brighton.reclaimhosting.com:3306/tp558_DariasDogsV2";
        String username = "tp558_select";
        String password = "P_;2,}lafy}r";
        String sqlQuery = "SELECT * FROM tCustomer";


        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            ObservableList<Customer> customers = FXCollections.observableArrayList();

            while (resultSet.next()) {

                Customer customer = new Customer(
                        resultSet.getString("customerID"),
                        resultSet.getString("customerFirstName"),
                        resultSet.getString("customerSecondName"),
                        resultSet.getString("customerEmail"),
                        resultSet.getString("customerMobile"),
                        resultSet.getString("customerHomePhone"),
                        resultSet.getString("customerAddress1"),
                        resultSet.getString("customerAddress2"),
                        resultSet.getString("customerPostcode")

                );
                customers.add(customer);

            }

            customerTableView.setItems(customers);
            customerTableView.refresh();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
